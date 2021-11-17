package net.twistedmc.events.commands.advent;

import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
<<<<<<< HEAD
import twistedmc.core.util.api.API;

public class ToggleArmorStandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if (cmd.getName().equalsIgnoreCase("toggleacas")) {
            Player p = (Player) sender;
            if (!p.hasPermission("rank.owner")) {
                sender.sendMessage(c.red + "I'm sorry, but you do not have permission to do that.");
                return false;
            }

            if (API.systemDisabled("adventCalendarNpc")) {
                sender.sendMessage(c.green + "Enabled System: " + c.yellow + "Advent Calendar Figure");
                API.enableSystem("adventCalendarNpc");
                return false;
            }

            if (!API.systemDisabled("halloween")) {
                sender.sendMessage(c.green + "Disabled adventCalendarNpc: " + c.yellow + "Advent Calendar Figure");
                API.disableSystem("adventCalendarNpc");
                return false;
=======

public class ToggleArmorStandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender,Command cmd,String label,String[] args) {
        if (cmd.getName().equalsIgnoreCase("toggleacas")) {
            Player p = (Player) commandSender;
            if (!p.hasPermission("rank.owner")) {
                commandSender.sendMessage(c.red + "I'm sorry, but you do not have permission to do that.");
                return false;
            }

            if (Main.ACArmorStandEnabled == true) {
                Main.ACArmorStandEnabled = false;
                p.sendMessage(c.red + "Disabled the ACArmorStand's click detection.");
            } else {
                Main.ACArmorStandEnabled = true;
                p.sendMessage(c.green + "Enabled the ACArmorStand's click detection.");
>>>>>>> origin/master
            }

        }
        return false;
    }
}
