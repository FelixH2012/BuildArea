package eu.felix.buildarea.command.implementation;

import eu.felix.buildarea.command.CommandInfo;
import eu.felix.buildarea.command.BuildAreaCommand;
import eu.felix.buildarea.mapping.AreaData;
import eu.felix.buildarea.mapping.AreaStorage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "SetInterval", purpose = "Setting up the clear interval")
public class SetInterval extends BuildAreaCommand {


    @Override
    protected void handleCommand(CommandSender cSender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sendMessage(cSender, "Please select a area where you want to set the interval");
        }
        if (args.length > 2) {
            final AreaData areaData = AreaStorage.getByName(args[1]);
            if (areaData == null) {
                sendMessage(cSender, "Unable to find " + args[1]);
            }
            if (areaData == null) return;

            areaData.setResetDelay(Integer.parseInt(args[2]));

            sendMessage(cSender, "Reset interval from " + ChatColor.RED + areaData.getAreaName() + " Is now " + ChatColor.GREEN + ChatColor.BOLD + areaData.getResetDelay());

        }
    }

    @Override
    public int compareTo(BuildAreaCommand o) {
        return 0;
    }
}
