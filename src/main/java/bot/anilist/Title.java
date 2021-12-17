package bot.anilist;

import com.fasterxml.jackson.annotation.*;

public class Title {
    private String romaji;
    private Object english;
    private String titleNative;

    @JsonProperty("romaji")
    public String getRomaji() { return romaji; }
    @JsonProperty("romaji")
    public void setRomaji(String value) { this.romaji = value; }

    @JsonProperty("english")
    public Object getEnglish() { return english; }
    @JsonProperty("english")
    public void setEnglish(Object value) { this.english = value; }

    @JsonProperty("native")
    public String getTitleNative() { return titleNative; }
    @JsonProperty("native")
    public void setTitleNative(String value) { this.titleNative = value; }
}
