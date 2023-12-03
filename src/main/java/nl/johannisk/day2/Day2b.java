package nl.johannisk.day2;

import nl.johannisk.support.ChallengeFile;

import java.util.List;

public class Day2b {
    public static void main(String[] args) {
        int result = new ChallengeFile("day2/input.txt").readLines().stream()
                .map(Game::fromString)
                .map(Game::reveals)
                .map(e -> List.of(
                        e.stream().mapToInt(Reveal::red).max().orElse(0),
                        e.stream().mapToInt(Reveal::green).max().orElse(0),
                        e.stream().mapToInt(Reveal::blue).max().orElse(0)))
                .map(e -> e.stream().mapToInt(a -> a).reduce(1, (a,b) -> a * b))
                .mapToInt(a -> a)
                .sum();

        System.out.println(result);
    }
}