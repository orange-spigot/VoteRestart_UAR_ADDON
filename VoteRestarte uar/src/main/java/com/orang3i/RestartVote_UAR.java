package com.orang3i;

import dev.norska.uar.UltimateAutoRestart;
import dev.norska.uar.api.UltimateAutoRestartAutoDelayEvent;
import dev.norska.uar.api.UltimateAutoRestartDelayEvent;
import dev.norska.uar.api.UltimateAutoRestartRestartEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.server.ServerCommandEvent;

import static com.orang3i.Voting.vote11;
import static com.orang3i.Voting.votea;

public class RestartVote_UAR implements Listener {

    private voterestart plugin;

    public RestartVote_UAR(voterestart pl) {

        plugin = pl;
    }

    private Voting test;

    public RestartVote_UAR(Voting ttt) {

        test = ttt;
    }


    @EventHandler
    public void onUAR(UltimateAutoRestartRestartEvent event) {


        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ar delay 60");

        Bukkit.broadcastMessage(ChatColor.GREEN + "click on vote to delay the restart");


    }


}



