package net.twistedmc.events.commands;

import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import twistedmc.core.framework.ServerGameType;
import twistedmc.core.util.api.APICoins;

public class RankGiveCommand implements CommandExecutor {

    private static Main instance = Main.getInstance();
    private static String checkingfor = "rank.legend";
    private static String giving = "LEGEND RANK (25 DAYS)";
    private static String fallbackCommand = "givegold %s 45000 Winter Event Challenge Prize Compensation";
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rankgive")) {
            if ((sender instanceof Player)) {
                Player plr = (Player) sender;
                if (plr.hasPermission("rank.owner")) {
                    if (args.length == 0) {
                        plr.sendMessage(c.gray + c.strike + "------------------------------");
                        plr.sendMessage(c.red + c.bold + "Incorrect Usage!");
                        plr.sendMessage(c.red + "/rankgive (player) ");
                        plr.sendMessage(c.red + "Checking for: " + checkingfor);
                        plr.sendMessage(c.red + "Giving: " + giving);
                        plr.sendMessage(c.gray + c.strike + "------------------------------");
                        return false;
                    }
                    if (Bukkit.getServer().getPlayer(args[0]) != null) {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (!target.hasPermission(checkingfor)) {
                            String pcmd = String.format("storerank %s LEGENDEVENT",target.getName());
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),pcmd);
                        } else {
                            String pcmd = String.format(fallbackCommand,target.getName());
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),pcmd);
                            target.sendMessage(c.green + "You already have the rank of the prize you so have been compensated.");
                        }
                        return true;
                    } else {
                        plr.sendMessage(c.red + "I'm sorry, but the specified player " + c.bold + args[0] + c.red + " is not currently online.");
                    }
                } else {
                    plr.sendMessage(c.red + "You do not have access to this command.");
                    return false;
                }
                return false;
            } else {
                if (args.length == 0) {
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                    sender.sendMessage(c.red + "/rankgive (player) ");
                    sender.sendMessage(c.red + "Checking for: " + checkingfor);
                    sender.sendMessage(c.red + "Giving: " + giving);
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    return false;
                }
                if (Bukkit.getServer().getPlayer(args[0]) != null) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (!target.hasPermission(checkingfor)) {
                        String pcmd = String.format("storerank %s LEGENDEVENT",target.getName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),pcmd);
                    } else {
                        String pcmd = String.format(fallbackCommand,target.getName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),pcmd);
                        target.sendMessage(c.green + "You already have the rank of the prize you so have been compensated.");
                    }
                    return true;
                } else {
                    sender.sendMessage(c.red + "I'm sorry, but the specified player " + c.bold + args[0] + c.red + " is not currently online.");
                }
            }
        }
        return false;
    }
}
