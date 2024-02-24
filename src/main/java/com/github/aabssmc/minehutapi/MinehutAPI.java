
// phew!!!!

package com.github.aabssmc.minehutapi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The Main Class
 */
@SuppressWarnings("unused")
public class MinehutAPI {
    /**
     * The api url.
     */
    private static final String url = "https://api.minehut.com/";

    /**
     * @param url The main url.
     * @param endpoint The api endpoint (ex: servers).
     * @return The response body as a string.
     */
    @Nullable
    public static String request(@NotNull String url, @NotNull String endpoint){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+endpoint))
                .build();
        try {
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return Gets the online server count.
     */
    public static int getOnlineServerCount(){
        String servers = request(url, "network/simple_stats");
        return new JSONObject(servers).getInt("server_count");
    }

    /**
     * @return Gets the ram count.
     */
    public static int getRamCount(){
        String servers = request(url, "network/simple_stats");
        return new JSONObject(servers).getInt("ram_count");
    }

    /**
     * @return Gets the max amount of the ram.
     */
    public static int getRamMax(){
        String servers = request(url, "network/simple_stats");
        return new JSONObject(servers).getInt("ram_max");
    }

    /**
     * @return Gets the amount of all servers registered.
     */
    public static int getServerCount(){
        String servers = request(url, "network/homepage_stats");
        return new JSONObject(servers).getInt("server_count");
    }

    /**
     * @return Gets the amount of all users registered.
     */
    public static int getUserCount(){
        String servers = request(url, "network/homepage_stats");
        return new JSONObject(servers).getInt("user_count");
    }

    /**
     * @return Gets the amount of all users registered.
     */
    public static int getRawMOTD(){
        String servers = request("https://api.mcsrvstat.us/", "2/minehut.com");
        return new JSONObject(servers).getInt("user_count");
    }
}