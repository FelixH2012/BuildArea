package eu.felix.buildarea.command.implementation;

import eu.felix.buildarea.command.CommandInfo;
import eu.felix.buildarea.command.BuildAreaCommand;
import eu.felix.buildarea.mapping.AreaData;
import eu.felix.buildarea.mapping.AreaStorage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "runArea", purpose = "Add an area to system.")
public class RunArea extends BuildAreaCommand {

    @Override
    protected void handleCommand(CommandSender cSender, Command command, String label, String[] args) {
        if (args.length == 1) {
            sendMessage(cSender, ChatColor.BOLD + "Please select the area you want to run!");
        } else if (args.length > 2) {
            final AreaData areaData = AreaStorage.getByName(args[1]);
            if (areaData == null) {
                sendMessage(cSender, "Unable to find " + args[1]);
            }
            if (areaData == null) return;

            final boolean status = Boolean.parseBoolean(args[2]);

            areaData.isAllowToRun = status;

            sendMessage(cSender, "running status from " + ChatColor.RED + areaData.getAreaName() + ChatColor.GRAY + " Is now " + ChatColor.GREEN + ChatColor.BOLD + status);


        }
    }

    @Override
    public int compareTo(BuildAreaCommand o) {
        return 0;
    }
}
