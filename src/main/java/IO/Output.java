package IO;

import java.util.List;

import static constants.PhoneBookConstants.MATCHED_WORDS_MESSAGE;
import static constants.PhoneBookConstants.NO_MATCHED_WORDS_FOUND_MESSAGE;

public class Output {
    public void print(String word) {
        System.out.println(word);
    }

    public void display(String phoneNumber, List<String> words) {
        if (isEmpty(words)) {
            print(NO_MATCHED_WORDS_FOUND_MESSAGE + phoneNumber);
        } else {
            print(MATCHED_WORDS_MESSAGE + phoneNumber);
            for (String word : words) {
                print(word);
            }
        }
    }

    private boolean isEmpty(List<String> words) {
        return words.size() == 0;
    }
}
