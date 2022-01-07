import bot.AnimeBot;
import bot.commandhandler.CommandHandler;
import okhttp3.OkHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import pw.mihou.jaikan.Jaikan4;

import java.io.IOException;
import java.time.Duration;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Setting up Jaikan Client");
        Jaikan4.setConfiguration(builder -> builder
                .setOkHTTPClient(new OkHttpClient.Builder().connectTimeout(Duration.ofSeconds(5)).build())
                .setUserAgent("Sayan Biswas's Java Telegram bot")
                .setRatelimit(Duration.ofSeconds(2))
                .setRequestCache(caffeine -> caffeine.expireAfterWrite(Duration.ofHours(6)))
                .build());
        logger.info("Starting bot");
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new AnimeBot());
            botsApi.registerBot(new CommandHandler());
        } catch (TelegramApiException | IOException e) {
            logger.trace(e);
        }
    }
}
