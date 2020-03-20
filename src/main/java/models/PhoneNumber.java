package models;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumber {
    String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Integer> getDigits() {
        return phoneNumber.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }

    private void replaceDotWithHyphen() {
        this.phoneNumber = phoneNumber.replaceAll("[.]", "-");
    }

    private void replaceSpaceWithHyphen() {
        this.phoneNumber = phoneNumber.replaceAll("\\s", "-");
    }

    private void removeAllPunctuationsOtherThanDotSpace() {
        this.phoneNumber = phoneNumber.replaceAll("[^0-9A-Za-z._\\-\\s]", "");
    }

    public String removeNoise() {
        removeAllPunctuationsOtherThanDotSpace();
        replaceDotWithHyphen();
        replaceSpaceWithHyphen();
        return this.phoneNumber;
    }
}
