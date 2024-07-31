package me.osarikas.testPlugin.commands;

import me.osarikas.testPlugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private final TestPlugin plugin;

    public SpawnCommand(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player p){
            Location spawn = plugin.getConfig().getLocation("spawn");
            if(spawn != null){
                p.teleport(spawn);
                p.sendMessage(ChatColor.DARK_AQUA + "Вы были телепортированы на спавн");
            }
            else{
                p.sendMessage("Точка спавна не установлена");
            }
        }
        return true;
    }
}
