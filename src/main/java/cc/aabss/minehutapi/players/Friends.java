package cc.aabss.minehutapi.players;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import static cc.aabss.minehutapi.MinehutAPI.request;

/**
 * The Friends Class
 */
@SuppressWarnings("unused")
public class Friends {

    /**
     * @param NameOrUuid Either the uuid or the name of the user.
     * @return All the user's friends.
     */
    public static List<MinehutPlayer> getFriends(String NameOrUuid) {
        String uuid = "";
        if (NameOrUuid.length() <= 16) {
            uuid = formatUUID(getUUID(NameOrUuid));
        } else {
            if (!NameOrUuid.contains("-")) {
                uuid = formatUUID(NameOrUuid);
            }
        }
        String url = "https://api.minehut.com/";
        String response = request(url, "network/player/" + uuid + "/friends");
        JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
        JsonArray friendsArray = jsonResponse.getAsJsonArray("friends");
        List<MinehutPlayer> friends = new ArrayList<>();
        for (int i = 0; i < friendsArray.size(); i++) {
            JsonObject friendObject = friendsArray.get(i).getAsJsonObject();
            String name = friendObject.get("name").getAsString();
            Rank rank = Rank.valueOf(friendObject.get("rank").getAsString());
            boolean is = friendObject.get("online").getAsBoolean();
            MinehutPlayer friend = new MinehutPlayer(name, rank, is);
            friends.add(friend);
        }
        return friends;
    }

    /**
     * @param uuidString The uuid to format.
     * @return a formatted uuid
     */
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
