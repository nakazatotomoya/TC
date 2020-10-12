package tests;

import model.Account;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class TC_03_EmployeeManagement extends PageFactoryInitializer {
    private Account account = testDataModel.getAccount();

    @Test
    public void TC_01_DisplayVideoList() throws InterruptedException {
        System.out.println("Running TC_01_DisplayVideoList");
        openUrlDefault();
        loginPage()
                .login(account.getUserName(), account.getPass());
        employeeManagementPage()
                .checkDisplayVideoList();
    }

    @Test
    public void TC_02_DeleteProject() throws Exception {
        System.out.println("Running TC_02_DeleteProject");
        openUrlDefault();
        loginPage()
                .login(account.getUserName(), account.getPass());
        employeeManagementPage()
                .deleteProject();
    }
}
