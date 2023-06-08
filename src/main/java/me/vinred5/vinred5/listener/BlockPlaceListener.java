package me.vinred5.vinred5.listener;

import me.vinred5.vinred5.VinPoison;
import net.kyori.adventure.text.Component;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Arrays;
import java.util.List;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        VinPoison instance = VinPoison.getInstance();

        if (event.canBuild() && !event.isCancelled()) {
            List<String> blockInfo = Arrays.asList(
                    "&fВы установили блок: &e" + block,
                    "&fКоординаты: " + block.getLocation().getX() + ", " + block.getLocation().getY() + ", " + block.getLocation().getZ()
            );

            blockInfo.forEach(s -> player.sendMessage(Component.text(instance.color(s))));
        }
    }
}
