package cc.aabss.minehutapi.players;


import java.util.List;

/**
 * The MinehutPlayer Class
 */
@SuppressWarnings("unused")
public class MinehutPlayer {

    /**
     * @param profileId The minehut profile id of the player.
     * @param uuid The uuid of the player.
     * @param name The name of the player.
     * @param online The online state of the player.
     * @param rank The rank of the player.
     * @param api internal use.
     */
    MinehutPlayer(String profileId, String uuid, String name, boolean online, Rank rank, Players api){
        this.profileId = profileId;
        this.uuid = uuid;
        this.name = name;
        this.online = online;
        this.rank = rank;
        this.api = api;
    }

    private final String profileId;
    private final String name;
    private final String uuid;
    private final Rank rank;
    private final boolean online;
    private final Players api;

    public String getProfileId() {
        return profileId;
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

    /**
     * @return All the friends of the player.
     */
    public List<MinehutPlayer> getFriends(){
        return api.getFriends(uuid);
    }

    /**
     * @return The online state of the player.
     */
    public boolean isOnline(){
        return online;
    }

    /**
     * @return The minehut player as a string.
     */
    @Override
    public String toString() {
        return "MinehutPlayer{" +
                "profileId='" + profileId + '\'' +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", rank=" + rank +
                ", online=" + online +
                ", api=" + api +
                '}';
    }
}
