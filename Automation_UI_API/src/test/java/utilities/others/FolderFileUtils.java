package utilities.others;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class FolderFileUtils {

    /**
     * @param folderPath, numberFolder
     * @throws IOException
     */
    // E.g: createFolder(parentFolder/childFolder)
    // E.g: createFolder(C:\\parentFolder\\childFolder)
    public static boolean createFolder(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists()) {
            if (file.mkdir()) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Directory was exist !");
            return false;
        }
    }

    /**
     * @param folderPath, numberFolder
     * @throws IOException
     */
    public static void createMutilFolder(String folderPath, int numberFolder) {
        File file = new File(folderPath);
        for (int i = 1; i <= numberFolder; i++) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    System.out.println("True");
                } else {
                    System.out.println("false");
                }
            } else {
                System.out.println("Directory was exist !");
                System.out.println("false");
            }
        }
    }






}
