package runner.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component //spring создаст bin
public class TelegramBot extends TelegramLongPollingBot {

    /**
     * поместили переменные botName и botToken в appProperties для безопасности
     */
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;
    private static final Logger log = Logger.getLogger(TelegramBot.class);


    @Override
    public String getBotUsername() {
        return botName;//возвращает имя бота
    }

    @Override
    public String getBotToken() {
        return botToken;//возвращает токен
    }

    @Override
    public void onUpdateReceived(Update update) {
        var originalMessage = update.getMessage();
        log.debug(originalMessage.getText());
    }
}
