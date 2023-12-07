import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws Exception {
        donwloadFile();
    }

    private static void donwloadFile() throws Exception {

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        String downloadPath = new File(".").getCanonicalPath() + "/target/";
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://simplemaps.com/static/data/us-cities/1.77/" +
                "basic/simplemaps_uscities_basicv1.77.zip");

        driver.quit();
        System.out.println("done");
    }

}
