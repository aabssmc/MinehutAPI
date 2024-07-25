package cc.aabss.minehutapi.players;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import static cc.aabss.minehutapi.MinehutAPI.request;

/**
 * The MinehutPlayer Class
 */
@SuppressWarnings("unused")
public class MinehutPlayer {

    /**
     * @param name The name of the player.
     * @param rank The rank of the player.
     * @param online The online state of the player.
     */
    public MinehutPlayer(String name, Rank rank, boolean online){
        this.name = name;
        this.rank = rank;
        this.online = online;
    }

    private final String name;
    private final Rank rank;
    private final boolean online;

    /**
     * @return The UUID of the player.
     */
    public String getUUID(){
        return Friends.getUUID(this.name);
    }

    /**
     * @return The name of the player.
     */
    public String getName(){
        return name;
    }

    /**
     * @return The rank of the player.
     */
    public Rank getRank(){
        return rank;
    }

    /**
     * @return All the friends of the player.
     */
    public List<MinehutPlayer> getFriends(){
        String response = request("https://api.minehut.com/", "network/player/" + getUUID() + "/friends");
        if (response != null) {
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
        return null;
    }

    /**
     * @return The online state of the player.
     */
    public boolean isOnline(){
        return online;
    }

    public String toString(){
        return getRank() + " " + getName();

    }

}
