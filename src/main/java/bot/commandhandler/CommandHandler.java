package bot.commandhandler;
import bot.commands.AnimeCommand;
import bot.commands.StartCommand;
import config.ParseConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

/**
 * This handler mainly works with commands to demonstrate the Commands feature of the API
 *
 * @author Timo Schulz (Mit0x2)
 */
public class CommandHandler extends TelegramLongPollingCommandBot {

    /**
     * Constructor.
     */
    private ParseConfig config;
    private static final Logger logger = LogManager.getLogger(CommandHandler.class);
    public CommandHandler() {
        super(new DefaultBotOptions());
        // super(botUsername);

        register(new StartCommand());
        register(new AnimeCommand());

        try {
            config =  new ParseConfig("config.ini");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*

        registerDefaultAction((absSender, message) -> {
            SendMessage commandUnknownMessage = new SendMessage();
            commandUnknownMessage.setChatId(String.valueOf(message.getChatId()));
            commandUnknownMessage.setText("The command '" + message.getText() + "' is not known by this bot. Here comes some help ");
            try {
                absSender.execute(commandUnknownMessage);
            } catch (TelegramApiException e) {
                logger.trace(e);
            }
            // helpCommand.execute(absSender, message.getFrom(), message.getChat(), new String[] {});
        });

        */
    }

    /**
     * @return Bot username
     */
    @Override
    public String getBotUsername() {
        return config.BotUserName;
    }

    @Override
    public void processNonCommandUpdate(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                SendMessage echoMessage = new SendMessage();
                echoMessage.setChatId(String.valueOf(message.getChatId()));
                // echoMessage.setText("Hey here's your message:\n" + message.getText());

                try {
                    execute(echoMessage);
                } catch (TelegramApiException e) {
                    logger.trace(e);
                }
            }
        }
    }

    @Override
    public String getBotToken() {
        return config.BotToken;
    }
}
