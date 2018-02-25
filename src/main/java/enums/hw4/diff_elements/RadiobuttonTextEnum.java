package enums.hw4.diff_elements;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RadiobuttonTextEnum {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String text;

    static public List<String> getTextList(){
        return Arrays.stream(RadiobuttonTextEnum.values()).map(s -> s.text).collect(Collectors.toList());
    }

    RadiobuttonTextEnum(String text) {
        this.text = text;
    }
}
