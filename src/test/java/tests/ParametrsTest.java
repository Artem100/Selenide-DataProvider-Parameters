package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPageJira;
import utils.ConfigProperties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class ParametrsTest {

    private static LoginPageJira loginPage;
    private static DashboardPage dashboardPage;

    @BeforeTest
    @Parameters("browser")
    public void setupSuite(String browser){
        Configuration.browser=browser;
        loginPage = new LoginPageJira();
        dashboardPage = new DashboardPage();
        loginPage.loginToJiraSite();
        loginPage.enterLogin(ConfigProperties.getTestProperty("LoginWebinar5"));
        loginPage.enterPassword(ConfigProperties.getTestProperty("PasswordWebinar5"));
        loginPage.clickSubmitButton();
        loginPage.atRequiredPage();
        loginPage.jSessionCookies=WebDriverRunner.getWebDriver().manage().getCookieNamed("JSESSIONID").getValue();
        close();
    }

    @BeforeMethod
    public void setupTest() {
        open(ConfigProperties.getTestProperty("jiraURL"));
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("JSESSIONID", loginPage.jSessionCookies));
        dashboardPage.navigateToProfile();
        System.out.println("Hi!");
    }

    @Test
    public void jiraDashboard(){
        dashboardPage.navigateToProfile();
        System.out.println("Hi!");
    }



}
