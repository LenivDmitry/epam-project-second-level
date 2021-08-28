package page.i_can_win_and_bring_it_on;

import page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewPastePastebinPage extends AbstractPage {

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement marker;
    @FindBy(xpath = "//h1")
    private WebElement title;
    @FindBy(xpath = "//a[@href='/archive/bash']")
    private WebElement syntaxBash;

    public NewPastePastebinPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMarker() {
        waitingVisibilityOfElement(marker);
        return marker;
    }

    public WebElement getTitle() {
        waitingVisibilityOfElement(title);
        return title;
    }

    public WebElement getSyntaxBash() {
        waitingVisibilityOfElement(syntaxBash);
        return syntaxBash;
    }
}
