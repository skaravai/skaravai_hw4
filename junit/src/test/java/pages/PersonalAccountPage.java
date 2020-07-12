package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends AbstractPage {

    public PersonalAccountPage(WebDriver driver) {

        super(driver);
    }

    public BiographyPage clickAboutMe() {
        // /html/body/div[1]/div/div[3]/div/div/div/a[3]
        driver.findElement(By.cssSelector("a[title='О себе']")).click();
        return new BiographyPage(driver);
    }

}
