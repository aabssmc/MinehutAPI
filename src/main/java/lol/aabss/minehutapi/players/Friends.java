package lol.aabss.minehutapi.players;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static lol.aabss.minehutapi.MinehutAPI.request;

public class Friends {

    private static String url = "https://api.minehut.com/";

    /**
     * @param NameOrUuid Either the uuid or the name of the user.
     * @return All the user's friends.
     */
    public static List<MinehutPlayer> getFriends(String NameOrUuid) {
        String uuid;
        if (NameOrUuid.length() <= 16) {
            uuid = formatUUID(request("https://mcapi.aabss.lol/uuid/", NameOrUuid));
        } else {
            uuid = formatUUID(NameOrUuid);
        }
        String response = request(url, "network/player/" + uuid + "/friends");
        if (response != null) {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray friendsArray = jsonResponse.getJSONArray("friends");
            List<MinehutPlayer> friends = new ArrayList<>();
            for (int i = 0; i < friendsArray.length(); i++) {
                JSONObject friendObject = friendsArray.getJSONObject(i);
                String id = friendObject.getString("uuid");
                String name = friendObject.getString("name");
                MinehutPlayer.Rank rank = MinehutPlayer.Rank.valueOf(friendObject.getString("rank"));
                boolean is = friendObject.getBoolean("online");
                MinehutPlayer friend = new MinehutPlayer(id, name, rank, is);
                friends.add(friend);
            }
            return friends;
        }
        return null;
    }

    private static String formatUUID(String uuidString) {
        return String.format(
                "%s-%s-%s-%s-%s",
                uuidString.substring(0, 8),
                uuidString.substring(8, 12),
                uuidString.substring(12, 16),
                uuidString.substring(16, 20),
                uuidString.substring(20)
        );
    }
}
