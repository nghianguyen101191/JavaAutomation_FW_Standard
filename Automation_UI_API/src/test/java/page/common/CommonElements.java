package page.common;

import drivers.ui.InitGUI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonElements extends InitGUI {
  @FindBy(tagName = "body")
  public  WebElement getAllTextPage;

  @FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
  public WebElement sourceVMSearchField;

  public CommonElements() {
    PageFactory.initElements(driver, this);
  }
}
