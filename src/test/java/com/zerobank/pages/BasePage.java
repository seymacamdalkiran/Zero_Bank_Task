package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement signinButton;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankMenu;
    @FindBy(className = "brand")
    public WebElement zeroBankText;
    @FindBy(xpath = "//a[contains(.,'username')]")
    public WebElement settings;
    @FindBy (xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement usernameText;

    @FindBy(xpath = "//strong[text()='Feedback']")
    public WebElement feedback;
    @FindBy(xpath = "//strong[text()='Home']")
    public WebElement home;
    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBanking;

    public static void click(WebElement element){
        element.click();
    }
    public void homeOnlineFeedback(String menu){
        Driver.get().findElement(By.xpath("//strong[text()='"+menu+"']")).click();
    }
    public void onlineBankingModule(String module){
        Driver.get().findElement(By.xpath("//span[text()='"+module+"']")).click();
    }
}
