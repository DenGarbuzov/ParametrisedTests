package dgg;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MethodSourceTest extends Main{

    static Stream<String> testWithDefaultString() {
        return Stream.of(randomName(), randomName(), randomName(), randomName(), randomName(), randomName(),
                randomName(), randomName(), randomName(), randomName(), randomName(), randomName(), randomName(),
                randomName(), randomName(), randomName(), randomName(), randomName(), randomName(), randomName());
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
        System.out.println("testWith_MethodSource(arg) => "+arg);
        assertNotNull(arg);
    }

    @ParameterizedTest
    @MethodSource()
    void testWithIntAndStrings(String arg, int arg1, int arg2, int arg3) {
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

