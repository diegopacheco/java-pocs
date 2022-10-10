import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String args[]) throws Exception {
        String token = System.getenv("GH_TOKEN");
        GitHub github = new GitHubBuilder().withOAuthToken(token).build();

        System.out.println("Netflix >=2022 Repos ");
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
        Date year = sdformat.parse("01/01/2022");

        github.getOrganization("Netflix").getRepositories().values().
                forEach(r -> {
                    try {
                        if (r.getCreatedAt().after(year)){
                            System.out.print(r.getFullName());
                            System.out.println(r.getCreatedAt());
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
