import IO.Input;
import IO.Output;
import exceptions.NoArgumentException;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.PhoneNumber;
import models.WordGenerator;

import java.io.IOException;
import java.util.List;

import static helper.PhoneBookConstants.DATA_PATH;

public class PhoneBook {
    static List<String> phoneNumbers;
    static Dictionary dictionary;
    static WordGenerator wordGenerator;
    static Output output;

    public static void main(String[] args) throws IOException, NoArgumentException, NoSuchFileFoundException {
        initialize(args);
        generateWords(phoneNumbers);
    }

    private static void generateWords(List<String> phoneNumbers) {
        wordGenerator = new WordGenerator(dictionary);
        output = new Output();
        for (String phoneNumber : phoneNumbers) {
            PhoneNumber phNum = new PhoneNumber(phoneNumber);
            phNum.removeNoise();
            output.displayWords(phoneNumber, wordGenerator.generateWords(phNum.getPhoneNumber()));
        }
    }

    static void initialize(String[] args) throws IOException, NoSuchFileFoundException, NoArgumentException {
        Input input = new Input();
        if (args.length != 0) {
            phoneNumbers = input.loadFile(args[0], DATA_PATH);
            dictionary = new Dictionary(input.loadFile(args[1], DATA_PATH));
        } else
            throw new NoArgumentException();
    }
}
