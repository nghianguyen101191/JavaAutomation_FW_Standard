package api.test.campaignmanagement;

import api.page.campaignmanagement.ApiCreateCampaignPage;
import common.Constants;
import drivers.api.APITestData;
import org.testng.annotations.Test;

public class ApiCreateCampaignJobs extends ApiCreateCampaignPage {
    public static Constants constants;
    ApiCreateCampaignPage apiCreateCampaign;

    static {
        constants = new Constants();
    }

    @Test(groups = {"PostCreateNewCampaign"})
    public void PostCreateNewCampaign() throws Exception {
        APITestData apiTestData =
                APITestData.getApiTestData("Campaign Management", "CAM001").get(0);
        apiCreateCampaign = new ApiCreateCampaignPage();
        apiCreateCampaign.createCampaignAndValidation(apiTestData);


    }


}
