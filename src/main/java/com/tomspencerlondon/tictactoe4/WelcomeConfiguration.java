package com.tomspencerlondon.tictactoe4;

import com.tomspencerlondon.tictactoe4.adapter.in.web.ReadableIdGenerator;
import com.tomspencerlondon.tictactoe4.hexagon.application.port.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WelcomeConfiguration {
  @Bean
  public IdGenerator idGenerator() {
    return new ReadableIdGenerator();
  }

}
