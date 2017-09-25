package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class CartPage extends BasePage {



    @FindBy(xpath = "//div[@id='PageHeader_ctl06_SearchPanel']/div[3]/div/div/div[2]/div[2]/div[4]")
    WebElement signInOutButton;

    @FindBy(css = "span.ePanelLinks_Label")
    WebElement myOzonButton;

    @FindBy(xpath = "//*[text()='Удалить всё']")
    WebElement clearAllButton;

    @FindBy(xpath = "//*[@id='TDphLeft']/div/div[3]/div[1]/div[1]/div/div/span")
    WebElement cartIsEmpty;



    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void checkGoodsInCart(List goodsForCheck){
        for (int i = 0; i<goodsForCheck.size(); i++) {
            assertTrue(isElementPresent(By.xpath("//*[@data-id=\"" + goodsForCheck.get(i) + "\"]")));
        }
    }

    public void deleteAllFromCart(){
        while (isElementPresent(By.xpath("//*[text()='Удалить всё']"))){
            Wait<WebDriver> wait = new WebDriverWait(driver, 2, 5000);
            WebElement search = clearAllButton;
            wait.until(ExpectedConditions.visibilityOf(search));
            search.click();
            driver.navigate().refresh();
        }
    }

    public void logOutOzon(){
        Actions actions = new Actions(driver);
        actions.moveToElement(myOzonButton).build().perform();
        signInOutButton.click();
    }

    public void checkEmptyCart(){
        assertNotNull(cartIsEmpty);
    }
}



