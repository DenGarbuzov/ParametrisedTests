package dgg;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Main {
    String baseUrl = "https://skylove.su/";
    public SelenideElement panelFirst = $(".nav-main");



    public void openMyWebsite(){
            open(baseUrl);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals(baseUrl, currentUrl);
    }
}
