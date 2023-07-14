import com.splunk.Application;
import com.splunk.Service;
import com.splunk.ServiceArgs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.Socket;
import java.security.cert.CertificateException;

public class Main {
    public static void main(String args[]) throws Exception {

        /*
        trustAllHosts();
        ServiceArgs splunkArgs = new ServiceArgs();
        splunkArgs.setUsername("admin");
        splunkArgs.setPassword("<password>");
        splunkArgs.setHost("127.0.0.1");
        splunkArgs.setToken("5086f1e1-2bfd-4352-9b3f-cb11fcfcf099");
        splunkArgs.setPort(8000);
        Service service = Service.connect(splunkArgs);
        for (Application app : service.getApplications().values()) {
            System.out.println(app.getName());
        }
        */

        //Logger logger = Logger.getLogger(Main.class.getName());
        Logger logger = LogManager.getLogger(Main.class);
        logger.info("This is going to splunk. app=mainapp env=local test=true");
        logger.error("This is a test error for log4j test app=mainapp env=local test=true");
        logger.error("here is a stack there " + new RuntimeException(new RuntimeException(new IOException("fake"))));
        logger.info("DONE! app=mainapp env=local test=true");
        logger.info("DONE! app=mainapp env=local test=true");
        logger.info("DONE! app=mainapp env=local test=true");
        logger.info("DONE! app=mainapp env=local test=true");
        Thread.sleep(5000);
    }

    public static void trustAllHosts() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509ExtendedTrustManager() {
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] xcs, String string, Socket socket) throws CertificateException {
                        }
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] xcs, String string, Socket socket) throws CertificateException {
                        }
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] xcs, String string, SSLEngine ssle) throws CertificateException {
                        }
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] xcs, String string, SSLEngine ssle) throws CertificateException {
                        }
                    }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
