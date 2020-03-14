import IO.Input;
import models.Dictionary;
import models.PhoneNumber;
import models.WordGenerator;

import java.io.IOException;
import java.util.List;

import static helper.PhoneBookConstants.DICT_FILE_PATH;
import static helper.PhoneBookConstants.PHNUM_FILE_PATH;

public class WordGeneratorMain {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Dictionary dictionary = new Dictionary(input.loadFile(DICT_FILE_PATH));
        WordGenerator wordGenerator = new WordGenerator(dictionary);

        List<String> phoneNumbers = input.loadFile(PHNUM_FILE_PATH);
        for (String phoneNum : phoneNumbers){
            PhoneNumber phoneNumber = new PhoneNumber(Integer.parseInt(phoneNum));
            for(String word: wordGenerator.getDictionaryWords(phoneNumber)){
                System.out.println(word);
            }
        }
    }
}
