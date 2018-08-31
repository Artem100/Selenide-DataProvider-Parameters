package pages;

import utils.ConfigProperties;

import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {
    public void navigateToProfile() {
        open(ConfigProperties.getTestProperty("jiraURL") + "/secure/Dashboard.jspa");
    }
}
