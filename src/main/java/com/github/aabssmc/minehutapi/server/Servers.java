package com.github.aabssmc.minehutapi.server;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.github.aabssmc.minehutapi.MinehutAPI.request;

/**
 * The Servers Class
 */
@SuppressWarnings("unused")
public class Servers {

    private static final String url = "https://api.minehut.com/";

    /**
     * @return All the online minehut servers.
     */
    // WARNING! This is a high usage method and may cause large amounts of lag.
    public static List<Server> getServers() {
        String response = request(url, "servers");
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


    /**
     * @param IdOrName The IdOrName of the server.
     * @return The specified server from the id or name.
     */
    public static Server getServer(String IdOrName){
        String response = request(url,"server/" + IdOrName + (IdOrName.length() <= 16 ? "?byName=true" : ""));
        return new Server(new JSONObject(response));
    }

    /**
     * @return All the top minehut servers.
     */
    // WARNING! This is a high usage method and may cause large amounts of lag.
    @NotNull
    public static List<Server> getTopServers() {
        String response = request(url,"network/top_servers");
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

    /**
     * @param name The name of the server.
     * @return Returns true if the name of the server is available.
     */
    public static boolean isAvailable(String name){
        String response = request(url, "server/"+name+"?byName=true");
        return Objects.equals(response, "{\"ok\":false,\"msg\":\"An unknown error occured\"}");
    }

}
