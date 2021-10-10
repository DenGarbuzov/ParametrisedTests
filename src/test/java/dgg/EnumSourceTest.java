package dgg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;

public class EnumSourceTest extends Main{

    @Test
    @EnumSource(Panel.class)
    public void testEnum (Panel panel) {
        openMyWebsite();
        panelFirst.$$(By.linkText(String.valueOf(panel)));


    }
}
