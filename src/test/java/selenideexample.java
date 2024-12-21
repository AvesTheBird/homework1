import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class Selenideexample {

    @BeforeClass
    void init(){
        Configuration.baseUrl = "https://www.simbirsoft.com/";
        Configuration.browserSize = "1920x2100";
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 40000;
        Configuration.headless = false;
    }

    @Test
    public void test1() {
        open();
        $(By.cssSelector("[data-gclick='showModalFeedback']"))
                .shouldBe(visible)
                .shouldHave(text("Написать нам"))
                .click();
        $x("//*[@class='fmo-parent']//*[@class='fb-modal-default']").shouldBe(visible);
        sleep(5000);
    }

    @Test
    public void test2() {
        open("https://www.simbirsoft.com/");
        $(By.xpath("//*[contains(@class,'gh-nav-item--about')]"))
                .shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .click();
        $(By.xpath("//h1"))
                .shouldHave(text("Контакты"))
                .shouldBe(visible);
        webdriver().shouldHave(url("https://www.simbirsoft.com/contacts/"));
        sleep(5000);
    }


    //мой тест для проверки кнопки вакансии
    @Test
    public void checkVacanciesButton() {
        open("https://www.simbirsoft.com/");
        $x("//a[contains(@class,'gh-nav-link') and contains(text(),'Вакансии')]")
                .shouldBe(visible)
                .click();
        webdriver().shouldHave(url("https://www.simbirsoft.com/vacancies/"));
        $x("//h1").shouldHave(text("Вакансии"));
    }

}
