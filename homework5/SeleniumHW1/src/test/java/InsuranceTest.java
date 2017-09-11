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
  public void test12() throws Exception {
    Wait<WebDriver> wait = new WebDriverWait(driver, 1, 5000);

    //Шаг 1: Перейти на страницу http://www.sberbank.ru/ru/person
    driver.get(baseUrl);

    //Шаг 2: Нажать на кнопку выбора региона
    driver.findElement(By.cssSelector("span.region-list__arrow")).click();

    //Шаг 3: В появившемся «окне»  при помощи поиска найти и выбрать Нижегородская область
    WebElement search = driver.findElement(By.xpath("(//input[@value=''])[3]"));
    wait.until(ExpectedConditions.visibilityOf(search));
    search.click();
    search.sendKeys("Ниж");
    driver.findElement(By.cssSelector("div.kit-autocomplete-input__option")).click();

    //Шаг 4: Проверить, что на главной странице отображается выбранная область
    assertTrue(isElementPresent(By.linkText("Нижегородская область")));

    //Шаг 5: Сделать скролл до footer объекта на главной странице.
    wait.until(ExpectedConditions.visibilityOf(
            driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-container']"))));
    WebElement footer = driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-container']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", footer);

    //Шаг 6: Проверить, что footer содержит значки социальных сетей
    assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_fb']")));
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
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
