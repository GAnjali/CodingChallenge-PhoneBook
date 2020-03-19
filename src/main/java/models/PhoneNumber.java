package models;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumber {
    Integer phoneNumber;

    public PhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumStr() {
        return phoneNumber.toString();
    }

    public List<Integer> getDigits() {
        return String.valueOf(phoneNumber).chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }
}
