package api.writejsonfile.campaignmanagement;

public class CreateCampaignUtils {
    private String campaignName = null;
    private String campaignDescription = "string";
    private String campaignFromtime = "2020-12-15T17:00:00Z";
    private String campaignToTime = "2021-01-11T16:59:59.999000Z";

    /**
     * Get default value
     *
     * @return
     */

    public String getCampaignName() {
        return campaignName;
    }


    public String getCampaignDescription() {

        return campaignDescription;
    }

    public String getCampaignFromtime() {

        return campaignFromtime;
    }

    public String getCampaignToTime() {

        return campaignToTime;
    }

    /**
     * @param type
     */

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }

    public void setCampaignFromtime(String campaignFromtime) {
        this.campaignFromtime = campaignFromtime;
    }

    public void setCampaignToTime(String campaignToTime) {
        this.campaignToTime = campaignToTime;
    }


}
