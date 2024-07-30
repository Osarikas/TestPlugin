package me.osarikas.testPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player p ){
            if(p.hasPermission("testplugin.god")){
                if (p.isInvulnerable()){
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "Режим бога отключен");
                }
                else{
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "Режим бога включен");
                }
            }
            else {
                p.sendMessage("У тебя нет прав");
            }

        }
        return true;
    }
}
