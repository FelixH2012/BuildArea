package eu.felix.buildarea;

import eu.felix.buildarea.command.CommandManager;
import eu.felix.buildarea.file.AreaSaving;
import eu.felix.buildarea.mapping.AreaStorage;
import eu.felix.buildarea.listener.BlockHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class BuildArea extends JavaPlugin {

    public static BuildArea instance;

    private final CommandManager commandManager = new CommandManager();

    private AreaSaving areaSaving = new AreaSaving(new File("area.data"));

    @Override
    public void onEnable() {

        instance = this;

        getCommand("buildarea").setExecutor(commandManager);

        if (!getDataFolder().exists() && !getDataFolder().mkdir())
            getLogger().warning("Failed to create data folder");

        areaSaving = new AreaSaving(new File(getDataFolder() + "/data.json"));

        areaSaving.loadData(this);

        new BlockHandler().handle(this);

        super.onEnable();
    }

    @Override
    public void onDisable() {
        instance = null;
        if (AreaStorage.areas.isEmpty()) return;

        areaSaving.save();

        super.onDisable();
    }
}
