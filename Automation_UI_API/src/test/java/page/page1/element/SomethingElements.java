package page.page1.element;

import drivers.ui.TestData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utilities.selenium.ClickUtils.clickOnElement;
import static utilities.selenium.TextField.sendKeysToElement;

public class SomethingElements {
    /**
     * =================================================================================================================
     * VM
     */
    @FindBy(how = How.XPATH, using = "//input[@name='ctl00$CPHContainer$txtUserLogin']")
    public WebElement username;

    @FindBy(how = How.XPATH, using = "//input[@name='ctl00$CPHContainer$txtPassword']")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@name='ctl00$CPHContainer$btnLoginn']")
    public WebElement loginButton;


    /**
     * =================================================================================================================
     * element interaction
     */


    public WebDriver driver;

    public SomethingElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // FIXME: 8/1/2020 Will be define page object here
    public void inputUserName(TestData testData) {
        sendKeysToElement(username, testData.getUserName());


    }

    public void inputPassword(TestData testData) {
        sendKeysToElement(password, testData.getPassWord());
    }

    public void clickLoginButton() {

        clickOnElement(loginButton);
    }


}
