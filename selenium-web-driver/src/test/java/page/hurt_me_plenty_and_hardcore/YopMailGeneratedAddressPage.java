package page.hurt_me_plenty_and_hardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class YopMailGeneratedAddressPage extends AbstractPage {
    @FindBy(xpath = "//button[@id='cprnd']")
    private WebElement buttonCopyEmail;
    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement buttonCheckEmail;
    @FindBy(css = "tr td:nth-child(2) > h3")
    private WebElement totalCost;

    protected YopMailGeneratedAddressPage(WebDriver driver) {
        super(driver);
    }

    public void copyRandomEmail() {
        clickingOnAppearedElement(buttonCopyEmail);
    }

    public YopMailCheckingMailPage openCheckingEmailPage() {
        clickingOnAppearedElement(buttonCheckEmail);
        return new YopMailCheckingMailPage(driver);
    }


}
