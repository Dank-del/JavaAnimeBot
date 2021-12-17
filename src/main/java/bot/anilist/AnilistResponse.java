
package bot.anilist;

import com.fasterxml.jackson.annotation.*;

public class AnilistResponse {
    private Error[] errors;
    private Data data;

    @JsonProperty("errors")
    public Error[] getErrors() { return errors; }
    @JsonProperty("errors")
    public void setErrors(Error[] value) { this.errors = value; }

    @JsonProperty("data")
    public Data getData() { return data; }
    @JsonProperty("data")
    public void setData(Data value) { this.data = value; }
}
