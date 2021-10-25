package net.twistedmc.events.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;
import net.twistedmc.events.data.c;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class JoinListener implements Listener {

    static Main plugin = Main.getInstance();

    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent e) {
        if (Main.getConnection() == null) {
                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "There was an error with the database, please try again in a minute. If the problem persists, please contact an administrator with the code (N9TT-9G0A)");
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void discordRewards(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("twisted.discord.events.counting")) {
            p.sendMessage(c.gray + "--------------------------------------------");
            p.sendMessage(c.green + c.bold + "Congratulations! " + c.green + "Here is some rewards for reaching the counting goal!");
            p.sendMessage(c.blue + "➜ " + c.gold + "+1,500 Gold");
            p.sendMessage(c.blue + "➜ " + c.yellow + "+350 Coins");
            p.sendMessage(c.blue + "➜ " + c.red + "+3x Ultra Crate Key");
            p.sendMessage(c.gray + "--------------------------------------------");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 2.0F);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "eco give " + p.getName() + " 1500");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "coins add " + p.getName() + " 350");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate give p ultra 3 " + p.getName());
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " permission set twisted.discord.events.counting false");
            return;
        }
    }
/**
    @EventHandler(priority = EventPriority.HIGH)
    public void summerEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        TextComponent click = new TextComponent(c.yellow + "CLICK " + c.green + "to participate!");
        click.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/events"));
        click.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(c.yellow + "Click!").create()));

        int progress = 0;
        try {
            MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT progress VALUE FROM progress WHERE uuid = '" + p.getUniqueId() + "'");
            while (result.next()) {
                progress = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " permission set twisted.events.redeem.reward true");

        if (progress != 20) {
            p.sendMessage(c.gray + "--------------------------------------------");
            p.sendMessage(c.green + c.bold + "Our Summer Event is active!");
            p.sendMessage(c.green + "Win prizes up to a " + c.aqua + "1x VIP Rank (30 days) Voucher");
            p.sendMessage(c.green + "");
            p.spigot().sendMessage(click);
            p.sendMessage(c.gray + "--------------------------------------------");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 2.0F);
            return;
        }
    }*/


    @EventHandler(priority = EventPriority.LOWEST)
    public void eventJoin(PlayerLoginEvent e) {
        Player player = e.getPlayer();
        if(!hasJoined(player.getUniqueId())) {
            try {
                MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                Statement statement = MySQL.openConnection().createStatement();
                statement.executeUpdate("INSERT INTO progress (UUID, progress) VALUES ('" + player.getUniqueId() + "', '0')");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }

        if(!hasJoinedE(player.getUniqueId())) {
            String sqlHostE = "173.44.44.251";
            String sqlPortE = "3306";
            String sqlDbE = "network_events?useSSL=false";
            String sqlUserE = "network_events";
            String sqlPwE = "mDYvjpZIbj1CZjGD";

            try {
                MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                Statement statement = MySQL.openConnection().createStatement();
                statement.executeUpdate("INSERT INTO networkEvents (UUID, eventsCompleted, rewardsClaimed, claimableRewards) VALUES ('" + player.getUniqueId() + "', '0', '0', '0')");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }

        if(!inCandyCurrencyDB(player.getUniqueId())) {
            String sqlHostCurrency = "173.44.44.251";
            String sqlPortCurrency = "3306";
            String sqlDbCurrency = "currency?useSSL=false";
            String sqlUserCurrency = "currency";
            String sqlPwCurrency = "GDfn7YcSr5gcktDr";
            try {
                MySQL MySQL = new MySQL(sqlHostCurrency, sqlPortCurrency, sqlDbCurrency, sqlUserCurrency, sqlPwCurrency);
                Statement statement = MySQL.openConnection().createStatement();
                statement.executeUpdate("INSERT INTO candy (uuid, candy) VALUES ('" + player.getUniqueId() + "', '0')");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }

        if(!inSnowflakesCurrencyDB(player.getUniqueId())) {
            String sqlHostCurrency = "173.44.44.251";
            String sqlPortCurrency = "3306";
            String sqlDbCurrency = "currency?useSSL=false";
            String sqlUserCurrency = "currency";
            String sqlPwCurrency = "GDfn7YcSr5gcktDr";
            try {
                MySQL MySQL = new MySQL(sqlHostCurrency, sqlPortCurrency, sqlDbCurrency, sqlUserCurrency, sqlPwCurrency);
                Statement statement = MySQL.openConnection().createStatement();
                statement.executeUpdate("INSERT INTO snowflakes (uuid, snowflakes) VALUES ('" + player.getUniqueId() + "', '0')");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }

        if(!inSnowflakesCurrencyDB(player.getUniqueId())) {
            String sqlHostCurrency = "173.44.44.251";
            String sqlPortCurrency = "3306";
            String sqlDbCurrency = "currency?useSSL=false";
            String sqlUserCurrency = "currency";
            String sqlPwCurrency = "GDfn7YcSr5gcktDr";
            try {
                MySQL MySQL = new MySQL(sqlHostCurrency, sqlPortCurrency, sqlDbCurrency, sqlUserCurrency, sqlPwCurrency);
                Statement statement = MySQL.openConnection().createStatement();
                statement.executeUpdate("INSERT INTO snowflakes (uuid, snowflakes) VALUES ('" + player.getUniqueId() + "', '0')");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }

        if(!inAdventCalendarDB(player.getUniqueId())) {
            try {
                MySQL MySQL = new MySQL(Main.sqlHostAdvent, Main.sqlPortAdvent, Main.sqlDbAdvent, Main.sqlUserAdvent, Main.sqlPwAdvent);
                Statement statement = MySQL.openConnection().createStatement();
                statement.executeUpdate("INSERT INTO adventCalendar (uuid, openedWindow) VALUES ('" + player.getUniqueId() + "', '0')");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }
    }
    public static boolean hasJoined(UUID uuid){
        try {
            MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM progress WHERE UUID = '" + uuid.toString() + "'");
            while(res.next()){
                return res.getString("uuid") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasJoinedE(UUID uuid){
        String sqlHostE = "173.44.44.251";
        String sqlPortE = "3306";
        String sqlDbE = "network_events?useSSL=false";
        String sqlUserE = "network_events";
        String sqlPwE = "mDYvjpZIbj1CZjGD";

        try {
            MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM networkEvents WHERE UUID = '" + uuid.toString() + "'");
            while(res.next()){
                return res.getString("uuid") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean inCandyCurrencyDB(UUID uuid){
         String sqlHostCurrency = "173.44.44.251";
         String sqlPortCurrency = "3306";
         String sqlDbCurrency = "currency?useSSL=false";
         String sqlUserCurrency = "currency";
         String sqlPwCurrency = "GDfn7YcSr5gcktDr";
        try {
            MySQL MySQL = new MySQL(sqlHostCurrency, sqlPortCurrency, sqlDbCurrency, sqlUserCurrency, sqlPwCurrency);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM candy WHERE UUID = '" + uuid.toString() + "'");
            while(res.next()){
                return res.getString("uuid") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean inSnowflakesCurrencyDB(UUID uuid){
        String sqlHostCurrency = "173.44.44.251";
        String sqlPortCurrency = "3306";
        String sqlDbCurrency = "currency?useSSL=false";
        String sqlUserCurrency = "currency";
        String sqlPwCurrency = "GDfn7YcSr5gcktDr";
        try {
            MySQL MySQL = new MySQL(sqlHostCurrency, sqlPortCurrency, sqlDbCurrency, sqlUserCurrency, sqlPwCurrency);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM snowflakes WHERE UUID = '" + uuid.toString() + "'");
            while(res.next()){
                return res.getString("uuid") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean inAdventCalendarDB(UUID uuid){
        try {
            MySQL MySQL = new MySQL(Main.sqlHostAdvent, Main.sqlPortAdvent, Main.sqlDbAdvent, Main.sqlUserAdvent, Main.sqlPwAdvent);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM adventCalendar WHERE UUID = '" + uuid.toString() + "'");
            while(res.next()){
                return res.getString("uuid") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


}
