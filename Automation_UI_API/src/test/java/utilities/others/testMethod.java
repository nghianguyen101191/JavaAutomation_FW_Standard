//package utilities.others;
//
//import org.apache.commons.io.FileUtils;
//import org.testng.annotations.Test;
//import test.jobaction.RetryFailedTestCases;
//import utilities.esxi.VmwareDiscoveryItem;
//import utilities.office365.Office365Utils;
//
//import java.io.*;
//import java.net.MalformedURLException;
//import java.rmi.RemoteException;
//
//import static utilities.esxi.VmwareUtils.getVmStatusFormHost;
//
//public class testMethod {
//
//
//    @Test
//    public void tesss() throws InterruptedException, RemoteException, MalformedURLException {
//        VmwareDiscoveryItem di = new VmwareDiscoveryItem();
//        di.setHost("10.10.11.21");
//        String test =  getVmStatusFormHost(di, "@a").toString();
//    System.out.println(test);
//    }
//
//    @Test(retryAnalyzer = RetryFailedTestCases.class)
//    public void UploadOneDrive_2000000_5000000() throws IOException {
//        Office365Utils office365Utils = new Office365Utils();
//        office365Utils.uploadFileToOneDrive("Y:/txt2_5/");
//    }
//
//    @Test
//    public void _20k_docx_createFile() throws IOException {
//        // variable
//        String folderName = "docx";
//        String fileName = "doc1_";
//        String extension = ".docx";
//
//        File source = new File("C:\\doc1.docx");
//        for (int i = 401; i <= 402; i++) {
//            // make folder
//            FileUtils.forceMkdir(new File("Y:\\OneDrive - Nakivo\\" + folderName + "" + i + ""));
//            System.out.println("Make copy file number folder is " + i + "");
//            // make file
//            for (int j = 1; j <= 5000; j++) {
//                File des = new File("Y:\\OneDrive - Nakivo\\" + folderName + "" + i + "\\" + fileName + "" + j + "" + extension + "");
//                System.out.println("Make copy file number is " + j + "");
//                copyFileUsingStream(source, des);
//            }
//        }
//    }
//
//    @Test
//    public void createFolder() throws IOException {
//        for (int i = 41; i <= 200; i++) {
//            FileUtils.forceMkdir(new File("D:\\newOneDrive\\OneDrive - Nakivo\\image" + i + ""));
//        }
//    }
//
//    @Test
//    public void _20k_xlsx_createFile() throws IOException {
//        File source = new File("C:\\book1.xlsx");
//        for (int j = 1; j <= 5000; j++) {
//            File des = new File("D:\\newOneDrive\\OneDrive - Nakivo\\excel1\\book1_" + j + ".xlsx");
//            System.out.println("Make copy file number is " + j + "");
//            copyFileUsingStream(source, des);
//        }
//    }
//
//    @Test
//    public void _20k_image_createFile() throws IOException {
//        File source = new File("C:\\picture.png");
//        for (int i = 6; i <= 40; i++) {
//            for (int j = 1; j <= 5000; j++) {
//                File des = new File("D:\\newOneDrive\\OneDrive - Nakivo\\image1\\picture_" + j + ".png");
//                System.out.println("Make copy file number is " + j + "");
//                copyFileUsingStream(source, des);
//            }
//        }
//    }
//
//
//    @Test(retryAnalyzer = RetryFailedTestCases.class)
//    public void UploadOneDrive_1000000_2000000() throws IOException {
//        Office365Utils office365Utils = new Office365Utils();
//        office365Utils.uploadFileToOneDrive("Y:/txt2/");
//    }
//
//    @Test
//    public void _100000_2000000_createFile() throws IOException {
//        File source = new File("Y:\\txt2\\AD_service.txt");
//        for (int j = 1000001; j <= 2000000; j++) {
//            File des = new File("Y:\\txt2\\AD_service_" + j + ".txt");
//            System.out.println("Make copy file number is " + j + "");
//            copyFileUsingStream(source, des);
//        }
//    }
//
//
//    public void copyFileUsingStream(File source, File dest) throws IOException {
//        InputStream is = null;
//        OutputStream os = null;
//        try {
//            is = new FileInputStream(source);
//            os = new FileOutputStream(dest);
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = is.read(buffer)) > 0) {
//                os.write(buffer, 0, length);
//            }
//        } finally {
//            is.close();
//            os.close();
//        }
//    }
//}
