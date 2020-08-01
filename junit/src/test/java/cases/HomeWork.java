package cases;

import org.junit.Assert;
import org.junit.Test;
import pages.BiographyPage;
import pages.MainPage;
import utils.BaseHooks;

public class HomeWork extends BaseHooks {

    @Test
    public void HomeWorkPageObject() {
        MainPage mainPage = new MainPage(driver);
        BiographyPage biographyPage = new BiographyPage(driver);

        //В тесте используются тестовые данные(не личные!)
        String login = System.getenv("login");
        String password = System.getenv("password");
        String name = System.getenv("name");
        String surname = System.getenv("surname");
        String firstContact = System.getenv("firstContact");
        String secondContact = System.getenv("secondContact");

        mainPage.openPage()
                .clickLoginButton()
                .authorization(login, password)
                .goToPersonalAccountPage()
                .clickAboutMe()
                .fillData(name, surname, firstContact, secondContact);

        mainPage.switchToNewTab().openPage()
                .clickLoginButton()
                .authorization(login, password)
                .goToPersonalAccountPage()
                .clickAboutMe();

        //Проверяем ранее введенные данные Имя/Фамилия
        Assert.assertEquals("First Name не совпадает", name, biographyPage.getName().getAttribute("value"));
        Assert.assertEquals("Surname не совпадает", surname, biographyPage.getSurname().getAttribute("value"));
        //Проверяем ранее созданные контакты
        Assert.assertEquals("First contact не совпадает", firstContact, biographyPage.getFirstContact().getAttribute("value"));
        Assert.assertEquals("Second contact не совпадает", secondContact, biographyPage.getSecondContact().getAttribute("value"));
        //Удаляем контакты
        biographyPage.clickDeleteButton()
                .clickSaveButton();
    }
}
