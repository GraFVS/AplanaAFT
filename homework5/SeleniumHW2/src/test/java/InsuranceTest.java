import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTest {
  private WebDriver driver;
  private String baseUrl;


  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    baseUrl = "http://www.sberbank.ru/ru/person";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }


  @Test
  public void testInsuranceTest02() throws Exception {
    Wait<WebDriver> wait = new WebDriverWait(driver, 15, 2000);

    //Шаг 1: Перейти на страницу http://www.sberbank.ru/ru/person
    driver.get(baseUrl);

    //Шаг 2: Нажать на – Застраховать себя и имущество
    wait.until(ExpectedConditions.elementToBeClickable(
            driver.findElement(By.xpath("//div[contains(@class,' banner-group-carousel')]"))));
    driver.findElement(By.partialLinkText("Застраховать себя")).click();

    //Шаг 3: Выбрать – Страхование путешественников
    driver.findElement(By.linkText("Страхование путешественников")).click();

    //Шаг 4: Проверить наличие на странице заголовка – Страхование путешественников
    assertEquals("Страхование путешественников", driver.findElement(By.cssSelector(".sbrf-rich-outer>h1")).getText());

    //Шаг 5: Нажать на – Оформить Онлайн
    driver.findElement(By.cssSelector("p > a > img")).click();

    //Шаг 6: На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
    switchToNewWindow();
    wait.until(ExpectedConditions.visibilityOf(
            driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding"))));
    driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")).click();

    //Шаг 7: Нажать Оформить
    driver.findElement(By.cssSelector("span.b-continue-btn")).click();

    //Шаг 8: На вкладке Оформить заполнить поля
    driver.findElement(By.name("insured0_surname")).clear();
    driver.findElement(By.name("insured0_surname")).sendKeys("Ivanov");
    driver.findElement(By.name("insured0_name")).clear();
    driver.findElement(By.name("insured0_name")).sendKeys("Ivan");
    driver.findElement(By.cssSelector("img.ui-datepicker-trigger")).click();
    driver.findElement(By.name("insured0_birthDate")).sendKeys("09051990");
    driver.findElement(By.name("surname")).clear();
    driver.findElement(By.name("surname")).sendKeys("Иванов");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Иван");
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys("Иванович");
    driver.findElement(By.xpath("(//img[@alt='Выбрать дату'])[2]")).click();
    driver.findElement(By.name("birthDate")).sendKeys("09051990");
    driver.findElement(By.name("passport_series")).clear();
    driver.findElement(By.name("passport_series")).sendKeys("1710");
    driver.findElement(By.name("passport_number")).clear();
    driver.findElement(By.name("passport_number")).sendKeys("112233");
    driver.findElement(By.xpath("(//img[@alt='Выбрать дату'])[3]")).click();
    driver.findElement(By.name("issueDate")).sendKeys("20102010");
    driver.findElement(By.name("issuePlace")).clear();
    driver.findElement(By.name("issuePlace")).sendKeys("тыр тыр тыр");

    //Шаг 9: Проверить, что все поля заполнены правильно
    assertEquals("Ivanov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
    assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
    assertEquals("09.05.1990", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
    assertEquals("Иванов", driver.findElement(By.name("surname")).getAttribute("value"));
    assertEquals("Иван", driver.findElement(By.name("name")).getAttribute("value"));
    assertEquals("Иванович", driver.findElement(By.name("middlename")).getAttribute("value"));
    assertEquals("09.05.1990", driver.findElement(By.name("birthDate")).getAttribute("value"));
    assertEquals("1710", driver.findElement(By.name("passport_series")).getAttribute("value"));
    assertEquals("112233", driver.findElement(By.name("passport_number")).getAttribute("value"));
    assertEquals("20.10.2010", driver.findElement(By.name("issueDate")).getAttribute("value"));
    assertEquals("тыр тыр тыр", driver.findElement(By.name("issuePlace")).getAttribute("value"));

    //Шаг 10: Нажать продолжить
    driver.findElement(By.cssSelector("span.b-continue-btn")).click();

    //Шаг 11: Проверить, что появилось сообщение - Заполнены не все обязательные поля
    assertEquals(
            "Заполнены не все обязательные поля",
            driver.findElement(By.xpath("//div[contains(@ng-show,'tryNext && myForm.$invalid')]")).getText()
    );
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
   }

  private void switchToNewWindow() {
    Set<String> handles = driver.getWindowHandles();
    for (String winHandle : handles) {
      if (!winHandle.equals(driver.getWindowHandle())) {
        driver.switchTo().window(winHandle);
      }
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
