package lol.aabss.minehutapi.players;

public class MinehutPlayer {

    private String uuid;
    private String name;
    private Rank rank;
    private boolean online;

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

    /**
     * @return The online state of the player.
     */
    public boolean isOnline(){
        return online;
    }

    public String toString(){
        return getRank() + " " + getName();

    }

    public enum Rank{

        DEFAULT,
        VIP,
        VIP_PLUS,
        PRO,
        LEGEND,
        PATRON,
        SUPER_HELPER,
        ADMIN;

    }

}
