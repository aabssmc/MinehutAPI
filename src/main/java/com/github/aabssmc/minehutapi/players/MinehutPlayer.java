package com.github.aabssmc.minehutapi.players;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.github.aabssmc.minehutapi.MinehutAPI.request;

/**
 * The MinehutPlayer Class
 */
@SuppressWarnings("unused")
public class MinehutPlayer {

    private final String name;
    private final Rank rank;
    private final boolean online;

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
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray friendsArray = jsonResponse.getJSONArray("friends");
            List<MinehutPlayer> friends = new ArrayList<>();
            for (int i = 0; i < friendsArray.length(); i++) {
                JSONObject friendObject = friendsArray.getJSONObject(i);
                String name = friendObject.getString("name");
                Rank rank = Rank.valueOf(friendObject.getString("rank"));
                boolean is = friendObject.getBoolean("online");
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
