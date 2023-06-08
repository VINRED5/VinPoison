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

import java.util.Collections;
import java.util.List;

public class BlockPlaceListener implements Listener {

    VinPoison instance = VinPoison.getInstance();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (event.canBuild() && !event.isCancelled()) {
            List<String> blockInfo = Collections.singletonList(
                    "&fВы установили блок: &e" + block.getType()
            );
            blockInfo.forEach(s -> player.sendMessage(Component.text(instance.color(s))));
            if (block.getType() == Material.CAMPFIRE) {
                checkCampfire(block, player);
            } else if (block.getType() == Material.CAULDRON) {
                checkCauldron(block, player);
            }
        }
    }

    public void checkCampfire(Block block, Player player) {
        Location loc = block.getLocation().add(0, 1, 0);
        Material checkCauldron = loc.getBlock().getType();
        if (checkCauldron == Material.CAULDRON) {
            List<String> yes = Collections.singletonList("&dУсловие выполнено: над костром находиться котёл");
            yes.forEach(s -> player.sendMessage(Component.text(instance.color(s))));
        }
    }

    public void checkCauldron(Block block, Player player) {
        Location loc = block.getLocation().add(0, -1, 0);
        Material checkCampfire = loc.getBlock().getType();
        if (checkCampfire == Material.CAMPFIRE) {
            List<String> yes = Collections.singletonList("&dУсловие выполнено: под котлом находиться костёр");
            yes.forEach(s -> player.sendMessage(Component.text(instance.color(s))));
        }
    }

}
