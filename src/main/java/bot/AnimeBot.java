package bot;
import config.ParseConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class AnimeBot extends TelegramLongPollingBot {
    protected ParseConfig config;
    private static final Logger log = LogManager.getLogger(AnimeBot.class);
    public AnimeBot() throws IOException {
        this.config = new ParseConfig("config.ini");
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message msg = update.getMessage();
            log.debug(String.format("[Bot] Got message from %s%n", msg.getFrom().getFirstName()));
        }
    }

    @Override
    public String getBotUsername() {
      return this.config.BotUserName;
    }

    @Override
    public String getBotToken() {
        return this.config.BotToken;
    }
}

