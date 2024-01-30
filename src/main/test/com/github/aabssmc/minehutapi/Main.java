package com.github.aabssmc.minehutapi;

import com.github.aabssmc.minehutapi.players.Friends;
import com.github.aabssmc.minehutapi.players.Friends;
import com.github.aabssmc.minehutapi.players.MinehutPlayer;
import com.github.aabssmc.minehutapi.players.Players;
import com.github.aabssmc.minehutapi.server.Icon;
import com.github.aabssmc.minehutapi.server.Servers;

import static com.github.aabssmc.minehutapi.server.Icon.getIcon;
import static com.github.aabssmc.minehutapi.server.Servers.getServer;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(getServer("Comic").getIcon().getCreated());
        System.out.println("end");
    }
}