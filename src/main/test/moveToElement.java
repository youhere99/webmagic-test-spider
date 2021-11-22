import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class moveToElement {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    try {
      // Navigate to Url
      driver.get("https://google.com");

      // Store 'Gmail' anchor web element
      WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
      Actions actionProvider = new Actions(driver);
      // Performs mouse move action onto the element
      actionProvider.moveToElement(gmailLink).build().perform();
    } finally {
      driver.quit();
    }
  }
}
  