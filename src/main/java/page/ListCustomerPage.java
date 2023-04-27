package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage extends BasePage {
    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") WebElement SUMMARY_ON_PROFILE_ELEMENT;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]") WebElement DELETE_BUTTON_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BAR_ON_LIST_CUSTOMER_ELEMENT;


    public ListCustomerPage(WebDriver driver){
        this.driver = driver;
    }
    //WebElement

    //Interactable Methods
    public void validateProfilePage(){
        waitForElement(driver, 5, SUMMARY_ON_PROFILE_ELEMENT);
        Assert.assertFalse(SUMMARY_ON_PROFILE_ELEMENT.isDisplayed(), "Profile page not found!");
    }


    String before_xpath = "//tbody/tr[";
    String after_xpath =  "]/td[3]";
    String after_xpath_delete = "]/td[7]/a[2]";
    String after_xpath_profile = "]/td[7]/a[1]";
    public void validateInsertedNamePageAndDelete() throws InterruptedException {
        //tbody/tr/td[3]
        //tbody/tr[2]/td[3]
        //tbody/tr[3]/td[3]
        //tbody/tr[4]/td[3]
        ///////=============deleteButton
        //tobody/tr[1]/td[7]/a[2]


        System.out.println("The names of the rows here: ");
        for(int i =1; i<=5; i++){
            String names = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
            System.out.println(names);
            if(names.contains(AddCustomerPage.getInsertedName())){
                Thread.sleep(2000);
                driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
                DELETE_BUTTON_ELEMENT.click();
            }
            break;
        }
        System.out.println("============ " + AddCustomerPage.getInsertedName());
    }

    public void clickOnAddCustomerOnListCustomer(){
        ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT.click();
    }

    public void insertOnSearchBarOnListCustomer(){
        SEARCH_BAR_ON_LIST_CUSTOMER_ELEMENT.sendKeys(AddCustomerPage.getInsertedName());
    }

    public void validInsertedNameAndProfile(){
        for(int i = 0 ;i<=5;i++){
           String name= driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
           if(name.contains(AddCustomerPage.getInsertedName())){
               driver.findElement(By.xpath(before_xpath + i + after_xpath_profile)).click();
           }
           break;
        }
    }





}
