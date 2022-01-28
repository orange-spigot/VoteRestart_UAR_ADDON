package com.orang3i;

import dev.norska.uar.UltimateAutoRestart;
import dev.norska.uar.api.UltimateAutoRestartAPI;
import dev.norska.uar.api.UltimateAutoRestartAutoDelayEvent;
import dev.norska.uar.api.UltimateAutoRestartDelayEvent;
import dev.norska.uar.api.UltimateAutoRestartRestartEvent;
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
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.permissions.PermissionAttachment;



public class RestartVote_UAR  implements Listener {

    private voterestart plugin;

    public RestartVote_UAR(voterestart pl) {

        plugin = pl;
    }



    @EventHandler
    public void onUAR(UltimateAutoRestartRestartEvent event) {
        UltimateAutoRestartAPI.setInterval(UltimateAutoRestart.getInstance(), 60);
        Bukkit.broadcastMessage(ChatColor.GREEN + "click on vote to delay the restart");
        TextComponent message = new TextComponent(ChatColor.RED + "click this to vote");
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/restartvote"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("click this to vote").create()));
        Bukkit.getServer().spigot().broadcast(message);
        for(Player player : Bukkit.getOnlinePlayers()){
            PermissionAttachment attachment = player.addAttachment(plugin, 1200);
            attachment.setPermission("voterestart.vote", true);
        }
    }


}



