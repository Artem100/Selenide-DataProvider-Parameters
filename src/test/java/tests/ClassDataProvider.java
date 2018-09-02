package tests;

import org.testng.annotations.DataProvider;

public class ClassDataProvider {
    @DataProvider(name = "TestData2")
    public static Object[] credentials() {
        Object[] elementArray = new Object[][]{
                { "testuser_1", "Test@1" },
                { "testuser_2", "Test@2" },
                { "testuser_3", "Test@3" },
                { "testuser_4", "Test@4" },
                { "webinar5", "webinar5" }};
        return elementArray;
    }
}
