package utilities.others;

import com.assertthat.selenium_shutterbug.core.ElementSnapshot;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;

import static drivers.ui.InitGUI.*;

public class Screenshot {
    public static String screenShoot(){
        String imgPath ="";
        String imgName = DateTimeUtils.getCurrentTime("MM-dd-yyyy_HHmmss") + ".png";
        try {
            File scrnsht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //File path=new File("").getAbsoluteFile();
            //String pathfile = path.toString() + "./test-reports/" + reportFolder + "/images/" + imgName;
            String pathfile = "./test-reports/" + reportFolder + "/images/" + imgName;
            driver.close();
            FileUtils.copyFile(scrnsht, new File(pathfile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        imgPath = Reporter.addScreenCapture("./images/" + imgName);

        return imgPath;
    }


}