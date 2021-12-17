package config;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public final class ParseConfig {
    public String BotToken;
    public String BotUserName;
    public ParseConfig(String filename) throws IOException {
        Wini ini = new Wini(new File(filename));
        this.BotToken = ini.get("bot", "token");
        this.BotUserName = ini.get("bot", "username");
    }
}
