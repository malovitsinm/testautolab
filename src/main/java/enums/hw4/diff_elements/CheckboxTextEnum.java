package enums.hw4.diff_elements;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CheckboxTextEnum {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String text;

    static public List<String> getTextList(){
        return Arrays.stream(CheckboxTextEnum.values()).map(s -> s.text).collect(Collectors.toList());
    }

    CheckboxTextEnum(String text) {
        this.text = text;
    }

}
