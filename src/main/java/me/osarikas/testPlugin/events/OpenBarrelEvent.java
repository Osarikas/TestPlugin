package me.osarikas.testPlugin.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockType;
import org.bukkit.block.data.type.Barrel;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.InventoryBlockStartEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class OpenBarrelEvent implements Listener {
    @EventHandler
    public void OpenBarrel(InventoryOpenEvent event){
        if(event.getInventory().getLocation()!= null && event.getInventory().getLocation().getBlock().getType() == Material.BARREL ){
            Block barrel =event.getInventory().getLocation().getBlock();
            Location location = barrel.getLocation().add(0.5, 1, 0.5);
            World w = event.getInventory().getLocation().getWorld();
            for (int i = 0; i < 4; i++) {
                w.spawnEntity(location, EntityType.SILVERFISH);
            }

        }
    }

}
