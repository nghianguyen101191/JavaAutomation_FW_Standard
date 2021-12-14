package api.writejsonfile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minidev.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AllJsonMethodUtils {

  public JSONObject writeSimpleJsonObject(AllJsonUtils jsonUtils) {
    JSONObject jo = new JSONObject();
    jo.put("action", jsonUtils.getAction());
    jo.put("method", jsonUtils.getMethod());
    jo.put("type", jsonUtils.getType());
    jo.put("tid", jsonUtils.getTid());
    return jo;
  }

  public String writeFormDataObject(AllJsonUtils jsonUtils) {
    String formData = "action=" + jsonUtils.getAction() + "\n"
                    + "method=" + jsonUtils.getMethod() + "\n"
                    + "type=" + jsonUtils.getType() + "\n"
                    + "tid=" + jsonUtils.getTid() + "\n";
    return formData;
  }

  public void writeJsonStringToJsonFile(JSONObject jsonobject, String jsonPath) {
    File jsonFile = new File(jsonPath);
    Gson gson = new GsonBuilder().serializeNulls().create();
    String json = gson.toJson(jsonobject);

    try {
      FileWriter writer = new FileWriter(jsonFile);
      writer.write(json);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(json);
  }

  public void writeFormDataStringToFile(String formDataObject, String filePath) {
    try {
      FileWriter writer = new FileWriter(filePath);
      writer.write(formDataObject);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(formDataObject);
  }
}
