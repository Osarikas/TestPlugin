package me.osarikas.testPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player p ){
            p.setFoodLevel(20);
            p.sendMessage(ChatColor.AQUA + "Вы были накормлены");
        }
        return true;
    }
}
