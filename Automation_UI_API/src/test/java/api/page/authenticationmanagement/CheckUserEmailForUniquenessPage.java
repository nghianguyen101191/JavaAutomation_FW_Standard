package api.page.authenticationmanagement;/*
package api.page.authenticationmanagement;

import api.page.apiutils.APIUtilsPage;
import api.page.common.Constants;
import drivers.api.APITestData;
import drivers.ui.InitGUI;
import io.restassured.response.Response;

import static api.page.apiutils.APIUtilsPage.apiMethod;

public class CheckUserEmailForUniquenessPage extends InitGUI {
  public static Constants constants;

  static {
    constants = new Constants();
  }

  public void checkUserEmailForUniqueness(APITestData apiTestData) throws Exception {
    Response response = apiMethod(constants.AM_PATH + apiTestData.getJsonPath());
    APIUtilsPage apiUtilsPage = new APIUtilsPage();
    apiUtilsPage.validateApiResultOverview(response, apiTestData, apiTestData.getBodyResponse());
  }
}
*/
