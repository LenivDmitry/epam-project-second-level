package page.hurt_me_plenty_and_hardcore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import page.enums.OperatingSystemOrSoftware;

import java.util.HashMap;
import java.util.Map;

public class GoogleCloudPlatformPricingCalculator extends AbstractPage {
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstance;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemOrSoftware;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClass;
    @FindBy(xpath = "//md-select-menu[@style] /descendant::md-option[@value='regular']")
    private WebElement regularMachineClass;
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement series;
    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesN1;
    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineType;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineTypeN1Standard8;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[@class='md-container md-ink-ripple']")
    private WebElement addGPUs;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    @FindBy(xpath = "//md-select-menu[@style]//md-option[@value='1']")
    private WebElement numberOfGPUs1;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement typeOfGPU;
    @FindBy(xpath = "//md-select-menu//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement typeOfGPUNvidiaTeslaV100;
    @FindBy(xpath = "//md-input-container[@class='md-input-has-placeholder md-input-has-value flex']/md-select[@placeholder='Local SSD']")
    private WebElement localSSD;
    @FindBy(xpath = "//md-select-menu[@style]//md-option[@value='2']/div[contains(text(),'2x375 GB')]")
    private WebElement localSSD2x375Gb;
    @FindBy(xpath = "//md-input-container[@class]/md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocation;
    @FindBy(xpath = "//md-select-menu[@style]//md-option[@value='europe-west3']")
    private WebElement datacenterLocationFrankfurt;
    @FindBy(xpath = "//md-input-container//md-select[@aria-label='Committed usage: None']")
    private WebElement committedUsage;
    @FindBy(xpath = "//div/md-select-menu[@style]//md-option[@ng-value='1']")
    private WebElement committedUsage1Year;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addTOEstimate;

    public GoogleCloudPlatformPricingCalculator(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPlatformPricingCalculator goInTheFrame() {
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectComputeEngineChapter() {
        clickingOnAppearedElement(computeEngine);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator fillingNumberOfInstance(String numberAsString) {
        waitingVisibilityOfElement(numberOfInstance);
        numberOfInstance.sendKeys(numberAsString);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectOperatingSystemOrSoftware(OperatingSystemOrSoftware operatingSystemOrSoft) {
        clickingOnAppearedElement(operatingSystemOrSoftware);
        driver.findElement(By.xpath(operatingSystemOrSoft.getTitle())).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectRegularMachineClass() {
        clickingOnAppearedElement(machineClass);
        clickingOnAppearedElement(regularMachineClass);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectSeries() {
        clickingOnAppearedElement(series);
        clickingOnAppearedElement(seriesN1);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectMachineType() {
        clickingOnAppearedElement(machineType);
        clickingOnAppearedElement(machineTypeN1Standard8);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectAddGPUs() {
        clickingOnAppearedElement(addGPUs);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectNumberOfGPUs() {
        clickingOnAppearedElement(numberOfGPUs);
        clickingOnAppearedElement(numberOfGPUs1);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectTypeOfGPUs() {
        clickingOnAppearedElement(typeOfGPU);
        clickingOnAppearedElement(typeOfGPUNvidiaTeslaV100);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectLocalSSD() {
        clickingOnAppearedElement(localSSD);
        clickingOnAppearedElement(localSSD2x375Gb);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectDatacenterLocation() {
        clickingOnAppearedElement(datacenterLocation);
        clickingOnAppearedElement(datacenterLocationFrankfurt);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectCommittedUsage() {
        clickingOnAppearedElement(committedUsage);
        clickingOnAppearedElement(committedUsage1Year);
        return this;
    }

    public EstimatePage enterAddToEstimate() {
        clickingOnAppearedElement(addTOEstimate);
        return new EstimatePage(driver);
    }
}
