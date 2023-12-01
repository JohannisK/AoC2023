package nl.johannisk.support;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ChallengeFile {

    private final String filename;

    public ChallengeFile(String filename) {
        this.filename = filename;
    }

    public List<String> readLines() {
        try {
            return Files.readAllLines(Paths.get(Objects.requireNonNull(ChallengeFile.class.getClassLoader().getResource(filename)).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
