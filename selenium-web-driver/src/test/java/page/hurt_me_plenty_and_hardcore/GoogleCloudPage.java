package page.hurt_me_plenty_and_hardcore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class GoogleCloudPage extends AbstractPage {
    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchIcon;
    @FindBy(xpath = "//h1[@class='cws-headline--headline-2']")
    private WebElement titleGoogleCloud;


    public GoogleCloudPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPage openPage() {
        driver.get("https://cloud.google.com/");
        waitingVisibilityOfElement(searchIcon, titleGoogleCloud);
        return this;
    }

    public GoogleCloudSearchingResults searchInGoogleCloud(String searchText) {
        searchIcon.click();
        searchIcon.sendKeys(searchText + Keys.ENTER);
        return new GoogleCloudSearchingResults(driver);
    }
}
