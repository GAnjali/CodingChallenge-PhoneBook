package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Input {
    public List<String> loadDict(String dictPath) throws IOException {
        Path path = Paths.get(dictPath);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
