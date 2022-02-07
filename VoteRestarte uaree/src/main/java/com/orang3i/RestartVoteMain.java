package com.orang3i;

import com.orang3i.voting.VoteExecutor;
import com.orang3i.voting.VotingLogic;


import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public final class RestartVoteMain extends JavaPlugin {

    private static RestartVoteMain instance;

    public static int MAXR;


    @Override
    public void onEnable() {

        instance = this;


        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new VoteExecutor(this), this);

        new VotingLogic(this);

        MAXR = getConfig().getInt("max delays.value");


    }

    @Override


    public void onDisable() {


    }




    public static RestartVoteMain getInstance () {

        return instance;
    }



}