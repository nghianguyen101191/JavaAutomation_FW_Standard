package api.test.campaignmanagement;

import api.page.campaignmanagement.ApiGetCampaignPage;
import drivers.api.APITestData;
import org.testng.annotations.Test;

public class ApiGetCampaignJobs extends ApiGetCampaignPage {
    ApiGetCampaignPage apiGetCampaignPage;


    @Test(groups = {"GetCampaignDeatail"})
    public void GetCampaignFromCampaignName() throws Exception {
        APITestData apiTestData =
                APITestData.getApiTestData("Campaign Management", "CAM002").get(0);
        apiGetCampaignPage = new ApiGetCampaignPage();
        apiGetCampaignPage.getCampaignApiFromNameAndValidation(apiTestData);


    }


}
