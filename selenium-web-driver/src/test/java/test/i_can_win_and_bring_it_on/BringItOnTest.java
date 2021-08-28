package test.i_can_win_and_bring_it_on;

import page.enums.PasteExpiration;
import page.i_can_win_and_bring_it_on.NewPastePastebinPage;
import page.i_can_win_and_bring_it_on.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BringItOnTest {
    private WebDriver driver;
    private NewPastePastebinPage newPastePastebinPage;
    private String postFormText = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String nameTitle = "how to gain dominance among developers";
    private String syntaxHighlighting = "Bash";
    private PasteExpiration pasteExpiration = PasteExpiration.MINUTES_10;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        newPastePastebinPage = pastebinHomePage.openPage()
                .fillingFieldsOfPage(postFormText, nameTitle, pasteExpiration, syntaxHighlighting)
                .createNewPaste();
    }

    @Test()
    public void nameTitleIsRight() throws InterruptedException {
        Assert.assertEquals(nameTitle, newPastePastebinPage.getTitle().getText(), "Title doesn't equal to the given");
    }

    @Test()
    public void syntaxHighlightingIsCorrect() throws InterruptedException {
        Assert.assertEquals(syntaxHighlighting, newPastePastebinPage.getSyntaxBash().getText(), "Syntax doesn't equal to the given");
    }

    @Test()
    public void postFormTextIsRight() throws InterruptedException {
        Assert.assertEquals(postFormText, newPastePastebinPage.getMarker().getText(), "Text doesn't equal to the given");
    }

    @AfterTest()
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
