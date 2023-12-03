package nl.johannisk.day3;

import nl.johannisk.support.ChallengeFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3a {
    public static void main(String[] args) {
        String string = new ChallengeFile("day3/input.txt").readAll();
        int width = string.indexOf("\n");
        Pattern numberFinder = Pattern.compile("([0-9]+)");
        Matcher numberMatcher = numberFinder.matcher(string);
        Pattern connectionFinder = Pattern.compile("([^0-9^.^\\n]+)");
        int result = 0;
        while(numberMatcher.find()) {
            String surrounding = "";
            if(numberMatcher.start() - (width + 2) > 0) {
                surrounding += string.substring(numberMatcher.start() - (width + 2), numberMatcher.end() - width).trim();
            }
            if(numberMatcher.start() - 1 > 0) {
                surrounding += string.substring(numberMatcher.start() - 1, numberMatcher.start()).trim();
            }
            if(numberMatcher.end() + 1 < string.length()) {
                surrounding += string.substring(numberMatcher.end(), numberMatcher.end() + 1).trim();
            }
            if(numberMatcher.end() + (width + 2) < string.length()) {
                surrounding += string.substring(numberMatcher.start() + width, numberMatcher.end() + width + 2).trim();
            }
            Matcher matcher = connectionFinder.matcher(surrounding);
            if(matcher.find()) {
                result += Integer.parseInt(string.substring(numberMatcher.start(), numberMatcher.end()));
            }
        }
        System.out.println(result);
    }

    public static void oldDebug(String string, Matcher matcher) {
        String topLine = "";
        String left = "";
        String right = "";
        String bottomLine = "";
        if(matcher.start() - 12 > 0) {
            topLine = string.substring(matcher.start() - 12, matcher.end() - 10).trim();
        }
        if(matcher.start() - 1 > 0) {
            left = string.substring(matcher.start() - 1, matcher.start()).trim();
        }
        if(matcher.end() + 1 < string.length()) {
            right = string.substring(matcher.end(), matcher.end() + 1).trim();
        }
        if(matcher.end() + 10 < string.length()) {
            bottomLine = string.substring(matcher.start() + 10, matcher.end() + 12).trim();
        }
        //System.out.println(matcher.start() + ", " + matcher.end());
        System.out.println(topLine);
        System.out.println(left + string.substring(matcher.start(), matcher.end()) + right);
        System.out.println(bottomLine);
        System.out.println();
    }
}

