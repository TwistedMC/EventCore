package net.twistedmc.events.commands;

import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.connorlinfoot.titleapi.TitleAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;
import net.twistedmc.events.data.c;
import net.twistedmc.events.listeners.JoinListener;
import net.twistedmc.events.listeners.ToTListener;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import twistedmc.core.util.api.API;

import static net.md_5.bungee.api.chat.TextComponent.fromLegacyText;

public class HolidayCurrencyCommand implements CommandExecutor {
    // So this command will be an all in one for holiday currency manipulation. Similar to hcc's format,
    // it will be  /hcc (or whatever you select) <player> <currency> <function> <amount>.
    // Player is self-explanitory, Currency is any of the holiday currencies, function is add/set/remove/reset, and amount is the amount to add/remove/set. 
    //Reset has no amount argument.
    private Main plugin;
    NumberFormat f = NumberFormat.getInstance();
    private static String currencyTab = "";
    private static String holidayCurrency = "";
    private static String holidayCurrencyNoColor = "";
    private static String holidayColor = "";
    public static void HCCSetup() {
        Bukkit.getLogger().log(Level.CONFIG, "[Events] Setting up HCC.");
        if (Main.holiday == "halloween") {
            currencyTab = "candy";
            holidayCurrency = c.gold + "candies";
            holidayCurrencyNoColor = "candies";
            holidayColor = c.gold;
            Bukkit.getLogger().log(Level.CONFIG, "[Events] Chosen Currency: Flakes");
        } else if (Main.holiday == "christmas") {
            currencyTab = "snowflakes";
            holidayCurrency = c.white + "snowflakes";
            holidayCurrencyNoColor = "snowflakes";
            holidayColor = c.white;
            Bukkit.getLogger().log(Level.CONFIG, "[Events] Chosen Currency: Snowflakes.");
        }
        Bukkit.getLogger().log(Level.CONFIG, "[Events] HCC Setup Complete.");
    }
    
