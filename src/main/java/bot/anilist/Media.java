package bot.anilist;

import com.fasterxml.jackson.annotation.*;

public class Media {
    private Long id;
    private Title title;
    private String type;
    private String format;
    private String status;
    private String description;
    private Object episodes;
    private Object bannerImage;
    private ExternalLink[] externalLinks;
    private Object duration;
    private Long chapters;
    private Long volumes;
    private String[] genres;
    private String[] synonyms;
    private Long averageScore;
    private AiringSchedule airingSchedule;
    private String siteURL;

    @JsonProperty("id")
    public Long getID() { return id; }
    @JsonProperty("id")
    public void setID(Long value) { this.id = value; }

    @JsonProperty("title")
    public Title getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(Title value) { this.title = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("format")
    public String getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(String value) { this.format = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("episodes")
    public Object getEpisodes() { return episodes; }
    @JsonProperty("episodes")
    public void setEpisodes(Object value) { this.episodes = value; }

    @JsonProperty("bannerImage")
    public Object getBannerImage() { return bannerImage; }
    @JsonProperty("bannerImage")
    public void setBannerImage(Object value) { this.bannerImage = value; }

    @JsonProperty("externalLinks")
    public ExternalLink[] getExternalLinks() { return externalLinks; }
    @JsonProperty("externalLinks")
    public void setExternalLinks(ExternalLink[] value) { this.externalLinks = value; }

    @JsonProperty("duration")
    public Object getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(Object value) { this.duration = value; }

    @JsonProperty("chapters")
    public Long getChapters() { return chapters; }
    @JsonProperty("chapters")
    public void setChapters(Long value) { this.chapters = value; }

    @JsonProperty("volumes")
    public Long getVolumes() { return volumes; }
    @JsonProperty("volumes")
    public void setVolumes(Long value) { this.volumes = value; }

    @JsonProperty("genres")
    public String[] getGenres() { return genres; }
    @JsonProperty("genres")
    public void setGenres(String[] value) { this.genres = value; }

    @JsonProperty("synonyms")
    public String[] getSynonyms() { return synonyms; }
    @JsonProperty("synonyms")
    public void setSynonyms(String[] value) { this.synonyms = value; }

    @JsonProperty("averageScore")
    public Long getAverageScore() { return averageScore; }
    @JsonProperty("averageScore")
    public void setAverageScore(Long value) { this.averageScore = value; }

    @JsonProperty("airingSchedule")
    public AiringSchedule getAiringSchedule() { return airingSchedule; }
    @JsonProperty("airingSchedule")
    public void setAiringSchedule(AiringSchedule value) { this.airingSchedule = value; }

    @JsonProperty("siteUrl")
    public String getSiteURL() { return siteURL; }
    @JsonProperty("siteUrl")
    public void setSiteURL(String value) { this.siteURL = value; }
}
