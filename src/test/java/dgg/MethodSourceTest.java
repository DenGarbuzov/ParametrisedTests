package dgg;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MethodSourceTest extends Main{

    static Stream<String> testWithDefaultString() {
        return Stream.of(randomName(), randomName(), randomName(),
                randomName(), randomName(), randomName());
    }

    static Stream<Arguments> testWithIntAndStrings() {
        return Stream.of(
                Arguments.of("Peter", 28, 178, 90),
                Arguments.of("Molly", 23, 170, 55),
                Arguments.of("Fura",99, 165, 60));
    }

    @ParameterizedTest
    @MethodSource("testWithDefaultString")
    void testWith_MethodSource(String arg) {
        assertNotNull(arg);
        open(google);
        $(".gLFyf").setValue(arg).pressEnter();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assert currentUrl.contains("search?q="+arg);
    }

    @ParameterizedTest
    @MethodSource()
    void testWithIntAndStrings(String arg, int arg1, int arg2, int arg3) {

        // название теста такое как и у метода (как часть теста)

        String wc = String.valueOf(arg2/arg3);
        System.out.println("\n"+ arg + " is my name and I am " + arg1 + " years old.\nMy Height is " + arg2 +
                " my weight is "+ arg3 + "!\nMy weight coefficient is " + wc );
        assertNotNull(arg);
        int wcToCompare = Integer.parseInt(wc);
        if (wcToCompare < 2) {
            System.out.println(arg + " is FATSO!!!");
        } else {
            System.out.println(arg + "is in good form!");
        }
    }

}

