package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    private By emailField = By.cssSelector("form[action='/login/'] input[name='email']");
    private By passwordField = By.cssSelector("form[action='/login/'] input[name='password']");
    private By loginButton = By.cssSelector("form[action='/login/'] button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String login) {
        driver.findElement(emailField).sendKeys(login);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return new LoginPage(driver);
    }

    public LoginPage clickEnterButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public MainPage authorization(String login, String password) {
        this.enterEmail(login);
        this.enterPassword(password);
        this.clickEnterButton();
        return new MainPage(driver);
    }

}
