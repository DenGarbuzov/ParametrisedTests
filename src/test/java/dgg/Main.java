package dgg;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Main {
    String baseUrl = "https://habr.com/ru/all/",
            panelFirstLink = ".tm-tabs__tab-item";



    public void openMyWebsite(){
            open(baseUrl);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals(baseUrl, currentUrl);
    }
}
