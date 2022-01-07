package bot.commands;

import bot.AnimeBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import pw.mihou.jaikan.Jaikan;
import pw.mihou.jaikan.endpoints.Endpoints;
import pw.mihou.jaikan.models.Anime;
import pw.mihou.jaikan.models.AnimeResult;

import java.util.Arrays;
import java.util.Optional;

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
        String messageBuilder = null;
        if (strings.length == 0) {
            messageBuilder = "Provide anime name\nSample usage /anime name";
        } else {
            // AnilistResponse j = res.SearchAnime(Arrays.toString(strings));
            // messageBuilder = String.valueOf(Converter.toJsonString(j));
            Optional<AnimeResult> animeResult = Jaikan.search(Endpoints.SEARCH, AnimeResult.class, "anime", Arrays.toString(strings))
                    .stream().limit(5).findFirst();/*forEach(animeResult -> {
                        Anime anime = animeResult.asAnime();
                        System.out.println("Title: " + animeResult.getTitle());
                        System.out.println("\nSynopsis: " + anime.getSynopsis());
                        System.out.println("\n\n");
                    });*/
            if (animeResult.isPresent()) {
                Anime anime = animeResult.get().asAnime();
                messageBuilder = String.format("""
                        *%s*
                        *Type*: `%s`
                        *Average Score*: `%s`
                        *Status*: `%s`
                        *Genres*: `%s`
                        *Synopsis*: `%s`
                        [‎](%s)
                        """, anime.getTitle(), anime.getType(), anime.getRating(), anime.getStatus(), anime.getGenres(), anime.getSynopsis(), anime.getImage());
            }
        }
        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        assert messageBuilder != null;
        answer.setText(messageBuilder);
        answer.setParseMode("markdown");

        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            log.trace(e);
        }
    }
}
