package com.orang3i;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import static org.bukkit.Bukkit.getServer;


public   class restartvote {

    public  static int vote1 ;
    public  static double vote2 = 1;
    public  static  double votee;
   public static boolean ch1 = true;

    public  restartvote(voterestart plugin) {

        new CommandBase("restartvote" , true) {

            @Override

            public  boolean onCommand(CommandSender sender , String [] args) {


                double plo = getServer().getOnlinePlayers().size();
                FileConfiguration config = plugin.getConfig();
                int restartmode = config.getInt("restart mode.value");
                double perc = config.getInt("percentage of votes needed to restart.value");
                int vote_valuex = config.getInt("number of votes needed to restart.value");
                int delay = config.getInt("delay time.value");

                String restart_command = config.getString("restart command.value");

                int vote_value = vote_valuex -1;

                if(restartmode == 1) {


                    if (vote1 < vote_value) {
                        ++vote1;

                        Player player = (Player) sender;
                        Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.RED + " has voted to delay" + " " + "now there are " + " " + vote1 + " " + "votes" + " " + vote_valuex + " " + "required to delay");
                        PermissionAttachment attachment = player.addAttachment(plugin,1200);
                        attachment.setPermission("voterestart.vote",false);

                        ch1 = false;
                    } else {


                        Player player = (Player) sender;
                        Bukkit.broadcastMessage(ChatColor.GREEN + "number of votes to restart reached delaying restart...");

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ar delay" + " " + delay);

                        ch1 = false;
                    }
                }

                if (restartmode == 2){

                    votee = (vote2/plo) * 100 ;

                    if (votee < perc) {
                        ++vote2;

                        Player player = (Player) sender;
                        Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.RED + " has voted to delay" + " " + "now there are " + " " + votee + "%" + " " + "of players who voted " +perc + "%" + " " + "of players must vote to delay");
                        ch1 = false;
                    } if(votee > perc){


                        Player player = (Player) sender;
                        Bukkit.broadcastMessage(ChatColor.GREEN + "percentage of votes to restart" + "[" + perc+ "]" + " "+"delaying restart.....");

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ar delay" + " " + delay);
                        PermissionAttachment attachment = player.addAttachment(plugin,1200);
                        attachment.setPermission("voterestart.vote",false);

                        ch1 = false;
                    }

                }

                return true;
            }
            @Override

            public  String getUsage() {

                return "/prefix <user> <prefix>";
            }
        }.enableDelay(0).setPermission("voterestart.vote");
    }
}
