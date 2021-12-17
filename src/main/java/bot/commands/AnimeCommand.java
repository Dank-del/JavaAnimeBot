package bot.commands;

import bot.AnimeBot;
import bot.anilist.AnilistResponse;
import bot.anilist.Converter;
import bot.anilist.SendAnilistRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Arrays;

public class AnimeCommand extends BotCommand {
    private static final Logger log = LogManager.getLogger(AnimeBot.class);
    public AnimeCommand() {
        super("anime", "With this command you can search anime");
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
    public void execute(AbsSender absSender, User user, Chat chat, @NotNull String[] strings) {
        String messageBuilder;
        if (strings.length == 0) {
            messageBuilder = "Provide anime name\nSample usage /anime name";
        } else {
            SendAnilistRequest res = new SendAnilistRequest();
            try {
                AnilistResponse j = res.SearchAnime(Arrays.toString(strings));
                messageBuilder = String.valueOf(Converter.toJsonString(j));
            } catch (IOException e) {
                messageBuilder = e.getMessage();
            }
        }
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
