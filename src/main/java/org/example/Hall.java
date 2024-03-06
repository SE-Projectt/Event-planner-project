package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hall {
    String name;
    List<String> bookedDates;

    public Hall(String name) {
        this.name = name;
        this.bookedDates = new ArrayList<>();
    }
}
