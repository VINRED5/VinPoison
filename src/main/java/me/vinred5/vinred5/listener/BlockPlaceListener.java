package me.vinred5.vinred5.listener;

import me.vinred5.vinred5.VinPoison;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location loc = block.getLocation().add(0, -1, 0);
        Material campfireCheck = loc.getBlock().getType();
        Material campfire = Material.valueOf("CAMPFIRE");

        VinPoison instance = VinPoison.getInstance();

        if (event.canBuild() && !event.isCancelled()) {
            List<String> blockInfo = Arrays.asList(
                    "&fВы установили блок: &e" + block.getType(),
                    "&fКоординаты: &e" + block.getLocation().getX() + ", " + block.getLocation().getY() + ", " + block.getLocation().getZ(),
                    "&fСнизу: &e" + campfireCheck
            );

            blockInfo.forEach(s -> player.sendMessage(Component.text(instance.color(s))));
        }
        if (campfireCheck == campfire) {
            player.sendMessage(Component.text("&dУсловие выполненно"));
        } else player.sendMessage(Component.text("&dУсловие не выполненно"));

    }

}
