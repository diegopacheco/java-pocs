package com.github.diegopacheco.sandboxspring;

import com.github.diegopacheco.sandboxspring.service.ExampleServices;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.github.diegopacheco.sandboxspring")
public class Application {

	@Value("${server.port}")
	String serverPort;

	@Value("${app.api.path}")
	String contextPath;

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(), contextPath + "/*");
		servlet.setName("CamelServlet");
		return servlet;
	}

	@Component
	class RestApi extends RouteBuilder {

		@Override
		public void configure() {

			CamelContext context = new DefaultCamelContext();

			// http://localhost:8081/camel/api-doc
			restConfiguration().contextPath(contextPath) //
					.port(serverPort)
					.enableCORS(true)
					.apiContextPath("/api-doc")
					.apiProperty("api.title", "Test REST API")
					.apiProperty("api.version", "v1")
					.apiProperty("cors", "true") // cross-site
					.apiContextRouteId("doc-api")
					.component("servlet")
					.bindingMode(RestBindingMode.json)
					.dataFormatProperty("prettyPrint", "true");
			/**
			 The Rest DSL supports automatic binding json/xml contents to/from
			 POJOs using Camels Data Format.
			 By default the binding mode is off, meaning there is no automatic
			 binding happening for incoming and outgoing messages.
			 You may want to use binding if you develop POJOs that maps to
			 your REST services request and response types.
			 */
			// curl -d '{"id":1,"name":"diego"}' -H "Content-Type: application/json"-X POST http://localhost:8081/camel/api/bean -v
			// http://localhost:8081/camel/api/bean
			rest("/api/").description("Teste REST Service")
					.id("api-route")
					.post("/bean")
					.produces(MediaType.APPLICATION_JSON_VALUE)
					.consumes(MediaType.APPLICATION_JSON_VALUE)
					.bindingMode(RestBindingMode.auto)
					.type(MyBean.class)
					.enableCORS(true)
					.to("direct:remoteService");

			from("direct:remoteService").routeId("direct-route")
					.tracing()
					.log(">>> ${body.id}")
					.log(">>> ${body.name}")
					.process(new Processor() {
						@Override
						public void process(Exchange exchange) throws Exception {
							MyBean bodyIn = (MyBean) exchange.getIn().getBody();
							ExampleServices.example(bodyIn);
							exchange.getIn().setBody(bodyIn);
						}
					})
					.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Spring Boot 2.0 working! ");
		};
	}
}

