package page.home.element;

import drivers.ui.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static utilities.selenium.ClickUtils.clickOnElement;
import static utilities.selenium.TextField.sendKeysToElement;

public class LoginPageElements {
    WebDriver driver;

    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * =================================================================================================================
     * VM
     */
    @FindBy(how = How.XPATH, using = "NGHHHHHHHH//input[@name='ctl00$CPHContainer$txtUserLogin']")
    public WebElement username;

    @FindBy(how = How.XPATH, using = "NGHHHHHHHH//input[@name='ctl00$CPHContainer$txtPassword']")
    public WebElement password;


    /**
     * =================================================================================================================
     * element interaction
     */


    public void inputUserName(TestData testData) {
        //clickOnElement(replicationDestinationTargetDatastore);
        sendKeysToElement(username, testData.getUserName());


    }

    public void inputPassword(TestData testData) {
        //clickOnElement(replicationDestinationTargetContainer);
        sendKeysToElement(password, testData.getPassWord());
    }


}
