package cc.aabss.minehutapi.server;

import cc.aabss.minehutapi.MinehutAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The Servers Class
 */
@SuppressWarnings("unused")
public class Servers {

    private static final String url = "https://api.minehut.com/";

    public Servers(MinehutAPI api) {
        this.api = api;
    }

    private final MinehutAPI api;

    /**
     * @return All the online minehut servers.
     */
    // WARNING! This is a high usage method and may cause large amounts of lag.
    public List<Server> getServers() {
        String response = api.request(url, "servers", "");
        JsonArray json = JsonParser.parseString(response).getAsJsonObject().getAsJsonArray("servers");
        List<Server> servers = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            JsonObject staticInfo = json.get(i).getAsJsonObject().getAsJsonObject("staticInfo");
            String serverId = staticInfo.get("_id").getAsString();
            servers.add(getServer(serverId));
        }
        return servers;
    }


    /**
     * @param IdOrName The IdOrName of the server.
     * @return The specified server from the id or name.
     */
    public Server getServer(String IdOrName){
        String response = api.request(url,"server/" + IdOrName + (IdOrName.length() <= 16 ? "?byName=true" : ""), "");
        return new Server(JsonParser.parseString(response).getAsJsonObject(), this);
    }

    /**
     * @return All the top minehut servers.
     */
    // WARNING! This is a high usage method and may cause large amounts of lag.
    @NotNull
    public List<Server> getTopServers() {
        String response = api.request(url,"network/top_servers", "");
        JsonObject json = JsonParser.parseString(response).getAsJsonObject();
        JsonArray serversArray = json.get("servers").getAsJsonArray();
        List<Server> servers = new ArrayList<>();
        for (int i = 0; i < serversArray.size(); i++) {
            JsonObject staticInfo = serversArray.get(i).getAsJsonObject().get("staticInfo").getAsJsonObject();
            String serverId = staticInfo.get("_id").getAsString();
            servers.add(getServer(serverId));
        }
        return servers;
    }

    /**
     * @param name The name of the server.
     * @return Returns true if the name of the server is available.
     */
    public boolean isAvailable(String name){
        String response = api.request(url, "server/"+name+"?byName=true", "");
        return Objects.equals(response, "{\"ok\":false,\"msg\":\"An unknown error occured\"}");
    }

}
