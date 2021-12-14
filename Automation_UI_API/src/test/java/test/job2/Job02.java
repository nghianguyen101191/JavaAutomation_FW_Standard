package test.job2;

import drivers.ui.TestData;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.page1.something.SomethingPage;
import page.page2.something02.Something02Page;
import test.jobaction.JobRunResultListener;

//@Listeners(JobRunResultListener.class)
public class Job02 extends Something02Page {
    @Test(groups = {"functionNghia"})
    //@Parameters({"type"})
    public void Function01() throws Exception {
        TestData testData = TestData.getTestData("Login", "Login").get(0);
        Function_Nghia(testData);
    }

}
