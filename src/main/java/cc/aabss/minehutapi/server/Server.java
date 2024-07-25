package cc.aabss.minehutapi.server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * The Server Class
 */
@SuppressWarnings("unused")
public class Server {

    /**
     * @param json The response body retrieved from the request.
     */
    public Server(JsonObject json){
        this.json = json.getAsJsonObject("server");
    }

    /**
     * The response body retrieved from the request.
     */
    private final JsonObject json;

    /**
     * @return The server's ID.
     */
    public String getID(){
        return json.get("_id").getAsString();
    }

    /**
     * @return All the categories.
     */
    @Nullable
    public List<String> getCategories(){
        JsonArray array = json.getAsJsonArray("categories");
        List<String> categories = new ArrayList<>();
        for (Object id : array.asList()){
            categories.add((String) id);
        }
        return categories;
    }

    /**
     * @return All the purchased icons.
     */
    @Nullable
    public List<Icon> getPurchasedIcons(){
        JsonArray array = json.getAsJsonArray("purchased_icons");
        List<Icon> icons = new ArrayList<>();
        for (Object id : array.asList()){
            icons.add(Icon.getIcon((String) id));
        }
        return icons;
    }

    /**
     * @return The amount of backup slots a server has.
     */
    public int getBackupSlots(){
        return json.get("backup_slots").getAsInt();
    }

    /**
     * @return If the server is suspended.
     */
    public boolean isSuspended(){
        return json.get("suspended").getAsBoolean();
    }

    /**
     * @return The server version type (ex: Paper)
     */
    public VersionType getServerVersionType(){
        String type = json.get("server_version_type").getAsString();
        try {
            return VersionType.valueOf(type.toUpperCase().replaceAll("_", ""));
        } catch (IllegalArgumentException ignored) {
            return VersionType.UNKNOWN;
        }
    }

    /**
     * @return If the server is a proxy (Velocity, Waterfall etc.).
     */
    public boolean isProxy(){
        return json.get("proxy").getAsBoolean();
    }

    /**
     * @return All the connected servers.
     */
    @Nullable
    public List<Server> getConnectedServers(){
        JsonArray array = json.getAsJsonArray("connectedServers");
        List<Server> servers = new ArrayList<>();
        for (Object id : array.asList()){
            servers.add(Servers.getServer((String) id));
        }
        return servers;
    }

    /**
     * @return The server's message of the day.
     */
    @Nullable
    public String getMOTD(){
        return json.get("motd").getAsString();
    }

    /**
     * @return If the server can be discovered.
     */
    public boolean getVisibility(){
        return json.get("visibility").getAsBoolean();
    }

    /**
     * @return The server's plan. (ex: pro, custom, etc.)
     */
    public ServerPlan getServerPlan(){
        String type = json.get("server_plan").getAsString();
        try {
            return ServerPlan.valueOf(type.toUpperCase().replaceAll("_", ""));
        } catch (IllegalArgumentException ignored) {
            return ServerPlan.UNKNOWN;
        }
    }

    /**
     * @return The server's active server plan
     */
    public String getActiveServerPlan() {
        return json.get("activeServerPlan").getAsString();
    }

    /**
     * @return The server's storage node.
     */
    public String getStorageNode(){
        return json.get("storage_node").getAsString();
    }

    /**
     * @return The server's default banner image.
     */
    public String getDefaultBannerImage(){
        return json.get("default_banner_image").getAsString();
    }

    /**
     * @return The server's default banner glint.
     */
    public String getDefaultBannerTint(){
        return json.get("default_banner_tint").getAsString();
    }

    /**
     * @return The Minecraft UUID of the owner.
     */
    public String getOwner(){
        return json.get("owner").getAsString();
    }

    /**
     * @return The server's name.
     */
    public String getName(){
        return json.get("name").getAsString();
    }

    /**
     * @return The date the server was created in unix timestamp.
     */
    public long getCreation(){
        return json.get("creation").getAsLong();
    }

    /**
     * @return The platform of the server.
     */
    public String getPlatform(){
        return json.get("platform").getAsString();
    }


    /**
     * @return The amount of credits that are used for the server each day.
     */
    public double getCreditsPerDay(){
        return json.get("credits_per_day").getAsDouble();
    }

    /**
     * @return The server's port.
     */
    public long getPort(){
        return json.get("port").getAsLong();
    }

    /**
     * @return The last time the server was online.
     */
    public long getLastOnline(){
        return json.get("last_online").getAsLong();
    }

    /**
     * @return If the server has expired.
     */
    public boolean isExpired(){
        return json.get("expired").getAsBoolean();
    }

    /**
     * @return The amount of times people have joined.
     */
    public int getJoins(){
        return json.get("joins").getAsInt();
    }


    /**
     * @return If the server is online.
     */
    public Boolean isOnline(){
        return json.get("online").getAsBoolean();
    }

    /**
     * @return The maximum amount of players allowed on the server.
     */
    public int getMaxPlayers(){
        return json.get("maxPlayers").getAsInt();
    }

    /**
     * @return The amount of players on the server.
     */
    public int getPlayerCount(){
        return json.get("playerCount").getAsInt();
    }

    public String toString(){
        return "Name: " + getName() + " ID: " + getID() + " VersionType: " + getServerVersionType() + " ServerPlan: " + getServerPlan();
    }

    /**
     * All of Minehut's server versions.
     */
    public enum VersionType {
        /**
         * SpongeForge Server Type
         */
        SPONGEFORGE,
        /**
         * PaperSpigot Server Type
         */
        PAPER,
        /**
         * FabricMC Server Type
         */
        FABRIC,
        /**
         * NachoSpigot Server Type
         */
        NACHOSPIGOT,
        /**
         * Velocity Server Type (Proxy)
         */
        VELOCITY,
        /**
         * Waterfall Server Type (Proxy)
         */
        WATERFALL,
        /**
         * Unknown Server Type
         */
        UNKNOWN;

        public String toString(){
            return "Version_Type: " + name();
        }

    }

    /**
     * All of Minehut's server plans.
     */
    public enum ServerPlan {
        /**
         * Starter (Free) Plan
         */
        STARTER,
        /**
         * Standard Plan
         */
        STANDARD,
        /**
         * Pro Plan
         */
        PRO,
        /**
         * Ultimate Plan
         */
        ULTIMATE,
        /**
         * External Plan
         */
        EXTERNAL,
        /**
         * Custom Plan
         */
        CUSTOM,
        /**
         * Unknown Server Plan
         */
        UNKNOWN;

        public String toString(){
            return "Server_Plan: " + name();
        }

    }

}
