package com.github.diegopacheco.lambda.testing;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import com.amazonaws.services.lambda.runtime.tests.EventLoader;
import com.github.diegopacheco.lambda.MyLambdaHandler;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SimpleTest {

    @Test
    public void testLoadEventBridgeEvent() throws IOException {
        // Given
        ScheduledEvent event = EventLoader.loadScheduledEvent("event.json");
        MyLambdaHandler handler = new MyLambdaHandler();

        // When
        String response = handler.handleRequest((Map) event.getDetail(), null);

        // Then
        assertThat(response,equalTo("it works"));
    }

}
