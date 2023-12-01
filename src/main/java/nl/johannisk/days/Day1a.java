package nl.johannisk.days;

import nl.johannisk.support.ChallengeFile;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day1a {
    public static void main(String[] args) {
        Integer result = new ChallengeFile("day1.txt")
                .readLines().stream()
                .map(e -> e.replaceAll("\\D+", ""))
                .map(e -> e.substring(0, 1) + e.substring(e.length() - 1, e.length()))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println(result);
    }
}