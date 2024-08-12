package fr.vertugo.autopush;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PluginUpdater {
    private final ServerMain plugin;

    public PluginUpdater(ServerMain plugin) {
        this.plugin = plugin;
    }

    public void updatePlugin() {
        String targetFileName = plugin.getConfigManager().getTargetFile();
        String downloadUrl = "https://github.com/" + plugin.getConfigManager().getRepoName() + "/releases/latest/download/" + targetFileName;

        File pluginFile = new File("plugins/" + targetFileName);

        try {
            Files.copy(new URL(downloadUrl).openStream(), pluginFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(targetFileName.replace(".jar", "")));
            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(targetFileName.replace(".jar", "")));
            plugin.getLogger().info(targetFileName + " a été mis à jour et rechargé.");
        } catch (IOException e) {
            plugin.getLogger().severe("Échec de la mise à jour du plugin " + targetFileName + " : " + e.getMessage());
        }
    }
}
