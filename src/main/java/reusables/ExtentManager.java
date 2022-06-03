package reusables;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager { //configure report. Generate report in some folder.

    private static ExtentReports suiteReport;

    //one method to create the report
    public static synchronized ExtentReports getReporter() {

        try {
            if (suiteReport == null) {
                String extentReportPath = "extentReports";
                extentReportPath = generateFolderPath(extentReportPath);
                File f = new File(extentReportPath);
                if (!f.isDirectory()) {
                    f.mkdirs();
                }
                suiteReport = new ExtentReports(extentReportPath + "//TestResults.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suiteReport;
    }

    public static String generateFolderPath(String path) { //test//resources//MAY-20//10-30-23//TestResults.html
        String str = System.getProperty("user.dir") + File.separator + path;
        str = str + File.separator + new SimpleDateFormat("MMM-dd").format(new Date());
        str = str + File.separator + new SimpleDateFormat("hh-mm-ss").format(new Date());
        return str;

    }


}