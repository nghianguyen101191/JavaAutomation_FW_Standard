package test.jobaction;

import com.relevantcodes.extentreports.LogStatus;
import drivers.ui.InitGUI;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.net.MalformedURLException;
import java.rmi.RemoteException;





public class JobRunResultListener extends TestListenerAdapter {
  InitGUI initGUI;


  @Override
  public void onTestFailure(ITestResult result) {
    initGUI = new InitGUI();
    try {
      System.out.println("MY NAME IS FAILEDDDDDDDD");
      initGUI.Reporter.log(
              LogStatus.FAIL, result.getMethod().getMethodName(), "Test case is failed");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    initGUI = new InitGUI();
    try {
      initGUI.Reporter.log(
          LogStatus.PASS, result.getMethod().getMethodName(), "Test case passed");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    initGUI = new InitGUI();
    try {
      initGUI.Reporter.log(
          LogStatus.SKIP, result.getMethod().getMethodName(), "Test case Skip");
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
