package cc.aabss.minehutapi.players;

import cc.aabss.minehutapi.network.Network;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static cc.aabss.minehutapi.MinehutAPI.request;
import static cc.aabss.minehutapi.players.Players.getUUID;

/**
 * The Rank Class
 */
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

    Rank(Integer index) {
        if (Network.rankList == null) {
            Network.rankList = JsonParser.parseString(request("https://api.minehut.com/", "network/ranks")).getAsJsonArray();
        }
        rank = Network.rankList.get(index).getAsJsonObject();
    }

    private final JsonObject rank;

    /**
     * @param NameOrUUID The Name or UUID of the player.
     * @return Gets the rank of the player.
     */
    public static Rank getRank(String NameOrUUID){
        String uuid = "";
        if (NameOrUUID.length() <= 16) {
            uuid = Players.formatUUID(getUUID(NameOrUUID));
        } else {
            if (!NameOrUUID.contains("-")) {
                uuid = Players.formatUUID(NameOrUUID);
            }
        }
        JsonObject json = JsonParser.parseString(request("https://api.minehut.com/cosmetics/profile/", uuid)).getAsJsonObject();
        return valueOf(json.get("rank").getAsString());
    }

    /**
     * @return Returns the id of the rank.
     */
    public String getId(){
        return rank.get("id").getAsString();
    }

    /**
     * @return Returns the name of the rank.
     */
    public String getName(){
        return rank.get("name").getAsString();
    }

    /**
     * @return Returns the ordinal of the rank.
     */
    public int getOrdinal(){
        return rank.get("ordinal").getAsInt();
    }

    /**
     * @return Returns the color of the rank.
     */
    public String getColor(){
        return rank.get("color").getAsString();
    }

    /**
     * @return Returns the chat color of the rank.
     */
    public String getChatColor(){
        return rank.get("chatColor").getAsString();
    }

    /**
     * @return Returns the prefix color of the rank.
     */
    public String getPrefixColor(){
        return rank.get("prefixColor").getAsString();
    }

    /**
     * @return Returns the prefix of the rank.
     */
    public String getPrefix(){
        return rank.get("prefix").getAsString();
    }

    /**
     * @return Returns the legacy prefix of the rank.
     */
    public String getPrefixLegacy(){
        return rank.get("prefixLegacy").getAsString();
    }

    /**
     * @return Returns the mini message prefix of the rank.
     */
    public String getPrefixMini(){
        return rank.get("prefixMini").getAsString();
    }

    /**
     * @return Returns true if the rank is a staff rank.
     */
    public boolean isStaff(){
        return rank.get("staff").getAsBoolean();
    }

    /**
     * @return Returns the chat delay seconds of the rank.
     */
    public int getChatDelaySeconds(){
        return rank.get("chatDelaySeconds").getAsInt();
    }

    /**
     * @return Returns the rate limit between each ad of the rank.
     */
    public int getAdRateLimit(){
        return rank.get("adRateLimit").getAsInt();
    }

    /**
     * @return Returns the limit of each ad each month of the rank.
     */
    public int getAdMonthlyLimit(){
        return rank.get("adMonthlyLimit").getAsInt();
    }

    /**
     * @return Returns true if the rank can be subscribed to.
     */
    public boolean isSubscription(){
        return rank.get("subscription").getAsBoolean();
    }

}
