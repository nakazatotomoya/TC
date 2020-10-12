package tests;

import model.Account;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class TC_07_MatchingProject extends PageFactoryInitializer{
    private Account account = testDataModel.getAccount();

    @Test
    public void TC_07_MatchingProject() throws InterruptedException {
        System.out.println("Running TC_07_MatchingProject");
        openUrlDefault();
        loginPage()
                .login(account.getUserName(), account.getPass());
        matchingProject()
                .searchByConditions();
    }
}
