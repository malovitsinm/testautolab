package enums.hw4.diff_elements;

public enum LogEntriesEnum {
    TEXT_0("Colors:Yellow"),
    TEXT_1("metal:Selen"),
    TEXT_2("Wind:true"),
    TEXT_3("Water:true"),
    TEXT_4("Wind:false"),
    TEXT_5("Water:false");

    public String text;

    LogEntriesEnum(String text) {
        this.text = text;
    }

}
