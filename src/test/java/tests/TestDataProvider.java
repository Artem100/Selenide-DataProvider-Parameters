package tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.LoginPageJira;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDataProvider {

    private static LoginPageJira loginPage;

    @BeforeMethod
    public void setup(){
        open("http://jira.hillel.it:8080");
        loginPage = new LoginPageJira();
    }

    @DataProvider(name = "TestData")
    public Object[][] getData(){

        Object[][]data = new Object[3][2];

        data[0][0]="webinar2";
        data[0][1]="webinar2";

        data[1][0]="webinar3";
        data[1][1]="webinar3";

        data[2][0]="webinar51";
        data[2][1]="webinar51";

        return data;
    }

    //@Test(dataProvider = "TestData2", dataProviderClass = ClassDataProvider.class) - класс с данными для DataProvider
    @Test(dataProvider = "TestData")
    public void providerLoginNegative(String username, String password){
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.errorMessage();
    }

}
