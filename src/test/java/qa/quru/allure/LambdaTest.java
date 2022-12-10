package qa.quru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends SelenideTest {


    @Test
    public void testLambda() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную старницу" + REPOSITORY, () -> {
            open(URL);
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Открываем репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Переходим на вкладку Issue", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue", () -> {
            $(withText("ISSUE")).should(Condition.exist);
        });

    }

    @Test
    public void checkIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage(URL);
        webSteps.searchRepository(REPOSITORY);
        webSteps.openRepo(REPOSITORY);
        webSteps.openIssue();
        webSteps.checkIssue(ISSUE);

    }

}
