package api.page.apiutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;
import common.Constants;
import drivers.api.APITestData;
import drivers.ui.InitGUI;
import edu.emory.mathcs.backport.java.util.Arrays;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.Constants.SCHEMA_PATH;
import static io.restassured.RestAssured.given;

public class APIUtilsPage extends InitGUI {
    public static Constants constants;

    static {
        constants = new Constants();
    }

    //CommonMethods commonMethods;


    public static Integer parseStringToInterger(String value) {
        int integerValue;
        integerValue = Integer.parseInt(value);
        return integerValue;
    }

    public static String returnRandomValueFromList(List<String> listValue) {
        String value = null;
        int randomIndex = (int) (Math.random() * listValue.size());
        value = listValue.get(randomIndex);

        return value;
    }

    /*public static String jsonPath(String jsonFile, String jsonvalue, int valueobject)
            throws IOException {
        Response response = apiMethod(jsonFile);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ArrayList object = jsonPathEvaluator.get(jsonvalue);
        return object.get(valueobject).toString();
    }*/

    public static int convertStingToInteger(String string) {
        return Integer.parseInt(string);
    }

    /*public static Cookies getcookie() {
        Cookies cookies;
        try {
            String jsonBody = generateStringFromResource(LOGIN_JSON_PATH);
            cookies =
                    RestAssured.given()
                            .contentType(ContentType.JSON)
                            .when()
                            .body(jsonBody)
                            .post("c/router")
                            .then()
                            .statusCode(200)
                            .extract()
                            .response()
                            .getDetailedCookies();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Failed to get cookies !");
        }
        return cookies;
    }*/
    public static Response apiPostMethod(String suffixEndpoint, String prefixJsonFile, APITestData apiTestData) throws IOException {
        //Cookies cookies = getcookie();
        Response response = null;
        String jsonBody = null;
        String endPoint = apiTestData.getApiRootEndPoint() + suffixEndpoint;
        RequestSpecification request = given();
        String jsonFile = prefixJsonFile;
        //request.cookies(cookies);
        request.header(CONTENT_TYPE, CONTEN_TYPE_VALUE);
        request.header("Authorization",JWT);
        jsonBody = generateStringFromResource(jsonFile);
        request.body(jsonBody);
        response = request.post(endPoint);
        return response;
    }

    public static Response apiPatchMethod(String suffixEndpoint, String prefixJsonFile, APITestData apiTestData) throws IOException {
        String jsonBody = null;
        String endPoint = apiTestData.getApiRootEndPoint() + suffixEndpoint;
        RequestSpecification request = given();
        String jsonFile = prefixJsonFile;
        request.header(CONTENT_TYPE, CONTEN_TYPE_VALUE);
        jsonBody = generateStringFromResource(jsonFile);
        request.body(jsonBody);
        Response response = request.patch(endPoint);
        return response;

    }

//    public static Response apiGetMethod(String suffixEndPoint, APITestData apiTestData) throws IOException {
//        String endPoint = apiTestData.getApiRootEndPoint() + suffixEndPoint;
//        RestAssured.baseURI = endPoint;
//        RequestSpecification request = RestAssured.given();
//        request.header(CONTENT_TYPE, CONTEN_TYPE_VALUE);
//        Map param = new HashMap();
//        param.put("filter", "{\"name\":\"apiCampaign\"}");
//        param.put("paging", "{\"page\":1,\"page_size\":25}");
//        Response response = request.params(param).get(endPoint);
//        System.out.println(response.prettyPrint());
//        return response;
//
//    }
    public static RequestSpecification apiRequestGetMethod(String suffixEndPoint, APITestData apiTestData) throws IOException {
        //Cookies cookies = getcookie();
        String endPoint = apiTestData.getApiRootEndPoint() + suffixEndPoint;
        RestAssured.baseURI = endPoint;
        RequestSpecification request = RestAssured.given();
        request.header(CONTENT_TYPE, CONTEN_TYPE_VALUE);
        return request;

    }


    public static Response apiPostMethodMultipartData(
            String formDataFile, String keyFile, String valueFile) throws Exception {
        //Cookies cookies = getcookie();
        String formDataBody = generateStringFromResource(formDataFile);
        List<String> formDataParam = Arrays.asList(formDataBody.split("\n"));
        RequestSpecification request = given();
        request.multiPart(keyFile, new File(valueFile));
        for (int i = 0; i < formDataParam.size(); i++) {
            List<String> keyValue = Arrays.asList(formDataParam.get(i).split("="));
            request.formParam(keyValue.get(0), keyValue.get(1));
        }
        //request.cookies(cookies);
        request.header(CONTENT_TYPE, MULTIPART_FORMDATA);
        Response response = request.post("c/router");
        Reporter.log(LogStatus.INFO, response.asString());
        return response;
    }


