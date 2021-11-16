package net.twistedmc.events.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.twistedmc.events.inventorys.globalevents.GlobalMenu;

public class GlobalMenuTestCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("snowflakecontribution")) {
          
            Player pp = (Player) sender;

            new GlobalMenu(pp);

            return true;
        }

        return false;
    }
}
