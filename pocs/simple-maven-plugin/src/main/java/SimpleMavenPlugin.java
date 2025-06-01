import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "smp", defaultPhase = LifecyclePhase.COMPILE)
public class SimpleMavenPlugin extends AbstractMojo {

    @Parameter(property = "smp.name", defaultValue = "World")
    private String name;

    public void execute() throws MojoExecutionException {
        getLog().info("************** Simple Maven Plugin **************");
        getLog().info("Hello, " + name + " from your Maven Plugin!");
        getLog().info("**************************************************");
    }
}
