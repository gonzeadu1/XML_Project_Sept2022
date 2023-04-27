package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

   WebDriver driver;


    String userName;
    String password;



    @Test
    @Parameters({"UserName", "Password"})
    public void validUserShouldBeAbleToLogin(String userName, String password){
        this.driver =  BrowserFactory.init();
        LoginPage loginPage = PageFactory.initElements(this.driver, LoginPage.class);
        loginPage.enterUserName(userName);
        loginPage.insertPassword(password);
        loginPage.clickOnSigninButton();

        DashboardPage dashboardPage= PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.validateDashboard();




        BrowserFactory.tearDown();
    }
}
