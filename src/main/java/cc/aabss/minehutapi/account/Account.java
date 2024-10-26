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

    /**
     * @param api The minehut api login instance.
     */
    public Account(MinehutAPI api) {
        this.api = api;
    }

    private final MinehutAPI api;

    /**
     * @return All the transactions that the account made.
     */
    public List<Transaction> getTransactions(){
        JsonArray array = JsonParser.parseString(MinehutAPI.request("https://api.minehut.com/", "user/"+api.userId+"/credit/transactions")).getAsJsonObject().getAsJsonArray("transactions");
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
        return new AccountInfo(JsonParser.parseString(MinehutAPI.request("https://api.minehut.com/", "v2/user/" + api.userId)).getAsJsonObject().getAsJsonObject("user"), api);
    }

    /**
     * Creates a new server.
     * @param name The name of the new server.
     * @param platform The platform of the new server.
     */
    public void createServer(String name, String platform){
        HttpClient httpClient = MinehutAPI.httpClient;
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/servers/create"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.profileId)
                .header("X-Session-Id", api.sessionId)
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
    @Override
    public String toString() {
        return "Account{" +
                "api=" + api +
                '}';
    }
}
