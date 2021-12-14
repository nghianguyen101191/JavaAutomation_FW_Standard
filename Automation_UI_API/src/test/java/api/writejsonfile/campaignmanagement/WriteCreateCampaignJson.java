package api.writejsonfile.campaignmanagement;

import api.writejsonfile.AllJsonMethodUtils;
import net.minidev.json.JSONObject;

public class WriteCreateCampaignJson {
    AllJsonMethodUtils allJsonMethodUtils;
    JSONObject jo;

    /*
    Methods
     */
    public void writeCreateCampaignJson(CreateCampaignUtils createCampaignUtils, String jsonFile) {
        allJsonMethodUtils = new AllJsonMethodUtils();
        jo = new JSONObject();
        jo.put("name", createCampaignUtils.getCampaignName());
        jo.put("description", createCampaignUtils.getCampaignDescription());
        jo.put("from_time", createCampaignUtils.getCampaignFromtime());
        jo.put("to_time", createCampaignUtils.getCampaignToTime());
        allJsonMethodUtils.writeJsonStringToJsonFile(jo, jsonFile);
    }


}
