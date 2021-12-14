package utilities.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

import static drivers.ui.InitGUI.driver;
import static java.lang.Thread.sleep;
import static utilities.selenium.WaitUtils.TIMEOUT_10;
import static utilities.selenium.WaitUtils.waitUntilElementDisplayed;

public class ClickUtils {
    public static void rightClick(WebElement element) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();
            sleep(1000);
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
        }
    }

    public static void clickOnElement(WebElement element) {
        try {
            waitUntilElementDisplayed(element, TIMEOUT_10);
            element.click();
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickOnLinkText(String linkText) {
        try {
            driver.findElement(By.linkText(linkText)).click();
            sleep(1000);
        } catch (Exception e) {

        }
    }
}
