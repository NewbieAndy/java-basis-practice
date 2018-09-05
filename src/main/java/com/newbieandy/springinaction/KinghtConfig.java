package com.newbieandy.springinaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class KinghtConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }


    @Bean
    public Minstrel minstrel() {
        return new Minstrel(System.out);
    }

    @Bean
    @Conditional(MagicExistCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
