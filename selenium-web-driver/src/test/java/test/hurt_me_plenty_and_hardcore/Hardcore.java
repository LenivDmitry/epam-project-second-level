package test.hurt_me_plenty_and_hardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.enums.OperatingSystemOrSoftware;
import page.hurt_me_plenty_and_hardcore.EstimatePage;
import page.hurt_me_plenty_and_hardcore.GoogleCloudPage;

public class Hardcore {
    private WebDriver driver;
    private EstimatePage estimatePage;
    private String searchText = "Google Cloud Platform Pricing Calculator";
    private String numberOfInstances = "4";
    private OperatingSystemOrSoftware operatingSystemOrSoft = OperatingSystemOrSoftware.FREE;
    private int machineClass = 1;



    @BeforeTest()
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        GoogleCloudPage googleCloudPage = new GoogleCloudPage(driver);
        estimatePage = googleCloudPage.openPage()
                .searchInGoogleCloud(searchText)
                .chooseGoogleCloudPlatformPricingCalculator()
                .goInTheFrame()
                .selectComputeEngineChapter()
                .fillingNumberOfInstance(numberOfInstances)
                .selectOperatingSystemOrSoftware(operatingSystemOrSoft)
                .selectRegularMachineClass()
                .selectSeries()
                .selectMachineType()
                .selectAddGPUs()
                .selectNumberOfGPUs()
                .selectTypeOfGPUs()
                .selectLocalSSD()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .enterAddToEstimate()
                .sendEmailEstimateToRandomEmail();
    }

    @Test()
    public void compareTotalCostInEmail() throws InterruptedException {
        Assert.assertTrue(estimatePage.getTotalEstimatedCost().contains(estimatePage.getTotalCostFromMail()));
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
