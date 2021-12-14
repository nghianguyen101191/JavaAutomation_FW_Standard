package page.home;

import com.relevantcodes.extentreports.LogStatus;
import drivers.ui.InitGUI;
import drivers.ui.TestData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.home.element.LoginPageElements;

import static drivers.ui.InitGUI.Reporter;
import static drivers.ui.InitGUI.*;
import static utilities.others.Screenshot.screenShoot;
import static utilities.selenium.ClickUtils.clickOnElement;
import static utilities.selenium.TextField.sendKeysToElement;
import static utilities.selenium.WaitUtils.TIMEOUT_30;
import static utilities.selenium.WaitUtils.waitUntilElementDisplayed;


public class LoginPage{
    WebDriver driver;
    public LoginPage(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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


    public void inputUserName(TestData testData) {
        sendKeysToElement(username, testData.getUserName());

    }

    public void inputPassword(TestData testData) {
        sendKeysToElement(password, testData.getPassWord());
    }


    public void clickLoginButton() {

        clickOnElement(loginButton);
    }

    TestData testData = TestData.getTestData("Login", "Login").get(0);

    public void loginPageNghia() throws Exception {
        driver.get("http://www.testyou.in/Login.aspx");
        this.inputUserName(testData);
        this.inputPassword(testData);
        clickLoginButton();
        //waitUntilElementDisplayed(loginPassword, TIMEOUT_30);


    }


}
