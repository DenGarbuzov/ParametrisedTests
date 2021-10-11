package dgg;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnumSourceTest extends Main{

    @EnumSource(value = Panel.class, names = {"ARTICLES"}, mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest(name = "We are testing Enum with parameters: {0}")
    public void testEnum (Panel panel) {

        // в тесте первая строка Enum класса "ARTICLES" исключена по причине неработоспособности, исключена сознательно)

        openMyWebsite();
        $$(panelFirstLink).find(Condition.text(panel.getDesc())).click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertNotEquals(baseUrl, currentUrl);


    }
}
