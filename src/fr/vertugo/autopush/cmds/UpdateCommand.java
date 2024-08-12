package fr.vertugo.autopush.cmds;

import fr.vertugo.autopush.GitHubWatcher;
import fr.vertugo.autopush.ServerMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class UpdateCommand implements CommandExecutor {
    private final ServerMain plugin;
    private final GitHubWatcher gitHubWatcher;

    public UpdateCommand(ServerMain plugin, GitHubWatcher gitHubWatcher) {
        this.plugin = plugin;
        this.gitHubWatcher = gitHubWatcher;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("autopush.update")) {
            gitHubWatcher.updatePlugins();
            sender.sendMessage(plugin.getConfigManager().getUpdateSuccess());
            return true;
        } else {
            sender.sendMessage(plugin.getConfigManager().getNoPermission());
            return false;
        }
    }
}
