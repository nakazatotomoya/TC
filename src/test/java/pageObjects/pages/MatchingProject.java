package pageObjects.pages;

import controllers.BaseMethod;
import controllers.InitMethod;
import model.SearchConditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MatchingProject extends BaseMethod {

    @FindBy(xpath = "//nav[@id='nav']/ul/li[2]")
    public WebElement txtMatching;

    @FindBy(linkText = "案件マッチング")
    public WebElement txtMatchingProject;

    @FindBy(css = "div#nav-search form")
    public WebElement searchForm;

    @FindBy(css = "#search_flg_foreign")
    public WebElement foreign;

    @FindBy(css = "[for='search_occupation_1']")
    public WebElement occupation1;

    @FindBy(css = "[for='search_occupation_2']")
    public WebElement occupation2;

    @FindBy(css = "[for='search_occupation_3']")
    public WebElement occupation3;

    @FindBy(css = "[for='search_occupation_4']")
    public WebElement occupation4;

    @FindBy(css = "[for='search_occupation_5']")
    public WebElement occupation5;

    @FindBy(css = "[for='search_occupation_6']")
    public WebElement occupation6;

    @FindBy(css = "[for='search_occupation_7']")
    public WebElement occupation7;

    @FindBy(css = "[for='search_occupation_8']")
    public WebElement occupation8;

    @FindBy(css = "[for='search_occupation_9']")
    public WebElement occupation9;

    @FindBy(css = "[for='search_occupation_10']")
    public WebElement occupation10;

    @FindBy(css = "[for='search_occupation_11']")
    public WebElement occupation11;

    @FindBy(css = "[for='search_occupation_12']")
    public WebElement occupation12;

    @FindBy(css = "#search_term_begin")
    public WebElement startDate;

    @FindBy(css = "#search_term_end")
    public WebElement endDate;

    @FindBy(css = "#amount_from")
    public WebElement startPrice;

    @FindBy(css = "#amount_to")
    public WebElement endPrice;

    @FindBy(css = "#search_note")
    public WebElement note;

    @FindBy(css = "div:nth-of-type(9) > span:nth-of-type(1) > .btn > .glyphicon.glyphicon-plus")
    public WebElement suppliers;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(1) .search-chk")
    public WebElement cbxSupplier1;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(2) .search-chk")
    public WebElement cbxSupplier2;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(3) .search-chk")
    public WebElement cbxSupplier3;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(4) .search-chk")
    public WebElement cbxSupplier4;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(5) .search-chk")
    public WebElement cbxSupplier5;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(6) .search-chk")
    public WebElement cbxSupplier6;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(7) .search-chk")
    public WebElement cbxSupplier7;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(8) .search-chk")
    public WebElement cbxSupplier8;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(9) .search-chk")
    public WebElement cbxSupplier9;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(10) .search-chk")
    public WebElement cbxSupplier10;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(11) .search-chk")
    public WebElement cbxSupplier11;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(12) .search-chk")
    public WebElement cbxSupplier12;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(13) .search-chk")
    public WebElement cbxSupplier13;

    @FindBy(css = "body [class='col-md-6']:nth-of-type(14) .search-chk")
    public WebElement cbxSupplier14;

    @FindBy(css = "body > [role='dialog']:nth-child(6) [data-dismiss]")
    public WebElement btnClose;

    @FindBy(css = "form > div:nth-of-type(10) > span:nth-of-type(1)")
    public WebElement btnSearch;

    @FindBy(css = "[onclick='editSearchSkillCondition\\(\\)\\;'] .glyphicon-plus")
    public WebElement btnSkill;

    @FindBy(css = "#m_skill_sort")
    public WebElement cbx50Order;

    @FindBy(css = "#search_skill_label_16")
    public WebElement cbxC;

    @FindBy(css = "#search_skill_level_16")
    public WebElement ddC;

    @FindBy(xpath = "//div[@id='edit_search_skill_condition_modal']//ul[@class='list-group']/li[4]")
    public WebElement OSCate;

    @FindBy(css = "#search_skill_label_67")
    public WebElement cbxWebSphere;

    @FindBy(css = "#search_skill_level_67")
    public WebElement ddLevel;

    @FindBy(css = "body > [role='dialog']:nth-child(5) .modal-footer [data-dismiss]")
    public WebElement btnClose1;

    @FindBy(css = "#selected_skill_list")
    public WebElement txtInfor;

    @FindBy(xpath = "//div[@id='slider-range-age']/span[1]")
    public WebElement btnAge;

    private SearchConditions searchConditions = testDataModel.getSearchConditions();

    public MatchingProject searchByConditions() throws InterruptedException {
        checkDisplayForm();
        selectForeign();
        checkOccupation();
        selectSkill();
        inputTime();
        inputPrice();
        inputAge();
        checkSuppliers();
        inputNote();
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        click(btnSearch);
        Thread.sleep(InitMethod.SLEEP_5000_MS);
        saveScreenShotFullPage("7-1-1", InitMethod.SCREENSHOT_PATH + "Testcase-7.1");
        return this;
    }

    public MatchingProject selectSkill() throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        click(btnSkill);
        Thread.sleep(InitMethod.SLEEP_2000_MS);
        click(cbx50Order);
        assertIsDisplayed(cbxC, InitMethod.SLEEP_2000_MS);
        click(cbxC);
        assertIsDisplayed(ddC, InitMethod.SLEEP_1000_MS);
        selectByIndex(ddC, 4);
        assertIsDisplayed(OSCate, InitMethod.SLEEP_2000_MS);
        click(OSCate);
        assertIsDisplayed(cbxWebSphere, InitMethod.SLEEP_2000_MS);
        click(cbxWebSphere);
        selectByIndex(ddLevel, 6);
        assertIsDisplayed(btnClose1, InitMethod.SLEEP_3000_MS);
        scrollToElement(btnClose1);
        click(btnClose1);
        Thread.sleep(InitMethod.SLEEP_2000_MS);
        assertIsDisplayed(txtInfor, InitMethod.SLEEP_2000_MS);
        assertEquals(txtInfor.getText(), searchConditions.getInforSkill());
        return this;
    }

    public MatchingProject checkSuppliers() throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        assertIsDisplayed(suppliers, InitMethod.SLEEP_2000_MS);
        click(suppliers);
        Thread.sleep(InitMethod.SLEEP_5000_MS);
        cbxSupplier1.isSelected();
        cbxSupplier2.isSelected();
        cbxSupplier3.isSelected();
        cbxSupplier4.isSelected();
        cbxSupplier5.isSelected();
        cbxSupplier6.isSelected();
        cbxSupplier7.isSelected();
        cbxSupplier8.isSelected();
        cbxSupplier9.isSelected();
        cbxSupplier10.isSelected();
        cbxSupplier11.isSelected();
        cbxSupplier12.isSelected();
        cbxSupplier13.isSelected();
        cbxSupplier14.isSelected();
        assertIsDisplayed(btnClose, InitMethod.SLEEP_2000_MS);
        click(btnClose);
        return this;
    }

    public MatchingProject inputNote() throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        assertIsDisplayed(note, InitMethod.SLEEP_2000_MS);
        clearAndType(note, searchConditions.getNote());
        return this;
    }

    public MatchingProject inputAge() throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        btnAge.sendKeys(Keys.ARROW_UP);
        btnAge.sendKeys(Keys.ARROW_DOWN);
        return this;
    }

    public MatchingProject inputPrice() throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        assertIsDisplayed(startPrice, InitMethod.SLEEP_2000_MS);
        clearAndType(startPrice, searchConditions.getStartPrice());
        assertIsDisplayed(endPrice, InitMethod.SLEEP_2000_MS);
        clearAndType(endPrice, searchConditions.getEndPrice());
        return this;
    }

    public MatchingProject inputTime() throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        assertIsDisplayed(startDate, InitMethod.SLEEP_2000_MS);
        clearAndType(startDate, searchConditions.getStartDate());
        assertIsDisplayed(endDate, InitMethod.SLEEP_2000_MS);
        clearAndType(endDate, searchConditions.getEndDate());
        return this;
    }

   public MatchingProject selectForeign() throws InterruptedException {
       Thread.sleep(InitMethod.SLEEP_3000_MS);
        assertIsDisplayed(foreign, InitMethod.SLEEP_2000_MS);
        selectByIndex(foreign, 1);
        return this;
    }

    public MatchingProject checkDisplayForm() throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        mousehover(txtMatching);
        click(txtMatchingProject);
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        assertIsDisplayed(searchForm, InitMethod.SLEEP_3000_MS);
        return this;
    }

    public MatchingProject checkOccupation() throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_3000_MS);
        assertIsDisplayed(occupation1);
        click(occupation1);
        assertIsDisplayed(occupation2);
        click(occupation2);
        assertIsDisplayed(occupation3);
        click(occupation3);
        assertIsDisplayed(occupation4);
        click(occupation4);
        assertIsDisplayed(occupation5);
        click(occupation5);
        assertIsDisplayed(occupation6);
        click(occupation6);
        assertIsDisplayed(occupation7);
        click(occupation7);
        assertIsDisplayed(occupation8);
        click(occupation8);
        assertIsDisplayed(occupation9);
        click(occupation9);
        assertIsDisplayed(occupation10);
        click(occupation10);
        assertIsDisplayed(occupation11);
        click(occupation11);
        assertIsDisplayed(occupation12);
        click(occupation12);
        return this;
    }
}
