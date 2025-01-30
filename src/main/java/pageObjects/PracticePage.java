package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage {
    public WebDriver driver;
    public PracticePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//tr//th)[1]")
    WebElement header1;

    @FindBy(xpath = "(//tr//th)[2]")
    WebElement header2;

    @FindBy(xpath = "(//tr//th)[3]")
    WebElement header3;

    @FindBy(id = "openwindow")
    WebElement openWindow;
    @FindBy(xpath = "//*[text()='Welcome to QAClick Academy ']")
    WebElement welcomeText;

    public WebElement welcomeText(){
        return welcomeText;
    }

    public WebElement openWindow(){
        return openWindow;
    }


    public WebElement header1(){
        return header1;
    }
    public WebElement header2(){
        return header2;
    }
    public WebElement header3(){
        return header3;
    }



}
