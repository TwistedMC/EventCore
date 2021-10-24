package net.twistedmc.events.commands;

import net.twistedmc.events.inventorys.store.CandyStore;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import net.twistedmc.events.inventorys.MainMenu;

public class CurrencyStoreCommand implements CommandExecutor {
    private Main plugin;
    public CurrencyStoreCommand(Main main) {
        this.plugin = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("candy")) {
            if (sender.hasPermission("twisted.cstore.blocked")) {
                sender.sendMessage(c.red + "I'm sorry, but you have been blocked from using the TwistedMC Seasonal Store.");
                return false;
            } 
            Player pp = (Player) sender;

            if (Main.systemDisabled("halloweenSurvival")) {
                sender.sendMessage(c.red + "Halloween event not active!");
                return false;
            }

            new CandyStore(pp);


        }
        
        return false;
    }
}
