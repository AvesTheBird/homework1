import org.dao.Person;
import org.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SimbirPage extends BaseTest {

    // Локатор главного меню
    private IWebElement MainMenu => Browser.FindElement(By.CssSelector(".main-menu"));

    // Локатор кнопки "Оставить заявку"
    private IWebElement FeedbackButton => Browser.FindElement(By.CssSelector(".feedback-button"));

    // Локатор поля поиска
    private IWebElement SearchInput => Browser.FindElement(By.CssSelector(".search-input"));

    // Локатор блока с контактами
    private IWebElement ContactsBlock => Browser.FindElement(By.CssSelector(".contacts"));

    // Метод для открытия модального окна "Оставить заявку"
    public void ShowFeedbackModal()
    {
        FeedbackButton.Click();
    }

    // Метод для ввода текста в поле поиска и выполнения поиска
    public void PerformSearch(string query)
    {
        SearchInput.SendKeys(query);
        SearchInput.Submit();
    }

    // Метод для проверки наличия блока контактов
    public bool IsContactsBlockVisible()
    {
        return ContactsBlock.Displayed;
    }

}
