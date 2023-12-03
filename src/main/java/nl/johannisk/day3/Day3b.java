package nl.johannisk.day3;

import nl.johannisk.support.ChallengeFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3b {
    public static void main(String[] args) {
        String string = new ChallengeFile("day3/input.txt").readAll();
        int width = string.indexOf("\n");
        Pattern numberFinder = Pattern.compile("([0-9]+)");
        Matcher numberMatcher = numberFinder.matcher(string);
        Map<Integer, List<Integer>> gears = new HashMap<>();
        while (numberMatcher.find()) {
            String topLine = "";
            String left = "";
            String right = "";
            String bottomLine = "";
            if(numberMatcher.start() - (width + 2) > 0) {
                topLine = string.substring(numberMatcher.start() - (width + 2), numberMatcher.end() - width);
            }
            if(numberMatcher.start() - 1 > 0) {
                left = string.substring(numberMatcher.start() - 1, numberMatcher.start());
            }
            if(numberMatcher.end() + 1 < string.length()) {
                right = string.substring(numberMatcher.end(), numberMatcher.end() + 1);
            }
            if(numberMatcher.end() + width + 2 < string.length()) {
                bottomLine = string.substring(numberMatcher.start() + width, numberMatcher.end() + (width + 2));
            }
            Pattern gearFinder = Pattern.compile("([*]+)");
            Matcher topMather = gearFinder.matcher(topLine);
            while(topMather.find()) {
                addToGear(gears, numberMatcher.start() - (width + 2) + topMather.start(), Integer.parseInt(string.substring(numberMatcher.start(), numberMatcher.end())));
            }
            Matcher bottomMatcher = gearFinder.matcher(bottomLine);
            while(bottomMatcher.find()) {
                addToGear(gears, numberMatcher.start() + width + bottomMatcher.start(), Integer.parseInt(string.substring(numberMatcher.start(), numberMatcher.end())));
            }
            if(left.length() > 0 && left.charAt(0) == '*') {
                addToGear(gears, numberMatcher.start() - 1, Integer.parseInt(string.substring(numberMatcher.start(), numberMatcher.end())));
            }
            if(right.length() > 0 && right.charAt(0) == '*') {
                addToGear(gears, numberMatcher.end(), Integer.parseInt(string.substring(numberMatcher.start(), numberMatcher.end())));
            }
        }
        System.out.println(gears.values().stream()
                .filter(e -> e.size() == 2)
                .mapToInt(e -> e.get(0) * e.get(1))
                .sum());
        System.out.println(gears);
    }

    private static void addToGear(Map<Integer, List<Integer>> gears, int loc, int value) {
        List<Integer> gearValues;
        if(gears.containsKey(loc)) {
            gearValues = gears.get(loc);
        } else {
            gearValues = new ArrayList<>();
        }
        gearValues.add(value);
        gears.put(loc, gearValues);
    }
}

