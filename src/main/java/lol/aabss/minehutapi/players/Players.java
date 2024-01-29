package lol.aabss.minehutapi.players;

import org.json.JSONObject;

import static lol.aabss.minehutapi.MinehutAPI.request;
import static lol.aabss.minehutapi.MinehutAPI.simple;

public class Players {

    private static final String url = "https://api.minehut.com/";
    public static final JSONObject distribution = new JSONObject(request(url, "network/players/distribution"));

    /**
     * @return Gets the total amount of players across the whole network.
     */
    public static int getOnlinePlayerCount(){
        return simple.getInt("player_count");
    }

    /**
     * @return Gets the total amount of bedrock players across the whole network.
     */
    public static int getBedrockTotal(){
        return distribution.getInt("bedrockTotal");
    }

    /**
     * @return Gets the total amount of java players across the whole network.
     */
    public static int getJavaTotal(){
        return distribution.getInt("javaTotal");
    }

    /**
     * @return Gets the total amount of bedrock players in the lobby.
     */
    public static int getBedrockLobby(){
        return distribution.getInt("bedrockLobby");
    }

    /**
     * @return Gets the total amount of bedrock players in servers.
     */
    public static int getBedrockPlayerServer(){
        return distribution.getInt("bedrockPlayerServer");
    }

    /**
     * @return Gets the total amount of java players in the lobby.
     */
    public static int getJavaLobby(){
        return distribution.getInt("javaLobby");
    }

    /**
     * @return Gets the total amount of java players in servers.
     */
    public static int getJavaPlayerServer(){
        return distribution.getInt("javaPlayerServer");
    }
}
