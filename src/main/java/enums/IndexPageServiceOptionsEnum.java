package enums;

public enum IndexPageServiceOptionsEnum {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TBL("Complex Table"),
    SIMPLE_TBL("Simple Table"),
    PAGE_TBL("Table With Pages"),
    DIF_ELEMS("Different Elements");

    public String text;

    IndexPageServiceOptionsEnum(String text) {
        this.text = text;
    }

}
