package page.home.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static utilities.selenium.ClickUtils.clickOnElement;

public class HomePageElements {
    WebDriver driver;

    public HomePageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(how = How.NAME, using = "email")
    public WebElement tenantEmail;

    @FindBy(how = How.CSS, using = ".augBlue.ttButton .x-btn-inner")
    public WebElement tenantCreateButton;

    @FindBy(how = How.NAME, using = "name")
    public WebElement tenantName;

    @FindBy(how = How.NAME, using = "allocatedShared")
    public WebElement tenantAllocatedShared;

    @FindBy(how = How.NAME, using = "allocatedOffice365ExchangeMailboxes")
    public WebElement tenantAllocatedOffice365ExchangeMailboxes;

    @FindBy(how = How.NAME, using = "allocatedEc2Instances")
    public WebElement tenantAllocatedEc2Instance;

    @FindBy(how = How.NAME, using = "allocatedPhysicalServers")
    public WebElement tenantAllocatedPhysicalServer;

    @FindBy(how = How.NAME, using = "phone")
    public WebElement tenantPhone;

    @FindBy(how = How.NAME, using = "website")
    public WebElement tenantWebsite;

    @FindBy(how = How.NAME, using = "address")
    public WebElement tenantAddress;

    @FindBy(how = How.NAME, using = "adminLogin")
    public WebElement tenantAdminLogin;

    @FindBy(how = How.NAME, using = "adminEmail")
    public WebElement tenantAdminEmail;

    @FindBy(how = How.NAME, using = "adminPassword")
    public WebElement tenantAdminPassword;

    @FindBy(how = How.CSS, using = ".mttbLogo")
    public WebElement tenantLogo;

    public void clickTenantLogo(){
        clickOnElement(tenantLogo);
    }


    @FindBy(how = How.TAG_NAME, using = "body")
    public WebElement tenantTagNameBody;

    @FindBy(how = How.NAME, using = "repeatAdminPassword")
    public WebElement tenantRepeatAdminPassword;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'All filters')]")
    public WebElement tenantAllFilters;

    @FindBy(how = How.CSS, using = "div[title='Self-service administrator']")
    public WebElement tenantRoleAdminTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='mtttbActionIcon clickableIcon mtIconDeactivate']")
    public WebElement tenantMtIconDeactivate;

    @FindBy(how = How.CSS, using = "[role] .x-field-default:nth-of-type(7) [role='button']")
    public WebElement tenantRoleAdminTrigger;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Add New...')]")
    public WebElement addNewButtonFirstLogin;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Got It')]")
    public WebElement buttonGotItFirstLogin;

    @FindBy(how = How.NAME, using = "username")
    public WebElement username;

    @FindBy(how = How.NAME, using = "fullname")
    public WebElement fullname;

    @FindBy(how = How.NAME, using = "email")
    public WebElement email;

    @FindBy(how = How.NAME, using = "password")
    public WebElement password;

    @FindBy(how = How.NAME, using = "confirmPassword")
    public WebElement confirmPassword;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Proceed')]")
    public WebElement proceedButton;

    @FindBy(how = How.NAME, using = "name")
    public WebElement name;

    @FindBy(how = How.CSS, using = ".ttButton2 .x-btn-inner")
    public WebElement buttonGotItCss;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Create New Tenant')]")
    public WebElement buttonCreateNewTenant;

    @FindBy(how = How.CSS, using = ".mtIconTenants")
    public WebElement tenantIcon;


    public void clickTenantIcon() {
        clickOnElement(tenantIcon);
    }

    @FindBy(
            how = How.XPATH,
            using =
                    "//div[@class='mttbActions']//div[@class='mtttbActionIcon mtIconActivate clickableIcon' and @title='Enable"
                            + " the tenant']")
    public WebElement enabledTenantIcon;


    public void clickEnableTenantIcon(){
        clickOnElement(enabledTenantIcon);
    }

    @FindBy(how = How.CSS, using = ".mttbLogo")
    public WebElement loginPageMTLogo;





    @FindBy(how = How.XPATH, using = "//div[@title='Logout']")
    public WebElement logoutIcon;
    public void clickLogoutIcon() {
        clickOnElement(logoutIcon);
    }


    @FindBy(how = How.CSS, using = ".popupButton .x-btn-inner")
    public WebElement logoutButton;

    @FindBy(how = How.CSS, using = ".popupMenu")
    public WebElement logoutPopup;

    public String getLogoutPopup() {
        return logoutPopup.getText();
    }
    @FindBy(how = How.LINK_TEXT, using = "Log out")
    public WebElement linkTextLogOut;

    public void clickLinkTextLogOut() {
        clickOnElement(linkTextLogOut);
    }


    public void clickLoginPageMTLogo(){
        clickOnElement(loginPageMTLogo);
    }
}
