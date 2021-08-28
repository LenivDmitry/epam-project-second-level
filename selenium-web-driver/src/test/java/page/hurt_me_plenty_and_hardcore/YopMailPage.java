package page.hurt_me_plenty_and_hardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class YopMailPage extends AbstractPage {
    @FindBy(xpath = "//a[@title='Случайный одноразовый адрес электронной почты']")
    private WebElement emailGenerator;

    private YopMailGeneratedAddressPage yopMailGeneratedAddressPage;

    public YopMailGeneratedAddressPage getYopMailGeneratedAddressPage() {
        return yopMailGeneratedAddressPage;
    }

    protected YopMailPage(WebDriver driver) {
        super(driver);
    }

    public YopMailPage openPage() {
        driver.get("https://yopmail.com/");
        waitingVisibilityOfElement(emailGenerator);
        return this;
    }

    public YopMailGeneratedAddressPage selectEmailGenerator() {
        clickingOnAppearedElement(emailGenerator);
        return new YopMailGeneratedAddressPage(driver);
    }


}
