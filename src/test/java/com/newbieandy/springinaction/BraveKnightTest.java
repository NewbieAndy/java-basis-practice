package com.newbieandy.springinaction;

import org.junit.Test;
import org.mockito.Mockito;

public class BraveKnightTest {
    @Test
    public void test0() {
        System.out.println("Test");
    }

    @Test
    public void test1() {
        Quest mockQuest = Mockito.mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        Mockito.verify(mockQuest, Mockito.times(1)).embark();
    }
}
