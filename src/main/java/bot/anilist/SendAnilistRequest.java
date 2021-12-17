package bot.anilist;

import java.io.IOException;
import java.util.Objects;

import okhttp3.*;

public class SendAnilistRequest {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static final String anilistUrl = "https://anilist.co/graphiql";
    final OkHttpClient client = new OkHttpClient();
    private static final String animeGraphQL = """
            query ($search: String, $id: Int) {
                Media (search: $search, id: $id) {
                  id
                  title {
                    romaji
                    english
                    native
                  }
                  type
                  format
                  status
                  description
                  episodes
                  bannerImage
                externalLinks{
                  url
                }
                  duration
                  chapters
                  volumes
                  genres
                  synonyms
                  averageScore
                  airingSchedule(notYetAired: true) {
                    nodes {
                      airingAt
                      timeUntilAiring
                      episode
                    }
                  }
                  siteUrl
                }
              }
                        
            """;
    String post(String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(SendAnilistRequest.anilistUrl)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    String buildJSON(String query) {
        return String.format("""
                {
                  "query": %s
                  "variables": {
                  "search": %s
                }
                """, animeGraphQL, query);
    }

    public AnilistResponse SearchAnime(String query) throws IOException {
        SendAnilistRequest req = new SendAnilistRequest();
        String json = req.buildJSON(query);
        String res = req.post(json);
        return Converter.fromJsonString(res);
    }

    /*public static void main(String[] args) throws IOException {
        PostExample example = new PostExample();
        String json = example.bowlingJson("Jesse", "Jake");
        String response = example.post("http://www.roundsapp.com/post", json);
        System.out.println(response);
    }*/
}