package lol.aabss.minehutapi;

import lol.aabss.minehutapi.players.Friends;
import lol.aabss.minehutapi.players.MinehutPlayer;
import lol.aabss.minehutapi.players.Players;
import lol.aabss.minehutapi.server.Servers;

public class Main {
    public static void main(String[] args) {
        for (MinehutPlayer p : Friends.getFriends("aabss")){
            System.out.println(p);
        }
    }
}
