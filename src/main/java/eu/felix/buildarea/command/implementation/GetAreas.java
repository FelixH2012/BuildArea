package eu.felix.buildarea.command.implementation;


import eu.felix.buildarea.command.CommandInfo;
import eu.felix.buildarea.command.BuildAreaCommand;
import eu.felix.buildarea.mapping.AreaData;
import eu.felix.buildarea.mapping.AreaStorage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "listAreas", purpose = "Returns all areas")
public class GetAreas extends BuildAreaCommand {

    @Override
    protected void handleCommand(CommandSender cSender, Command command, String label, String[] args) {
        if (args.length == 1) {
            for (AreaData areaData : AreaStorage.areas) {
                final int roundXP1 = (int) Math.round(areaData.getFirstLocation().toVector().getX());
                final int roundYP1 = (int) Math.round(areaData.getFirstLocation().toVector().getY());
                final int roundZP1 = (int) Math.round(areaData.getFirstLocation().toVector().getZ());

                final int roundXP2 = (int) Math.round(areaData.getSecondLocation().toVector().getX());
                final int roundYP2 = (int) Math.round(areaData.getSecondLocation().toVector().getY());
                final int roundZP2 = (int) Math.round(areaData.getSecondLocation().toVector().getZ());

                sendMessage(cSender, ChatColor.WHITE + "AreaName: " + ChatColor.DARK_RED + areaData.getAreaName() + ChatColor.GRAY + " P1: " + "X: " + ChatColor.BOLD + roundXP1 + ChatColor.GRAY + " Y: " + ChatColor.BOLD + roundYP1 + " " + ChatColor.GRAY + "Z: " + ChatColor.BOLD + roundZP1);
                sendMessage(cSender, ChatColor.WHITE + "AreaName: " + ChatColor.DARK_RED + areaData.getAreaName() + ChatColor.GRAY +  " P2: " + "X: " + ChatColor.BOLD + roundXP2 + ChatColor.GRAY + " Y: " + ChatColor.BOLD + roundYP2 + " " + ChatColor.GRAY + "Z: " + ChatColor.BOLD + roundZP2);
            }
        }
    }

    @Override
    public int compareTo(BuildAreaCommand o) {
        return 0;
    }
}
