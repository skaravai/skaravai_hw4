package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BiographyPage extends AbstractPage {

    public BiographyPage(WebDriver driver) {
        super(driver);
    }

    public BiographyPage enterName (String name) {
        driver.findElement(By.cssSelector("input[name='fname_latin']")).clear();
        driver.findElement(By.cssSelector("input[name='fname_latin']")).sendKeys(name);
        return new BiographyPage(driver);

    }

    public BiographyPage enterSurname (String surname) {
        driver.findElement(By.cssSelector("input[name='lname_latin']")).clear();
        driver.findElement(By.cssSelector("input[name='lname_latin']")).sendKeys(surname);
        return new BiographyPage(driver);
    }

    public BiographyPage chooseTypeOK () {
        driver.findElement(By.cssSelector(".placeholder")).click();
        driver.findElement(By.cssSelector("button[title='OK']")).click();
        return new BiographyPage(driver);
    }

    public BiographyPage chooseTypeVK () {
        driver.findElement(By.cssSelector(".placeholder")).click();
        driver.findElement(By.xpath("(//*[@title='VK'])[2]")).click();
        return new BiographyPage(driver);
    }
    public BiographyPage enterFirstContact (String contact) {
        driver.findElement(By.cssSelector("#id_contact-0-value")).sendKeys(contact);
        return new BiographyPage(driver);
    }

    public BiographyPage enterSecondContact (String contact) {
        driver.findElement(By.cssSelector("#id_contact-1-value")).sendKeys(contact);
        return new BiographyPage(driver);
    }

    public BiographyPage clickAddButton() {
        driver.findElement(By.xpath("//*[contains(text(),'Добавить')]")).click();
        return new BiographyPage(driver);
    }

    public BiographyPage clickSaveButton() {
        driver.findElement(By.cssSelector("button[name='continue']")).click();
        return new BiographyPage(driver);
    }

    public void fillData(String name, String surname, String contact1, String contact2) {
        this.enterName(name);
        this.enterSurname(surname);
        this.chooseTypeOK();
        this.enterFirstContact(contact1);
        this.clickAddButton();
        this.chooseTypeVK();
        this.enterSecondContact(contact2);
        this.clickSaveButton();
    }

    public BiographyPage clickDeleteButton() {
        driver.findElement(By.xpath("(//*[contains(text(),'Удалить')])[4]")).click();
        driver.findElement(By.xpath("(//*[contains(text(),'Удалить')])[2]")).click();
        return new BiographyPage(driver);
    }

    public WebElement getName() {
        return driver.findElement(By.cssSelector("input[name='fname_latin']"));
    }

    public WebElement getSurname() {
        return driver.findElement(By.cssSelector("input[name='lname_latin']"));
    }

    public WebElement getFirstContact() {
        return driver.findElement(By.cssSelector("#id_contact-0-value"));
    }

    public WebElement getSecondContact() {
        return driver.findElement(By.cssSelector("#id_contact-1-value"));
    }

}
