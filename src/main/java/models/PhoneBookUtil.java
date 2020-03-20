package models;

public class PhoneBookUtil {
    public String replaceDotWithHyphen(String phoneNumber) {
        return phoneNumber.replaceAll("[.]", "-");
    }

    public String replaceSpaceWithHyphen(String phoneNumber) {
        return phoneNumber.replaceAll("\\s", "-");
    }

    public String removeAllPunctuationsOtherThanDotSpace(String phoneNumber){
        return phoneNumber.replaceAll("[^0-9A-Za-z._\\s]","");
    }
}
