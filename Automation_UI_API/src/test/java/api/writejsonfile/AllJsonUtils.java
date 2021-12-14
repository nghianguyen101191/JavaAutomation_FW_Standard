package api.writejsonfile;

public class AllJsonUtils {
  private String action = "MultitenancyManagement";
  private String method = "save";
  private String type = "rpc";
  private Integer tid = 1;

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getTid() {
    return tid;
  }

  public void setTid(Integer tid) {
    this.tid = tid;
  }
}
