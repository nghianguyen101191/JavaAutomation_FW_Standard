package api.page.campaignmanagement;

import api.page.apiutils.APIUtilsPage;
import drivers.api.APITestData;
import drivers.ui.InitGUI;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static api.page.apiutils.APIUtilsPage.apiRequestGetMethod;
import static api.page.apiutils.APIUtilsPage.getListReponseValueFromField;
import static common.Constants.*;

public class ApiGetCampaignPage extends InitGUI {
    APIUtilsPage apiUtilsPage;
    ApiCreateCampaignPage apiCreateCampaignPage;


    public Response getCampaignApiFromNameAndValidation(APITestData apiTestData) throws Exception {
        apiCreateCampaignPage = new ApiCreateCampaignPage();
        apiCreateCampaignPage.createCampaignAndValidation(apiTestData);
        Map getCampaignParams = new HashMap();
        String objectValue = "{" + '"' + "name" + '"' + ":" + '"' + apiCreateCampaignPage.createdCampaignName + '"' + "}";
        System.out.println(objectValue);
        getCampaignParams.put(FILTER_OBJECT_KEY, objectValue);
        getCampaignParams.put(PAGING_OBJECT_KEY, "{\"page\":1,\"page_size\":25}");
        Response response = apiRequestGetMethod(API_SUFFIX_CAMPAIGN, apiTestData).params(getCampaignParams).get();
        apiUtilsPage.validateApiResultOverview(response, SCHEMA_PATH, apiTestData);
        return response;
    }

    public Integer getCampaignIdFromCampaignName(APITestData apiTestData) throws Exception {
        Response response = getCampaignApiFromNameAndValidation(apiTestData);
        List<Integer> campaignIdList;
        campaignIdList = getListReponseValueFromField(response, FIELD_DATA_RECORDS);
        return campaignIdList.get(0);
    }


}
