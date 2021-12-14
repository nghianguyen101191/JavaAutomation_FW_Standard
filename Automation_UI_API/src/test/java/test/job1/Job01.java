package test.job1;

import drivers.ui.TestData;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.page1.something.SomethingPage;

//@Listeners(JobRunResultListener.class)
public class Job01 extends SomethingPage {
    @Test(groups = {"LoginNghia"})
    //@Parameters({"appUrl"})
    public void Function01(String appUrl) throws Exception {
        TestData testData = TestData.getTestData("Login", "Login").get(0);
        LoginPageNghia(testData);
    }

}
