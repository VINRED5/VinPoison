package me.vinred5.vinred5;

import me.vinred5.vinred5.listener.BlockPlaceListener;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class VinPoison extends JavaPlugin {

    private static VinPoison instance;

    public static VinPoison getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        console(true);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), instance);
    }


    @Override
    public void onDisable() {
        console(false);
    }

    public String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    private void console(boolean enable) {
        String status = enable ? "Включён" : "Выключен";

        List<String> messages = Arrays.asList(
                instance.getDescription().getFullName() + instance.getDescription().getAuthors(),
                "-------------------",
                "Статус: " + status,
                "Версия: " + instance.getDescription().getVersion()
        );

        messages.forEach(str -> Bukkit.getConsoleSender().sendMessage(Component.text(color(str))));
    }
}
