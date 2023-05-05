package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionsPage extends BasePage{

    @FindBy(id = "aa_fromDate")
    @CacheLookup
    private WebElement fromDate;

    @FindBy(id = "aa_toDate")
    @CacheLookup
    private WebElement toDate;

    @FindBy(xpath = "//button[text()='Find']")
    @CacheLookup
    private WebElement findButton;

    @FindBy(id = "aa_description")
    @CacheLookup
    private WebElement description;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    @CacheLookup
    private List<WebElement> dateList;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[2]")
    @CacheLookup
    private List<WebElement> descriptionList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    @CacheLookup
    private List<WebElement> depositColumnList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    @CacheLookup
    private List<WebElement> withdrawColumnList;

    public void sendKeysToDates(int a1,int a2,int a3,int a4,int a5,int a6){
        fromDate.sendKeys(a1+"-"+a2+"-"+a3);
        toDate.sendKeys(a4+"-"+a5+"-"+a6);
    }
    public void tapOnTheFindButton(){
        BrowserUtils.waitForClickablility(findButton,3);
        BrowserUtils.clickWithJS(findButton);
    }
    public void sendKeysToDescription(String message){
        description.sendKeys(message);
    }

    public void sendKeysToDates(String from,String to){
        fromDate.sendKeys(from);
        toDate.sendKeys(to);
    }

    public List<String> getAllTextFromDescriptions(){
        List<String> elementsText = BrowserUtils.getElementsText(descriptionList);
        return elementsText;
    }
    public List<String> getAllTextFromDeposit(){
        List<String> elementsText = BrowserUtils.getElementsText(depositColumnList);
        List<String> deposit=new ArrayList<>();
        for (String s : elementsText) {
            if(!s.isEmpty()){
                deposit.add(s);
            }
        }
        return deposit;
    }
    public List<String> getAllTextFromWithdrawal(){
        List<String> elementsText = BrowserUtils.getElementsText(withdrawColumnList);
        List<String> withdraw=new ArrayList<>();
        for (String s : elementsText) {
            if(!s.isEmpty()){
                withdraw.add(s);
            }
        }
        return withdraw;
    }
    public void selectType(String str){
        WebElement type = Driver.get().findElement(By.id("aa_type"));
        Select select=new Select(type);
        select.selectByVisibleText(str);
        select.getFirstSelectedOption().click();
    }
    public boolean isDateOrdered() throws ParseException {
        List<Date> dates=new ArrayList<>();
        List<String> stringOfDates = BrowserUtils.getElementsText(dateList);
        for (String stringOfDate :stringOfDates) {
            SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date=sdFormat.parse(stringOfDate);
            dates.add(date);
        }
        for (int i = 0; i < dates.size(); i++) {
            for (int j = i+1; j < dates.size() ; j++) {
                if(dates.get(i).compareTo(dates.get(j))<=0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDateBetweenFromAndTo(String from,String to) throws ParseException {
        List<Date> dates=new ArrayList<>();
        List<String> stringOfDates = BrowserUtils.getElementsText(dateList);
        SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date fromD=sdFormat.parse(from);
        Date toD=sdFormat.parse(to);
        for (String stringOfDate :stringOfDates) {
            Date date=sdFormat.parse(stringOfDate);
            dates.add(date);
        }
        for (Date date : dates) {
            if (toD.compareTo(date)<0) {
                return false;
            }
            if(date.compareTo(fromD)<0){
                return false;
            }
        }
        return true;
    }
}
