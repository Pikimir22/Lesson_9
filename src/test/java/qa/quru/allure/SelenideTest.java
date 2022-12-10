package qa.quru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.nio.channels.SocketChannel.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    public final String URL = "https://github.com";
    public final String REPOSITORY = "Pikimir22/Lesson_8";
    public final String ISSUE = "Issue";


    @Test
    public void testIssueSurch(){

        SelenideLogger.addListener("allure",new AllureSelenide());

            open(URL);
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();

            $(linkText(REPOSITORY)).click();
            $("#issues-tab").click();
            $(withText("#80")).should(Condition.exist);
    }
}
