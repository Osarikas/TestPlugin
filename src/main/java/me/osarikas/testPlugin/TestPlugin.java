package me.osarikas.testPlugin;

import me.osarikas.testPlugin.commands.FeedCommand;
import me.osarikas.testPlugin.commands.GodCommand;
import me.osarikas.testPlugin.events.CreeperExplode;
import me.osarikas.testPlugin.events.OpenBarrelEvent;
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
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());



    }


}
