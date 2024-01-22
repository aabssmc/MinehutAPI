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
    public static String request(@NotNull String url, @NotNull String endpoint){
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
     * @return Gets the online server count.
     */
    public static int getOnlineServerCount(){
        String servers = request(url, "network/simple_stats");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("server_count");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the ram count.
     */
    public static int getRamCount(){
        String servers = request(url,"network/simple_stats");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("ram_count");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the max amount of the ram.
     */
    public static int getRamMax(){
        String servers = request(url,"network/simple_stats");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("ram_max");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the amount of all servers registered.
     */
    public static int getServerCount(){
        String servers = request(url,"network/homepage_stats");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("server_count");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }

    /**
     * @return Gets the amount of all users registered.
     */
    public static int getUserCount(){
        String servers = request(url,"network/homepage_stats");
        if (servers != null) {
            JSONObject json = new JSONObject(servers);
            return json.getInt("user_count");
        }
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return 0;
    }
}