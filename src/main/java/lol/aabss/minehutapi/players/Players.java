package lol.aabss.minehutapi.players;

import org.json.JSONObject;

import static lol.aabss.minehutapi.MinehutAPI.request;

public class Players {

    private static final String url = "https://api.minehut.com/";

    /**
     * @return Gets the total amount of players across the whole network.
     */
    public static int getOnlinePlayerCount(){
        String servers = request(url, "network/simple_stats");
        return new JSONObject(servers).getInt("player_count");
    }

    /**
     * @return Gets the total amount of bedrock players across the whole network.
     */
    public static int getBedrockTotal(){
        String servers = request(url, "network/players/distribution");
        return new JSONObject(servers).getInt("bedrockTotal");
    }

    /**
     * @return Gets the total amount of java players across the whole network.
     */
    public static int getJavaTotal(){
        String servers = request(url, "network/players/distribution");
        return new JSONObject(servers).getInt("javaTotal");
    }

    /**
     * @return Gets the total amount of bedrock players in the lobby.
     */
    public static int getBedrockLobby(){
        String servers = request(url, "network/players/distribution");
        return new JSONObject(servers).getInt("bedrockLobby");
    }

    /**
     * @return Gets the total amount of bedrock players in servers.
     */
    public static int getBedrockPlayerServer(){
        String servers = request(url, "network/players/distribution");
        return new JSONObject(servers).getInt("bedrockPlayerServer");
    }

    /**
     * @return Gets the total amount of java players in the lobby.
     */
    public static int getJavaLobby(){
        String servers = request(url, "network/players/distribution");
        return new JSONObject(servers).getInt("javaLobby");
    }

    /**
     * @return Gets the total amount of java players in servers.
     */
    public static int getJavaPlayerServer(){
        String servers = request(url, "network/players/distribution");
        return new JSONObject(servers).getInt("javaPlayerServer");
    }
}
