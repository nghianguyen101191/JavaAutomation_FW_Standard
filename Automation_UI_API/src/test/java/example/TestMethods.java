//package example;
//
//import org.testng.annotations.Test;
//import page.common.CommonMethods;
//import utilities.esxi.VmwareDiscoveryItem;
//import utilities.esxi.VmwareUtils;
//
//import java.net.MalformedURLException;
//import java.rmi.RemoteException;
//
//public class TestMethods extends CommonMethods {
//
//  @Override
//  public void createJobType(String type) {}
//
//  @Test
//  public void testesxi()
//      throws MalformedURLException, RemoteException, InterruptedException {
//    VmwareDiscoveryItem di = new VmwareDiscoveryItem();
//    di.setHost("10.10.20.81");
//    VmwareUtils vmwareUtils = new VmwareUtils();
//    String a = vmwareUtils.returnLatestCheckedPointApi(di, "AT_VM_Test_01_Root");
//    System.out.println(a);
//  }
//
//  @Test
//  public String returnTextFromInput(){
//
//    String a = "Nghia test try";
//    System.out.println(a + "Nghiaa");
//    return a;
//
//  }
//
//}
