package utilities.others;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;


public class ExtentManagerUtils {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);

            extent
                    .addSystemInfo("User Name", "NghiaNguyen")
                    .addSystemInfo("Host Name", "Automation Host")
                    .addSystemInfo("Environment", "Qa team");

            extent.loadConfig(new File("Extent-Config.xml"));
        }

        return extent;
    }
}
