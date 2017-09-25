package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class MainPage extends BasePage{

    @FindBy(xpath = "//*[contains(text(),'Мой OZON')]")
    WebElement myOzonButton;

    @FindBy(xpath = "//div[contains(text(),'Вход')]")
    WebElement signInOutButton;

    @FindBy(name = "login")
    WebElement login;

    @FindBy(name = "Password")
    WebElement password;

    @FindBy(xpath = "//*[text()='Войти']")
    WebElement signIn;

    @FindBy(id = "SearchText")
    WebElement searchText;

    @FindBy(css = "div.bFlatButton.mSearchButton")
    WebElement searchButton;


    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void logInOzon(String userLogin, String userPassword) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 2, 5000);
        myOzonButton.click();
        myOzonButton.click();
        wait.until(ExpectedConditions.visibilityOf(signInOutButton));
        signInOutButton.click();
        fillField(login,userLogin);
        fillField(password,userPassword);
        signIn.click();
        wait.until(stalenessOf(driver.findElement(By.xpath("//*[text()='Войти']"))));
    }

    public void makeSearch(String yourSearchtext){
        searchText.click();
        fillField(searchText, yourSearchtext);
        searchButton.click();
    }


}
