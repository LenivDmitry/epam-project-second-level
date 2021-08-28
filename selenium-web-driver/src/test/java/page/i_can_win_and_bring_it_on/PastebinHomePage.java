package page.i_can_win_and_bring_it_on;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import page.enums.PasteExpiration;

public class PastebinHomePage extends AbstractPage {
    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement elementPostFormText;
    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement elementPasteExpiration;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteNameTitle;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement buttonCreateNewPaste;
    @FindBy(xpath = "//span[@class='select2-selection__rendered']")
    private WebElement fieldSyntaxHighlighting;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement fieldWritingSyntaxHighlighting;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get("https://pastebin.com/");
        waitingForPageLoad();
        return this;
    }

    public PastebinHomePage fillingFieldsOfPage(String postFormText, String nameTitle, PasteExpiration pasteExpiration) {
        elementPostFormText.sendKeys(postFormText);
        elementPasteExpiration.click();
        choosePasteExpiration(pasteExpiration);
        pasteNameTitle.sendKeys(nameTitle);
        return this;
    }

    public PastebinHomePage fillingFieldsOfPage(String postFormText, String nameTitle,
                                                PasteExpiration pasteExpiration, String syntaxHighlighting) {
        elementPostFormText.sendKeys(postFormText);
        fieldSyntaxHighlighting.click();
        fieldWritingSyntaxHighlighting.sendKeys(syntaxHighlighting + System.lineSeparator());
        elementPasteExpiration.click();
        choosePasteExpiration(pasteExpiration);
        pasteNameTitle.sendKeys(nameTitle);
        return this;
    }

    public NewPastePastebinPage createNewPaste() {
        buttonCreateNewPaste.click();
        return new NewPastePastebinPage(driver);
    }

    public void choosePasteExpiration(PasteExpiration pasteExpiration) {
        driver.findElement(By.xpath(pasteExpiration.getTitle())).click();
    }
}
