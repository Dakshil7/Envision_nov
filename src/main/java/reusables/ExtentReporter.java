package reusables;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporter {



        public static ExtentReports mainReport;

        public static String generateFolderPath(String path){
            String str = System.getProperty("user.dir") + File.separator + path;
            str = str + File.separator + new SimpleDateFormat("MMM-dd").format(new Date());
            str = str + File.separator + new SimpleDateFormat("hh-mm-ss").format(new Date());
            return str;
        }

        public static synchronized ExtentReports getReporter() {
            try {
                if (mainReport == null){
                    String extentReportPath = "extentReport";
                    extentReportPath = generateFolderPath(extentReportPath);
                    File reportDirectory = new File(extentReportPath);
                    if (!reportDirectory.exists()) {
                        reportDirectory.mkdirs();
                    }
                    mainReport = new ExtentReports(extentReportPath + "//AutomationReport.html");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return mainReport;
        }


}
