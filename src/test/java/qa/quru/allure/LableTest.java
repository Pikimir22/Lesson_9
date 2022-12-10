package qa.quru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LableTest {


    @Test
    @Feature("Поиск")
    @Story("Создание")
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание")
    public void testStatic(){

    }

    @Test
    public void testDynamic(){

    }

}
