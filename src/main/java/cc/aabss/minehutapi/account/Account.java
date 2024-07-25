package cc.aabss.minehutapi.account;

import cc.aabss.minehutapi.MinehutAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * The Account Class
 */
public class Account {

    public Account(MinehutAPI api) {
        this.api = api;
    }

    private final MinehutAPI api;

    /**
     * @return The current token.
     */
    public String getToken(){
        return api.token;
    }

    /**
     * @return The profile id.
     */
    public String getProfileID(){
        return api.proid;
    }

    /**
     * @return The user id.
     */
    public String getUserID(){
        return api.userid;
    }

    /**
     * @return The current session id.
     */
    public String getSessionID(){
        return api.sesid;
    }

    /**
     * @return All the transactions that the account made.
     */
    public List<Transaction> getTransactions(){
        JsonArray array = JsonParser.parseString(MinehutAPI.request("https://api.minehut.com/", "user/"+api.userid+"/credit/transactions")).getAsJsonObject().getAsJsonArray("transactions");
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JsonObject obj = array.get(i).getAsJsonObject();
            transactions.add(new Transaction(obj));
        }
        return transactions;
    }

    /**
     * @return The information of the account.
     */
    public AccountInfo getInfo(){
        return new AccountInfo(JsonParser.parseString(MinehutAPI.request("https://api.minehut.com/", "v2/user/" + api.userid)).getAsJsonObject().getAsJsonObject("user"), api);
    }

    /**
     * Creates a new server.
     * @param name The name of the new server.
     * @param platform The platform of the new server.
     */
    public void createServer(String name, String platform){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/servers/create"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\":\""+name+"\",\"platform\":\""+platform.toLowerCase() +"\"}"))
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    /**
     * @return The account as a string.
     */
    public String toString(){
        return "User: "+getUserID()+" Profile: "+getProfileID();
    }

}
