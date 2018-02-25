package enums.hw4.page;

public enum ServiceOptionsEnum {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TBL("Complex Table"),
    SIMPLE_TBL("Simple Table"),
    PAGE_TBL("Table With Pages"),
    DIF_ELEMS("Different Elements");

    public String text;

    ServiceOptionsEnum(String text) {
        this.text = text;
    }

}
