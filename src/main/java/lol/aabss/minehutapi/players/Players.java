package lol.aabss.minehutapi.players;

import org.json.JSONObject;

import static lol.aabss.minehutapi.MinehutAPI.request;

public class Players {

    private static String url = "https://api.minehut.com/";

    /**
     * @return Gets the total amount of players across the whole network.
     */
    public static int getOnlinePlayerCount(){
        String servers = request(url,"network/simple_stats");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("player_count");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the total amount of bedrock players across the whole network.
     */
    public static int getBedrockTotal(){
        String servers = request(url,"network/players/distribution");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("bedrockTotal");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the total amount of java players across the whole network.
     */
    public static int getJavaTotal(){
        String servers = request(url,"network/players/distribution");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("javaTotal");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the total amount of bedrock players in the lobby.
     */
    public static int getBedrockLobby(){
        String servers = request(url,"network/players/distribution");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("bedrockLobby");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the total amount of bedrock players in servers.
     */
    public static int getBedrockPlayerServer(){
        String servers = request(url,"network/players/distribution");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("bedrockPlayerServer");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the total amount of java players in the lobby.
     */
    public static int getJavaLobby(){
        String servers = request(url,"network/players/distribution");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("javaLobby");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the total amount of java players in servers.
     */
    public static int getJavaPlayerServer(){
        String servers = request(url,"network/players/distribution");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("javaPlayerServer");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }
}
