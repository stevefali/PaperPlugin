package org.steve.paperPlug_1_21_3;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.steve.paperPlug_1_21_3.events.DropEvents;

public final class PaperPlug_1_21_3 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents( new DropEvents(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
