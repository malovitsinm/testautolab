package enums;

public enum IndexPageTextEnum {
    TEXT_0("To include good practices and ideas from successful EPAM projec"),
    TEXT_1("To be flexible and customizable"),
    TEXT_2("To be multiplatform"),
    TEXT_3("Already have good base (about 20 internal and some external projects), wish to get more…");

    public String text;

    IndexPageTextEnum(String text) {
        this.text = text;
    }

}
