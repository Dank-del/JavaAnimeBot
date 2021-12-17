package bot.anilist;

import com.fasterxml.jackson.annotation.*;

public class AiringSchedule {
    private Object[] nodes;

    @JsonProperty("nodes")
    public Object[] getNodes() { return nodes; }
    @JsonProperty("nodes")
    public void setNodes(Object[] value) { this.nodes = value; }
}