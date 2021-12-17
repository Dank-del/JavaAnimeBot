package bot.anilist;

import com.fasterxml.jackson.annotation.*;

public class Data {
    private Media media;

    @JsonProperty("Media")
    public Media getMedia() { return media; }
    @JsonProperty("Media")
    public void setMedia(Media value) { this.media = value; }
}