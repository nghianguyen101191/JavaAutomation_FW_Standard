package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class Headless {
    private static String driverPath = "./web-driver";
    private static String appUrl= "https://localhost:4443/";
    @Test
    public void headless() {
        System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(appUrl);
        System.out.println("Page title is - " + driver.getTitle());
        //Search on Google
    }
    @Test
    public String returnText() {
        String a = "Nghia Test";
        System.out.println(a);

        return null;

    }

}
