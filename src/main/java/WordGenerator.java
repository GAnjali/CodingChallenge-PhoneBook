import IO.Input;
import IO.Output;
import exceptions.NoArgumentException;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.PhoneNumber;
import models.WordGenerator;

import java.io.IOException;
import java.util.List;

public class WordGeneratorMain {
    static List<String> phoneNumbers;
    static Dictionary dictionary;

    public static void main(String[] args) throws IOException, NoArgumentException, NoSuchFileFoundException {
        initialize(args);
        WordGenerator.processPhoneNumbers(phoneNumbers, dictionary);
    }

    static void initialize(String[] args) throws IOException, NoSuchFileFoundException, NoArgumentException {
        Input input = new Input();
        if (args.length != 0) {
            phoneNumbers = input.loadFile(args[0]);
            dictionary = new Dictionary(input.loadFile(args[1]));
        } else
            throw new NoArgumentException();
    }
}
