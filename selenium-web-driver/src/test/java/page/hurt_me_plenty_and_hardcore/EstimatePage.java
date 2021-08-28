package page.hurt_me_plenty_and_hardcore;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

import java.util.Set;

public class EstimatePage extends AbstractPage {
    @FindBy(xpath = "//div[contains(text(),'VM class')]")
    private WebElement VMClass;
    @FindBy(xpath = "//div[contains(text(),'Instance type')]")
    private WebElement instanceType;
    @FindBy(xpath = "//div[contains(text(),'Region')]")
    private WebElement region;
    @FindBy(xpath = "//div[contains(text(),'local SSD')]")
    private WebElement localSsd;
    @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
    private WebElement commitmentTerm;
    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement totalEstimatedCost;
    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimate;
    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement emailField;
    @FindBy(xpath = "//button[@ng-disabled='emailForm.$invalid']")
    private WebElement buttonSendEmail;

    private String window1_googleCloudPlatformPricingCalculator;
    private String window2_yopMailPage;

    private YopMailPage yopMailPage;
    private YopMailGeneratedAddressPage yopMailGeneratedAddressPage;

    protected EstimatePage(WebDriver driver) {
        super(driver);
    }

    public EstimatePage sendEmailEstimateToRandomEmail() {
        clickingOnAppearedElement(emailEstimate);
        window1_googleCloudPlatformPricingCalculator = driver.getWindowHandle();
        window2_yopMailPage = getNameNewWindow(window1_googleCloudPlatformPricingCalculator);
        driver.switchTo().window(window2_yopMailPage);

        yopMailPage = new YopMailPage(driver);
        yopMailPage.openPage();
        yopMailGeneratedAddressPage = yopMailPage.selectEmailGenerator();
        yopMailGeneratedAddressPage.copyRandomEmail();

        driver.switchTo().window(window1_googleCloudPlatformPricingCalculator);
        driver.switchTo().frame(0).switchTo().frame("myFrame");

        emailField.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v"));
        buttonSendEmail.click();
        return this;
    }

    public String getTotalCostFromMail() {
        driver.switchTo().window(window2_yopMailPage);
        String totalCost = yopMailGeneratedAddressPage.openCheckingEmailPage().getTotalCost().getText();
        driver.switchTo().window(window1_googleCloudPlatformPricingCalculator);
        return totalCost;
    }

    public String getNameNewWindow(String window1) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        //The window2 opened, but we stay on the first window. We don't know name of window2 and we can't to switch,
        //we can get only list of name's windows and find name of window2 by foreach.
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;
        for (String window : currentWindows) {
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }
        return window2;
    }

    public String getTextVMClass() {
        waitingVisibilityOfElement(VMClass);
        String VMClassAsString = VMClass.getText();
        return VMClassAsString;
    }

    public String getInstanceType() {
        waitingVisibilityOfElement(instanceType);
        String InstanceTypeAsString = instanceType.getText();
        return InstanceTypeAsString;
    }

    public String getRegion() {
        waitingVisibilityOfElement(region);
        String regionAsString = region.getText();
        return regionAsString;
    }

    public String getLocalSsd() {
        waitingVisibilityOfElement(localSsd);
        String localSsdAsString = localSsd.getText();
        return localSsdAsString;
    }

    public String getCommitmentTerm() {
        waitingVisibilityOfElement(commitmentTerm);
        String commitmentTermAsString = commitmentTerm.getText();
        return commitmentTermAsString;
    }

    public String getTotalEstimatedCost() {
        waitingVisibilityOfElement(totalEstimatedCost);
        String totalEstimatedCostAsString = totalEstimatedCost.getText();
        return totalEstimatedCostAsString;
    }
}
