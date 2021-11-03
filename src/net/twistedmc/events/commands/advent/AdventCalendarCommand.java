package net.twistedmc.events.commands.advent;

import net.twistedmc.events.inventorys.advent.AdventCalendar;
import net.twistedmc.events.inventorys.advent.AdventCalendarTestMenu;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import twistedmc.core.util.api.API;
import twistedmc.core.util.color.c;

import java.text.ParseException;

public class AdventCalendarCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("adventcalendar")) {
            Player p = (Player) sender;

            if (API.systemDisabled("adventCalendar")) {
                p.sendMessage(c.bold + "Sorry! " + c.red + "The Advent Calendar is currently disabled!");
                return false;
            }

            try {
                new AdventCalendarTestMenu(p);
            } catch (ParseException e) {
                p.sendMessage(c.red + "An error occurred while getting your Advent Calendar! Please contact an administrator. (Error code: 1)");
                e.printStackTrace();
            }


        }

        return false;
    }
}
