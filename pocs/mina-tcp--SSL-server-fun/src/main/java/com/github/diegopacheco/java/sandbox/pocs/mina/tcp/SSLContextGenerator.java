package com.github.diegopacheco.java.sandbox.pocs.mina.tcp;


import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.ssl.KeyStoreFactory;
import org.apache.mina.filter.ssl.SslContextFactory;
import org.apache.mina.filter.ssl.SslFilter;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.security.KeyStore;

public class SSLContextGenerator {

    public static void addSSLSupport(DefaultIoFilterChainBuilder chain) {
        try {
            SslFilter sslFilter = new SslFilter(SSLContextGenerator.getSslContext());
            chain.addLast("sslFilter", sslFilter);
            System.out.println("SSL support is added..");
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static SSLContext getSslContext() {
        SSLContext sslContext = null;
        try {
            String baseDir = new File(".").getCanonicalPath();
            File keyStoreFile = new File(   baseDir+"/keystore.jks");
            File trustStoreFile = new File(baseDir+"/myTrustStore");

            if (keyStoreFile.exists() && trustStoreFile.exists()) {
                final KeyStoreFactory keyStoreFactory = new KeyStoreFactory();
                System.out.println("Url is: " + keyStoreFile.getAbsolutePath());
                keyStoreFactory.setDataFile(keyStoreFile);
                keyStoreFactory.setPassword("123456");

                final KeyStoreFactory trustStoreFactory = new KeyStoreFactory();
                trustStoreFactory.setDataFile(trustStoreFile);
                trustStoreFactory.setPassword("123456");

                final SslContextFactory sslContextFactory = new SslContextFactory();
                final KeyStore keyStore = keyStoreFactory.newInstance();
                sslContextFactory.setKeyManagerFactoryKeyStore(keyStore);

                final KeyStore trustStore = trustStoreFactory.newInstance();
                sslContextFactory.setTrustManagerFactoryKeyStore(trustStore);
                sslContextFactory.setKeyManagerFactoryKeyStorePassword("123456");
                sslContext = sslContextFactory.newInstance();
                System.out.println("SSL provider is: " + sslContext.getProvider());
            } else {
                System.out.println("Keystore or Truststore file does not exist");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return sslContext;
    }
}
