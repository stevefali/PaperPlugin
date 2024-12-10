package org.steve.paperPlug_1_21_3.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class DropEvents implements Listener {

    @EventHandler
    public void blockDrop(BlockDropItemEvent event) {
        World world = event.getBlock().getWorld();
        Location location = event.getBlock().getLocation();

        ArrayList<Material> moddedLoot = new ArrayList<>();

        event.getItems().forEach(item -> {
            moddedLoot.add(item.getItemStack().getType());
        });

        event.getPlayer().sendMessage(event.getBlockState().getType() + " broken!");

        event.setCancelled(true);

        moddedLoot.forEach(vanillaDrop -> {
            dropSomething(location, world, vanillaDrop);
        });

    }

    private void dropSomething(Location location, World world, Material vanillaLoot) {
        // Just drop Gold Block for now, this will be a call to get the randomized loot from RandomDrops later.
        Material randomizedLoot = Material.GOLD_BLOCK;



        try  {
            world.dropItemNaturally(location, new ItemStack(randomizedLoot));
        } catch (Exception e) {
            System.out.println("Error dropping item!");
        }
    }
}
