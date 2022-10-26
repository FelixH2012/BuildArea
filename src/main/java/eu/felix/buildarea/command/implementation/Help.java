package eu.felix.buildarea.command.implementation;

import eu.felix.buildarea.command.CommandInfo;
import eu.felix.buildarea.command.BuildAreaCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "Help", purpose = "Helps you.")
public class Help extends BuildAreaCommand {

    @Override
    protected void handleCommand(CommandSender cSender, Command command, String label, String[] args) {

        //Kinda ugly code idfk will change
        {
            cSender.sendMessage("/buildarea " + ChatColor.GRAY + "createArea " + ChatColor.GRAY + ChatColor.BOLD + "<name>" + ChatColor.WHITE + " Creates a new area");
            cSender.sendMessage("/buildarea " + ChatColor.GRAY + "AddPoint " + ChatColor.GRAY + ChatColor.BOLD + "<name> <P1>" + ChatColor.WHITE + " Creates the first point from an area");
            cSender.sendMessage("/buildarea " + ChatColor.GRAY + "AddPoint " + ChatColor.GRAY + ChatColor.BOLD + "<name> <P2>" + ChatColor.WHITE + " Creates the second point from an area");
            cSender.sendMessage("/buildarea " + ChatColor.GRAY + "GetAreas " + ChatColor.WHITE + "Lists all areas");
            cSender.sendMessage("/buildarea " + ChatColor.GRAY + "RemoveArea <name> " + ChatColor.WHITE + "Removes a area");
            cSender.sendMessage("/buildarea " + ChatColor.GRAY + "runArea <name> <true/false> " + ChatColor.WHITE + "Sets the area running or disabled");
            cSender.sendMessage("/buildarea " + ChatColor.GRAY + "setInterval <name> <delay in ms> " + ChatColor.WHITE + "Sets The delay by deleting the blocks");

        }

    }

    @Override
    public int compareTo(BuildAreaCommand o) {
        return 0;
    }
}
