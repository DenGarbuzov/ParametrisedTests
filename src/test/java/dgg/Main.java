package dgg;

import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Main {


    String baseUrl = "https://habr.com/ru/all/",
            panelFirstLink = ".tm-tabs__tab-item",
           mainUrl = "https://habr.com",
            google = "https://google.com",
            yandex = "https://ya.ru";



    public void openMyWebsite(){
            open(baseUrl);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals(baseUrl, currentUrl);
    }

    public static String randomName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }
}
