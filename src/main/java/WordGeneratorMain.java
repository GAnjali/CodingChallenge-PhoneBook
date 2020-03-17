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
    public static void main(String[] args) throws IOException, NoArgumentException, NoSuchFileFoundException {
        Input input = new Input();
        Output output = new Output();
        List<String> phoneNumbers;
        Dictionary dictionary;
        if (args.length != 0) {
            phoneNumbers = input.loadFile(args[0]);
            dictionary = new Dictionary(input.loadFile(args[1]));
        } else
            throw new NoArgumentException();
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        for (String phoneNum : phoneNumbers) {
            PhoneNumber phoneNumber = new PhoneNumber(Integer.parseInt(phoneNum));
            for (String word : wordGenerator.getDictionaryWords(phoneNumber)) {
                output.print(word);
            }
        }
    }
}
