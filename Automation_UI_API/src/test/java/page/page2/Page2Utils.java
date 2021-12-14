package page.page2;

import org.openqa.selenium.support.PageFactory;
import page.common.CommonMethods;

public abstract class Page2Utils extends CommonMethods {

    public Page2Utils() {
        PageFactory.initElements(driver, this);
    }

}
