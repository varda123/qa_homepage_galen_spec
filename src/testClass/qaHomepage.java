package testClass;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

public class qaHomepage {
	public WebDriver driver;

	  
	@BeforeClass
    public void setUp()
    {
        //Create a Chrome Driver
    	String exePath = "C:\\Users\\Vardasaxena\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        //Set the browser size for desktop
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("https://qainfotech.com/");
    }
	  @Test
	    public void homePageLayoutTest() throws IOException
	    {
	        LayoutReport layoutReport = Galen.checkLayout(driver, "C:\\Users\\Vardasaxena\\eclipse-workspace\\qa_galen\\src\\testClass\\resources\\homepage.gspec", Arrays.asList("desktop"));
	        LinkedList<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
	        GalenTestInfo test = GalenTestInfo.fromString("homepage layout");
	        test.getReport().layout(layoutReport, "check homepage layout");
	        tests.add(test);
	        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
	        htmlReportBuilder.build(tests, "target");

	        //If layoutReport has errors Assert Fail
	     /*   if (layoutReport.errors() > 0)
	        {
	            AssertJUnit.fail("Layout test failed");
	        }*/
	    }
  @Test
	  public void elemnt() {
		 WebElement a =  driver.findElement(By.cssSelector("#trueHeader > div > div > header > div.logo.onepage.logo_lg > a > img"));
		  System.out.println(a.getCssValue("padding-top"));
		   System.out.println(a.getCssValue("padding-right"));
		  
	  }

	  //  @AfterMethod
		/*public void tearDown()
	    {
	        driver.quit();
	    }*/
}
