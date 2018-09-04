package com.newbieandy.springinaction.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CDPlayerConfig {
    @Bean
    public MediaPlayer cdPlayer(CompactDisc cd) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCompactDisc(cd);
        return cdPlayer;
    }
}
