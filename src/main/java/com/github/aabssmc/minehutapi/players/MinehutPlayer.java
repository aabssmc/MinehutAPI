package com.github.aabssmc.minehutapi.players;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.github.aabssmc.minehutapi.MinehutAPI.request;

public class MinehutPlayer {

    private final String uuid;
    private final String name;
    private final Rank rank;
    private final boolean online;

    /**
     * @param uuid The UUID of the player.
     * @param name The name of the player.
     * @param rank The rank of the player.
     * @param online The online state of the player.
     */
    public MinehutPlayer(String uuid, String name, Rank rank, boolean online){
        this.uuid = uuid;
        this.name = name;
        this.rank = rank;
        this.online = online;
    }

    /**
     * @return The UUID of the player.
     */
    public String getUUID(){
        return uuid;
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

    public List<MinehutPlayer> getFriends(){
        String response = request("https://api.minehut.com/", "network/player/" + uuid + "/friends");
        if (response != null) {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray friendsArray = jsonResponse.getJSONArray("friends");
            List<MinehutPlayer> friends = new ArrayList<>();
            for (int i = 0; i < friendsArray.length(); i++) {
                JSONObject friendObject = friendsArray.getJSONObject(i);
                String id = friendObject.getString("uuid");
                String name = friendObject.getString("name");
                Rank rank = Rank.valueOf(friendObject.getString("rank"));
                boolean is = friendObject.getBoolean("online");
                MinehutPlayer friend = new MinehutPlayer(id, name, rank, is);
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
