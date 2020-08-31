import com.github.jeanbaptistewatenberg.junit5kubernetes.core.JunitKubernetes;
import com.github.jeanbaptistewatenberg.junit5kubernetes.core.KubernetesGenericObject;
import com.github.jeanbaptistewatenberg.junit5kubernetes.core.KubernetesObject;
import com.github.jeanbaptistewatenberg.junit5kubernetes.core.PortMapper;
import com.github.jeanbaptistewatenberg.junit5kubernetes.core.impl.GenericPodBuilder;
import com.github.jeanbaptistewatenberg.junit5kubernetes.core.wait.impl.pod.PodWaitRunningStatusStrategy;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@JunitKubernetes
public class KubernetesJunitTest {

    private static final String NGINX_PORT = "nginx-80";
    private final PortMapper portMapper = new PortMapper();

    @KubernetesObject
    private KubernetesGenericObject pod = new GenericPodBuilder()
            .withNewSpec()
            .addNewContainer()
            .withName("demonginx")
            .withImage("nginx")
            .addNewPort()
            .withHostPort(portMapper.computeAvailablePort(NGINX_PORT))
            .withContainerPort(80)
            .endPort()
            .endContainer()
            .endSpec()
            .withWaitStrategy(new PodWaitRunningStatusStrategy())
            .build();

    @Test
    void should_start_a_pod() throws IOException {
        assertThat(pod.getObjectHostIp()).isNotBlank();
        assertThat(portMapper.getComputedPort("nginx-80")).isNotNull();

        URL url = new URL("http://" + pod.getObjectHostIp() + ":" + portMapper.getComputedPort(NGINX_PORT));
        int status = responseStatus(url);
        assertThat(status).isEqualTo(200);
    }

    private int responseStatus(URL url) {
        try{
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}