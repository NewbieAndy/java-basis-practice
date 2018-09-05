package com.newbieandy.springinaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KinghtConfig.class)
@ActiveProfiles("prd")
public class BraveKnightTest {

    @Autowired
    private Logger logger;

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

    @Test
    public void loggerTest() {
        logger.loggerName();
    }
}
