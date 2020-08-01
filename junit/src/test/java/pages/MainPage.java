package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By loginButton = By.cssSelector(".header2__auth");
    private By iconImg = By.xpath("//div[@class='header2-menu__icon-img ic-blog-default-avatar']");
    private By personalAcc = By.cssSelector("a[title='Личный кабинет']");

    public MainPage openPage() {
        driver.get("https://otus.ru/");
        return new MainPage(driver);
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public PersonalAccountPage goToPersonalAccountPage() {
        driver.findElement(iconImg).click();
        driver.findElement(personalAcc).click();
        return new PersonalAccountPage(driver);
    }

    public MainPage switchToNewTab() {
        driver.manage().deleteAllCookies();
        return new MainPage(driver);
    }
}
