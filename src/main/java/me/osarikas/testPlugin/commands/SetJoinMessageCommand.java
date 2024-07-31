package me.osarikas.testPlugin.commands;

import me.osarikas.testPlugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetJoinMessageCommand implements CommandExecutor {
    private final TestPlugin plugin;

    public SetJoinMessageCommand(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player p){
            if (strings[0]==null){
                p.sendMessage(ChatColor.GOLD + "Вы ничего не указали");
            }
            else {
                StringBuilder message = new StringBuilder();
                for(String i : strings){
                    message.append(i).append(" ");
                }
                p.sendMessage(ChatColor.AQUA + "Приветственное сообщение изменено на " + ChatColor.DARK_AQUA + message);
                plugin.getConfig().set("join-message", message.toString());
                plugin.saveConfig();
            }
        }
        return true;
    }
}
