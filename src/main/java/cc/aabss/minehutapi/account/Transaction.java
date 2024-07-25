package cc.aabss.minehutapi.account;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;

public class Transaction {

    /**
     * Transaction.
     * @param json The json object
     */
    public Transaction(JsonObject json) {
        this.json = json;
    }

    private final JsonObject json;

    /**
     * @return The user that made the purchase.
     */
    public String getUser(){
        return json.get("user").getAsString();
    }

    /**
     * @return The user's email
     */
    public String getEmail(){
        return json.get("user_email").getAsString();
    }

    /**
     * @return The description of the purchase
     */
    public String getDescription(){
        return json.get("desc").getAsString();
    }

    /**
     * @return The price of the purchase.
     */
    public int getPrice(){
        return json.get("price").getAsInt();
    }

    /**
     * @return The time that the purchase happened.
     */
    public long getTime(){
        return json.get("time").getAsLong();
    }

    /**
     * @return The server id the purchase was on.
     */
    @Nullable
    public String getServerID(){
        if (json.has("server_id")){
            return json.get("server_id").getAsString();
        }
        return null;
    }

    /**
     * @return The ip of the purchaser.
     */
    @Nullable
    public String getIp(){
        if (json.has("ip")){
            return json.get("ip").getAsString();
        }
        return null;
    }

    /**
     * @return The type of the purchase.
     */
    @Nullable
    public String getType(){
        if (json.has("type")){
            return json.get("type").getAsString();
        }
        return null;
    }

    /**
     * @return The purchase as a string.
     */
    public String toString(){
        return "Price: "+getPrice()+" Description: "+getDescription();
    }
}
