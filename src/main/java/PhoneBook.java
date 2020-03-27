import IO.Input;
import IO.Output;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.PhoneNumber;
import models.WordGenerator;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static constants.PhoneBookConstants.DICTIONARY_FILE;

public class PhoneBook {
    private static List<PhoneNumber> phoneNumbers;
    private static Dictionary dictionary;

    public static void main(String[] args) throws IOException, NoSuchFileFoundException {
        initialize(args);
        generateWords(phoneNumbers);
    }

    private static void generateWords(List<PhoneNumber> phoneNumbers) {
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        Output output = new Output();
        for (PhoneNumber phoneNumber : phoneNumbers) {
            phoneNumber.removeNoise();
            output.display(phoneNumber.getValue(), wordGenerator.generateDictionaryMatchingWords(phoneNumber));
        }
    }

    private static void initialize(String[] args) throws IOException, NoSuchFileFoundException {
        Input input = new Input();
        if (args.length == 0) {
            dictionary = new Dictionary(input.loadFile(DICTIONARY_FILE));
            phoneNumbers = input.loadPhoneNumbers();
        } else {
            phoneNumbers = input.loadFile(args[0]).stream().map(PhoneNumber::new).collect(Collectors.toList());
            dictionary = new Dictionary(input.loadFile(args[1]));
        }
    }
}
