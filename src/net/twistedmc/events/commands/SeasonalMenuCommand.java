package net.twistedmc.events.commands;

import net.twistedmc.events.inventorys.MainMenu;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;

public class SeasonalMenuCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("seasonal")) {
            if (sender.hasPermission("twisted.cstore.blocked")) {
                sender.sendMessage(c.red + "I'm sorry, but you have been blocked from using the TwistedMC Seasonal Store.");
                return false;
            }
            Player pp = (Player) sender;

            if (Main.systemDisabled("seasonalMenu")) {
                sender.sendMessage(c.red + c.bold + "Sorry! " + c.red + "This system is currently disabled! Try again shortly.");
                return false;
            }

            new MainMenu(pp);


        }

        return false;
    }
}
