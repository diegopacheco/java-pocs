import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void search() {
        open("https://google.com/ncr");
        $(By.name("q")).val("codeborne").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(5));
        sleep(1000);
    }

}
