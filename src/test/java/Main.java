import bot.anilist.SendAnilistRequest;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SendAnilistRequest res = new SendAnilistRequest();
        System.out.println(res.SearchAnime("steins; gate"));
    }
}
