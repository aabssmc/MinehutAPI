
// phew!!!!

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
    private static final String url = "https://api.minehut.com/";
    public static final JSONObject simple = new JSONObject(request(url, "network/simple_stats"));
    public static final JSONObject homepage = new JSONObject(request(url, "network/homepage_stats"));

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
        System.out.println("An unknown error occurred! Minehut servers are down?");
        return null;
    }

    /**
     * @return Gets the online server count.
     */
    public static int getOnlineServerCount(){
        return simple.getInt("server_count");
    }

    /**
     * @return Gets the ram count.
     */
    public static int getRamCount(){
        return simple.getInt("ram_count");
    }

    /**
     * @return Gets the max amount of the ram.
     */
    public static int getRamMax(){
        return simple.getInt("ram_max");
    }

    /**
     * @return Gets the amount of all servers registered.
     */
    public static int getServerCount(){
        return homepage.getInt("server_count");
    }

    /**
     * @return Gets the amount of all users registered.
     */
    public static int getUserCount(){
        return homepage.getInt("user_count");
    }
}