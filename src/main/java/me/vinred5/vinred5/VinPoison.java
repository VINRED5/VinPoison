package me.vinred5.vinred5;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.plugin.java.JavaPlugin;

public final class VinPoison extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(Component.text(Color.BLUE + "Плагин включился"));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
