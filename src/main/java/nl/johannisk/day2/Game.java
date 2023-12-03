package nl.johannisk.day2;

import java.util.Arrays;
import java.util.List;

public record Game (int id, List<Reveal> reveals){
    public static Game fromString(String line) {
        String[] parts = line.split(":");
        int id = Integer.parseInt(parts[0].split(" ")[1]);
        List<Reveal> reveals = Arrays.stream(parts[1].split(";"))
                .map(s -> Reveal.fromString(s))
                .toList();
        return new Game(id, reveals);
    }
}
