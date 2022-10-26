package eu.felix.buildarea.command;

import eu.felix.buildarea.command.implementation.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor {

    public final List<BuildAreaCommand> commands = new ArrayList<>();

    public CommandManager() {
        commands.add(new GetAreas());
        commands.add(new AddArea());
        commands.add(new RemoveArea());
        commands.add(new AddPoint());
        commands.add(new SetInterval());
        commands.add(new RunArea());
        commands.add(new Help());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("buildarea.admin")) {
            if (strings.length > 0) {
                for (final BuildAreaCommand cmd : commands) {
                    if (strings[0].equalsIgnoreCase(cmd.getCommandInfo().name())) {
                        cmd.handleCommand(commandSender, command, s, strings);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
