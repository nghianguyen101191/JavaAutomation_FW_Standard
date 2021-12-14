package utilities.selenium;


import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class TextField {

    /**
     * Text Field
     * =====================================================================================================================
     * *Text Field*
     * =====================================================================================================================
     */
    public static void sendKeysToElement(WebElement element, String value) {
        clearField(element);
        try {
            element.sendKeys(value);
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Error in sending following element: " + element + "");
        }
    }

    public static void clearField(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("The following element could not be cleared:  " + element.getText() + "");
        }
    }
}