# MinecraftServerAutoPush

🇫🇷 : En français
Pour pouvoir faire fonctionner le plugin correctement. Il faut se rendre sur github (https://github.com/settings/tokens) et créer un nouveau token avec comme permission "repo" (mettez toute les permissions cela pourrait faire des erreurs sinon). Ensuite rendez vous dans le config.yml:
```
github:
  token: "Mettez le token github"
  repo: "PSEUDO_GIT/NOM_DU_REPO"
  target_folder_plugin: "/out/" # Remplacez ça par l'emplacement du .jar dans votre plugin (qui a été build).

messages:
  noPermission: "&c&lErreur &c» Vous n'avez pas la permission d'utiliser cette commande."
  updateSuccess: "&a&lMAJ &a» Mise à jour des plugins en cours..."
```
