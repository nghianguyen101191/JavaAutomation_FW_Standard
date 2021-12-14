package drivers.ui;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.home.LoginPage;
import test.job1.Job01;
import utilities.others.DateTimeUtils;
import utilities.others.ExtentManagerUtils;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utilities.others.FolderFileUtils.createMutilFolder;
import static utilities.others.Screenshot.screenShoot;

public class InitGUI {
    public static final String LOCAL = "local";
    public static final String API = "api";
    public static final String INIT_TEXT = "init";
    public static final String REMOTE = "remote";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String EDGE = "edge";
    public static final String EXPLORER = "explorer";
    public static final String CONFIG = "config";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTEN_TYPE_VALUE = "application/json";
    public static final String JWT = "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5LCJ1c2VybmFtZSI6InRyaW5naGlhLm5ndXllbkBzaG9wZWUuY29tIiwiZXhwIjoxNjQ3OTE4MjUyLCJlbWFpbCI6InRyaW5naGlhLm5ndXllbkBzaG9wZWUuY29tIn0.8fBo7GCxRlIVojySsbwSYRRGAZGTcimv7_KjILbswW8";
    public static final String MULTIPART_FORMDATA = "multipart/form-data";
    public static final String LOGIN_JSON_PATH =
            "propertyfiles/api/authenticationmanagement/Login.json";
    public static WebElement webelement;
    public static WebDriver driver;
    public static List<WebElement> webelements = null;
    public static String browser;
    public static String driverPath = "./web-driver";
    public static ExtentReports extent;
    public static ExtentTest Reporter;
    public static String reportFolder = "";
    // public static int TIMEOUT_PAGE_LOADING = 15;
    public static int TIMEOUT_PAGE_LOADING = 5;
    // public static int TIMEOUT_IMPLICITLY_WAIT = 30;
    public static int TIMEOUT_IMPLICITLY_WAIT = 10;
    public String initappUrlConfig = null;

    ///////////////////////////////////////////////////////////////////////////
    // a
    ///////////////////////////////////////////////////////////////////////////

    LoginPage loginPage;
    Job01 job1;


    public static void setURLApi(String appUrl) {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = appUrl;
    }

    // over SSL api
    public void setURLApiConfig() {
        RestAssured.baseURI = getappUrlConfig();
        RestAssured.useRelaxedHTTPSValidation();
    }

    public String getappUrlConfig() {
        return initappUrlConfig;
    }

    public void setappUrlConfig(String initappUrlConfig) {
        this.initappUrlConfig = initappUrlConfig;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(String browserType) {
        switch (browserType) {
            case CHROME:
                driver = initChromeDriver();
                break;
            case FIREFOX:
                driver = initFirefoxDriver();
                break;
            case EDGE:
                driver = initEdgeDriver();
                break;
            case EXPLORER:
                break;
            default:
                System.out.println("browser : " + browserType + " Launching for your of choice..");
                driver = initChromeDriver();
        }
    }

    private WebDriver initEdgeDriver() {
        System.setProperty("webdriver.edge.driver", driverPath + "/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    public WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public WebDriver initFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public void setRemoteDriver(String browserType, String nodeUrl, String browserVersion)
            throws MalformedURLException {
        switch (browserType) {
            case CHROME:
                driver = initRemoteChromeDriver(nodeUrl, browserVersion);
                break;
            case FIREFOX:
                driver = initRemoteFirefoxDriver(nodeUrl, browserVersion);
                break;
            case EDGE:
                driver = initRemoteEdgeDriver(nodeUrl, browserVersion);
                break;
            case EXPLORER:
                break;
            default:
                System.out.println("Browser : " + browserType + " Launching for your of choice..");
                driver = initRemoteChromeDriver(nodeUrl, browserVersion);
        }
    }

    public WebDriver initRemoteFirefoxDriver(String nodeUrl, String browserVersion)
            throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities().firefox();
        capability.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capability.setPlatform(Platform.ANY);
        capability.setVersion(browserVersion);
        return driver = new RemoteWebDriver(new URL(nodeUrl), capability);
    }

    public WebDriver initRemoteChromeDriver(String nodeUrl, String browserVersion)
            throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities().chrome();
        capability.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capability.setPlatform(Platform.ANY);
        capability.setVersion(browserVersion);
        return driver = new RemoteWebDriver(new URL(nodeUrl), capability);
    }

    public WebDriver initRemoteEdgeDriver(String nodeUrl, String browserVersion)
            throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities().edge();
        capability.setBrowserName(DesiredCapabilities.edge().getBrowserName());
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capability.setPlatform(Platform.WINDOWS);
        capability.setVersion(browserVersion);
        return driver = new RemoteWebDriver(new URL(nodeUrl), capability);
    }

