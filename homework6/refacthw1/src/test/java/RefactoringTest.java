import org.junit.Test;
import pages.MainPage;
import pages.PolicyPage;
import pages.SendAppPage;
import pages.TravelPage;

import static org.junit.Assert.assertEquals;

public class RefactoringTest extends BaseTest {

    @Test
    public void testIcons() throws Exception {
        driver.get(baseUrl + "ru/person");

        MainPage mainPage = new MainPage(driver);
        mainPage.selectRegion("Нижегородская область");
        mainPage.checkRegion("Нижегородская область");
        mainPage.scrollToFooter();

        mainPage.checkSocialNetworkIcon(mainPage.facebook);
        mainPage.checkSocialNetworkIcon(mainPage.twitter);
        mainPage.checkSocialNetworkIcon(mainPage.youtube);
        mainPage.checkSocialNetworkIcon(mainPage.instagram);
        mainPage.checkSocialNetworkIcon(mainPage.vkontakte);
        mainPage.checkSocialNetworkIcon(mainPage.odnoklassniki);
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "ru/person");

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Застраховать себя");
        mainPage.selectInsuranceItem("Страхование путешественников");

        TravelPage travelPage = new TravelPage(driver);
        travelPage.clickIssueBtn();
        assertEquals("«Сбербанк» - Страхование путешественников", travelPage.getTitle());

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        PolicyPage policyPage = new PolicyPage(driver);
        policyPage.checkAmountOfCoverage("Минимальная");
        policyPage.clickIssueBtn();

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Surname", "Sokolov");
        sendAppPage.fillField("Name", "Vasiliy");
        sendAppPage.fillField("Birth Date", "20.07.1990");
        sendAppPage.fillField("Фамилия", "Соколов");
        sendAppPage.fillField("Имя", "Василий");
        sendAppPage.fillField("Отчество", "Евгеньевич");
        sendAppPage.fillField("Дата рождения", "20.07.1990");
        sendAppPage.checkSex("Муж");
        sendAppPage.fillField("Серия паспорта", "1710");
        sendAppPage.fillField("Номер паспорта", "123456");
        sendAppPage.fillField("Дата выдачи", "01.02.2003");
        sendAppPage.fillField("Кем выдан", "коммент");

        sendAppPage.scrollViewAndClick();

        sendAppPage.checkFillField("Sokolov", sendAppPage.insuredSurname);
        sendAppPage.checkFillField("Vasiliy", sendAppPage.insuredName);
        sendAppPage.checkFillField("20.07.1990", sendAppPage.insuredBirthDate);
        sendAppPage.checkFillField("Соколов", sendAppPage.surname);
        sendAppPage.checkFillField("Василий", sendAppPage.name);
        sendAppPage.checkFillField("Евгеньевич", sendAppPage.middlename);
        sendAppPage.checkFillField("20.07.1990", sendAppPage.birthDate);
        sendAppPage.checkFillField("1710", sendAppPage.passportSeries);
        sendAppPage.checkFillField("123456", sendAppPage.passportNumber);
        sendAppPage.checkFillField("01.02.2003", sendAppPage.issueDate);
        sendAppPage.checkFillField("коммент", sendAppPage.issuePlace);

        sendAppPage.checkFieldErrorMessage("Заполнены не все обязательные поля");
    }
}