package cc.aabss.minehutapi.network;

import cc.aabss.minehutapi.MinehutAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Network {

    public Network(MinehutAPI api) {
        this.api = api;
    }

    private final MinehutAPI api;
    public static JsonArray rankList;
    private final String url = "https://api.minehut.com/";

    /**
     * @return Gets the online server count.
     */
    public int getOnlineServerCount(){
        String servers = api.request(url, "network/simple_stats", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("server_count").getAsInt();
    }

    /**
     * @return Gets the ram count.
     */
    public int getRamCount(){
        String servers = api.request(url, "network/simple_stats", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("ram_count").getAsInt();
    }

    /**
     * @return Gets the max amount of the ram.
     */
    public int getRamMax(){
        String servers = api.request(url, "network/simple_stats", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("ram_max").getAsInt();
    }

    /**
     * @return Gets the amount of all servers registered.
     */
    public int getServerCount(){
        String servers = api.request(url, "network/homepage_stats", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("server_count").getAsInt();
    }

    /**
     * @return Gets the amount of all users registered.
     */
    public int getUserCount(){
        String servers = api.request(url, "network/homepage_stats", "");
        return JsonParser.parseString(servers).getAsJsonObject().get("user_count").getAsInt();
    }
}
