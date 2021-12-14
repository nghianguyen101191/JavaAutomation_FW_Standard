package drivers.api;

import com.relevantcodes.extentreports.LogStatus;
import drivers.ui.InitGUI;
import utilities.others.ExcelUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APITestData extends InitGUI {


    String apiCampaignName = null;
    String apiStatusCode = null;
    String apiContentType = null;
    String apiRootEndPoint = null;
    String apiMethod = null;
    String apiCampaignDescription = null;
    String apiCampaignFromTime = null;
    String apiCampaignToTime = null;
    /*
    Template data
     */
    String apiTemplateName = null;
    String apiTemplateDescription = null;
    String apiTemplateStatus = null;

    /*
    Layout data
     */

    String apiLayoutName = null;
    String apiNumberOfLayout = null;
    /*
    Zone Data
     */

    String apiZoneName = null;
    String apiNumberOfZone = null;

    /*
    Component data
     */
    String componentCode = null;
    String componentDurationFromTime = null;
    String componentDurationToTime = null;
    String submissionDeadline = null;
    String cbDeadline = null;
    String mechanicName = null;
    String mechanicDescription = null;
    String approvalNeedPricing = null;
    String approvalNeedQc = null;
    String approvalComponentDesign = null;
    String numberOfComponent = null;
    /*
    Slot data
     */
    String numberOfSlot = null;


    /**
     * Get data from excel row
     *
     * @param
     */
    public APITestData(HashMap<String, String> data) {
        /*
        Campaign section
         */
        this.apiCampaignName = data.get("Campaign Name");
        this.apiStatusCode = data.get("Status Code");
        this.apiContentType = data.get("Content Type");
        this.apiRootEndPoint = data.get("Root End Point");
        this.apiMethod = data.get("API Method");
        this.apiCampaignDescription = data.get("Campaign Description");
        this.apiCampaignFromTime = data.get("Campaign From Time");
        this.apiCampaignToTime = data.get("Campaign To Time");

    /*
    Template section ****************************
     */

        this.apiTemplateName = data.get("Template Name");
        this.apiTemplateDescription = data.get("Template Description");
        this.apiTemplateStatus = data.get("Template Status");
        /*
        Layout section
         */
        this.apiLayoutName = data.get("Layout Name");
        this.apiNumberOfLayout = data.get("Number Of Layout");
        /*
        Zone section
         */
        this.apiZoneName = data.get("Zone Name");
        this.apiNumberOfZone = data.get("Number Of Zone");
        /*
        Component section
         */
        this.componentCode = data.get("Component Code");
        this.componentDurationFromTime = data.get("Component Duration From Time");
        this.componentDurationToTime = data.get("Component Duration To Time");
        this.submissionDeadline = data.get("Submission Deadline");
        this.cbDeadline = data.get("CB Deadline");
        this.mechanicName = data.get("Mechanic Name");
        this.mechanicDescription = data.get("Mechanic Description");
        this.approvalNeedPricing = data.get("Approval Needs Pricing");
        this.approvalNeedQc = data.get("Approval Needs QC");
        this.approvalComponentDesign = data.get("Approval Component Design");
        this.numberOfComponent = data.get("Number Of Component");
        /*
        Slot section
         */
        this.numberOfSlot = data.get("Number of Slot");


    }


    /**
     * Return value to get data
     *
     * @return
     */

    public String getApiCampaignName() {
        return apiCampaignName;
    }

    public String getApiStatusCode() {
        return apiStatusCode;
    }

    public String getApiContentType() {
        return apiContentType;
    }


    public String getApiRootEndPoint() {

        return apiRootEndPoint;
    }

    public String getApiMethod() {
        return apiMethod;
    }


    public String getApiCampaignDescription() {
        return apiCampaignDescription;
    }

    public String getApiCampaignFromTime() {
        return apiCampaignFromTime;
    }


    public String getApiCampaignToTime() {

        return apiCampaignToTime;
    }

    /*
    Get Template methods section
     */
    public String getApiTemplateName() {

        return apiTemplateName;
    }

    public String getApiTemplateDescription() {

        return apiTemplateDescription;
    }

    public String getApiTemplateStatus() {

        return apiTemplateStatus;
    }

    /*
    Get layout method section
     */

    public String getApiLayoutName() {
        return apiLayoutName;
    }

    public String getApiNumberOfLayout() {
        return apiNumberOfLayout;
    }

    /*
    Get Zone method section
     */

    public String getApiZoneName() {
        return apiZoneName;
    }

    public String getApiNumberOfZone() {
        return apiNumberOfZone;
    }

    /*
    Get Component method section
     */
    public String getComponentCode() {
        return componentCode;
    }

    public String getComponentDurationFromTime() {
        return componentDurationFromTime;
    }

    public String getComponentDurationToTime() {
        return componentDurationToTime;
    }

    public String getSubmissionDeadline() {
        return submissionDeadline;
    }

    public String getCbDeadline() {
        return cbDeadline;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public String getMechanicDescription() {
        return mechanicDescription;
    }

    public String getApprovalNeedPricing() {
        return approvalNeedPricing;
    }

    public String getApprovalNeedQc() {
        return approvalNeedQc;
    }

    public String getApprovalComponentDesign() {
        return approvalComponentDesign;
    }

    public String getNumberOfComponent() {
        return numberOfComponent;
    }

    /*
    Get slot section
     */
    public String getNumberOfSlot() {
        return numberOfSlot;
    }


    /**
     * Set data method
     */

    public void setApiCampaignName(String apiCampaignName) {
        this.apiCampaignName = apiCampaignName;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }


    /**
     * =================================================================================================================
     * //Return all data input
     *
     * @return
     */
    public static List<APITestData> getApiTestData(String sheetName, String apiTestID)
            throws Exception {
        List<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
        listData = ExcelUtils.readXSLXFileID("propertyfiles/api/apidata.xlsx", sheetName, apiTestID);
        List<APITestData> apiDataTest = new ArrayList<>();
        for (HashMap<String, String> data : listData) {
            Reporter.log(
                    LogStatus.INFO,
                    "**************** Test Case: "
                            + data.get("Description")
                            + " "
                            + "**********************************");
            APITestData apibkTestData = new APITestData(data);
            apiDataTest.add(apibkTestData);
        }
        return apiDataTest;
    }


}
