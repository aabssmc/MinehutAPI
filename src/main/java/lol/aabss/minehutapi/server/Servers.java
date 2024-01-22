package lol.aabss.minehutapi.server;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static lol.aabss.minehutapi.MinehutAPI.request;

public class Servers {

    /**
     * @return All of the online minehut servers.
     */

    // WARNING! This is a high usage method and may cause large amounts of lag.
    @Nullable
    public static Server[] getServers() {
        String response = request("servers");
        if (response != null) {
            JSONObject json = new JSONObject(response);
            JSONArray serversArray = json.getJSONArray("servers");
            List<Server> servers = new ArrayList<>();
            for (int i = 0; i < serversArray.length(); i++) {
                JSONObject staticInfo = serversArray.getJSONObject(i).getJSONObject("staticInfo");
                String serverId = staticInfo.getString("_id");
                servers.add(getServer(serverId));
            }
            return servers.toArray(Server[]::new);
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return null;
    }


    /**
     * @return The specified server from the ID.
     */
    @Nullable
    public static Server getServer(String ID){
        String response = request("server/" + ID);
        if (response != null) {
            return new Server(new JSONObject(response));
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return null;
    }
    /**
     * @return The specified server from the name.
     */

    @Nullable
    public static Server getServerByName(String name){
        String response = request("server/" + name + "?byName=true");
        if (response != null) {
            return new Server(new JSONObject(response));
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return null;
    }
}
