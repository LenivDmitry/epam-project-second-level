package test.i_can_win_and_bring_it_on;

import page.enums.PasteExpiration;
import page.i_can_win_and_bring_it_on.NewPastePastebinPage;
import page.i_can_win_and_bring_it_on.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ICanWinTest {
    private WebDriver driver;
    private NewPastePastebinPage newPastePastebinPage;
    private String postFormText = "Hello from WebDriver";
    private String nameTitle = "helloweb";
    private PasteExpiration pasteExpiration = PasteExpiration.MINUTES_10;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        newPastePastebinPage = pastebinHomePage.openPage()
                .fillingFieldsOfPage(postFormText, nameTitle, pasteExpiration)
                .createNewPaste();
    }

    @Test()
    public void nameTitleIsRight() throws InterruptedException {
        Assert.assertEquals(nameTitle, newPastePastebinPage.getTitle().getText(), "Title doesn't equal to the given");
    }

    @Test()
    public void postFormTextIsRight() throws InterruptedException {
        Assert.assertEquals(postFormText, newPastePastebinPage.getMarker().getText(), "Text doesn't equal to the given");
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
