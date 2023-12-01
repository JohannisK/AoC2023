package nl.johannisk.days;

import nl.johannisk.support.ChallengeFile;

import java.util.Map;
import java.util.function.BiFunction;

import static java.util.Map.Entry;
import static java.util.Map.entry;

public class Day1b {

    public static final Map<String, String> WRITTEN_NUMBERS_TO_INTS_MAP = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine","9");

    public static void main(String[] args) {
        Integer result = new ChallengeFile("day1.txt")
                .readLines().stream()
                .map(e -> replaceWrittenNumberWithIntegerAtIndex(e, (needle, haystack) -> haystack.indexOf(needle)))
                .map(e -> replaceWrittenNumberWithIntegerAtIndex(e, (needle, haystack) -> haystack.lastIndexOf(needle)))
                .map(e -> e.replaceAll("\\D+", ""))
                .map(e -> e.charAt(0) + e.substring(e.length() - 1))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println(result);
    }

    public static String replaceWrittenNumberWithIntegerAtIndex(String line, BiFunction<String, String, Integer> indexer) {
        return WRITTEN_NUMBERS_TO_INTS_MAP.keySet().stream()
                .map(e -> entry(indexer.apply(e, line), e))
                .filter(e -> e.getKey() != -1)
                .min(Entry.comparingByKey())
                .map(e -> line.substring(0, e.getKey()) + WRITTEN_NUMBERS_TO_INTS_MAP.get(e.getValue()) + line.substring(e.getKey() + e.getValue().length()))
                .orElse(line);
    }
}