package page.page1.something;


import drivers.ui.InitGUI;
import drivers.ui.TestData;
import org.openqa.selenium.support.PageFactory;
import page.page1.element.SomethingElements;

public class SomethingPage extends InitGUI {


    SomethingElements somethingElements;
    public SomethingPage() {
        PageFactory.initElements(driver, this);
    }


    public void LoginPageNghia(TestData testData) {
        somethingElements = new SomethingElements(driver);
        driver.get("http://www.testyou.in/Login.aspx");
        somethingElements.inputUserName(testData);
        somethingElements.inputPassword(testData);
        somethingElements.clickLoginButton();
    }
}
