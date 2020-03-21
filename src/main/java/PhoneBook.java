import IO.Input;
import IO.Output;
import exceptions.NoArgumentException;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.PhoneNumber;
import models.WordGenerator;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {
    static List<PhoneNumber> phoneNumbers;
    static Dictionary dictionary;

    public static void main(String[] args) throws IOException, NoArgumentException, NoSuchFileFoundException {
        initialize(args);
        generateWords(phoneNumbers);
    }

    private static void generateWords(List<PhoneNumber> phoneNumbers) {
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        Output output = new Output();
        for (PhoneNumber phoneNumber : phoneNumbers) {
            phoneNumber.removeNoise();
            output.display(phoneNumber.getValue(), wordGenerator.generate(phoneNumber.getValue()));
        }
    }

    static void initialize(String[] args) throws IOException, NoSuchFileFoundException, NoArgumentException {
        Input input = new Input();
        if (args.length == 0)
            throw new NoArgumentException();
        phoneNumbers = input.loadFile(args[0]).stream().map(PhoneNumber::new).collect(Collectors.toList());
        dictionary = new Dictionary(input.loadFile(args[1]));
    }
}
