package api.page.campaignmanagement;

import api.page.apiutils.APIUtilsPage;
import api.writejsonfile.campaignmanagement.CreateCampaignUtils;
import api.writejsonfile.campaignmanagement.WriteCreateCampaignJson;
import drivers.api.APITestData;
import drivers.ui.InitGUI;
import io.restassured.response.Response;
import utilities.others.DateTimeUtils;

import static api.page.apiutils.APIUtilsPage.apiPostMethod;
import static api.page.apiutils.APIUtilsPage.getIntergerReponseValueFromField;
import static common.Constants.*;

public class ApiCreateCampaignPage extends InitGUI {
    APIUtilsPage apiUtilsPage;
    WriteCreateCampaignJson writeCreateCampaignJson;
    CreateCampaignUtils createCampaignUtils;
    public String createdCampaignName = null;
    public Integer campaignId = 0;

    /**
     * Methods
     *
     * @param apiTestData
     * @return
     * @throws Exception
     */
    public Response createCampaignApi(APITestData apiTestData) throws Exception {
        createdCampaignName = inputDataToCampaign(apiTestData);
        return apiPostMethod(API_SUFFIX_CAMPAIGN, CAMPAIGN_JSON_PATH, apiTestData);

    }

    public Response createCampaignAndValidation(APITestData apiTestData) throws Exception {
        Response response = createCampaignApi(apiTestData);
        campaignId = getIntergerReponseValueFromField(response, "data.id");
        apiUtilsPage = new APIUtilsPage();
        apiUtilsPage.validateApiResultOverview(response, SCHEMA_PATH, apiTestData);
        return response;

    }

    public String inputDataToCampaign(APITestData apiTestData) {
        createdCampaignName = apiTestData.getApiCampaignName() + "_" + DateTimeUtils.getCurrentTime("MM-dd-yyyy_HHmmss");
        createCampaignUtils = new CreateCampaignUtils();
        createCampaignUtils.setCampaignName(createdCampaignName);
        createCampaignUtils.setCampaignDescription(apiTestData.getApiCampaignDescription());
        createCampaignUtils.setCampaignFromtime(apiTestData.getApiCampaignFromTime());
        createCampaignUtils.setCampaignToTime(apiTestData.getApiCampaignToTime());
        writeCreateCampaignJson = new WriteCreateCampaignJson();
        writeCreateCampaignJson.writeCreateCampaignJson(createCampaignUtils, CAMPAIGN_JSON_PATH);
        return createdCampaignName;
    }


}
