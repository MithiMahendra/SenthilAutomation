package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PracticePage;
import utility.Base;
import java.util.List;

public class HomePageTest extends Base{
    @Test
    public void verifyTitle(){
        String actualURL = Base.driver.getTitle();
        Assert.assertEquals(actualURL,"Practice Page");
        System.out.println("Title is verified");
    }
    @Test
    public void verifyCheckBox(){
        System.out.println("Checkbox is verified");
    }
    @Test
    public void verifyTable(){
        PracticePage pp = new PracticePage(Base.driver);
        Assert.assertEquals(pp.header1().getText(),"Instructor");
        System.out.println("Header 1 is verified");
        Assert.assertEquals(pp.header2().getText(),"Course");
        System.out.println("Header 2 is verified");
        Assert.assertEquals(pp.header3().getText(),"Price");
        System.out.println("Header 3 is verified");
        List<WebElement> elemets = Base.driver.findElements(By.xpath("//tr//td[2]"));
        int size = elemets.size();
        for(int i=0;i<size;i++){
            System.out.println("The available courses are : "+elemets.get(i).getText());
        }
    }
}
