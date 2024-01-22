package lol.aabss.minehutapi.server;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static lol.aabss.minehutapi.MinehutAPI.request;

public class Servers {

    private static String url = "https://api.minehut.com/";

    /**
     * @return All the online minehut servers.
     */
    // WARNING! This is a high usage method and may cause large amounts of lag.
    @Nullable
    public static List<Server> getServers() {
        String response = request(url, "servers");
        if (response != null) {
            JSONObject json = new JSONObject(response);
            JSONArray serversArray = json.getJSONArray("servers");
            List<Server> servers = new ArrayList<>();
            for (int i = 0; i < serversArray.length(); i++) {
                JSONObject staticInfo = serversArray.getJSONObject(i).getJSONObject("staticInfo");
                String serverId = staticInfo.getString("_id");
                servers.add(getServer(serverId));
            }
            return servers;
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return null;
    }


    /**
     * @return The specified server from the id or name.
     */
    @Nullable
    public static Server getServer(String IdOrName){
        String response = request(url,"server/" + IdOrName + (IdOrName.length() <= 16 ? "?byName=true" : ""));
        if (response != null) {
            return new Server(new JSONObject(response));
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return null;
    }

    /**
     * @return All the top minehut servers.
     */
    // WARNING! This is a high usage method and may cause large amounts of lag.
    @Nullable
    public static List<Server> getTopServers() {
        String response = request(url,"network/top_servers");
        if (response != null) {
            JSONObject json = new JSONObject(response);
            JSONArray serversArray = json.getJSONArray("servers");
            List<Server> servers = new ArrayList<>();
            for (int i = 0; i < serversArray.length(); i++) {
                JSONObject staticInfo = serversArray.getJSONObject(i).getJSONObject("staticInfo");
                String serverId = staticInfo.getString("_id");
                servers.add(getServer(serverId));
            }
            return servers;
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return null;
    }

}
