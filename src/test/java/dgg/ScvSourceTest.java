package dgg;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScvSourceTest extends Main{

    @ValueSource(strings = {
            "/ru/flows/develop/",
            "/ru/flows/admin/",
            "/ru/flows/design/",
            "/ru/flows/management/",
            "/ru/flows/marketing/",
            "/ru/flows/popsci/"

    })
    @ParameterizedTest(name = "Searching element on web page: {0}")
    void checkSiteLinks(String searchQuery) {
        open(baseUrl + searchQuery);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(baseUrl + searchQuery, currentUrl);
    }

    @CsvSource({
            "/ru/flows/develop/",
            "/ru/flows/admin/",
            "/ru/flows/design/",
            "/ru/flows/management/",
            "/ru/flows/marketing/",
            "/ru/flows/popsci/"
    })
    @ParameterizedTest(name = "Searching element on web page: {0}")
    void searchElementsInDome(String searchQuery) {
        open(baseUrl);
        $$(".tm-main-menu__item").filterBy(Condition.href(searchQuery)).first().click();
        sleep(1000);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(baseUrl + searchQuery, currentUrl);
    }
}
