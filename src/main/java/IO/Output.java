package IO;

import java.util.List;

public class Output {
    public void print(String word) {
        System.out.println(word);
    }

    public void displayWords(String phoneNumber, List<String> words) {
        if (words.size() == 0) {
            print("No matched words found for : " + phoneNumber);
        } else {
            print("Possible words for : " + phoneNumber);
            for (String word : words) {
                print(word);
            }
        }
    }
}
