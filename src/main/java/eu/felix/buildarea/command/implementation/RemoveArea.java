package eu.felix.buildarea.command.implementation;

import eu.felix.buildarea.command.CommandInfo;
import eu.felix.buildarea.command.BuildAreaCommand;
import eu.felix.buildarea.mapping.AreaData;
import eu.felix.buildarea.mapping.AreaStorage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "RemoveArea", purpose = "Add an area to system.")
public class RemoveArea extends BuildAreaCommand {

    @Override
    protected void handleCommand(CommandSender cSender, Command command, String label, String[] args) {
        if (args.length == 1) {
            sendMessage(cSender, ChatColor.BOLD + "Please tell the name from the area you want to remove!");
        } else if (args.length == 2) {
            final AreaData areaData = AreaStorage.getByName(args[1]);
            AreaStorage.areas.remove(areaData);
            sendMessage(cSender, ChatColor.BOLD + "Removed area: " + ChatColor.DARK_RED + args[1]);
        }
    }

    @Override
    public int compareTo(BuildAreaCommand o) {
        return 0;
    }
}
