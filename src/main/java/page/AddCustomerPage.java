package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
    WebDriver driver;

    static String insertedName;
    public static String getInsertedName() {
        return insertedName;
    }

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
    }
    //WebElement

    @FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_PAGE;
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")WebElement FULLNAME_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")WebElement COMPANY_DROPDOWN_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")WebElement EMAIL_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")WebElement PHONE_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")WebElement ADDRESS_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")WebElement CITY_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")WebElement STATE_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")WebElement ZIP_ELEMENT;
    @FindBy(how = How.XPATH, using = "//select[@name = 'country']")WebElement COUNTRY_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")WebElement SAVE_ELEMENT;


    //Interactable Methods
   public void validateAddContactPage(){
       Assert.assertTrue(ADD_CONTACT_PAGE.isDisplayed(), "Add contact page not found!");
   }


   public void insertFullName(String fullName){
      insertedName = fullName + generateRandomChar(26);
       FULLNAME_ELEMENT.sendKeys(" " + insertedName);
       //FULLNAME_ELEMENT.sendKeys(fullName  + " " + generateRandomChar(26));

   }

    public void selectFromCompany(String companyName){
        selectFromDropDown(COMPANY_DROPDOWN_ELEMENT, companyName);
    }

    public void insertEmailAddress(String email){
       EMAIL_ELEMENT.sendKeys( generateRandomNum(9999) + email);
   }

    public void insertPhoneNumber(String phone){
       PHONE_ELEMENT.sendKeys(phone + generateRandomNum(999));
    }

    public void insertAddress(String address){
        ADDRESS_ELEMENT.sendKeys(address);
    }

    public void insertCity(String city){
        CITY_ELEMENT.sendKeys(city);
    }

    public void insertState(String state){
        STATE_ELEMENT.sendKeys(state);
    }

    public void insertZip(String zip){
        ZIP_ELEMENT.sendKeys(zip);
    }

    public void selectCountry(String country){
        selectFromDropDown(COUNTRY_ELEMENT, country);
    }

    public void clickSaveButton(){
        SAVE_ELEMENT.click();
    }







}
