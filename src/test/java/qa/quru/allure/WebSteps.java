package qa.quru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step
    public void openMainPage(String value){
        open(value);
    }

    @Step
    public void searchRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }
    @Step
    public void openRepo(String repo){
        $(linkText(repo)).click();
    }

    @Step
    public void openIssue(){
        $("#issues-tab").click();
    }

    @Step
    public void checkIssue(String issue){
        $(withText(issue)).should(Condition.exist);

    }

}
