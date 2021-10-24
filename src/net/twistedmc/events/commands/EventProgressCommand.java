package net.twistedmc.events.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import net.luckperms.api.LuckPermsProvider;
import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;
import net.twistedmc.events.data.c;
import net.twistedmc.events.listeners.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class EventProgressCommand implements CommandExecutor {

    private Main plugin;

    public EventProgressCommand(Main main) {
        this.plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("eventprogress")) {
            if (!sender.hasPermission("rank.admin")) {
                sender.sendMessage(c.red + "I'm sorry, but you do not have permission to do that.");
                return false;
            }

            if (args.length < 2) {
                sender.sendMessage(c.gray + c.strike + "------------------------------");
                sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                sender.sendMessage(c.red + "/eventprogress (player) (get|set|add|reset|block) (set amount)");
                sender.sendMessage(c.gray + c.strike + "------------------------------");
                return false;
            }

            UUID uuid = null;

            Player t = Bukkit.getPlayer(args[0]);

            OfflinePlayer ot = null;

            if(t != null){

                uuid = t.getUniqueId();

            }else{

                ot = Bukkit.getOfflinePlayer(args[0]);

                uuid = ot.getUniqueId();

            }

            if(!JoinListener.hasJoined(uuid)){

                sender.sendMessage(c.red + "We are sorry, but we cannot find a player with the username " + c.red + c.bold + args[0] + c.red + " in our database.");

                return false;

            }


            int progress = 0;

            Player target = Bukkit.getServer().getPlayer(args[0]);
            OfflinePlayer op = Bukkit.getServer().getOfflinePlayer(args[0]);

            if (target == null) {

                if (args[1].equalsIgnoreCase("get")) {

                    try {
                        MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                        Statement statement = MySQL.openConnection().createStatement();
                        ResultSet result = statement.executeQuery("SELECT progress VALUE FROM progress WHERE uuid = '" + op.getUniqueId() + "'");
                        while (result.next()) {
                            progress = result.getInt("VALUE");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    String totalProgress = PlaceholderAPI.setPlaceholders(target, "%events_progresstotal%");

                    sender.sendMessage(c.yellow + op.getName() + c.green + "'s Event Progress Stats:");
                    sender.sendMessage(c.green + "Progress: " + c.yellow + progress + c.white + "/" + c.yellow + totalProgress);
                    return false;
                }


                if (args[1].equalsIgnoreCase("add")) {

                    try {
                        MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                        Statement statement = MySQL.openConnection().createStatement();
                        statement.executeUpdate("UPDATE `progress` SET progress = progress + 1 WHERE UUID = '" + op.getUniqueId() + "'");
                    } catch (SQLException | ClassNotFoundException s) {
                        s.printStackTrace();
                    }

                    sender.sendMessage(c.green + "Added " + c.yellow + "+1" + c.green + " Progress Point to " + c.yellow + op.getName() + c.green + "!");
                    return false;
                }

                if (args[1].equalsIgnoreCase("set")) {

                    if (args.length < 3) {
                        sender.sendMessage(c.gray + c.strike + "------------------------------");
                        sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                        sender.sendMessage(c.red + "/eventprogress (player) (get|set|add|reset|block) (set amount)");
                        sender.sendMessage(c.gray + c.strike + "------------------------------");
                        return false;
                    }

                    try {
                        MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                        Statement statement = MySQL.openConnection().createStatement();
                        statement.executeUpdate("UPDATE `progress` SET progress = " + args[2] + " WHERE UUID = '" + op.getUniqueId() + "'");
                    } catch (SQLException | ClassNotFoundException s) {
                        s.printStackTrace();
                    }

                    sender.sendMessage(c.green + "Set " + c.yellow + op.getName() + c.green + "'s Progress Points to " + c.yellow + args[2] + c.green + "!");
                    return false;
                }


                if (args[1].equalsIgnoreCase("reset")) {

                    try {
                        MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                        Statement statement = MySQL.openConnection().createStatement();
                        statement.executeUpdate("UPDATE `progress` SET progress = 0 WHERE UUID = '" + op.getUniqueId() + "'");
                    } catch (SQLException | ClassNotFoundException s) {
                        s.printStackTrace();
                    }

                    sender.sendMessage(c.green + "Reset " + c.yellow + op.getName() + c.green + "'s Event Progress!");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + op.getName() + " permission set quests.quest.events1 true");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + op.getName() + " permission set twisted.events.redeemed.reward false");
                    return false;

                }

                if (args[1].equalsIgnoreCase("block")) {

                    if (offlineHasPermission(op.getUniqueId(), "twisted.events.blocked")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + op.getName() + " permission set twisted.events.blocked false");

                        sender.sendMessage(c.green + "Successfully unblocked " + c.yellow + op.getName() + c.green + "'s access to events!");
                        return false;
                    }

                    if (!offlineHasPermission(op.getUniqueId(), "twisted.events.blocked")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + op.getName() + " permission set twisted.events.blocked true");

                        sender.sendMessage(c.green + "Successfully blocked " + c.yellow + op.getName() + c.green + "'s access to events!");
                        return false;
                    }
                }

            }






            if (args[1].equalsIgnoreCase("get")) {

                try {
                    MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                    Statement statement = MySQL.openConnection().createStatement();
                    ResultSet result = statement.executeQuery("SELECT progress VALUE FROM progress WHERE uuid = '" + target.getUniqueId() + "'");
                    while (result.next()) {
                        progress = result.getInt("VALUE");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

                String totalProgress = PlaceholderAPI.setPlaceholders(op, "%events_progresstotal%");

                sender.sendMessage(c.yellow + target.getName() + c.green + "'s Event Progress Stats:");
                sender.sendMessage(c.green + "Progress: " + c.yellow + progress + c.white + "/" + c.yellow + totalProgress);
                return false;
            }


            if (args[1].equalsIgnoreCase("add")) {

                try {
                    MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                    Statement statement = MySQL.openConnection().createStatement();
                    statement.executeUpdate("UPDATE `progress` SET progress = progress + 1 WHERE UUID = '" + target.getUniqueId() + "'");
                } catch (SQLException | ClassNotFoundException s) {
                    s.printStackTrace();
                }

                sender.sendMessage(c.green + "Added " + c.yellow + "+1" + c.green + " Progress Point to " + c.yellow + target.getName() + c.green + "!");
                target.sendMessage(c.yellow + "+1 " + c.green + "Progress Point has been added to your Event Progress Point Total.");
                return false;
            }

            if (args[1].equalsIgnoreCase("set")) {

                if (args.length < 3) {
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                    sender.sendMessage(c.red + "/eventprogress (player) (get|set|add|reset|block) (set amount)");
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    return false;
                }

                try {
                    MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                    Statement statement = MySQL.openConnection().createStatement();
                    statement.executeUpdate("UPDATE `progress` SET progress = " + args[2] + " WHERE UUID = '" + target.getUniqueId() + "'");
                } catch (SQLException | ClassNotFoundException s) {
                    s.printStackTrace();
                }

                sender.sendMessage(c.green + "Set " + c.yellow + target.getName() + c.green + "'s Progress Points to " + c.yellow + args[2] + c.green + "!");
                target.sendMessage(c.green + "Your total Event Progress Points have been set to " + c.yellow + args[2] + c.green + "!");
                return false;
            }


            if (args[1].equalsIgnoreCase("reset")) {

                try {
                    MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                    Statement statement = MySQL.openConnection().createStatement();
                    statement.executeUpdate("UPDATE `progress` SET progress = 0 WHERE UUID = '" + target.getUniqueId() + "'");
                } catch (SQLException | ClassNotFoundException s) {
                    s.printStackTrace();
                }

                sender.sendMessage(c.green + "Reset " + c.yellow + target.getName() + c.green + "'s Event Progress!");
                target.sendMessage(c.red + "[Notice] " + c.yellow + "Your event progress has been reset.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + target.getName() + " permission set quests.quest.events1 true");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + target.getName() + " permission set twisted.events.redeemed.reward false");
                return false;

            }

            if (args[1].equalsIgnoreCase("block")) {

                if (target.hasPermission("twisted.events.blocked")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + target.getName() + " permission set twisted.events.blocked false");

                    sender.sendMessage(c.green + "Successfully unblocked " + c.yellow + target.getName() + c.green + "'s access to events!");
                    target.sendMessage(c.red + "[Notice] " + c.yellow + "You have been unbanned from events.");
                    return false;
                }

                if (!target.hasPermission("twisted.events.blocked")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + target.getName() + " permission set twisted.events.blocked true");

                    sender.sendMessage(c.green + "Successfully blocked " + c.yellow + target.getName() + c.green + "'s access to events!");
                    target.sendMessage(c.red + "[Notice] " + c.yellow + "You have been banned from all future events.");
                    return false;
                }
            }
        }

        return false;
    }


    public boolean offlineHasPermission(UUID user, String permission) {
        return LuckPermsProvider.get().getUserManager().loadUser(user).join().getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }



}
