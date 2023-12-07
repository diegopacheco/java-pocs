import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main{
  public static void main(String args[]){




  }

  private static void donwloadFile(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    WebDriver driver = new ChromeDriver(options);

    driver.get("https://simplemaps.com/static/data/us-cities/1.77/" +
    "basic/simplemaps_uscities_basicv1.77.zip");
    
    driver.quit();
    System.out.println("done");
  }

}
