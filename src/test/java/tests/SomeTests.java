package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPageJira;
import utils.ConfigProperties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class SomeTests {

    private static LoginPageJira loginPage;
    private static DashboardPage dashboardPage;

    @BeforeSuite
    public void setupSuite(){
        loginPage = new LoginPageJira();
        dashboardPage = new DashboardPage();
        Configuration.browser = ConfigProperties.getTestProperty("useBrowser");
        loginPage.loginToJiraSite();
        loginPage.enterLogin(ConfigProperties.getTestProperty("LoginWebinar5"));
        loginPage.enterPassword(ConfigProperties.getTestProperty("PasswordWebinar5"));
        loginPage.clickSubmitButton();
        loginPage.atRequiredPage();
        loginPage.jSessionCookies=WebDriverRunner.getWebDriver().manage().getCookieNamed("JSESSIONID").getValue();
        close();
    }

    @BeforeMethod
    public void setupTest(){
        Configuration.browser = ConfigProperties.getTestProperty("useBrowser");
        open(ConfigProperties.getTestProperty("jiraURL"));
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("JSESSIONID", loginPage.jSessionCookies));
        dashboardPage.navigateToProfile();
    }

    @Test
    public void firstTest(){
        System.out.println("Hi!");
    }

}
