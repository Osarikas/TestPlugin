package me.osarikas.testPlugin.commands;

import me.osarikas.testPlugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    private final TestPlugin plugin;

    public SetSpawnCommand(TestPlugin pl) {
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player p){
            if(p.hasPermission("testplugin.setspawn")){
                Location loc = p.getLocation();
                plugin.getConfig().set("spawn", loc);
                plugin.saveConfig();

                p.sendMessage(ChatColor.AQUA + "Точка спавна установлена");
            }
            else{
                p.sendMessage("У тебя нет прав на установку спавна");
            }

        }
        return true;
    }
}
