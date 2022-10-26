package eu.felix.buildarea.command;

import eu.felix.buildarea.utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class BuildAreaCommand implements Comparable<BuildAreaCommand> {

    protected abstract void handleCommand(final CommandSender cSender, final Command command, final String label, final String[] args);

    public void sendMessage(final CommandSender sender, final String message) {
        sender.sendMessage(ColorUtil.translate(message));
    }

    public CommandInfo getCommandInfo() {
        if (this.getClass().isAnnotationPresent(CommandInfo.class)) {
            return this.getClass().getAnnotation(CommandInfo.class);
        } else {
            System.err.println("CommandInfo annotation hasn't been added to the class " + this.getClass().getSimpleName() + ".");
        }
        return null;
    }


}
