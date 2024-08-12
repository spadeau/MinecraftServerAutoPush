package fr.vertugo.autopush;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GitHubWatcher {
    private final ServerMain plugin;
    private final ConfigManager configManager;
    private final OkHttpClient httpClient;
    private Timer timer;
    private String lastCommitSha;

    public GitHubWatcher(ServerMain plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
        this.httpClient = new OkHttpClient();
        this.timer = new Timer(true);
    }

    public void startWatching() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkForUpdates();
            }
        }, 0, 15 * 60 * 1000);
    }

    public void stopWatching() {
        timer.cancel();
    }

    private void checkForUpdates() {
        String repoUrl = "https://api.github.com/repos/" + configManager.getRepoName() + "/commits";
        Request request = new Request.Builder()
                .url(repoUrl)
                .header("Authorization", "token " + configManager.getToken())
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String newCommitSha = extractLatestCommitSha(response.body().string());
                if (newCommitSha != null && !newCommitSha.equals(lastCommitSha)) {
                    lastCommitSha = newCommitSha;
                    updatePlugins();
                }
            }
        } catch (IOException e) {
            plugin.getLogger().severe("Erreur lors de la vérification des mises à jour : " + e.getMessage());
        }
    }

    private String extractLatestCommitSha(String jsonResponse) {
        return jsonResponse.split("\"sha\":\"")[1].split("\"")[0];
    }

    public void updatePlugins() {
        Bukkit.getScheduler().runTask(plugin, () -> {
            PluginUpdater updater = new PluginUpdater(plugin);
            updater.updatePlugin();
        });
    }
}