    private static String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static void updateParameterListToJsonFile(String filename, String key, List<String> value)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JSONObject root = mapper.readValue(new File(filename), JSONObject.class);
        root.put(key, value);
        // Write into the file
        try (FileWriter file = new FileWriter(filename)) {
            file.write(root.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void textOneTextContainTextTwoApi(String text1, String text2) {
        if (text1.contains(text2)) {
            Reporter.log(LogStatus.PASS, "TextContain was verify passed");
        } else {
            Reporter.log(
                    LogStatus.FAIL, " CompareTextContain failed. Expected: " + text1 + " - Actual: ");
            throw new Error("elementTextContain was verify failed" + text1 + " - Actual: " + text2);
        }
    }

    public static List<String> readMultipleContentPerCell(String value) {
        String[] splited = value.trim().split(",");
        List<String> listName = new ArrayList();
        for (int i = 0; i < splited.length; i++) {
            listName.add(splited[i]);
        }
        return listName;
    }

    public static void validateJsonSchema(Response response, String jsonSchemaFile, APITestData apiTestData) throws IOException {
        String expectedJsonSchemaPath = SCHEMA_PATH + jsonSchemaFile;
        //String expectedJson = FileUtils.readFileToString(new File("/src/CreateCampaignSchema.json"));
        //response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(expectedJsonSchemaPath));
        //RestAssured.given().when().get("https://test-vanhanh.uat.shopee.vn/campaign/system/api-0/main/templates/").then().assertThat().body(matchesJsonSchemaInClasspath(expectedJsonSchema));

    }

    public static String getStringReponseValueFromField(Response response, String field) {
        JsonPath jsonPathValidator = response.jsonPath();
        return jsonPathValidator.getString(field);
    }

    public static Integer getIntergerReponseValueFromField(Response response, String field) {
        JsonPath jsonPathValidator = response.jsonPath();
        return jsonPathValidator.get(field);
    }
    public static List getListReponseValueFromField(Response response, String field) {
        JsonPath jsonPathValidator = response.jsonPath();
        return jsonPathValidator.get(field);
    }

    /*------------------------------VALIDATE METHODS-----------------------------------------------------*/
    public static void validateApiResultOverview(
            Response response, String jsonSchemaFile, APITestData apiTestData) throws Exception {
        // Validate Status  Code
        validateStatusCode(response, apiTestData);
        // Validate Content Type
        validateContentType(response, apiTestData);

        //Validate json schema
        validateJsonSchema(response, jsonSchemaFile, apiTestData);
        //Validate Option Value in Body Response
        //validateTextInBodyResponse(response, actualValue);
        // Report to html
        Reporter.log(LogStatus.INFO, response.prettyPrint());
    }

    public static void validateStatusCode(Response response, APITestData apiTestData)
            throws Exception {
        int statuscode = parseStringToInterger(apiTestData.getApiStatusCode());
        if (response.getStatusCode() != statuscode) {
            Reporter.log(LogStatus.FAIL, constants.errorStatusCode);
            throw new Error(constants.errorStatusCode);
        }
    }

    public static void validateContentType(Response response, APITestData apiTestData)
            throws Exception {
        if (!response.getContentType().equalsIgnoreCase(apiTestData.getApiContentType())) {
            Reporter.log(LogStatus.FAIL, constants.errorContentType);
            throw new Error(constants.errorContentType);
        }
    }

    public static void validateTextInBodyResponse(Response response, String actualValue)
            throws Exception {

        String bodyResponse = response.getBody().asString();
        System.out.println("Reponse Body is:" + bodyResponse);
        System.out.println(
                "************************---------------*********************************" + "\n" + "\n");
        List<String> listBodyContent = readMultipleContentPerCell(actualValue);
        for (int i = 0; i < listBodyContent.size(); i++) {
            textOneTextContainTextTwoApi(bodyResponse, listBodyContent.get(i));
        }
        System.out.print("List body response option that are verified: " + listBodyContent + "\n");
        System.out.println(
                "************************---------------*********************************" + "\n" + "\n");
    }


}
