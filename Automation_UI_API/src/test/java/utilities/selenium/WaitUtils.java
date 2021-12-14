package utilities.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static drivers.ui.InitGUI.driver;

public class WaitUtils {

    public static final int TIMEOUT_5 = 5;
    public static final int TIMEOUT_10 = 10;
    public static final int TIMEOUT_20 = 20;
    public static final int TIMEOUT_30 = 30;
    public static final int TIMEOUT_40 = 40;
    public static final int TIMEOUT_50 = 50;
    public static final int TIMEOUT_60 = 60;
    public static final int TIMEOUT_70 = 70;
    public static final int TIMEOUT_80 = 80;
    public static final int TIMEOUT_90 = 90;
    public static final int TIMEOUT_100 = 100;
    public static final int TIMEOUT_200 = 200;
    public static final int TIMEOUT_300 = 300;
    public static final int TIMEOUT_500 = 500;
    public static final int TIMEOUT_700 = 700;
    public static final int TIMEOUT_5_SECOND = 5000;
    public static final int TIMEOUT_10_SECOND = 10000;
    public static final int TIMEOUT_20_SECOND = 20000;
    public static final int TIMEOUT_30_SECOND = 30000;
    public static final int TIMEOUT_40_SECOND = 40000;
    public static final int TIMEOUT_50_SECOND = 50000;
    public static final int MAX_TRIES_5 = 5;

    public static void waitUntilTextDisplayed(WebElement element, Integer maxTries, String text) {
        int count = 0;
        while (true) {
            try {
                if (element.getText().contains(text)) {
                    break;
                }
            } catch (Exception e) {

                if (++count == maxTries) throw e;
            }
        }
    }

    public static void setWaitMinutes(int time) {
        try {
            Thread.sleep(time * 60000); // 1 minute
        } catch (Exception e) {
            throw new Error("waiting sleepMinute failed => Please check your method");
        }
    }

    public static void waitUntilElementDisplayed(final WebElement webElement, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsDisplayed =
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            webElement.isDisplayed();
                            return true;
                        } catch (NoSuchElementException e) {
                            throw new Error("NoSuchElementException");
                        } catch (StaleElementReferenceException f) {
                            throw new Error("StaleElementReferenceException");
                        }
                    }
                };
       wait.until(elementIsDisplayed);
    }

    public static void waitUntilElementNotDisplayed(WebElement webElement, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsDisplayed =
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            webElement.isDisplayed();
                            return false;
                        } catch (StaleElementReferenceException e) {
                            return true;
                        } catch (NoSuchElementException e) {
                            return true;
                        } catch (Exception e) {
                            return true;
                        }
                    }
                };
        wait.until(elementIsDisplayed);
    }

    public static void validateLinkTextIsNotExisted(String name) {
        List<WebElement> value = driver.findElements(By.linkText(name));
        if (value.size() != 0) {
            throw new Error("Link Text is existed");
        }
    }

    public static void waitForInvisibility(WebElement webElement, int maxSeconds) {
        Long startTime = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - startTime < maxSeconds * 1000
                    && webElement.isDisplayed()) {
            }
        } catch (StaleElementReferenceException e) {
            return;
        }
    }



    public static void sleepMinutes(int time) {
        try {
            Thread.sleep(time * 60000); // 1 minute
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static WebDriverWait initWait(int time) {
        return new WebDriverWait(driver, time);
    }



    public static boolean isElementVisible(final By by) {
        boolean value = false;

        if (driver.findElements(by).size() > 0) {
            value = true;
        }
        return value;
    }



    public static boolean returnWaitElementVisible(WebElement we, int time) {
        try {
            WebDriverWait wa = initWait(time);
            wa.until(ExpectedConditions.visibilityOf(we));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitElementInvisible(By by, int time) {
        WebDriverWait wa = initWait(time);
        wa.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitElementVisible(By by, int time) {
        WebDriverWait wa = initWait(time);
        wa.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitListElementVisible(ArrayList<WebElement> we, int time) {
        WebDriverWait wa = initWait(time);
        wa.until(ExpectedConditions.visibilityOfAllElements(we));
    }

    public static void waitElementPresence(By by, int time) {
        WebDriverWait wa = initWait(time);
        wa.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitElementVisibleLocator(String byElement, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        switch (byElement) {
            case "id":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                break;
            case "css":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
                break;
            default:
                break;
        }
    }

    public static void waitElementClickable(WebElement we, int time) {
        WebDriverWait wa = initWait(time);
        wa.until(ExpectedConditions.elementToBeClickable(we));
    }

    public WebElement findWebElement(By by) {
        WebElement wb = null;
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return wb;
    }

    public boolean elementEndabled(WebElement we) {
        try {
            return we.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Extra Nghia Nguyen Method
     */
    public WebElement getWhenVisible(By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public void clickWhenReady(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

  /*public void Influentwait throws InterruptedException  {
      WaitUtils<WebDriver> wait = new FluentWait<WebDriver>(driver)
              .withTimeout(30, TimeUnit.SECONDS)
              .pollingEvery(5, TimeUnit.SECONDS)
              .ignoring(NoSuchElementException.class);
      WebElement selectlink = wait.until(new Function<Webdriver, WebElement>(){

          public WebElement apply(WebDriver driver ) {
              return driver.findElement(By.xpath(""));
          }
      });
  }*/

    public void implicit_Wait_ID(String str, String iddd) throws Exception {
        for (int i = 0; i < 30; i++) {
            try {
                driver.findElement(By.id(str)).isDisplayed();
                break;
            } catch (Exception e) {
                Thread.sleep(2000);
            }
        }
    }

    public WebElement isElementLoaded(WebElement elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }
}
