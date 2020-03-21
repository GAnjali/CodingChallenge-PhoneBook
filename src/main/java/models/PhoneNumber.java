package models;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumber {
    private String value;

    public PhoneNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public List<Integer> getDigits() {
        return value.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }

    private void setBoundaryWithHyphen() {
        this.value = value.replaceAll("[.\\s]", "-");
    }

    private void removeAllPunctuationsOtherThanDotSpace() {
        this.value = value.replaceAll("[^0-9A-Za-z._\\-\\s]", "");
    }

    public String removeNoise() {
        removeAllPunctuationsOtherThanDotSpace();
        setBoundaryWithHyphen();
        return value;
    }
}
