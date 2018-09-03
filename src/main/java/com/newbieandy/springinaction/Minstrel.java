package com.newbieandy.springinaction;

import java.io.PrintStream;

public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    //探索之前
    public void singBeforeQuest() {
        stream.println("Fa la la , the knight is so brave!");
    }

    //探索之后
    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight did embark on quest");
    }
}
