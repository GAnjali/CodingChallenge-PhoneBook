package IO;

import java.util.List;

public class Output {
    public void print(String word) {
        System.out.println(word);
    }

    public void display(String phoneNumber, List<String> words) {
        if (isEmpty(words)) {
            print("No matched words found for : " + phoneNumber);
        } else {
            print("Possible words for : " + phoneNumber);
            for (String word : words) {
                print(word);
            }
        }
    }

    private boolean isEmpty(List<String> words) {
        return words.size() == 0;
    }
}
