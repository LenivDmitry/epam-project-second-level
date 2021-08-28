package page.enums;

public enum PasteExpiration {

    NEVER("//li[text()='Never']"),
    BURN_AFTER_READ("//li[text()='Burn after read']"),
    MINUTES_10("//li[text()='10 Minutes']"),
    HOUR_1( "//li[text()='1 Hour']"),
    DAY_1("//li[text()='1 Day']"),
    WEEK_1("//li[text()='1 Week']"),
    WEEKS_2("//li[text()='2 Weeks']"),
    MONTH_1("//li[text()='1 Month']"),
    MONTHS_6("//li[text()='6 Months']"),
    YEAR_1("//li[text()='1 Year']");

    private String title;

    PasteExpiration(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
