package com.newbieandy.springinaction.soundsystem;


public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    public void setCompactDisc(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
