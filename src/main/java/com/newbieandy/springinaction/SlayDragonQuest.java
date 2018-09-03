package com.newbieandy.springinaction;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embark on quest to slay the dragon!");
    }
}
