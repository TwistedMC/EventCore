package net.twistedmc.events.commands.advent;

import net.twistedmc.api.util.c;
import net.twistedmc.events.inventorys.advent.AdventCalendar;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.ParseException;

public class AdventCalendarCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("adventcalendar")) {
            Player p = (Player) sender;

            if (net.twistedmc.api.API.systemDisabled("adventCalendar")) {
                p.sendMessage(c.red + c.bold + "Sorry! " + c.red + "The Advent Calendar is currently disabled!");
                return false;
            }

            try {
                new AdventCalendar(p);
            } catch (ParseException e) {
                p.sendMessage(c.red + "An error occurred while getting your Advent Calendar! Please contact an administrator. (Error code: 1)");
                e.printStackTrace();
            }


        }

        return false;
    }
}
