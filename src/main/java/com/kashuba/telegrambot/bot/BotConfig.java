package com.kashuba.telegrambot.bot;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotConfig {

  String botUserName = "cityspringbot"; //This cannot be hardcoded, i know

  String token = "2036732554:AAGuLCaPfrbD75SP75eOKnh-ocBIaxlki44"; //This cannot be hardcoded, i know
}