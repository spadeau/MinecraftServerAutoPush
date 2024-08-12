package fr.vertugo.autopush;

import fr.vertugo.autopush.cmds.UpdateCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerMain extends JavaPlugin {

    private GitHubWatcher gitHubWatcher;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        configManager = new ConfigManager(this);
        gitHubWatcher = new GitHubWatcher(this, configManager);

        gitHubWatcher.startWatching();

        this.getCommand("update").setExecutor(new UpdateCommand(this, gitHubWatcher));
    }

    @Override
    public void onDisable() {
        gitHubWatcher.stopWatching();
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

}
