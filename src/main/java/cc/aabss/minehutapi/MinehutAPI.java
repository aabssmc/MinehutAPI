package cc.aabss.minehutapi;

import cc.aabss.minehutapi.account.Account;
import cc.aabss.minehutapi.network.Network;
import cc.aabss.minehutapi.players.Players;
import cc.aabss.minehutapi.server.Servers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

/**
 * The Main Class
 */
public class MinehutAPI {
    
    public String token = "";
    public String profileId = "";
    public String sessionId = "";
    public String userId = "";
    public Account account;
    public static HttpClient httpClient = HttpClient.newHttpClient();

    /**
     * See {@link Builder#builder()}  MinehutAPI#login}
     */
    public MinehutAPI(String token, String userId, String profileId, String sessionId) {
        this.token = token;
        this.userId = userId;
        this.profileId = profileId;
        this.sessionId = sessionId;
        this.account = new Account(this);
    }

    /**
     * public MinehutAPI access.
     */
    public MinehutAPI() {}

    public Network getNetwork() {
        return new Network(this);
    }

    public Players getPlayers() {
        return new Players(this);
    }
    
    public Servers getServers() {
        return new Servers(this);
    }

    /**
     * @param url The main url.
     * @param endpoint The api endpoint (ex: servers).
     * @param headers The headers.
     * @return The response body as a string.
     */
    public String request(@NotNull String url, @NotNull String endpoint, @Nullable String... headers){
        HttpRequest request;
        HttpRequest.Builder builder;
        builder = HttpRequest.newBuilder()
                .uri(URI.create(url + endpoint))
                .header("Authorization", "Bearer " + token)
                .header("X-Profile-Id", profileId)
                .header("X-Session-Id", sessionId)
                .header("User-Agent", "MinehutAPI-Java-Client");
        if (!Arrays.stream(headers).toList().isEmpty()) {
            try {
                builder.headers(headers);
            } catch (Exception ignored){}
        }
        request = builder.build();
        try {
            var a = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(a);
            System.out.println(a.body());
            return a.body();
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    /**
     * @param url The main url.
     * @param endpoint The api endpoint (ex: servers).
     * @return The response body as a string.
     */
    public static String request(@NotNull String url, @NotNull String endpoint){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+endpoint))
                .header("User-Agent", "MinehutAPI-Java-Client")
                .build();
        try {
            var a = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(a);
            System.out.println(a.body());
            return a.body();
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public static class Builder {

        public String token;
        public String profileId;
        public String sessionId;
        public String userId;

        /**
         * A login builder (Tutorial: <a href="link">TODO: Add tutorial</a>)
         * @return A new builder.
         */
        public static Builder builder(){
            return new Builder();
        }

        /**
         * Sets the token of the builder.
         * @param token The minehut account token.
         * @return A new builder with the token.
         */
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        /**
         * Sets the profile id of the builder.
         * @param profileId The minehut account profile id.
         * @return A new builder with the profile id.
         */
        public Builder profileId(String profileId){
            this.profileId = profileId;
            return this;
        }

        /**
         * Sets the user id of the builder.
         * @param userId The minehut user id.
         * @return A new builder with the user id.
         */
        public Builder userId(String userId){
            this.userId = userId;
            return this;
        }

        /**
         * Sets the session id of the builder.
         * @param sessionId The minehut account session id.
         * @return A new builder with the session id.
         */
        public Builder sessionId(String sessionId){
            this.sessionId = sessionId;
            return this;
        }

        /**
         * Builds the builder (will not work if credentials are invalid).
         * @return The logged in api with the credentials.
         */
        public MinehutAPI build(){
            return new MinehutAPI(token, profileId, userId, sessionId);
        }
    }
}