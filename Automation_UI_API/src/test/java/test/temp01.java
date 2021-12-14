//package test;
//
//import drivers.ui.TestData;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import page.backup.amazonec2backup.AmazonEC2BackupPage;
//import test.jobaction.JobRunResultListener;
//
//import static common.Constants.BVT_BACKUP_JOB;
//
//@Listeners(JobRunResultListener.class)
//public class temp01 extends AmazonEC2BackupPage {
//
//    @Test(groups = {"thanh", "sles", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupSLES(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0018").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "rhel", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupRHEL(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0015").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "ubuntu16", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupUbtSrv16(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0003").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "ubuntu18", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupUbtSrv18(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0006").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "window2016", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupWinSrv2016(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0009").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "window2019", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupWinSrv2019(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0012").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    /*========================================== env02=================================================*/
//
//    @Test(groups = {"thanh", "sles02", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupSLES02(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0050").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "rhel02", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupRHEL02(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0051").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "ubuntu1602", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupUbtSrv1602(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0052").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "ubuntu1802", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupUbtSrv1802(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0053").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "window201602", "bvt_automation"})
//    @Parameters({"type"})
//    public void bvtEC2BackupWinSrv201602(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0054").get(0);
//        createBackupJobs(testData, type);
//    }
//
//    @Test(groups = {"thanh", "window201902", "bvt_automation", "test"})
//    @Parameters({"type"})
//    public void bvtEC2BackupWinSrv201902(String type) throws Exception {
//        TestData testData = TestData.getTestDataBvt(BVT_BACKUP_JOB, "BK0055").get(0);
//        createBackupJobs(testData, type);
//    }
//
//}