    public HolidayCurrencyCommand(Main main) {
        this.plugin = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (cmd.getName().equalsIgnoreCase("hcc")) {
            if (!sender.hasPermission("rank.admin")) {
                sender.sendMessage(c.red + "I'm sorry, but you do not have permission to do that.");
                return false;
            }

            if (args.length < 2) {
                sender.sendMessage(c.gray + c.strike + "------------------------------");
                sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                sender.sendMessage(c.red + "/hcc (player) (get|set|add|remove|reset|block) (add amount)");
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

            if(!!JoinListener.inSnowflakesCurrencyDB(uuid)){

                sender.sendMessage(c.red + "We are sorry, but we cannot find a player with the username " + c.red + c.bold + args[0] + c.red + " in our database.");

                return false;

            }


            int currency = 0;

            Player target = Bukkit.getServer().getPlayer(args[0]);
            OfflinePlayer op = Bukkit.getServer().getOfflinePlayer(args[0]);
            String currencyPlaceholder = PlaceholderAPI.setPlaceholders(target, "%events_holidaycurrency%");
            String currencyPlaceholderNoColor = PlaceholderAPI.setPlaceholders(target, "%events_holidaycurrencynocolor%");
            String color = PlaceholderAPI.setPlaceholders(target, "%events_color%");
            if (target == null) {

                if (args[1].equalsIgnoreCase("get")) {

                    try {
                        MySQL MySQL = new MySQL(plugin.sqlHostCurrency, plugin.sqlPortCurrency, plugin.sqlDbCurrency, plugin.sqlUserCurrency, plugin.sqlPwCurrency);
                        Statement statement = MySQL.openConnection().createStatement();
                        ResultSet result = statement.executeQuery("SELECT " + currencyTab + " VALUE FROM `" + currencyTab + "` WHERE uuid = '" + op.getUniqueId() + "'");
                        while (result.next()) {
                            currency = result.getInt("VALUE");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }


                    sender.sendMessage(c.yellow + op.getName() + c.green + " has " + holidayColor + currency + " " + holidayCurrency + c.green + ".");;
                    return false;
                }


                if (args[1].equalsIgnoreCase("add")) {
                    if (args.length < 3) {
                        sender.sendMessage(c.gray + c.strike + "------------------------------");
                        sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                        sender.sendMessage(c.red + "/hcc (player) (get|set|add|remove|reset|block) (add amount)");
                        sender.sendMessage(c.gray + c.strike + "------------------------------");
                        return false;
                    }

                    try {
                        MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                        Statement statement = MySQL.openConnection().createStatement();
                        statement.executeUpdate("UPDATE `" + currencyTab + "` SET " + currencyTab + " = " + currencyTab + " + " + args[2] + " WHERE UUID = '" + op.getUniqueId() + "'");
                    } catch (SQLException | ClassNotFoundException s) {
                        s.printStackTrace();
                    }

                    API.addSnowflakesOffline(op, Integer.parseInt(args[2]));

                    sender.sendMessage(c.green + "Added " + c.yellow + args[2] + c.green + " " + holidayCurrencyNoColor + " to " + c.yellow + op.getName() + c.green + "!");
                    return false;
                }

                if (args[1].equalsIgnoreCase("remove")) {
                    if (args.length < 3) {
                        sender.sendMessage(c.gray + c.strike + "------------------------------");
                        sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                        sender.sendMessage(c.red + "/hcc (player) (get|set|add|remove|reset|block) (remove amount)");
                        sender.sendMessage(c.gray + c.strike + "------------------------------");
                        return false;
                    }

                    try {
                        MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                        Statement statement = MySQL.openConnection().createStatement();
                        statement.executeUpdate("UPDATE `" + currencyTab + "` SET " + currencyTab + " = " + currencyTab + " - " + args[2] + " WHERE UUID = '" + op.getUniqueId() + "'");
                    } catch (SQLException | ClassNotFoundException s) {
                        s.printStackTrace();
                    }

                    sender.sendMessage(c.green + "Removed " + c.yellow + args[2] + c.green + " " + holidayCurrencyNoColor + " to " + c.yellow + op.getName() + c.green + "!");
                    return false;
                }

                if (args[1].equalsIgnoreCase("set")) {

                    if (args.length < 3) {
                        sender.sendMessage(c.gray + c.strike + "------------------------------");
                        sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                        sender.sendMessage(c.red + "/hcc (player) (get|set|add|remove|reset|block) (add amount)");
                        sender.sendMessage(c.gray + c.strike + "------------------------------");
                        return false;
                    }

                    try {
                        MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                        Statement statement = MySQL.openConnection().createStatement();
                        statement.executeUpdate("UPDATE `" + currencyTab + "` SET " + currencyTab + " = " + args[2] + " WHERE UUID = '" + op.getUniqueId() + "'");
                    } catch (SQLException | ClassNotFoundException s) {
                        s.printStackTrace();
                    }

                    API.setSnowflakes(op, Integer.parseInt(args[2]));

                    sender.sendMessage(c.green + "Set " + c.yellow + op.getName() + c.green + "'s " + holidayCurrencyNoColor + " to " + c.yellow + args[2] + c.green + "!");
                    return false;
                }


                if (args[1].equalsIgnoreCase("reset")) {

                    try {
                        MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                        Statement statement = MySQL.openConnection().createStatement();
                        statement.executeUpdate("UPDATE `" + currencyTab + "` SET " + currencyTab + " = 0 WHERE UUID = '" + op.getUniqueId() + "'");
                    } catch (SQLException | ClassNotFoundException s) {
                        s.printStackTrace();
                    }

                    API.resetSnowflakes(op);

                    sender.sendMessage(c.green + "Reset " + c.yellow + op.getName() + c.green + "'s " + holidayCurrencyNoColor + c.green + " currency!");
                    return false;

                }

               /* if (args[1].equalsIgnoreCase("block")) {

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
                } */

            }


            if (args[1].equalsIgnoreCase("get")) {

                try {
                    MySQL MySQL = new MySQL(plugin.sqlHostCurrency, plugin.sqlPortCurrency, plugin.sqlDbCurrency, plugin.sqlUserCurrency, plugin.sqlPwCurrency);
                    Statement statement = MySQL.openConnection().createStatement();
                    ResultSet result = statement.executeQuery("SELECT " + currencyTab + " VALUE FROM `" + currencyTab + "` WHERE uuid = '" + target.getUniqueId() + "'");
                    while (result.next()) {
                        currency = result.getInt("VALUE");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }


                sender.sendMessage(c.yellow + target.getName() + c.green + " has " + color + currency + " " + currencyPlaceholder + c.green + ".");;
                return false;
            }


            if (args[1].equalsIgnoreCase("add")) {
                if (args.length < 3) {
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                    sender.sendMessage(c.red + "/hcc (player) (get|set|add|remove|reset|block) (add amount)");
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    return false;
                }

                try {
                    MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                    Statement statement = MySQL.openConnection().createStatement();
                    statement.executeUpdate("UPDATE `" + currencyTab + "` SET " + currencyTab + " = " + currencyTab + " + " + args[2] + " WHERE UUID = '" + target.getUniqueId() + "'");
                } catch (SQLException | ClassNotFoundException s) {
                    s.printStackTrace();
                }

                API.addSnowflakes(target, Integer.parseInt(args[2]));

                sender.sendMessage(c.green + "Added " + c.yellow + args[2] + c.green + " " + currencyPlaceholderNoColor + " to " + c.yellow + target.getName() + c.green + "!");
                NumberFormat f = NumberFormat.getInstance();
                if (Main.holiday.equalsIgnoreCase("christmas")) {
                    Integer inte = Integer.parseInt(args[2]); // Some stupidly complex conversion because yes -N
                    int in = inte.intValue();
                    String val = f.format(in);
                    TitleAPI.sendTitle(target, 3, 40, 5, c.aqua + "+" + val + c.white + "❄", "");
                }
                return false;
            }

            if (args[1].equalsIgnoreCase("remove")) {
                if (args.length < 3) {
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                    sender.sendMessage(c.red + "/hcc (player) (get|set|add|remove|reset|block) (remove amount)");
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    return false;
                }

                try {
                    MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                    Statement statement = MySQL.openConnection().createStatement();
                    statement.executeUpdate("UPDATE `" + currencyTab + "` SET " + currencyTab + " = " + currencyTab + " - " + args[2] + " WHERE UUID = '" + target.getUniqueId() + "'");
                } catch (SQLException | ClassNotFoundException s) {
                    s.printStackTrace();
                }

                sender.sendMessage(c.green + "Removed " + c.yellow + args[2] + c.green + " " + holidayCurrencyNoColor + " to " + c.yellow + target.getName() + c.green + "!");
                return false;
            }

            if (args[1].equalsIgnoreCase("set")) {

                if (args.length < 3) {
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    sender.sendMessage(c.red + c.bold + "Incorrect Usage!");
                    sender.sendMessage(c.red + "/hcc (player) (get|set|add|remove|reset|block) (add amount)");
                    sender.sendMessage(c.gray + c.strike + "------------------------------");
                    return false;
                }

                try {
                    MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                    Statement statement = MySQL.openConnection().createStatement();
                    statement.executeUpdate("UPDATE `" + currencyTab + "` SET " + currencyTab + " = " + args[2] + " WHERE UUID = '" + target.getUniqueId() + "'");
                } catch (SQLException | ClassNotFoundException s) {
                    s.printStackTrace();
                }

                API.setSnowflakes(target, Integer.parseInt(args[2]));

                sender.sendMessage(c.green + "Set " + c.yellow + target.getName() + c.green + "'s " + currencyPlaceholderNoColor + " to " + c.yellow + args[2] + c.green + "!");
                return false;
            }


            if (args[1].equalsIgnoreCase("reset")) {

                try {
                    MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                    Statement statement = MySQL.openConnection().createStatement();
                    statement.executeUpdate("UPDATE `" + currencyTab + "` SET " + currencyTab + " = 0 WHERE UUID = '" + target.getUniqueId() + "'");
                } catch (SQLException | ClassNotFoundException s) {
                    s.printStackTrace();
                }

                API.resetSnowflakes(target);

                sender.sendMessage(c.green + "Reset " + c.yellow + target.getName() + c.green + "'s " + currencyPlaceholderNoColor + c.green + " currency!");
                return false;

            }

               /* if (args[1].equalsIgnoreCase("block")) {

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
                } */
            
            
        }
        
        return false;
    }


    public boolean offlineHasPermission(UUID user, String permission) {
        return LuckPermsProvider.get().getUserManager().loadUser(user).join().getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }

}