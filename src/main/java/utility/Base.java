package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.javadoc.doclet.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    Properties prop;
    String browserName,baseURL;

    public WebDriver setUpBrowser() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config.properties");
        prop = new Properties();
        prop.load(fis);
        browserName=prop.getProperty("browser");
        baseURL = prop.getProperty("baseURL");
        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("Launched Chrome Browser");
            driver.get(baseURL);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("Launched Web Page");
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            System.out.println("Launched Firefox Browser");
            driver.get(baseURL);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("Launched Web Page");
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            System.out.println("Launched Edge Browser");
            driver.get(baseURL);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            System.out.println("Launched Web Page");

        }
        else
        {
            System.out.println("Please give proper browser name");
        }


        return driver;
    }


}