    @BeforeSuite(alwaysRun = true)
    protected void beforeSuite() {
        reportFolder = DateTimeUtils.getCurrentTime("MM-dd-yyyy_HHmmss");
        String reportPath = "test-reports/" + reportFolder + "/images";
        createMutilFolder(reportPath, 0);
        extent = ExtentManagerUtils.getReporter("test-reports/" + reportFolder + "/ExtentReport.html");
    }

    @BeforeClass(alwaysRun = true)
    public WebDriver start() {
        return getDriver();
    }

    @Parameters({
            "browserType",
            "driverMode",
            "nodeUrl",
            "browserVersion",
            "appUrl",
            "platform",

    })
    @BeforeMethod(alwaysRun = true)
    protected synchronized void beforeMethod(
            String browserType,
            String driverMode,
            String nodeUrl,
            String browserVersion,
            String appUrl,
            String platform,
            Method method)
            throws Exception {
        System.out.println(
                "We Start Running on browser :"
                        + browserType
                        + "driverMode is :"
                        + driverMode
                        + "nodeUrl is:"
                        + nodeUrl);
        try {
            /*
             * ============================= Start to write report on HTML ==========================================
             * */
            Reporter = extent.startTest(method.getName()).assignCategory(getClass().getSimpleName());
            if (!browserType.equals(API)) {
                initDriverBrowser(browserType, driverMode);
                Reporter.log(
                        LogStatus.INFO, "=============================================================");

            } else {
                System.out.println("API MODE");
            }
            /*
             * ============================= Init API ==========================================
             * */
            setURLApi(appUrl);
        } catch (Exception e) {
            System.out.println(
                    e.getStackTrace()); // handle before method failed it will skip all test suite
        }
    }

    @Parameters({"browserType"})
    @AfterMethod(alwaysRun = true)
    protected synchronized void afterMethod(
            ITestResult result, Method method, String browserType) {
        if (result.getStatus() == ITestResult.FAILURE) {
            if (browserType.equals(API)) {
                Reporter.log(LogStatus.FAIL, result.getThrowable());
            } else {
                Reporter.log(LogStatus.FAIL, result.getThrowable() + screenShoot());
                //driver.close();
            }
        }
        extent.endTest(Reporter);
        extent.flush();
        if (!browserType.equals(API)) {
            driver.close();
        }


    }

    @AfterSuite(alwaysRun = true)
    protected void afterSuite() {
        extent.close();
    }

    @BeforeGroups("security")
    public void setUpSecurity() {
        System.out.println("setUpSecurity()");
    }

    @AfterGroups("security")
    public void tearDownSecurity() {
        System.out.println("tearDownSecurity()\n");
    }

    @BeforeGroups("database")
    public void setUpDatabase() {
        System.out.println("setUpDatabase()");
    }

    @AfterGroups("database")
    public void tearDownDatabase() {
        System.out.println("tearDownDatabase()\n");
    }

    @BeforeGroups(value = "ui")
    public void setUpUI() {
        System.out.println("setUpUI()");
    }

    @AfterGroups(value = "ui")
    public void tearDownUI() {
        System.out.println("tearDownUI()\n");
    }

    public void initDriverBrowser(
            String browserType, String driverMode) {
        try {
            switch (driverMode) {
                case LOCAL:
                    setDriver(browserType);
                    loginPage = new LoginPage(driver);
                    loginPage.loginPageNghia();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
            throw new Error("Can not load browser on your system!!!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT_PAGE_LOADING, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TIMEOUT_IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
}
