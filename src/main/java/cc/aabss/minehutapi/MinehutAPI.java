package cc.aabss.minehutapi;

import cc.aabss.minehutapi.account.Account;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The Main Class
 */
public class MinehutAPI {

    public static final String url = "https://api.minehut.com/";
    private static MinehutAPI api;
    public String token;
    public String proid;
    public String sesid;
    public String userid;
    public Account account;

    /**
     * See {@link MinehutAPI#login MinehutAPI#login}
     */
    public MinehutAPI(String t, String uid, String pid, String sid) {
        api = this;
        token = t;
        userid = uid;
        proid = pid;
        sesid = sid;
        account = new Account(this);
    }

    /**
     * Creates a MinehutLogin builder.
     */
    public static MinehutLogin login() {
        return MinehutLogin.builder();
    }

    /**
     * @return Gets the online server count.
     */
    public static int getOnlineServerCount(){
        String servers = request(url, "network/simple_stats");
        return JsonParser.parseString(servers).getAsJsonObject().get("server_count").getAsInt();
    }

    /**
     * @return Gets the ram count.
     */
    public static int getRamCount(){
        String servers = request(url, "network/simple_stats");
        return JsonParser.parseString(servers).getAsJsonObject().get("ram_count").getAsInt();
    }

    /**
     * @return Gets the max amount of the ram.
     */
    public static int getRamMax(){
        String servers = request(url, "network/simple_stats");
        return JsonParser.parseString(servers).getAsJsonObject().get("ram_max").getAsInt();
    }

    /**
     * @return Gets the amount of all servers registered.
     */
    public static int getServerCount(){
        String servers = request(url, "network/homepage_stats");
        return JsonParser.parseString(servers).getAsJsonObject().get("server_count").getAsInt();
    }

    /**
     * @return Gets the amount of all users registered.
     */
    public static int getUserCount(){
        String servers = request(url, "network/homepage_stats");
        return JsonParser.parseString(servers).getAsJsonObject().get("user_count").getAsInt();
    }

    /**
     * @param url The main url.
     * @param endpoint The api endpoint (ex: servers).
     * @return The response body as a string.
     */
    public static String request(@NotNull String url, @NotNull String endpoint){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        if (api != null) {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(url + endpoint))
                    .header("Authorization", "Bearer " + api.token)
                    .header("X-Profile-Id", api.proid)
                    .header("X-Session-Id", api.sesid)
                    .header("User-Agent", "MinehutAPI-Java-Client")
                    .build();
        } else{
            request = HttpRequest.newBuilder()
                    .uri(URI.create(url + endpoint))
                    .build();
        }
        try {
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    /**
     * @param url The main url.
     * @param endpoint The api endpoint (ex: servers).
     * @param headers The headers.
     * @return The response body as a string.
     */
    public static String request(@NotNull String url, @NotNull String endpoint, @NotNull String... headers){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        if (api != null) {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(url + endpoint))
                    .header("Authorization", "Bearer " + api.token)
                    .header("X-Profile-Id", api.proid)
                    .header("X-Session-Id", api.sesid)
                    .header("User-Agent", "MinehutAPI-Java-Client")

                    .headers(headers)
                    .build();
        } else{
            request = HttpRequest.newBuilder()
                    .uri(URI.create(url + endpoint))
                    .headers(headers)
                    .build();
        }
        try {
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }
}