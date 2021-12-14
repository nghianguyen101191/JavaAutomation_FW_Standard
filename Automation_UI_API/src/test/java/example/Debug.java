package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static log.LoggerMethod.Log;

public class Debug {
  public static WebDriver driver;
  private static String driverPath = "./web-driver";
  private static String appUrl= "https://10.10.20.21:4443/";

  @BeforeTest
  protected void startReport() throws InterruptedException {
    // System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "/geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
    driver = new ChromeDriver();
    // driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get(appUrl);
    sleep(2000);
    LoginNakivo();
    sleep(2000);
  }

  @Test(groups = "2")
  public void LoginNakivo() throws InterruptedException {
    System.out.print("We will to login Nakivo");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("123456");
    sleep(2000);
    driver.findElement(By.cssSelector("div>div>div>div>div>div>div>div>em>button>span")).click();
    sleep(5000);
    Log("I am logger by local01");
    sleep(2000);
  }

  @AfterTest
  public void quit() throws InterruptedException {
    System.out.print("We will close browser");
    // driver.quit();
  }
}
