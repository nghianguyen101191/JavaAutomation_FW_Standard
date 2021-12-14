package page.page2.something02;


import com.relevantcodes.extentreports.LogStatus;
import drivers.ui.InitGUI;
import drivers.ui.TestData;

import page.home.LoginPage;
import page.page1.something.SomethingPage;
import page.page2.Page2Utils;
import page.page2.element.SomethingElements02;

import static utilities.selenium.WaitUtils.waitUntilElementDisplayed;

public class Something02Page extends Page2Utils {


    SomethingElements02 somethingElement02;
    LoginPage loginPage;
    SomethingPage somethingPage;


    public void Function_Nghia(TestData testData) throws Exception{
        somethingElement02 = new SomethingElements02(driver);
        somethingPage = new SomethingPage();
        //somethingPage.LoginPageNghia(testData);
        Thread.sleep(4000);
        driver.get("http://www.testyou.in/Student/StudentIndex.aspx");
        Reporter.log(
                LogStatus.INFO, "=============================================================");
        //somethingElement02.inputUserName(testData);
        //somethingElement02.inputPassword(testData);
        //waitUntilElementDisplayed(somethingElement02.temp01, 1);
    }
}
