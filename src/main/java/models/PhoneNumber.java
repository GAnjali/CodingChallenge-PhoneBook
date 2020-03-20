package models;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumber {
    String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Integer> getDigits() {
        return phoneNumber.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }
}
