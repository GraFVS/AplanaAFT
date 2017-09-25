import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SearchResultsPage;

import java.util.ArrayList;
import java.util.List;

public class OzonTest extends BaseTest{

    @Test(description = "Тест на ozon.ru")
    public void Test(){
        //1.	Перейдите на сервис http://www.ozon.ru/
        driver.get(baseUrl);

        MainPage mainPage = new MainPage(driver);

        //2.	Выполните авторизацию на сервисе с ранее созданным логином и паролем
        mainPage.logInOzon("tester@p33.org", "testpassword");

        //3.	Выполните поиск по «iPhone»
        mainPage.makeSearch("iPhone");

        //4.	Добавьте в корзину все возможные товары среди найденных
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<String> idToCartList = new ArrayList<>();
        idToCartList=searchResultsPage.addToCartAndRemember();

        //5.	Перейдите в корзину, убедитесь, что все добавленные ранее товары находятся в корзине
        searchResultsPage.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.checkGoodsInCart(idToCartList);

        //6.	Удалите все товары из корзины
        cartPage.deleteAllFromCart();

        //7.	Разлогиньтесь с сервиса
        cartPage.logOutOzon();

        //8.	Выполните авторизацию на сервисе
        mainPage.logInOzon("tester@p33.org", "testpassword");

        //9.	Проверьте, что корзина не содержит никаких товаров
        searchResultsPage.goToCartPage();
        cartPage.checkEmptyCart();

    }

}
