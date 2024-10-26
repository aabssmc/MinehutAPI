package cc.aabss.minehutapi.players;

import cc.aabss.minehutapi.MinehutAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import static cc.aabss.minehutapi.MinehutAPI.request;

/**
 * The Players Class
 */
@SuppressWarnings("unused")
public class Players {

    private final String url = "https://api.minehut.com/";

    public Players(MinehutAPI api) {
        this.api = api;
    }

    private final MinehutAPI api;

    /**
     * @param NameOrUuid Either the uuid or the name of the user.
     * @return All the user's friends.
     */
    public List<MinehutPlayer> getFriends(String NameOrUuid) {
        String uuid = "";
        if (NameOrUuid.length() <= 16) {
            uuid = formatUUID(getUUID(NameOrUuid));
        } else {
            if (!NameOrUuid.contains("-")) {
                uuid = formatUUID(NameOrUuid);
            }
        }
        String url = "https://api.minehut.com/";
        String response = api.request(url, "network/player/" + uuid + "/friends", "");
        JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
        JsonArray friendsArray = jsonResponse.getAsJsonArray("friends");
        List<MinehutPlayer> friends = new ArrayList<>();
        for (int i = 0; i < friendsArray.size(); i++) {
            JsonObject friendObject = friendsArray.get(i).getAsJsonObject();
            String profileId = friendObject.get("_id").getAsString();
            String playerUuid = friendObject.get("uuid").getAsString();
            String name = friendObject.get("name").getAsString();
            boolean is = friendObject.get("online").getAsBoolean();
            Rank rank = Rank.valueOf(friendObject.get("rank").getAsString());
            MinehutPlayer friend = new MinehutPlayer(profileId, playerUuid, name, is, rank, this);
            friends.add(friend);
        }
        return friends;
    }

    /**
     * @return Gets the total amount of players across the whole network.
     */
    public int getOnlinePlayerCount(){
        String servers = api.request(url, "network/simple_stats", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("player_count").getAsInt();
    }

    /**
     * @return Gets the total amount of bedrock players across the whole network.
     */
    public int getBedrockTotal(){
        String servers = api.request(url, "network/players/distribution", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("bedrockTotal").getAsInt();
    }

    /**
     * @return Gets the total amount of java players across the whole network.
     */
    public int getJavaTotal(){
        String servers = api.request(url, "network/players/distribution", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("javaTotal").getAsInt();
    }

    /**
     * @return Gets the total amount of bedrock players in the lobby.
     */
    public int getBedrockLobby(){
        String servers = api.request(url, "network/players/distribution", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("bedrockLobby").getAsInt();
    }

    /**
     * @return Gets the total amount of bedrock players in servers.
     */
    public int getBedrockPlayerServer(){
        String servers = api.request(url, "network/players/distribution", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("bedrockPlayerServer").getAsInt();
    }

    /**
     * @return Gets the total amount of java players in the lobby.
     */
    public int getJavaLobby(){
        String servers = api.request(url, "network/players/distribution", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("javaLobby").getAsInt();
    }

    /**
     * @return Gets the total amount of java players in servers.
     */
    public int getJavaPlayerServer(){
        String servers = api.request(url, "network/players/distribution", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("javaPlayerServer").getAsInt();
    }

    static String formatUUID(String uuidString) {
        return String.format(
                "%s-%s-%s-%s-%s",
                uuidString.substring(0, 8),
                uuidString.substring(8, 12),
                uuidString.substring(12, 16),
                uuidString.substring(16, 20),
                uuidString.substring(20)
        );
    }

    static String getUUID(String name) {
        JsonObject json = JsonParser.parseString(request("https://api.mojang.com/users/", "profiles/minecraft/" + name)).getAsJsonObject();
        return json.get("id").getAsString();
    }

    static String getName(String uuid) {
        JsonObject json = JsonParser.parseString(request("https://sessionserver.mojang.com/session/", "minecraft/profile/" + uuid + "?unsigned=false")).getAsJsonObject();
        return json.get("name").getAsString();
    }
}
