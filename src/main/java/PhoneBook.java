import IO.Input;
import exceptions.NoArgumentException;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.WordGeneratorUtil;

import java.io.IOException;
import java.util.List;

public class WordGenerator {
    static List<String> phoneNumbers;
    static Dictionary dictionary;

    public static void main(String[] args) throws IOException, NoArgumentException, NoSuchFileFoundException {
        initialize(args);
        WordGeneratorUtil wordGeneratorUtil = new WordGeneratorUtil(dictionary);
//        wordGeneratorUtil.generateWord(phoneNumbers);
    }

    static void initialize(String[] args) throws IOException, NoSuchFileFoundException, NoArgumentException {
        Input input = new Input();
        if (args.length != 0) {
            phoneNumbers = input.loadFile(args[0], "C:\\Users\\ganjali\\Documents\\Anjali\\Assignment-docstore\\PhoneBook\\src\\main\\java\\data");
            dictionary = new Dictionary(input.loadFile(args[1], "C:\\Users\\ganjali\\Documents\\Anjali\\Assignment-docstore\\PhoneBook\\src\\main\\java\\data"));
        } else
            throw new NoArgumentException();
    }
}
