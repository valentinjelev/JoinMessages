package me.codedcrown.joinmessages.join;

import me.codedcrown.joinmessages.JoinMessages;
import me.codedcrown.joinmessages.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {
    private JoinMessages plugin;

    public JoinListener(JoinMessages plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage(
                    Utils.chat(plugin.getConfig().getString("firstJoin_message").replace("%player", p.getName())));
        } else {
            Bukkit.broadcastMessage(
                    Utils.chat(plugin.getConfig().getString("join_message").replace("%player", p.getName())));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent q) {
        Player p = q.getPlayer();

        Bukkit.broadcastMessage(
                Utils.chat(plugin.getConfig().getString("leave_message").replace("%player", p.getName())));
    }

}
