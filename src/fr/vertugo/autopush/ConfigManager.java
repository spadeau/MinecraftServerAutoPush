package fr.vertugo.autopush;

import org.bukkit.ChatColor;

public class ConfigManager {
    private final ServerMain plugin;

    public ConfigManager(ServerMain plugin) {
        this.plugin = plugin;
    }

    public String getToken() {
        return plugin.getConfig().getString("github.token");
    }

    public String getRepoName() {
        return plugin.getConfig().getString("github.repo");
    }

    public String getUpdateSuccess() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.updateSuccess"));
    }

    public String getNoPermission() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.noPermission"));
    }

    public String getTargetFile() {
        return plugin.getConfig().getString("github.target_folder_plugin") + plugin.getConfig().getString("github.repo") + ".jar";
    }
}
