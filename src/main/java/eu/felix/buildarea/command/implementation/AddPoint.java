package eu.felix.buildarea.command.implementation;


import eu.felix.buildarea.command.CommandInfo;
import eu.felix.buildarea.command.BuildAreaCommand;
import eu.felix.buildarea.mapping.AreaData;
import eu.felix.buildarea.mapping.AreaStorage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "addPoint", purpose = "Adds an area to system.")
public class AddPoint extends BuildAreaCommand {
    @Override
    protected void handleCommand(CommandSender cSender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sendMessage(cSender, "Please select a area");
        }
        if (args.length > 2) {
            final AreaData areaData = AreaStorage.getByName(args[1]);
            if (areaData == null) {
                sendMessage(cSender, "Unable to find " + args[1]);
            }
            if (areaData == null) return;
            if (args[2].equalsIgnoreCase("P1")) {
                final AreaData area = AreaStorage.getByName(args[1]);

                final Player player = (Player) cSender;

                assert area != null;
                area.setFirstLocation(player.getLocation());
                sendMessage(cSender, ChatColor.BOLD + "Added point 1 to: " + ChatColor.DARK_RED + args[1]);
            }

            if (args[2].equalsIgnoreCase("P2")) {
                final AreaData area = AreaStorage.getByName(args[1]);

                final Player player = (Player) cSender;

                assert area != null;
                area.setSecondLocation(player.getLocation());
                sendMessage(cSender, ChatColor.BOLD + "Added point 2 to: " + ChatColor.DARK_RED + args[1]);
            }

        }
    }

    @Override
    public int compareTo(BuildAreaCommand o) {
        return 0;
    }
}
