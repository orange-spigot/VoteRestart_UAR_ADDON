package com.orang3i;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.permissions.PermissionAttachment;

import static org.bukkit.Bukkit.getPlayer;
import static org.bukkit.Bukkit.getServer;


public class Voting implements Listener {

    public static int vote11;
    public static double vote22 = 1;
    public static double votea;

    private voterestart plugin;


    public Voting(voterestart pl) {

        plugin = pl;
    }


    @EventHandler

    public void onPlayerChat(AsyncPlayerChatEvent event) {


        if (event.getMessage().equalsIgnoreCase("ar test")) {

            Player player = event.getPlayer();
            PermissionAttachment attachment = player.addAttachment(plugin,1200);
            attachment.setPermission("voterestart.vote",true);
            TextComponent message = new TextComponent(ChatColor.RED + "click this to vote");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/restartvote"));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("click this to vote").create()));
            player.spigot().sendMessage(message);

            }

        }
    }


