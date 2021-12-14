package me.codedcrown.joinmessages;

import me.codedcrown.joinmessages.join.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinMessages extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        new JoinListener(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
