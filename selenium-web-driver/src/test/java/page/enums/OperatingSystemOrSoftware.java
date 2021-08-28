package page.enums;

public enum OperatingSystemOrSoftware {

    FREE("//md-option[@value='free']"),
    PAID_UBUNTU_PRO("//md-option[@value='ubuntu-pro']"),
    PAID_WIN("//md-option[@value='win']"),
    PAID_RHEL( "//md-option[@value='rhel']"),
    PAID_RHEL_SAP_HA("//md-option[@value='rhel-sap-ha']"),
    PAID_SLES("//md-option[@value='sles']"),
    PAID_SLES_SAP_12("//md-option[@value='sles-sap-12']"),
    PAID_SLES_SAP_15("//md-option[@value='sles-sap-15']"),
    PAID_SQL_STANDART("//md-option[@value='sql-standart']"),
    PAID_SQL_WEB("//md-option[@value='sql-web']"),
    PAID_SQL_ENTERPRISE("//md-option[@value='sql-enterprise']");

    private String title;

    OperatingSystemOrSoftware(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
