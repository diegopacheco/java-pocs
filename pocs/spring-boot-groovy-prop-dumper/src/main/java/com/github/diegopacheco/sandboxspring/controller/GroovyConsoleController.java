package com.github.diegopacheco.sandboxspring.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.transform.TimedInterrupt;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer;
import org.codehaus.groovy.control.customizers.SecureASTCustomizer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.singletonMap;

@Controller
@RequestMapping("/console")
public class GroovyConsoleController implements ApplicationContextAware {

    private static final long SCRIPT_TIMEOUT_IN_SECONDS = 5;
    private static final List<String> RECEIVERS_BLACK_LIST = Stream.of(System.class, Thread.class)
            .map(Class::getName)
            .collect(Collectors.toList());

    private ApplicationContext applicationContext;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:/console/index.html";
    }

    @RequestMapping(value = "/groovy", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CompletableFuture<ScriptResult> execute(@RequestParam String script) {
        return CompletableFuture.supplyAsync(() -> {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            GroovyShell groovyShell = createGroovyShell(out);
            Object result = groovyShell.evaluate(script);
            return ScriptResult.create(result, out.toString());
        }).exceptionally(ScriptResult::create);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private GroovyShell createGroovyShell(OutputStream outputStream) {
        CompilerConfiguration configuration = createCompilerConfiguration();
        Binding binding = createBinding(outputStream);
        return new GroovyShell(binding, configuration);
    }

    private Binding createBinding(OutputStream outputStream) {
        Binding binding = new Binding();
        binding.setVariable("applicationContext", applicationContext);
        binding.setProperty("out", new PrintStream(outputStream, true));
        return binding;
    }

    private CompilerConfiguration createCompilerConfiguration() {
        ASTTransformationCustomizer timedCustomizer = new ASTTransformationCustomizer(singletonMap("value", SCRIPT_TIMEOUT_IN_SECONDS), TimedInterrupt.class);
        SecureASTCustomizer secureCustomizer = new SecureASTCustomizer();
        secureCustomizer.setReceiversBlackList(RECEIVERS_BLACK_LIST);
        CompilerConfiguration configuration = new CompilerConfiguration();
        configuration.addCompilationCustomizers(secureCustomizer, timedCustomizer);
        return configuration;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static final class ScriptResult {

        private String[] output;
        private Object result;

        private ScriptResult() {
        }

        public String[] getOutput() {
            return output;
        }

        public Object getResult() {
            return result;
        }

        private static ScriptResult create(Throwable throwable) {
            String message = throwable.getMessage() == null ? throwable.getClass().getName() : throwable.getMessage();
            return create(null, message);
        }

        private static ScriptResult create(Object result, String output) {
            ScriptResult scriptletResult = new ScriptResult();
            scriptletResult.result = result;
            if (StringUtils.hasLength(output)) {
                scriptletResult.output = output.split(System.lineSeparator());
            }
            return scriptletResult;
        }
    }
}