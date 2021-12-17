package bot.anilist;

import com.fasterxml.jackson.annotation.*;

public class Location {
    private Long line;
    private Long column;

    @JsonProperty("line")
    public Long getLine() { return line; }
    @JsonProperty("line")
    public void setLine(Long value) { this.line = value; }

    @JsonProperty("column")
    public Long getColumn() { return column; }
    @JsonProperty("column")
    public void setColumn(Long value) { this.column = value; }
}
