# MinecraftServerAutoPush

🇫🇷 : En français<br>
Pour faire fonctionner le plugin correctement, rendez-vous sur GitHub (https://github.com/settings/tokens) et créez un nouveau token avec la permission "repo" (il est conseillé d'activer toutes les permissions pour éviter des problèmes). Ensuite, allez dans le fichier `config.yml` :

```yaml
github:
  token: "Mettez le token GitHub ici"
  repo: "PSEUDO_GIT/NOM_DU_REPO"
  target_folder_plugin: "/out/" # Remplacez cela par l'emplacement du fichier .jar dans votre plugin (qui a été construit).

messages:
  noPermission: "&c&lErreur &c» Vous n'avez pas la permission d'utiliser cette commande."
  updateSuccess: "&a&lMAJ &a» Mise à jour des plugins en cours..."
```

<br><br>

🇬🇧: In English<br>
To ensure the plugin works correctly, please visit GitHub (https://github.com/settings/tokens) and create a new token with the "repo" permission (it's recommended to enable all permissions to avoid any issues). Then, navigate to the config.yml file:

```yaml
github:
  token: "Insert your GitHub token here"
  repo: "USERNAME/REPO_NAME"
  target_folder_plugin: "/out/" # Replace this with the path to the .jar file in your plugin (that has been built).

messages:
  noPermission: "&c&lError &c» You do not have permission to use this command."
  updateSuccess: "&a&lUpdate &a» Updating plugins..."
```
