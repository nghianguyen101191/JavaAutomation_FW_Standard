package utilities.selenium;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static drivers.ui.InitGUI.Reporter;
import static utilities.others.Screenshot.screenShoot;

public class Validate {

    public static void assertEquals(String actually, String expected) {
        try {
            Assert.assertEquals(actually, expected);
        } catch (Exception e) {
            throw (e);
        }
    }

    public static void elementTextEqual(WebElement wel, String text) {
        if (wel.getText().equals(text)) {
            Reporter.log(LogStatus.PASS, "-" + wel + " was verify passed");
        } else {
            Reporter.log(
                    LogStatus.FAIL,
                    ""
                            + wel
                            + " was verify failed. Expected: "
                            + text
                            + " - Actual: "
                            + wel.getText()
                            + screenShoot());
            throw new Error(
                    "elementTextEqual was verify failed: Expected:  "
                            + text
                            + " - Actual: "
                            + wel.getText()
                            + "");
        }
    }

    public static void elementTextContain(WebElement wel, String text) {
        if (wel.getText().contains(text)) {
            Reporter.log(LogStatus.PASS, "" + text + " was verify passed");
        } else {
            Reporter.log(
                    LogStatus.FAIL,
                    ""
                            + wel
                            + "  was verify failed. Expected: "
                            + text
                            + " - Actual: "
                            + wel.getText()
                            + screenShoot());
            throw new Error("elementTextContain was verify failed: " + text + "");
        }
    }

    public static void elementTextNotContain(WebElement wel, String text) {
        System.out.print(wel.getText());
        if (!wel.getText().contains(text)) {
            Reporter.log(LogStatus.PASS, "" + text + "  was verify passed");
        } else {
            Reporter.log(
                    LogStatus.FAIL,
                    ""
                            + wel
                            + "  was verify failed. Expected: "
                            + text
                            + " - Actual: "
                            + wel.getText()
                            + screenShoot());
            throw new Error("elementTextContain was verify failed: " + text + "---");
        }
    }

    public static void elementTextNotEmpty(WebElement wel) {
        System.out.print(wel.getText());
        if (!wel.getText().isEmpty()) {
            Reporter.log(LogStatus.PASS, "was verify passed");
        } else {
            Reporter.log(
                    LogStatus.FAIL,
                    "" + wel + "  was verify failed. Expected: " + " - Actual: " + wel.getText());
            throw new Error("elementTextContain was verify failed: " + "---");
        }
    }

    public static void elementTextMatches(String dec, WebElement wel, String regex) {
        System.out.print(wel.getText());
        if (wel.getText().matches(regex)) {
            Reporter.log(LogStatus.PASS, dec + " " + " was verify passed");
        } else {
            Reporter.log(
                    LogStatus.FAIL,
                    dec
                            + " "
                            + " was verify failed. Expected: "
                            + regex
                            + " - Actual: "
                            + wel.getText()
                            + screenShoot());
        }
    }

    public static void textOneTextContainTextTwo(String text1, String text2) {
        if (text1.contains(text2)) {
            Reporter.log(LogStatus.PASS, "TextContain was verify passed");
        } else {
            Reporter.log(
                    LogStatus.FAIL,
                    " CompareTextContain failed. Expected: " + text1 + " - Actual: " + text2 + screenShoot());
            throw new Error("elementTextContain was verify failed" + text1 + " - Actual: " + text2);
        }
    }

    public void clickElementsManytime(WebElement we2, int times) {
        for (int i = 1; i <= times; i++) {
            we2.click();
        }
    }

    public static void elementAttributeContainsText(WebElement webElement, String attribute, String text) {
        if (webElement.getAttribute(attribute).contains(text)) {
            Reporter.log(LogStatus.PASS, "" + text + " was verify passed");
        } else {
            Reporter.log(
                    LogStatus.FAIL,
                    ""
                            + webElement
                            + "  was verify failed. Expected: "
                            + text
                            + " - Actual: "
                            + webElement.getAttribute(attribute)
                            + screenShoot());
            throw new Error("elementTextContain was verify failed: " + text + "");
        }
    }
}
