package IO;

import exceptions.NoSuchFileFoundException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static helper.PhoneBookConstants.DATA_PATH;

public class Input {
    public List<String> loadFile(String filename) throws IOException, NoSuchFileFoundException {
        try {
            return Files.readAllLines(getPath(filename), StandardCharsets.UTF_8);
        } catch (NoSuchFileException exception) {
            throw new NoSuchFileFoundException();
        } catch (Exception exception) {
            throw new IOException();
        }
    }

    private Path getPath(String filename) {
        return Paths.get(DATA_PATH + "\\" + filename);
    }
}
