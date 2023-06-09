package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{
    @FindBy(id = "sp_amount")
    public WebElement amountBox;
    @FindBy(id = "sp_date")
    public WebElement dateBox;
    @FindBy(id = "sp_description")
    public WebElement descriptionBox;
    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//span[text()='The payment was successfully submitted.']")
    public WebElement succesPayMessage;



    public void pay(String amount,String date,String description){
        amountBox.sendKeys(amount);
        dateBox.sendKeys(date);
        descriptionBox.sendKeys(description);
        payButton.click();
    }
    public void tapOnPayBilssaTabs(String name){
        Driver.get().findElement(By.xpath("//a[text()='"+name+"']")).click();
    }


}
