package nl.johannisk.day1;

import nl.johannisk.support.ChallengeFile;

public class Day1a {
    public static void main(String[] args) {
        Integer result = new ChallengeFile("day1/input.txt")
                .readLines().stream()
                .map(e -> e.replaceAll("\\D+", ""))
                .map(e -> e.charAt(0) + e.substring(e.length() - 1))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println(result);
    }
}