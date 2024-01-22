package lol.aabss.minehutapi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.IOException;

public class MinehutAPI {
    /**
     * The api url.
     */
    private static String url = "https://api.minehut.com/";

    /**
     * @param endpoint The api endpoint (ex: servers)
     * @return The response body as a string.
     */
    @Nullable
    public static String request(@NotNull String endpoint){
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder()
                .url(url + endpoint)
                .build();
        try (Response response = client.newCall(req).execute()){
            if (response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * @return Gets the total amount of players across the whole network.
     */
    public static int getTotalPlayers(){
        String servers = request("servers");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("total_players");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the total amount of online servers.
     */
    public static int getTotalServers(){
        String servers = request("servers");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("total_servers");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the total amount of online visible servers.
     */
    public static int getTotalVisibleServers(){
        String servers = request("servers");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("total_search_results");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }
}