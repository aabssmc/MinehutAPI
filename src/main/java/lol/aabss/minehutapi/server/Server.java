package lol.aabss.minehutapi.server;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Server {

    /**
     * The response body retrieved from the request.
     */
    private final JSONObject json;

    /**
     * @param json The response body retrieved from the request.
     */
    public Server(JSONObject json){
        this.json = json;
    }

    /**
     * @return The server's ID.
     */
    public String getID(){
        return json.getJSONObject("server").getString("_id");
    }

    /**
     * @return All the categories.
     */
    @Nullable
    public String[] getCategories(){
        JSONArray array = json.getJSONObject("server").getJSONArray("categories");
        List<String> categories = new ArrayList<>();
        for (Object id : array.toList()){
            categories.add((String) id);
        }
        return categories.toArray(String[]::new);
    }

    /**
     * @return All the purchased icons.
     */
    @Nullable
    public String[] getPurchasedIcons(){
        JSONArray array = json.getJSONObject("server").getJSONArray("purchased_icons");
        List<String> icons = new ArrayList<>();
        for (Object id : array.toList()){
            icons.add((String) id);
        }
        return icons.toArray(String[]::new);
    }

    /**
     * @return The amount of backup slots a server has.
     */
    public int getBackupSlots(){
        return json.getJSONObject("server").getInt("backup_slots");
    }

    /**
     * @return If the server is suspended.
     */
    public boolean isSuspended(){
        return json.getJSONObject("server").getBoolean("suspended");
    }

    /**
     * @return The server version type (ex: Paper)
     */
    public VersionType getServerVersionType(){
        String type = json.getJSONObject("server").getString("server_version_type");
        return switch (type.toLowerCase().replaceAll("_", "")) {
            case "spongeforge" -> VersionType.SPONGEFORGE;
            case "paper" -> VersionType.PAPER;
            case "fabric" -> VersionType.FABRIC;
            case "nachospigot" -> VersionType.NACHOSPIGOT;
            case "velocity" -> VersionType.VELOCITY;
            case "waterfall" -> VersionType.WATERFALL;
            default -> null;
        };
    }

    /**
     * @return If the server is a proxy (Velocity, Waterfall etc.).
     */
    public boolean isProxy(){
        return json.getJSONObject("server").getBoolean("proxy");
    }

    /**
     * @return All the connected servers.
     */
    @Nullable
    public Server[] getConnectedServers(){
        JSONArray array = json.getJSONObject("server").getJSONArray("connectedServers");
        List<Server> servers = new ArrayList<>();
        for (Object id : array.toList()){
            servers.add(Servers.getServer((String) id));
        }
        return servers.toArray(Server[]::new);
    }

    /**
     * @return The server's message of the day.
     */
    @Nullable
    public String getMOTD(){
        return json.getJSONObject("server").getString("motd");
    }

    /**
     * @return If the server can be discovered.
     */
    public boolean getVisibility(){
        return json.getJSONObject("server").getBoolean("visibility");
    }

    /**
     * @return The server's plan. (ex: pro, custom, etc.)
     */
    public ServerPlan getServerPlan(){
        String type = json.getJSONObject("server").getString("server_plan");
        String modtype = type.toLowerCase().replaceAll("_", "").replaceAll("_"+json.getJSONObject("server").getString("_id"), "");
        return switch (modtype) {
            case "free" -> ServerPlan.STARTER;
            case "standard" -> ServerPlan.STANDARD;
            case "pro" -> ServerPlan.PRO;
            case "ultimate" -> ServerPlan.ULTIMATE;
            case "external" -> ServerPlan.EXTERNAL;
            case "custom" -> ServerPlan.CUSTOM;
            default -> null;
        };
    }

    /**
     * @return The server's storage node.
     */
    public String getStorageNode(){
        return json.getJSONObject("server").getString("storage_node");
    }

    /**
     * @return The Minecraft UUID of the owner.
     */
    public String getOwner(){
        return json.getJSONObject("server").getString("owner");
    }

    /**
     * @return The server's name.
     */
    public String getName(){
        return json.getJSONObject("server").getString("name");
    }

    /**
     * @return The date the server was created in unix timestamp.
     */
    public long getCreation(){
        return json.getJSONObject("server").getLong("creation");
    }

    /**
     * @return The amount of credits that are used for the server each day.
     */
    public double getCreditsPerDay(){
        return json.getJSONObject("server").getDouble("credits_per_day");
    }

    /**
     * @return The server's port.
     */
    public long getPort(){
        return json.getJSONObject("server").getLong("port");
    }

    /**
     * @return The last time the server was online.
     */
    public long getLastOnline(){
        return json.getJSONObject("server").getLong("last_online");
    }

    /**
     * @return The server's currently used icon.
     */
    public String getActiveIcon(){
        return json.getJSONObject("server").getString("active_icon");
    }

    /**
     * @return The server's default banner image.
     */
    public String getDefaultBannerImage(){
        return json.getJSONObject("server").getString("default_banner_image");
    }

    /**
     * @return The server's default banner glint.
     */
    public String getDefaultBannerTint(){
        return json.getJSONObject("server").getString("default_banner_tint");
    }

    /**
     * @return If the server has expired.
     */
    public boolean isExpired(){
        return json.getJSONObject("server").getBoolean("expired");
    }

    /**
     * @return The amount of times people have joined.
     */
    public int getJoins(){
        return json.getJSONObject("server").getInt("joins");
    }

    /**
     * @return The server's current icon.
     */
    public String getIcon(){
        return json.getJSONObject("server").getString("icon");
    }

    /**
     * @return If the server is online.
     */
    public Boolean isOnline(){
        return json.getJSONObject("server").getBoolean("online");
    }

    /**
     * @return The maximum amount of players allowed on the server.
     */
    public int getMaxPlayers(){
        return json.getJSONObject("server").getInt("maxPlayers");
    }

    /**
     * @return The amount of players on the server.
     */
    public int getPlayerCount(){
        return json.getJSONObject("server").getInt("playerCount");
    }

    public String toString(){
        return "Name: " + getName() + " ID: " + getID() + " VersionType: " + getServerVersionType() + " ServerPlan: " + getServerPlan();
    }

    /**
     * All of Minehut's server versions.
     */
    public enum VersionType {
        SPONGEFORGE,
        PAPER,
        FABRIC,
        NACHOSPIGOT,
        VELOCITY,
        WATERFALL;

        public String toString(){
            return "Version_Type: " + name();
        }

    }

    /**
     * All of Minehut's server plans.
     */
    public enum ServerPlan {
        STARTER,
        STANDARD,
        PRO,
        ULTIMATE,
        EXTERNAL,
        CUSTOM;

        public String toString(){
            return "Server_Plan: " + name();
        }

    }

}
