package com.github.aabssmc.minehutapi.server;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The Server Class
 */
@SuppressWarnings("unused")
public class Server {

    /**
     * The response body retrieved from the request.
     */
    private final JSONObject json;

    /**
     * @param json The response body retrieved from the request.
     */
    public Server(JSONObject json){
        this.json = json.getJSONObject("server");
    }

    /**
     * @return The server's ID.
     */
    public String getID(){
        return json.getString("_id");
    }

    /**
     * @return All the categories.
     */
    @Nullable
    public List<String> getCategories(){
        JSONArray array = json.getJSONArray("categories");
        List<String> categories = new ArrayList<>();
        for (Object id : array.toList()){
            categories.add((String) id);
        }
        return categories;
    }

    /**
     * @return All the purchased icons.
     */
    @Nullable
    public List<Icon> getPurchasedIcons(){
        JSONArray array = json.getJSONArray("purchased_icons");
        List<Icon> icons = new ArrayList<>();
        for (Object id : array.toList()){
            icons.add(Icon.getIcon((String) id));
        }
        return icons;
    }

    /**
     * @return The amount of backup slots a server has.
     */
    public int getBackupSlots(){
        return json.getInt("backup_slots");
    }

    /**
     * @return If the server is suspended.
     */
    public boolean isSuspended(){
        return json.getBoolean("suspended");
    }

    /**
     * @return The server version type (ex: Paper)
     */
    public VersionType getServerVersionType(){
        String type = json.getString("server_version_type");
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
        return json.getBoolean("proxy");
    }

    /**
     * @return All the connected servers.
     */
    @Nullable
    public List<Server> getConnectedServers(){
        JSONArray array = json.getJSONArray("connectedServers");
        List<Server> servers = new ArrayList<>();
        for (Object id : array.toList()){
            servers.add(Servers.getServer((String) id));
        }
        return servers;
    }

    /**
     * @return The server's message of the day.
     */
    @Nullable
    public String getMOTD(){
        return json.getString("motd");
    }

    /**
     * @return If the server can be discovered.
     */
    public boolean getVisibility(){
        return json.getBoolean("visibility");
    }

    /**
     * @return The server's plan. (ex: pro, custom, etc.)
     */
    public ServerPlan getServerPlan(){
        String type = json.getString("server_plan");
        String modtype = type.toLowerCase().replaceAll("_", "").replaceAll("_"+json.getString("_id"), "");
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
     * @return The server's active server plan
     */
    public String getActiveServerPlan() {
        return json.getString("activeServerPlan");
    }

    /**
     * @return The server's storage node.
     */
    public String getStorageNode(){
        return json.getString("storage_node");
    }

    /**
     * @return The server's default banner image.
     */
    public String getDefaultBannerImage(){
        return json.getString("default_banner_image");
    }

    /**
     * @return The server's default banner glint.
     */
    public String getDefaultBannerTint(){
        return json.getString("default_banner_tint");
    }

    /**
     * @return The Minecraft UUID of the owner.
     */
    public String getOwner(){
        return json.getString("owner");
    }

    /**
     * @return The server's name.
     */
    public String getName(){
        return json.getString("name");
    }

    /**
     * @return The date the server was created in unix timestamp.
     */
    public long getCreation(){
        return json.getLong("creation");
    }

    /**
     * @return The date the server was created in unix timestamp.
     */
    public String getPlatform(){
        return json.getString("platform");
    }


    /**
     * @return The amount of credits that are used for the server each day.
     */
    public double getCreditsPerDay(){
        return json.getDouble("credits_per_day");
    }

    /**
     * @return The server's port.
     */
    public long getPort(){
        return json.getLong("port");
    }

    /**
     * @return The last time the server was online.
     */
    public long getLastOnline(){
        return json.getLong("last_online");
    }

    /**
     * @return If the server has expired.
     */
    public boolean isExpired(){
        return json.getBoolean("expired");
    }

    /**
     * @return The amount of times people have joined.
     */
    public int getJoins(){
        return json.getInt("joins");
    }


    /**
     * @return If the server is online.
     */
    public Boolean isOnline(){
        return json.getBoolean("online");
    }

    /**
     * @return The maximum amount of players allowed on the server.
     */
    public int getMaxPlayers(){
        return json.getInt("maxPlayers");
    }

    /**
     * @return The amount of players on the server.
     */
    public int getPlayerCount(){
        return json.getInt("playerCount");
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
        WATERFALL;

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
        CUSTOM;

        public String toString(){
            return "Server_Plan: " + name();
        }

    }

}
