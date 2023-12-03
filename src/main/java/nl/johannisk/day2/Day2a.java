package nl.johannisk.day2;

import nl.johannisk.support.ChallengeFile;

public class Day2a {
    public static void main(String[] args) {
        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;
        Integer result = new ChallengeFile("day2/input.txt").readLines().stream()
                .map(Game::fromString)
                .filter(g -> g.reveals().stream().map(Reveal::red).allMatch(r -> r <= maxRed))
                .filter(g -> g.reveals().stream().map(Reveal::green).allMatch(r -> r <= maxGreen))
                .filter(g -> g.reveals().stream().map(Reveal::blue).allMatch(r -> r <= maxBlue))
                .map(g -> g.id())
                .reduce(0, Integer::sum);
        System.out.println(result);
    }
}