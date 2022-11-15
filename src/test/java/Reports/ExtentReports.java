package Reports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReports {
    static com.aventstack.extentreports.ExtentReports extent;

    public static com.aventstack.extentreports.ExtentReports extentReportGenerator() {
        String path = System.getProperty("user.dir") + File.separator + "target" + File.separator + "ExtentReport" + File.separator + "report-" + System.currentTimeMillis() + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("htmlReport");
        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("ReportGenerate", "Successfully");
        return extent;
    }
}
