package eu.felix.buildarea.listener;

import eu.felix.buildarea.BuildArea;
import eu.felix.buildarea.mapping.AreaData;
import eu.felix.buildarea.mapping.AreaStorage;
import eu.felix.buildarea.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import java.util.ArrayList;
import java.util.List;

public class BlockHandler {

    public void handle(BuildArea buildArea) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(buildArea, () -> {

            for (AreaData areaData : AreaStorage.areas) {
                if (areaData.getFirstLocation() == null || areaData.getSecondLocation() == null || areaData.getAreaName() == null)
                    return;

                if (areaData.timerUtil.reachedTime(areaData.getResetDelay()) && areaData.isAllowToRun) {
                    for (Block block : blocksFromTwoPoints(areaData.getFirstLocation(), areaData.getSecondLocation())) {
                        block.setTypeId(0);
                    }
                    Bukkit.broadcastMessage(ColorUtil.translate(ChatColor.DARK_GRAY + "Removed blocks from " + ChatColor.RED + areaData.getAreaName()));
                    areaData.timerUtil.doReset();
                }
            }

        }, 0, 10);
    }

    //https://bukkit.org/threads/block-listed-within-cuboid-x-y-coodinates.103681/
    public static List<Block> blocksFromTwoPoints(Location loc1, Location loc2) {
        final List<Block> blocks = new ArrayList<>();

        final int topBlockX = (Math.max(loc1.getBlockX(), loc2.getBlockX()));
        final int bottomBlockX = (Math.min(loc1.getBlockX(), loc2.getBlockX()));

        final int topBlockY = (Math.max(loc1.getBlockY(), loc2.getBlockY()));
        final int bottomBlockY = (Math.min(loc1.getBlockY(), loc2.getBlockY()));

        final int topBlockZ = (Math.max(loc1.getBlockZ(), loc2.getBlockZ()));
        final int bottomBlockZ = (Math.min(loc1.getBlockZ(), loc2.getBlockZ()));

        for (int x = bottomBlockX; x <= topBlockX; x++) {
            for (int z = bottomBlockZ; z <= topBlockZ; z++) {
                for (int y = bottomBlockY; y <= topBlockY; y++) {
                    Block block = loc1.getWorld().getBlockAt(x, y, z);

                    blocks.add(block);
                }
            }
        }

        return blocks;
    }
}
