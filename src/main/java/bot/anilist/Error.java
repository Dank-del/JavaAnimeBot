package bot.anilist;

import com.fasterxml.jackson.annotation.*;

public class Error {
    private String message;
    private Long status;
    private Location[] locations;

    @JsonProperty("message")
    public String getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(String value) { this.message = value; }

    @JsonProperty("status")
    public Long getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Long value) { this.status = value; }

    @JsonProperty("locations")
    public Location[] getLocations() { return locations; }
    @JsonProperty("locations")
    public void setLocations(Location[] value) { this.locations = value; }
}