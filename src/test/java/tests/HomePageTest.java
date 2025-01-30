package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PracticePage;
import utility.Base;

import java.io.IOException;
import java.util.List;

public class HomePageTest extends Base{
public WebDriver driver;
    @BeforeClass
    public void setUp() throws IOException {
        driver = setUpBrowser();

    }
    @Test
    public void verifyTitle(){
        String actualURL = driver.getTitle();
        Assert.assertEquals(actualURL,"Practice Page");
        System.out.println("Title is verified");

    }

    @Test
    public void verifyCheckBox(){
        System.out.println("Checkbox is verified");
    }
    @Test
    public void verifyTable(){
        PracticePage pp = new PracticePage(driver);
        Assert.assertEquals(pp.header1().getText(),"Instructor");
        System.out.println("Header 1 is verified");
        Assert.assertEquals(pp.header2().getText(),"Course");
        System.out.println("Header 2 is verified");
        Assert.assertEquals(pp.header3().getText(),"Price");
        System.out.println("Header 3 is verified");
        List<WebElement> elemets = driver.findElements(By.xpath("//tr//td[2]"));
        int size = elemets.size();
        for(int i=0;i<size;i++){
            System.out.println("The available courses are : "+elemets.get(i).getText());
        }
    }
    @AfterTest
    public void tearDown(){

        driver.close();
    }
}
