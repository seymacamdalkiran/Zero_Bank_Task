package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeePage extends BasePage{

    @FindBy(id = "np_new_payee_name")
    private WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    private WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    private WebElement account;

    @FindBy(id = "np_new_payee_details")
    private WebElement payeeDetails;


    @FindBy(xpath = "//div[@id='alert_content']")
    private WebElement succesPayeeMessage;

    @FindBy(id = "add_new_payee")
    private WebElement addButton;

    public WebElement getPayeeName() {
        return payeeName;
    }

    public WebElement getPayeeAddress() {
        return payeeAddress;
    }

    public WebElement getAccount() {
        return account;
    }

    public WebElement getPayeeDetails() {
        return payeeDetails;
    }
    public String getPayeeMessageText(){
        BrowserUtils.waitFor(3);
        return succesPayeeMessage.getText();
    }
    public void clickAddButton(){
        BrowserUtils.clickWithJS(addButton);
    }
}
