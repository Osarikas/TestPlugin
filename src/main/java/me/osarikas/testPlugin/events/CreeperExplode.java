package me.osarikas.testPlugin.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CreeperExplode implements Listener {
    @EventHandler
    public void CreeperExplodeEvent(EntityExplodeEvent event){
        event.setCancelled(true);
        Location explodeLocation = event.getLocation();
        World world = explodeLocation.getWorld();

        if (world != null) {
            world.spawnEntity(explodeLocation.add(2, 0, 2), EntityType.CREEPER);
            world.spawnEntity(explodeLocation.add(-4, 0, -4), EntityType.CREEPER);
        }
    }
}
