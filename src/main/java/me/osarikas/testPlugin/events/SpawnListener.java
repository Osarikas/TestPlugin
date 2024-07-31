package me.osarikas.testPlugin.events;

import me.osarikas.testPlugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {
    private final TestPlugin plugin;

    public SpawnListener(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        String joinMessage = plugin.getConfig().getString("join-message");
        if(joinMessage != null){
            joinMessage = joinMessage.replace("%player%",p.getDisplayName());
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
        }
        if(!event.getPlayer().hasPlayedBefore()){
            Location spawn = plugin.getConfig().getLocation("spawn");
            if(spawn != null){
                p.teleport(spawn);
                p.sendMessage(ChatColor.DARK_AQUA + "Удачной игры");
            }
        }
    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        Player p = event.getPlayer();
        Location spawn = plugin.getConfig().getLocation("spawn");
        if(spawn != null){
            p.teleport(spawn);
        }
    }
}
