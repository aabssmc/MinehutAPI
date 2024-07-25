package cc.aabss.minehutapi.account;

import cc.aabss.minehutapi.MinehutAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountInfo {

    private final JsonObject json;
    private final MinehutAPI api;

    public AccountInfo(JsonObject json, MinehutAPI api) {
        this.json = json;
        this.api = api;
    }

    /**
     * @return The id of the account.
     */
    public String getId(){
        return json.get("_id").getAsString();
    }

    /**
     * @return The max servers of the account.
     */
    public String getMaxServers(){
        return json.get("max_servers").getAsString();
    }

    /**
     * @return The email of the account
     */
    public String getEmail(){
        return json.get("email").getAsString();
    }

    /**
     * @return True if the email has been verified.
     */
    public boolean isEmailVerified(){
        return json.get("email_verified").getAsBoolean();
    }

    /**
     * @return The email sent at (don't really know what this does).
     */
    public int getEmailSentAt(){
        return json.get("email_sent_at").getAsInt();
    }

    /**
     * @return The time the account got created.
     */
    public long getCreatedAt(){
        return json.get("created_at").getAsLong();
    }

    /**
     * @return The date that was set as the birthday for the account.
     */
    public String getBirthday(){
        return json.get("birthday").getAsString();
    }

    /**
     * @return The last time the password got changed.
     */
    public long getPasswordChangeTime(){
        return json.get("last_password_change").getAsLong();
    }

    /**
     * @return The super league profile id.
     */
    public String getSuperLeagueProfileId(){
        return json.get("slg_profile_id").getAsString();
    }

    /**
     * @return The last time the account got logged into.
     */
    public long getLoginTime(){
        return json.get("last_login").getAsLong();
    }

    /**
     * @return The time the TOS got accepted.
     */
    public String getTosAcceptedTime(){
        return json.get("last_accepted_tos_time").getAsString();
    }

    /**
     * @return The link code.
     */
    @Nullable
    public Integer getLinkCode(){
        if (json.has("minecraft_link_code")){
            return json.get("minecraft_link_code").getAsInt();
        }
        return null;
    }

    /**
     * @return The time the account got linked
     */
    public long getLinkTime(){
        return json.get("minecraft_last_link_time").getAsLong();
    }

    /**
     * @return The name of the minecraft account the server is linked to.
     */
    public String getMinecraftName(){
        return json.get("minecraft_name").getAsString();
    }

    /**
     * @return The uuid of the minecraft account the server is linked to.
     */
    public UUID getMinecraftUUID(){
        return UUID.fromString(json.get("minecraft_uuid").getAsString());
    }

    /**
     * @return The server limit for the account.
     */
    public int getServerLimit(){
        return json.get("server_limit").getAsInt();
    }

    /**
     * @return All the account's servers.
     */
    public List<UserServer> getServers(){
        List<UserServer> servers = new ArrayList<>();
        JsonArray array = json.getAsJsonArray("servers");
        for (int i = 0; i < array.size(); i++){
            servers.add(new UserServer(array.get(i).getAsString(), api));
        }
        return servers;
    }

    /**
     * @return The amount of credits the account has.
     */
    public int getCredits(){
        return json.get("credits").getAsInt();
    }

    /**
     * @return The account info as a string.
     */
    public String toString(){
        return "Email: "+getEmail()+" Id: "+getId();
    }

}
