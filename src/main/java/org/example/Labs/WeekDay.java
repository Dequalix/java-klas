package org.example.Labs;

import java.util.stream.Stream;

public enum WeekDay {
    MAANDAG("Maandag"),
    DINSDAG("Peter"),
    WOENSDAG("Woensdag"),
    DONDERDAG("Donderdag"),
    VRIJDAG("Vrijdag");

    private static String name;

    WeekDay(String name) {
    }

    public static Stream<WeekDay> stream() {
        var name = WeekDay.getName();
        return Stream.of(WeekDay.values());
    }

    public static Stream<String> streamName() {
        return Stream.of(WeekDay.getName());
    }

    public static String getName() {
        return name;
    }


}