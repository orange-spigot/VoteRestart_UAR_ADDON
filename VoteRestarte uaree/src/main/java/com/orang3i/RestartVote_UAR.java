package com.orang3i;

import dev.norska.uar.UltimateAutoRestart;
import dev.norska.uar.api.UARAPI;
import dev.norska.uar.api.UARRestartEvent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;


public class RestartVote_UAR  implements Listener {

    private voterestart plugin;

    public RestartVote_UAR(voterestart pl) {

        plugin = pl;
    }

    private restartvote ch1;

    public RestartVote_UAR(restartvote cl) {

        ch1 = cl;
    }



    @EventHandler
    public void onnRestart(UARRestartEvent e) {
        if(ch1.ch1 == true){
            UARAPI.setInterval(UltimateAutoRestart.getInstance(), 60);
            ch1.ch1 = false;

            Bukkit.broadcastMessage(ChatColor.GREEN + "click on vote to delay the restart");
            TextComponent message = new TextComponent(ChatColor.RED + "click this to vote");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/restartvote"));
            Bukkit.getServer().spigot().broadcast(message);



            for (Player player : Bukkit.getOnlinePlayers()) {
                HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();
                PermissionAttachment attachment = player.addAttachment(plugin);
                perms.put(player.getUniqueId(), attachment);

                PermissionAttachment pperms = perms.get(player.getUniqueId());
                pperms.setPermission("voterestart.vote", true);
            }
        }


    }
}




