package com.github.diegopacheco.mockserver.tests;

import com.github.diegopacheco.mockserver.tests.bizcode.CartManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.mock.Expectation;
import org.mockserver.model.RequestDefinition;
import org.mockserver.verify.VerificationTimes;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.Cookie.cookie;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.Parameter.param;

public class SimpleMockServerTest {

    private static ClientAndServer mockServer;

    @BeforeAll
    public static void startMockServer() {
        mockServer = startClientAndServer(8081);

        Expectation[] expectations = new MockServerClient("localhost", 8081)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/view/cart")
                                .withCookies(
                                        cookie("session", "4930456C-C718-476F-971F-CB8E047AB349")
                                )
                                .withQueryStringParameters(
                                        param("cartId", "055CA455-1DF7-45BB-8535-4F83E7266092")
                                )
                )
                .respond(
                        response()
                                .withBody("some_response_body")
                );
        System.out.println(expectations);

        RequestDefinition[] requestDefinitions = new MockServerClient("localhost", 8081)
                .retrieveRecordedRequests(
                        request()
                                .withPath("/view/cart")
                                .withQueryStringParameter("cartId","055CA455-1DF7-45BB-8535-4F83E7266092")
                                .withMethod("GET")
                );
        System.out.println(requestDefinitions);
    }

    @AfterAll
    public static void stopMockServer() {
       mockServer.stop();
    }

    @Test
    public void simpleTest() {
        CartManager cm = new CartManager();
        cm.viewCart();

        new MockServerClient("localhost", 8081)
            .verify(
                    request()
                            .withPath("/view/cart"),
                    VerificationTimes.atLeast(1)
        );
    }

}
