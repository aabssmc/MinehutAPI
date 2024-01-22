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
    @Nullable
    public static Server[] getServers(){
        String response = request("servers");
        if (response != null) {
            JSONObject json = new JSONObject(response);
            JSONArray servers = json.getJSONArray("servers");
            List<Server> serverList = new ArrayList<>();
            for (Object obj : servers.toList()) {
                serverList.add(getServer(((JSONObject) obj).getString("servers.staticInfo._id")));
            }
            return serverList.toArray(Server[]::new);
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
