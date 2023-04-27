package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
    WebDriver driver;




    @Test
    @Parameters({"UserName","password","FullName","CompanyName","Email","Phone","Address","City","Country","State","Zip"})
    public void userShouldBeAbleToAddCustomerFromListCustomer(String userName, String password,String fullName,String companyName,String emailAddress,String phoneNumber, String streetAddress, String city, String country,String state, String zip) throws InterruptedException {
        driver = BrowserFactory.init();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUserName(userName);
        loginPage.insertPassword(password);
        loginPage.clickOnSigninButton();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.validateDashboard();
        dashboardPage.clickCustomerMenuElement();
        dashboardPage.clickListCustomerMenuElement();
        ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
        listCustomerPage.clickOnAddCustomerOnListCustomer();

        AddCustomerPage addCustomerPage= PageFactory.initElements(driver, AddCustomerPage.class);
        addCustomerPage.validateAddContactPage();
        addCustomerPage.insertFullName(fullName);
        addCustomerPage.selectFromCompany(companyName);
        addCustomerPage.insertEmailAddress(emailAddress);
        addCustomerPage.insertPhoneNumber(phoneNumber);
        addCustomerPage.insertAddress(streetAddress);
        addCustomerPage.insertCity(city);
        addCustomerPage.insertState(state);
        addCustomerPage.insertZip(zip);
        addCustomerPage.selectCountry(country);
        addCustomerPage.clickSaveButton();


        listCustomerPage.validateProfilePage();
        dashboardPage.clickListCustomerMenuElement();
        listCustomerPage.insertOnSearchBarOnListCustomer();
        listCustomerPage.validInsertedNameAndProfile();
        BrowserFactory.tearDown();

    }
}
