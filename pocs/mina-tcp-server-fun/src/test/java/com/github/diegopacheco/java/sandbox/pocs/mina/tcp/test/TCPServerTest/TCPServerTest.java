package com.github.diegopacheco.java.sandbox.pocs.mina.tcp.test.TCPServerTest;

import com.github.diegopacheco.java.sandbox.pocs.mina.tcp.TCPServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TCPServerTest {

    @Test
    public void testaskForTimeClientServer() throws Exception{
        TCPServer.main(new String[]{});
        SleepWell.sleepSilently(1000);
        TCPClient client = new TCPClient();
        SleepWell.sleepSilently(1000);
        String response = client.askTime();
        System.out.println("Response from TCP Server: " + response);

        assertNotNull(response);
        assertTrue(response.contains("<date-response>"));
        assertTrue(response.contains("</date-response>"));
        assertTrue(response.contains("<date>"));
        assertTrue(response.contains("</date>"));
    }

}
