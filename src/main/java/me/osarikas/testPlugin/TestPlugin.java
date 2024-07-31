package me.osarikas.testPlugin;

import me.osarikas.testPlugin.commands.*;
import me.osarikas.testPlugin.events.CreeperExplode;
import me.osarikas.testPlugin.events.OpenBarrelEvent;
import me.osarikas.testPlugin.events.SpawnListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OpenBarrelEvent(), this);
//        getServer().getPluginManager().registerEvents(new CreeperExplode(), this);
        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setjoinmessage").setExecutor(new SetJoinMessageCommand(this));



    }


}
