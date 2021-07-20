package com.github.diegopacheco.embeded.http.server.hc.test;

import com.github.diegopacheco.embeded.http.server.hc.EmbeddedHCServer;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class EmbeddedHCServerTest {

    @Test
    public void testHCServer(){
        try{
            EmbeddedHCServer.start();
            String status = new Scanner(EmbeddedHCServer.getServerHCURL().
                    openStream(), "UTF-8").useDelimiter("\\A").next();
            assertNotNull(status);
            assertEquals("200",status);
        }catch(Exception e){
            fail(e);
        }finally {
            EmbeddedHCServer.stop();
        }
    }

}
