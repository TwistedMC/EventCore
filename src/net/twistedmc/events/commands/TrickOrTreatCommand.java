package net.twistedmc.events.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import net.twistedmc.events.Main;
public class TrickOrTreatCommand implements CommandExecutor, Listener {
    @SuppressWarnings("unused")
    private Main core;
    public TrickOrTreatCommand(Main core) {
        this.core = core;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return false;
    }
}
