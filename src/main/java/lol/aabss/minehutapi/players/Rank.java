package lol.aabss.minehutapi.players;

import org.json.JSONArray;
import org.json.JSONObject;

import static lol.aabss.minehutapi.MinehutAPI.request;

public enum Rank {

    ADMIN(0),
    DEVELOPER(1),
    SR_MOD(2),
    MOD(3),
    SUPER_HELPER(4),
    HELPER(5),
    YOUTUBE(6),
    ARTIST(7),
    BUILDER(8),
    HEART(9),
    MAKER(10),
    PATRONTESTER(11),
    PATRON(12),
    LEGENDTESTER(13),
    LEGEND(14),
    TESTER(15),
    EVENTS(16),
    PRO(17),
    VIP_PLUS(18),
    VIP(19),
    DEFAULT(20);

    private JSONArray json;
    private Integer index;

    Rank(Integer index) {
        this.index = index;
        String req = request("https://api.minehut.com/", "network/ranks");
        if (req != null) {
            json = new JSONArray(req);
        }
        else{
            System.out.println("An unknown error occurred! Minehut servers are down?");
        }
    }

    public JSONObject test(){
        return json.getJSONObject(index);
    }

    public String getId(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getString("id");
    }

    public String getName(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getString("name");
    }

    public int getOrdinal(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getInt("ordinal");
    }

    public String getColor(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getString("color");
    }

    public String getChatColor(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getString("chatColor");
    }

    public String getPrefixColor(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getString("prefixColor");
    }

    public String getPrefix(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getString("prefix");
    }

    public String getPrefixLegacy(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getString("prefixLegacy");
    }

    public String getPrefixMini(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getString("prefixMini");
    }

    public boolean isStaff(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getBoolean("staff");
    }

    public int getChatDelaySeconds(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getInt("chatDelaySeconds");
    }

    public int getAdRateLimit(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getInt("adRateLimit");
    }

    public int getAdMonthlyLimit(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getInt("adMonthlyLimit");
    }

    public boolean isSubscription(){
        JSONObject rank = json.getJSONObject(index);
        return rank.getBoolean("subscription");
    }

}
