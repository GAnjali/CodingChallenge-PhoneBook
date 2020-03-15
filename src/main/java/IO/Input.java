package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static helper.PhoneBookConstants.DATA_PATH;

public class Input {
    public List<String> loadFile(String filename) throws IOException {
        Path path = Paths.get(DATA_PATH + filename);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
