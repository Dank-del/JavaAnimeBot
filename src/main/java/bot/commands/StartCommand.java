package bot.commands;

import bot.AnimeBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand extends BotCommand {
    private static final Logger log = LogManager.getLogger(AnimeBot.class);
    public StartCommand() {
        super("start", "With this command you can start the Bot");
    }

    /**
     * Execute the command
     *
     * @param absSender absSender to send messages over
     * @param user      the user who sent the command
     * @param chat      the chat, to be able to send replies
     * @param strings passed arguments
     */
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        String userName = user.getFirstName() + " " + user.getLastName();
        String messageBuilder = "Welcome " + userName + "\n" +
                "You're gay!";
        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText(messageBuilder);

        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            log.trace(e);
        }
    }
}
