package drivers.ui;

import utilities.others.Excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestData extends InitGUI {


    public String getPathToLocalFolderAndShare() {
        return pathtolocalfolderandshare;
    }

    public void setPathToLocalFolderAndShare(String pathtolocalfolderandshare) {
        this.pathtolocalfolderandshare = pathtolocalfolderandshare;
    }

    public String getUserName() {
        return username;
    }

    public String getPassWord() {
        return password;
    }

    /**
     * =================================================================================================================
     * //init varaiable
     *
     * @return
     */

    String pathtolocalfolderandshare = null;
    String username = null;
    String password = null;

    /**
     * =================================================================================================================
     * //Read Column in Excel file
     *
     * @return
     */

    public TestData(HashMap<String, String> data) {

        this.pathtolocalfolderandshare = data.get("Path local folder and Share");
        this.username = data.get("Username");
        this.password = data.get("Password");


    }

    /**
     * =================================================================================================================
     * //Return all data input
     *
     * @return
     */

    public static List<TestData> getTestData(String sheetName, String testCaseID) throws Exception {
        List<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
        listData = Excel.readXSLXFileID("propertyfiles/ui/data_UI.xlsx", sheetName, testCaseID);
        List<TestData> datasTest = new ArrayList<>();
        for (HashMap<String, String> data : listData) {
      /* Reporter.log(LogStatus.INFO, "=============================================================");
      Reporter.log(LogStatus.INFO, "Test Case: " + data.get("Description") + " " + "");
      Reporter.log(LogStatus.INFO, "=============================================================");*/
            TestData testData = new TestData(data);
            datasTest.add(testData);
        }
        return datasTest;
    }


}
