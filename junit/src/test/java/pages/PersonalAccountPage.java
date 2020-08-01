package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends AbstractPage {

    public PersonalAccountPage(WebDriver driver) {

        super(driver);
    }

    public BiographyPage clickAboutMe() {
        driver.findElement(By.cssSelector("a[title='О себе']")).click();
        return new BiographyPage(driver);
    }
}
