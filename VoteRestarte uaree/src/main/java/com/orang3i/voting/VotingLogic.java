package com.orang3i.voting;

import com.orang3i.commands.CommandBase;
import com.orang3i.RestartVoteMain;
import com.orang3i.iridium.IridiumColorAPI;
import dev.norska.uar.UltimateAutoRestart;
import dev.norska.uar.api.UARAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import static org.bukkit.Bukkit.getServer;


public   class VotingLogic {

    public  static int VOTEONE ;
    public  static double VOTETWO = 1;
    public  static  double VOTEE;



    public  VotingLogic(RestartVoteMain plugin) {

        new CommandBase("restartvote" , true) {

            @Override

            public  boolean onCommand(CommandSender sender , String [] args) {


                double plo = getServer().getOnlinePlayers().size();
                FileConfiguration config = plugin.getConfig();

                int restartmode = config.getInt("restart mode.value");
                double perc = config.getInt("percentage of votes needed to restart.value");
                int vote_valuex = config.getInt("number of votes needed to restart.value");
                int delay = config.getInt("delay time.value");
                String rs1v = config.getString("restart mode 1 message when someone votes.value");
                boolean rs1vb = config.getBoolean("restart mode 1 message when someone votes.enabled");
                String rs1d = config.getString("restart mode 1 message when number of votes needed to delay is reached.value");
                boolean rs1db = config.getBoolean("restart mode 1 message when number of votes needed to delay is reached.enabled");
                String rs2v = config.getString("restart mode 2 message when someone votes.value");
                boolean rs2vb = config.getBoolean("restart mode 2 message when someone votes.enabled");
                String rs2d = config.getString("restart mode 2 message when percentage of votes needed to delay is reached.value");
                boolean rs2db = config.getBoolean("restart mode 2 message when percentage of votes needed to delay is reached.enabled");
                int vote_value = vote_valuex -1;

                if(restartmode == 1) {


                if (VOTEONE < vote_value) {
                        ++VOTEONE;


                    if (rs1vb == true) {
                       Bukkit.broadcastMessage(IridiumColorAPI.process(rs1v));
                    }else {


                        Bukkit.broadcastMessage(IridiumColorAPI.process("<GRADIENT:9281fb>someone has voted to delay</GRADIENT:eb93fc>" + " " + "<GRADIENT:9281fb>now there are</GRADIENT:eb93fc>" + " " + " " + VOTEONE + " " + "<GRADIENT:9281fb>votes</GRADIENT:eb93fc>" + " " + vote_valuex + " " + "<GRADIENT:9281fb>required to delay</GRADIENT:eb93fc>"));
                    }
                    Player player = (Player) sender;
                        PermissionAttachment attachment = player.addAttachment(plugin,1200);
                        attachment.setPermission("voterestart.vote",false);


                    } else {

                        for (Player player : Bukkit.getOnlinePlayers()) {

                            double delaye = delay / 60;
                            if (rs1db == true) {
                                player.sendMessage(IridiumColorAPI.process(rs1d));
                            }else {
                                player.sendMessage(IridiumColorAPI.process("<GRADIENT:9281fb>number of votes to restart reached delaying restart by</GRADIENT:eb93fc>" + " " + delaye + " " + "<GRADIENT:9281fb>minutes</GRADIENT:eb93fc>"));
                            }
                            UARAPI.setInterval(UltimateAutoRestart.getInstance(), delay);
                        }



                    }
                }

                if (restartmode == 2){

                    VOTEE  = (VOTETWO/plo) * 100 ;

                    if (VOTEE < perc) {
                        ++VOTETWO;
                        for (Player player : Bukkit.getOnlinePlayers()) {

                            double perce = Math.round(VOTEE);
                if (rs2vb == true) {
                    player.sendMessage(IridiumColorAPI.process(rs2v));
                }else {
                    player.sendMessage(IridiumColorAPI.process("<GRADIENT:9281fb>someone has voted to delay</GRADIENT:eb93fc>" + " " + "<GRADIENT:9281fb>now there are</GRADIENT:eb93fc>" + " " + perce + "%" + " " + "<GRADIENT:9281fb>votes</GRADIENT:eb93fc>" + " " + perc + "%" + " " + "<GRADIENT:9281fb>required to delay</GRADIENT:eb93fc>"));
                }
                        }



                    }
                    if(VOTEE >= perc){


                        for (Player player : Bukkit.getOnlinePlayers()) {


                            double delaye = delay / 60;
                       if (rs2db == true) {
                           player.sendMessage(IridiumColorAPI.process(rs2d));
                       }else {
                           player.sendMessage(IridiumColorAPI.process("<GRADIENT:9281fb>percentage  of votes to restart reached delaying restart by</GRADIENT:eb93fc>" + " " + delaye + " " + "<GRADIENT:9281fb>minutes</GRADIENT:eb93fc>"));
                       }
                            PermissionAttachment attachment = player.addAttachment(plugin,1200);
                            attachment.setPermission("voterestart.vote",false);


                        }
                        UARAPI.setInterval(UltimateAutoRestart.getInstance(), delay);



                    }

                }

                return true;
            }
            @Override

            public  String getUsage() {

                return "/prefix <user> <prefix>";
            }
        }.enableDelay(60).setPermission("voterestart.vote");
    }
}
