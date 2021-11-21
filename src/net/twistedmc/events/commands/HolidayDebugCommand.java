package net.twistedmc.events.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.configuration.PlaceholderAPIConfig;
import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;
import net.twistedmc.events.data.c;
import net.twistedmc.events.placeholders.PlaceholderListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HolidayDebugCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender,  Command cmd,  String label,  String[] args) {
        if (cmd.getName().equalsIgnoreCase("holidaydebug")) {
            if ((commandSender instanceof Player)) {
                Player plr = (Player) commandSender;
                if (plr.hasPermission("rank.owner")) {
                    if (args.length > 1) {
                        plr.sendMessage(c.gray + c.strike + "------------------------------");
                        plr.sendMessage(c.red + c.bold + "Incorrect Usage!");
                        plr.sendMessage(c.red + "/holidebug (player) (info|short|medium|full/long)");
                        plr.sendMessage(c.gray + c.strike + "------------------------------");
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("info")) {
                        plr.sendMessage(c.gray +"This command will allow you to check different aspects within EventCore. From Placeholder Registration to Database Statuses.");
                        plr.sendMessage(c.gray + "Short will check only Placeholder Registry, Medium will check Short + Currency Databases,Long will Check Medium + All Databases Connections.");
                    }
                    if (args[0].equalsIgnoreCase("short")) {
                        String _1 = PlaceholderAPI.setPlaceholders(plr,"%events_registered%");
                        String _2 = PlaceholderAPI.setPlaceholders(plr,"%events_holidaycurrency");

                        plr.sendMessage(c.dgray + c.strike + "                                         ");
                        plr.sendMessage(c.gray + "EVENTCORE DEBUG DUMP | MODE: " + c.green + "SHORT");
                        plr.sendMessage("");
                        plr.sendMessage(c.gray + "Placeholders: " + _1);
                        plr.sendMessage(c.gray + "Holiday Currency: " + _2);
                        plr.sendMessage(c.gray + "");
                        plr.sendMessage(c.dgray + c.strike + "                                         ");

                    }
                    if (args[0].equalsIgnoreCase("medium")) {
                        String _1 = PlaceholderAPI.setPlaceholders(plr,"%events_registered%");
                        String _2 = PlaceholderAPI.setPlaceholders(plr,"%events_holidaycurrency");

                        plr.sendMessage(c.dgray + c.strike + "                                         ");
                        plr.sendMessage(c.gray + "EVENTCORE DEBUG DUMP | MODE: " + c.yellow + "MEDIUM");
                        plr.sendMessage("");
                        plr.sendMessage(c.gray + "Placeholders: " + _1);
                        plr.sendMessage(c.gray + "Holiday Currency: " + _2);
                        plr.sendMessage(c.gray + "");
                        try {
                            MySQL MySQL_Currency = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                            Statement statement = MySQL_Currency.openConnection().createStatement();
                            ResultSet set1 = statement.executeQuery("SELECT * FROM `snowflakes`");
                            while(set1.next()) {
                                plr.sendMessage(c.gray + "Snowflakes Database: " + c.green + c.bold + "OPERATIONAL");
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            plr.sendMessage(c.gray + "Snowflakes Database: " + c.red + c.bold + "ERROR OCCURRED, SEE CONSOLE.");
                            e.printStackTrace();
                        }
                        try {
                            MySQL MySQL_Currency = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                            Statement statement2 = MySQL_Currency.openConnection().createStatement();
                            ResultSet set2 = statement2.executeQuery("SELECT * FROM `candy`");
                            while(set2.next()) {
                                plr.sendMessage(c.gray + "Candies Database: " + c.green + c.bold + "OPERATIONAL");
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            plr.sendMessage(c.gray + "Candies Database: " + c.red + c.bold + "ERROR OCCURRED, SEE CONSOLE.");
                            e.printStackTrace();
                        }
                        plr.sendMessage("");
                        plr.sendMessage(c.dgray + c.strike + "                                         ");
                    }
                    if (args[0].equalsIgnoreCase("full")) {
                        String _1 = PlaceholderAPI.setPlaceholders(plr,"%events_registered%");
                        String _2 = PlaceholderAPI.setPlaceholders(plr,"%events_holidaycurrency");

                        plr.sendMessage(c.dgray + c.strike + "                                         ");
                        plr.sendMessage(c.gray + "EVENTCORE DEBUG DUMP | MODE: " + c.yellow + "MEDIUM");
                        plr.sendMessage("");
                        plr.sendMessage(c.gray + "Placeholders: " + _1);
                        plr.sendMessage(c.gray + "Holiday Currency: " + _2);
                        plr.sendMessage(c.gray + "");
                        try {
                            MySQL MySQL_Currency = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                            Statement statement = MySQL_Currency.openConnection().createStatement();
                            ResultSet set1 = statement.executeQuery("SELECT * FROM `snowflakes`");
                            while(set1.next()) {
                                plr.sendMessage(c.gray + "Snowflakes Database: " + c.green + c.bold + "OPERATIONAL");
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            plr.sendMessage(c.gray + "Snowflakes Database: " + c.red + c.bold + "ERROR OCCURRED, SEE CONSOLE.");
                            e.printStackTrace();
                        }
                        try {
                            MySQL MySQL_Currency = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
                            Statement statement2 = MySQL_Currency.openConnection().createStatement();
                            ResultSet set2 = statement2.executeQuery("SELECT * FROM `candy`");
                            while(set2.next()) {
                                plr.sendMessage(c.gray + "Candies Database: " + c.green + c.bold + "OPERATIONAL");
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            plr.sendMessage(c.gray + "Candies Database: " + c.red + c.bold + "ERROR OCCURRED, SEE CONSOLE.");
                            e.printStackTrace();
                        }
                        try {
                            MySQL MySQL = new MySQL(Main.sqlHostContribution, Main.sqlPortContribution, Main.sqlDbContribution, Main.sqlUserContribution, Main.sqlPwContribution);
                            Statement st = MySQL.openConnection().createStatement();
                            ResultSet s = st.executeQuery("SELECT * FROM `contribution`");
                            while(s.next()){
                                plr.sendMessage(c.gray + "Contribution Database: " + c.green + c.bold + "OPERATIONAL");
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                            plr.sendMessage(c.gray + "Contribution Database: " + c.red + c.bold + "ERROR OCCURRED, SEE CONSOLE.");
                        }


                        plr.sendMessage("");
                        plr.sendMessage(c.dgray + c.strike + "                                         ");
                    }
                }
                return false;
            } else {

            }
            return false;
        }
        return false;
    }
}
