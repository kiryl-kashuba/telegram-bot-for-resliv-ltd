package com.kashuba.telegrambot.bot;

import com.kashuba.telegrambot.dao.CityRepository;
import com.kashuba.telegrambot.entity.City;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

  @Autowired
  private CityRepository cityRepository;

  final BotConfig config;

  public Bot(BotConfig config) {
    this.config = config;
  }

  @SneakyThrows
  @Override
  public void onUpdateReceived(Update update) {
    update.getUpdateId();
    SendMessage.SendMessageBuilder builder = SendMessage.builder();
    String messageText;
    String chatId;

    if (update.getMessage() != null) {
      chatId = update.getMessage().getChatId().toString();
      builder.chatId(chatId);
      messageText = update.getMessage().getText();
      City city = cityRepository.findByName(messageText);
      builder.text(city.getMessage());
      execute(builder.build());
    } else {
      chatId = update.getChannelPost().getChatId().toString();
      builder.chatId(chatId);
      messageText = update.getChannelPost().getText();
    }

//    if (messageText.contains("/hello")) {
//      builder.text("Привет");
//      try {
//        execute(builder.build());
//      } catch (TelegramApiException e) {
//      }
//    }
  }

  @Override
  public String getBotUsername() {
    return config.getBotUserName();
  }

  @Override
  public String getBotToken() {
    return config.getToken();
  }
}
