package net.twistedmc.events.listeners;

import net.twistedmc.events.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class SuggestionsManager implements Listener {

    private Main plugin;

    public SuggestionsManager(final Main plugin) {
        this.plugin = plugin;
        if (plugin.getServer().getVersion().contains("1.17")) {
            plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
        }
    }

    @EventHandler
    public void onCommandSend(final PlayerCommandSendEvent event) {
        final List<String> commands = new ArrayList<String>(event.getCommands());
        final List<String> suggestions = (List<String>)this.plugin.getConfig().getStringList("suggestionsWhitelist");
        if (this.plugin.getConfig().getBoolean("reverse-suggestionsWhitelist")) {
            event.getCommands().removeAll(suggestions);
        }
        else {
            commands.forEach(s -> {
                if (!suggestions.contains(s)) {
                    event.getCommands().remove(s);
                }
            });
        }
    }



}
