package page.hurt_me_plenty_and_hardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class GoogleCloudSearchingResults extends AbstractPage {
    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement googleCloudPlatformPricingCalculatorLink;

    public GoogleCloudSearchingResults(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPlatformPricingCalculator chooseGoogleCloudPlatformPricingCalculator() {
        waitingVisibilityOfElement(googleCloudPlatformPricingCalculatorLink);
        googleCloudPlatformPricingCalculatorLink.click();
        return new GoogleCloudPlatformPricingCalculator(driver);
    }
}
