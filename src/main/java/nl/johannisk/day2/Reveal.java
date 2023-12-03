package nl.johannisk.day2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public record Reveal(int red, int green, int blue) {
    public static Reveal fromString(String s) {
        AtomicInteger red = new AtomicInteger();
        AtomicInteger green  = new AtomicInteger();
        AtomicInteger blue  = new AtomicInteger();
        Arrays.stream(s.split(","))
                .map(String::trim)
                .map(e -> e.split(" "))
                .forEach(p -> {
                    if(p[1].equals("red")) {
                        red.set(Integer.parseInt(p[0]));
                    } else if(p[1].equals("green")) {
                        green.set(Integer.parseInt(p[0]));
                    } else if(p[1].equals("blue")) {
                        blue.set(Integer.parseInt(p[0]));
                    }
                });
        return new Reveal(red.get(), green.get(), blue.get());
    }
}
