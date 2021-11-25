package net.twistedmc.events.commands.advent;

import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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

            if (!API.systemDisabled("adventCalendarNpc")) {
                sender.sendMessage(c.green + "Disabled System: " + c.yellow + "Advent Calendar Figure");
                API.disableSystem("adventCalendarNpc");
                return false;
            }
        }
        return false;
    }
}
