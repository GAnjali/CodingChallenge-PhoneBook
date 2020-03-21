import IO.Input;
import IO.Output;
import exceptions.NoArgumentException;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.PhoneNumber;
import models.WordGenerator;

import java.io.IOException;
import java.util.List;

public class PhoneBook {
    static List<String> phoneNumbers;
    static Dictionary dictionary;

    public static void main(String[] args) throws IOException, NoArgumentException, NoSuchFileFoundException {
        initialize(args);
        generateWords(phoneNumbers);
    }

    private static void generateWords(List<String> phoneNumbers) {
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        Output output = new Output();
        for (String phoneNumber : phoneNumbers) {
            PhoneNumber phNum = new PhoneNumber(phoneNumber);
            phNum.removeNoise();
            output.display(phoneNumber, wordGenerator.generateWords(phNum.getPhoneNumber()));
        }
    }

    static void initialize(String[] args) throws IOException, NoSuchFileFoundException, NoArgumentException {
        Input input = new Input();
        if (args.length == 0) {
            throw new NoArgumentException();
        } else {
            phoneNumbers = input.loadFile(args[0]);
            dictionary = new Dictionary(input.loadFile(args[1]));
        }
    }
}
