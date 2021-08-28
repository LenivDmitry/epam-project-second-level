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
import page.hurt_me_plenty_and_hardcore.GoogleCloudPlatformPricingCalculator;
import page.hurt_me_plenty_and_hardcore.GoogleCloudSearchingResults;

public class HurtMePlentyTest {
    private WebDriver driver;
    private EstimatePage estimatePage;
    private String searchText = "Google Cloud Platform Pricing Calculator";
    private String numberOfInstances = "4";
    private OperatingSystemOrSoftware operatingSystemOrSoft = OperatingSystemOrSoftware.FREE;



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
                .enterAddToEstimate();
    }

    @Test()
    public void checkVMClass() throws InterruptedException {
        Assert.assertEquals(estimatePage.getTextVMClass(), "VM class: regular",
                "Result is wrong");
    }

    @Test()
    public void checkInstanceType() throws InterruptedException {
        Assert.assertEquals(estimatePage.getInstanceType(), "Instance type: n1-standard-8",
                "Result is wrong");
    }

    @Test()
    public void checkRegion() throws InterruptedException {
        Assert.assertEquals(estimatePage.getRegion(), "Region: Frankfurt",
                "Result is wrong");
    }

    @Test()
    public void checkLocalSSD() throws InterruptedException {
        Assert.assertEquals(estimatePage.getLocalSsd(), "Total available local SSD space 2x375 GiB",
                "Result is wrong");
    }

    @Test()
    public void checkCommitmentTerm() throws InterruptedException {
        Assert.assertEquals(estimatePage.getCommitmentTerm(), "Commitment term: 1 Year",
                "Result is wrong");
    }

    @Test()
    public void checkTotalEstimatedCost() throws InterruptedException {
        Assert.assertEquals(estimatePage.getTotalEstimatedCost(), "Total Estimated Cost: USD 1,083.33 per 1 month",
                "Result is wrong");
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
