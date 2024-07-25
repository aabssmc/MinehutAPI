package cc.aabss.minehutapi.players;

import com.google.gson.JsonParser;

import static cc.aabss.minehutapi.MinehutAPI.request;

/**
 * The Players Class
 */
@SuppressWarnings("unused")
public class Players {

    private static final String url = "https://api.minehut.com/";

    /**
     * @return Gets the total amount of players across the whole network.
     */
    public static int getOnlinePlayerCount(){
        String servers = request(url, "network/simple_stats");
        return JsonParser.parseString(servers).getAsJsonObject().get("player_count").getAsInt();
    }

    /**
     * @return Gets the total amount of bedrock players across the whole network.
     */
    public static int getBedrockTotal(){
        String servers = request(url, "network/players/distribution");
        return JsonParser.parseString(servers).getAsJsonObject().get("bedrockTotal").getAsInt();
    }

    /**
     * @return Gets the total amount of java players across the whole network.
     */
    public static int getJavaTotal(){
        String servers = request(url, "network/players/distribution");
        return JsonParser.parseString(servers).getAsJsonObject().get("javaTotal").getAsInt();
    }

    /**
     * @return Gets the total amount of bedrock players in the lobby.
     */
    public static int getBedrockLobby(){
        String servers = request(url, "network/players/distribution");
        return JsonParser.parseString(servers).getAsJsonObject().get("bedrockLobby").getAsInt();
    }

    /**
     * @return Gets the total amount of bedrock players in servers.
     */
    public static int getBedrockPlayerServer(){
        String servers = request(url, "network/players/distribution");
        return JsonParser.parseString(servers).getAsJsonObject().get("bedrockPlayerServer").getAsInt();
    }

    /**
     * @return Gets the total amount of java players in the lobby.
     */
    public static int getJavaLobby(){
        String servers = request(url, "network/players/distribution");
        return JsonParser.parseString(servers).getAsJsonObject().get("javaLobby").getAsInt();
    }

    /**
     * @return Gets the total amount of java players in servers.
     */
    public static int getJavaPlayerServer(){
        String servers = request(url, "network/players/distribution");
        return JsonParser.parseString(servers).getAsJsonObject().get("javaPlayerServer").getAsInt();
    }
}
