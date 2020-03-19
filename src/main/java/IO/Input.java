package IO;

import exceptions.NoSuchFileFoundException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Input {
    public List<String> loadFile(String filename, String filepath) throws IOException, NoSuchFileFoundException {
        Path path = Paths.get(filepath + "\\" + filename);
        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (NoSuchFileException exception) {
            throw new NoSuchFileFoundException();
        } catch (Exception exception) {
            throw new IOException();
        }
    }
}
