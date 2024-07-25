package cc.aabss.minehutapi.account;

import cc.aabss.minehutapi.MinehutAPI;
import cc.aabss.minehutapi.server.Server;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * User Server
 */
public class UserServer extends Server {

    public UserServer(String id, MinehutAPI api) {
        super(JsonParser.parseString(MinehutAPI.request("https://api.minehut.com/", "server/" + id)).getAsJsonObject());
        this.api = api;
        this.id = id;
    }

    private final MinehutAPI api;
    private final String id;

    public void unhibernate(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/start_service"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void start(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/start"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/shutdown"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void hibernate(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/destroy_service"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void repairFiles(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/repair_files"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void reset(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/reset_all"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void sendCommand(String cmd){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/send_command"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.ofString("{\"command\":\""+cmd+"\"}"))
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void setName(String name){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/change_name"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\":\""+name+"\"}"))
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void setMOTD(String motd){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/change_motd"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\":\""+motd+"\"}"))
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void setVisibility(boolean visible){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/visibility"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.ofString("{\"visibility\":\""+(visible ? "true" : "false")+"\"}"))
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void saveWorld(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/save"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void resetWorld(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/reset_world"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }

    public void editServerProperites(ServerPropertyType field, String value){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.minehut.com/server/"+id+"/edit_server_properties"))
                .header("Authorization", "Bearer " + api.token)
                .header("X-Profile-Id", api.proid)
                .header("X-Session-Id", api.sesid)
                .header("User-Agent", "MinehutAPI-Java-Client")
                .POST(HttpRequest.BodyPublishers.ofString("{\"field\":\""+field.name().toLowerCase()+"\", \"value\":\""+value+"\"}"))
                .build();
        try {
            String body = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("report this to me plz");
            throw new RuntimeException(e);
        }
    }


    public enum ServerPropertyType {
        MAX_PLAYERS,
        LEVEL_TYPE,
        LEVEL_NAME,
        GENERATOR_SETTINGS,
        GAMEMODE,
        FORCE_GAMEMODE,
        PVP,
        SPAWN_MOBS,
        SPAWN_ANIMALS,
        ALLOW_FLIGHT,
        DIFFICULTY,
        HARDCORE,
        ENABLE_COMMAND_BLOCK,
        ANNOUNCE_PLAYER_ACHIEVEMENTS,
        ALLOW_NETHER,
        GENERATE_STRUCTURES,
        RESOURCE_PACK
    }

}
