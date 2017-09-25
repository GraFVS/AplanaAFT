package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'В корзину')]/parent::div/parent::div[@data-itemid]")
    WebElement goodsToCart;

    @FindBy(xpath = ".//div[@class='bFlatButton mTitle mAddToCart js_add']")
    WebElement addToCartButton;

    @FindBy(linkText = "Корзина")
    WebElement cartButton;

    public SearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List addToCartAndRemember(){
        List<WebElement> cartList = driver.findElements(By.xpath("//*[contains(text(), 'В корзину')]/parent::div/parent::div[@data-itemid]"));
        List<String> idToCartList = new ArrayList<>();
        for (int i = 0; i<cartList.size(); i++){
            idToCartList.add(cartList.get(i).getAttribute("data-itemid"));
            cartList.get(i).findElement(By.xpath(".//div[@class='bFlatButton mTitle mAddToCart js_add']")).click();
        }
        return idToCartList;
    }

    public void goToCartPage(){
        cartButton.click();
    }


}
