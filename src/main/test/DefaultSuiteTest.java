// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DefaultSuiteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();

  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testSeneniumSearch() throws InterruptedException {
    driver.get("http://172.28.30.184/#/home");
    driver.manage().window().setSize(new Dimension(1936, 1031));
//    driver.findElement(By.cssSelector(".icon-gengduo")).click();
//    driver.findElement(By.cssSelector(".el-dropdown-menu__item:nth-child(4) > span")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("superadmin");
    driver.findElement(By.name("password")).sendKeys("Fxq2020!@#");
    driver.findElement(By.cssSelector(".el-checkbox__inner")).click();
    driver.findElement(By.cssSelector(".el-button > span")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".workNotice span")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".workNotice span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    long time=1000;
    Thread.sleep(time);
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".taskNotice .el-menu-item"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector("#pane-1 .el-col:nth-child(1) .el-input > .el-input__inner")).click();
    driver.findElement(By.cssSelector("#pane-1 .el-col:nth-child(1) .el-input > .el-input__inner")).sendKeys("7");
    driver.findElement(By.cssSelector("#pane-1 .el-row .el-button--primary")).click();
    driver.findElement(By.cssSelector("#pane-1 .el-row .el-button--primary > span")).click();
    Thread.sleep(time);
  }
}
