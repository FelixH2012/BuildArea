package eu.felix.buildarea.command.implementation;

import eu.felix.buildarea.command.CommandInfo;
import eu.felix.buildarea.command.BuildAreaCommand;
import eu.felix.buildarea.mapping.AreaData;
import eu.felix.buildarea.mapping.AreaStorage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "createArea", purpose = "Add an area to system.")
public class AddArea extends BuildAreaCommand {

    @Override
    protected void handleCommand(CommandSender cSender, Command command, String label, String[] args) {
        if (args.length == 1) {
            sendMessage(cSender, ChatColor.BOLD + "Please set the areas name!");
        } else if (args.length == 2) {
            AreaStorage.areas.add(new AreaData(args[1], null, null, 0));
            sendMessage(cSender, ChatColor.BOLD + "Added an area with the name: " + ChatColor.DARK_RED + args[1]);
        }
    }

    @Override
    public int compareTo(BuildAreaCommand o) {
        return 0;
    }
}
