package page.page2.element;

import drivers.ui.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static utilities.selenium.TextField.sendKeysToElement;

public class SomethingElements02 {


  public WebDriver driver;

  public SomethingElements02(WebDriver driver) {
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

  @FindBy(how = How.XPATH, using = "//input[@name='ctl00$CPHContdsasadadsd']")
  public WebElement temp01;


  /**
   * =================================================================================================================
   * element interaction
   */




  // FIXME: 8/1/2020 Will be define page object here
  public void inputUserName(TestData testData) {
    sendKeysToElement(username, testData.getUserName());


  }

  public void inputPassword(TestData testData) {
    sendKeysToElement(password, testData.getPassWord());
  }


}
