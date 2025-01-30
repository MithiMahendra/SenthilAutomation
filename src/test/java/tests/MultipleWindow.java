package tests;

import org.testng.annotations.Test;
import pageObjects.PracticePage;
import utility.Base;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindow extends Base {
    @Test
    public void multipleWindow(){
        PracticePage pp = new PracticePage(Base.driver);
        String parentWindow = Base.driver.getWindowHandle();
        pp.openWindow().click();
        Set<String> windows = Base.driver.getWindowHandles();
        for (String str:windows){
            if (parentWindow.equals(str)){
                System.out.println("Parent Window ID: "+ str);
            }
            else {
                System.out.println("Child Window ID: "+ str);
                Base.driver.switchTo().window(str);
                Base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                System.out.println(pp.welcomeText().getText());
            }
        }

    }

}
