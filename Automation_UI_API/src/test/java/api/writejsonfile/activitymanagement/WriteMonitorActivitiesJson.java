package api.writejsonfile.activitymanagement;

import api.writejsonfile.AllJsonMethodUtils;
import api.writejsonfile.AllJsonUtils;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class WriteMonitorActivitiesJson {
    public static String ACTION = "ActivityManagement";
    public static String METHOD= "getActivities";
    public static Integer TID= 3;
    //public static Constants constants;

//    static {
//        constants = new Constants();
//    }

    public void writeMonitorActivites(MonitorActivitiesUtils monitorActivitiesUtils) {
        AllJsonMethodUtils allJsonMethodUtils = new AllJsonMethodUtils();
        AllJsonUtils allJsonUtils = new AllJsonUtils();

        // set action method, type, rpc
        allJsonUtils.setAction(ACTION);
        allJsonUtils.setMethod(METHOD);
        allJsonUtils.setTid(TID);
        JSONObject jo = allJsonMethodUtils.writeSimpleJsonObject(allJsonUtils);

        // write data
        JSONObject jodata = new JSONObject();

        jodata.put("startIndex", 0);
        jodata.put("pageSize", 100);
        jodata.put("searchPhrase", monitorActivitiesUtils.getSearchPhrase());

        // Put object data to array
        JSONArray ja = new JSONArray();
        ja.add(jodata);

        // add data to man object Json
        jo.put("data", ja);
        allJsonMethodUtils.writeJsonStringToJsonFile(jo, "dsds");
    }
}
