package com.github.aabssmc.minehutapi.players;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.github.aabssmc.minehutapi.MinehutAPI.request;
import static com.github.aabssmc.minehutapi.players.Friends.formatUUID;

@SuppressWarnings("unused")
public enum Rank {

    /**
     * The Admin Rank.
     */
    ADMIN(0),
    /**
     * The Developer Rank.
     */
    DEVELOPER(1),
    /**
     * The Sr Mod Rank.
     */
    SR_MOD(2),
    /**
     * The Mod Rank.
     */
    MOD(3),
    /**
     * The Super Helper Rank.
     */
    SUPER_HELPER(4),
    /**
     * The Helper Rank.
     */
    HELPER(5),
    /**
     * The YouTube Rank.
     */
    YOUTUBE(6),
    /**
     * The Artist Rank.
     */
    ARTIST(7),
    /**
     * The Builder Rank.
     */
    BUILDER(8),
    /**
     * The Heart Rank.
     */
    HEART(9),
    /**
     * The Maker Rank.
     */
    MAKER(10),
    /**
     * The Patron Tester Rank.
     */
    PATRONTESTER(11),
    /**
     * The Patron Rank.
     */
    PATRON(12),
    /**
     * The Legend Tester Rank.
     */
    LEGENDTESTER(13),
    /**
     * The Legend Rank.
     */
    LEGEND(14),
    /**
     * The Tester Rank.
     */
    TESTER(15),
    /**
     * The Events Rank.
     */
    EVENTS(16),
    /**
     * The Pro Rank.
     */
    PRO(17),
    /**
     * The Vip+ Rank.
     */
    VIP_PLUS(18),
    /**
     * The Vip Rank.
     */
    VIP(19),
    /**
     * The Default Rank.
     */
    DEFAULT(20);

    private final JSONObject rank;

    Rank(Integer index) {
        String req = request("https://api.minehut.com/", "network/ranks");
        rank = new JSONArray(req).getJSONObject(index);
    }

    /**
     * @param NameOrUUID The Name or UUID of the player.
     * @return Gets the rank of the player.
     */
    public static Rank getRank(String NameOrUUID){
        String uuid = "";
        if (NameOrUUID.length() <= 16) {
            uuid = formatUUID(request("https://mcapi.aabss.lol/uuid/", NameOrUUID));
        } else {
            if (!NameOrUUID.contains("-")) {
                uuid = formatUUID(NameOrUUID);
            }
        }
        JSONObject json = new JSONObject(request("https://api.minehut.com/cosmetics/profile/", uuid));
        return valueOf(json.getString("rank"));
    }

    /**
     * @return Returns the id of the rank.
     */
    public String getId(){
        return rank.getString("id");
    }

    /**
     * @return Returns the name of the rank.
     */
    public String getName(){
        return rank.getString("name");
    }

    /**
     * @return Returns the ordinal of the rank.
     */
    public int getOrdinal(){
        return rank.getInt("ordinal");
    }

    /**
     * @return Returns the color of the rank.
     */
    public String getColor(){
        return rank.getString("color");
    }

    /**
     * @return Returns the chat color of the rank.
     */
    public String getChatColor(){
        return rank.getString("chatColor");
    }

    /**
     * @return Returns the prefix color of the rank.
     */
    public String getPrefixColor(){
        return rank.getString("prefixColor");
    }

    /**
     * @return Returns the prefix of the rank.
     */
    public String getPrefix(){
        return rank.getString("prefix");
    }

    /**
     * @return Returns the legacy prefix of the rank.
     */
    public String getPrefixLegacy(){
        return rank.getString("prefixLegacy");
    }

    /**
     * @return Returns the mini message prefix of the rank.
     */
    public String getPrefixMini(){
        return rank.getString("prefixMini");
    }

    /**
     * @return Returns true if the rank is a staff rank.
     */
    public boolean isStaff(){
        return rank.getBoolean("staff");
    }

    /**
     * @return Returns the chat delay seconds of the rank.
     */
    public int getChatDelaySeconds(){
        return rank.getInt("chatDelaySeconds");
    }

    /**
     * @return Returns the rate limit between each ad of the rank.
     */
    public int getAdRateLimit(){
        return rank.getInt("adRateLimit");
    }

    /**
     * @return Returns the limit of each ad each month of the rank.
     */
    public int getAdMonthlyLimit(){
        return rank.getInt("adMonthlyLimit");
    }

    /**
     * @return Returns true if the rank can be subscribed to.
     */
    public boolean isSubscription(){
        return rank.getBoolean("subscription");
    }

    /**
     * @return Returns the rank as a string.
     */
    public String toString(){
        return getName();
    }

}
