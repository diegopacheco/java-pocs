package com.github.diegopacheco.astra.session;

import com.datastax.oss.driver.api.core.CqlSession;
import java.nio.file.Paths;

public class SessionManager {

    private static String username = System.getProperties().getProperty("ASTRA_USER");
    private static String pass = System.getProperties().getProperty("ASTRA_PASS");
    private static String bundle = System.getProperties().getProperty("ASTRA_BUNDLE");

    private static CqlSession session;

    static{
         session = CqlSession.builder()
                 .withCloudSecureConnectBundle(Paths.get(bundle))
                 .withAuthCredentials(username,pass)
                 .build();
    }

    public static CqlSession getSession(){
        return session;
    }

}
