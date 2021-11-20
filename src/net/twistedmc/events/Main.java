package net.twistedmc.events;


import java.io.*;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.ranktw.DiscordWebHooks.DiscordEmbed;
import net.ranktw.DiscordWebHooks.DiscordMessage;
import net.ranktw.DiscordWebHooks.DiscordWebhook;
import net.ranktw.DiscordWebHooks.embed.FooterEmbed;
import net.twistedmc.events.commands.*;
import net.twistedmc.events.commands.advent.AdventCalendarCommand;
import net.twistedmc.events.data.c;
import net.twistedmc.events.inventorys.CandyStoreListener;
import net.twistedmc.events.inventorys.advent.*;
import net.twistedmc.events.inventorys.globalevents.MenuListener;
import net.twistedmc.events.listeners.JoinListener;
import net.twistedmc.events.listeners.SnowflakeListener;
import net.twistedmc.events.listeners.SuggestionsManager;
import net.twistedmc.events.listeners.ToTListener;
import net.twistedmc.events.commands.CandyStoreCommand;
import net.twistedmc.events.placeholders.PlaceholderListener;
import net.twistedmc.events.util.API;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import twistedmc.core.framework.ServerDataManager;
import twistedmc.core.framework.ServerType;

@SuppressWarnings("deprecated")
public class Main extends JavaPlugin implements Listener {

    public static List<UUID> mob = new ArrayList<>();
    public static List<UUID> mobSpawner = new ArrayList<>();

    private static ServerDataManager serverDataManager;
    //Holiday Configuration
    public static String holiday = "halloween"; // halloween, christmas, newyears, (add any here)
    public static Main instance;
    public static int GlobalGoal = 250000;
    public static boolean AllContributionGetsPrize = false; // Anybody who donates any snowflakes (even after the goal is reached) will get the prize
    //
    public String sqlHost = "173.44.44.251";
    public String sqlPort = "3306";
    public String sqlDb = "survivalEnchanted_events?useSSL=false";
    public String sqlUser = "survivalEnchanted_events";
    public String sqlPw = "4mHYCVVltvCmLVgF";
    MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);


    public static String sqlHostCurrency = "173.44.44.251";
    public static String sqlPortCurrency = "3306";
    public static String sqlDbCurrency = "currency?useSSL=false";
    public static String sqlUserCurrency = "currency";
    public static String sqlPwCurrency = "GDfn7YcSr5gcktDr";

    public static String sqlHostAdvent = "173.44.44.251";
    public static String sqlPortAdvent = "3306";
    public static String sqlDbAdvent = "events_advent?useSSL=false";
    public static String sqlUserAdvent = "events_advent";
    public static String sqlPwAdvent = "KoIGPn0JQ9tTi3qf";

    public static String sqlHostCP = "173.44.44.251";
    public static String sqlPortCP = "3306";
    public static String sqlDbCP = "events_candyStorePurchases?useSSL=false";
    public static String sqlUserCP = "events_candyStorePurchases";
    public static String sqlPwCP = "FhX1fK75qtsJAZS5";

    public static String sqlHostStats = "173.44.44.253";
    public static String sqlPortStats = "3306";
    public static String sqlDbStats = "networkStats?useSSL=false";
    public static String sqlUserStats = "networkStats";
    public static String sqlPwStats = "gKEB57G.jxu3_xAB";
    // Contribution Login Info
    public static String sqlHostContribution = "173.44.44.251";
    public static String sqlPortContribution = "3306";
    public static String sqlDbContribution = "events_main?useSSL=false";
    public static String sqlUserContribution = "events_main";
    public static String sqlPwContribution = "2LRyqtCbRkzcRFlI";

    public static Connection connection = null;

    public void onEnable() {

        serverDataManager = new ServerDataManager();

        getServerDataManager().setServerType(ServerType.MINIGAME);

        if (!serverInDB(getIP() + ":" + getServer().getPort())) {

            String webhook = "https://discord.com/api/webhooks/853063307137515550/_SFH-Kru3klRQ_2O4zh1TTi6FnGX-4pWeqaIcpBiM--DYkIpWnFdfmhUSfcwxqewe1Bv";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new java.awt.Color(255, 0, 21))
                    .withTitle("EVENT CORE DETECTED ON UNAUTHORIZED SERVER!")
                    .withDescription("SERVER IP: " + getIP() + ":" + getServer().getPort() +
                            "\nSERVER VERSION: " + Bukkit.getServer().getVersion() +
                            "\nSERVER MOTD: " + Bukkit.getServer().getMotd() +
                            "\n\nPLUGIN DISABLED. AND SERVER SHUTDOWN."
                    )
                    .withFooter(new FooterEmbed("TwistedMC Management Alerts", ""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);

            Bukkit.getLogger().log(Level.WARNING, "[EVENT CORE] Error while enabling!");

            new BukkitRunnable() {
                @Override
                public void run() {

                    getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("EventCore1.17"));
                    Bukkit.getServer().shutdown();

                }
            }.runTaskLater(this, 30);
            return;
        }

        Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
            public void run() {
                Date now = new java.sql.Date(System.currentTimeMillis());
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ssa 'ET'");

                if (getServerDataManager().getServerType() == ServerType.DEV) {
                    Bukkit.getLogger().log(Level.INFO, "[EVENT CORE] Time: " + format.format(now));
                }

                for (final Player p : Bukkit.getOnlinePlayers()) {

                    TextComponent click = new TextComponent(c.yellow + "Type /warp advent or click here to claim!");
                    click.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/advent"));
                    click.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(c.yellow + "Click to open Advent Calendar!").create()));

                    if (format.format(now).equals("11/30/2021 11:50:00PM ET")) {
                        // 1 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/01/2021 12:00:00AM ET")) {
                        // 1 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                    }


                    if (format.format(now).equals("12/01/2021 11:50:00PM ET")) {
                        // 2 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/02/2021 12:00:00AM ET")) {
                        // 2 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(1);
                    }


                    if (format.format(now).equals("12/02/2021 11:50:00PM ET")) {
                        // 3 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/03/2021 12:00:00AM ET")) {
                        // 3 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(2);
                    }


                    if (format.format(now).equals("12/03/2021 11:50:00PM ET")) {
                        // 4 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/04/2021 12:00:00AM ET")) {
                        // 4 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(3);
                    }


                    if (format.format(now).equals("12/04/2021 11:50:00PM ET")) {
                        // 5 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/05/2021 12:00:00AM ET")) {
                        // 5 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(4);
                    }


                    if (format.format(now).equals("12/05/2021 11:50:00PM ET")) {
                        // 6 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/06/2021 12:00:00AM ET")) {
                        // 6 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(5);
                    }


                    if (format.format(now).equals("12/06/2021 11:50:00PM ET")) {
                        // 7 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/07/2021 12:00:00AM ET")) {
                        // 7 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(6);
                    }


                    if (format.format(now).equals("12/07/2021 11:50:00PM ET")) {
                        // 8 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/08/2021 12:00:00AM ET")) {
                        // 8 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(7);
                    }


                    if (format.format(now).equals("12/08/2021 11:50:00PM ET")) {
                        // 9 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/09/2021 12:00:00AM ET")) {
                        // 9 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(8);
                    }


                    if (format.format(now).equals("12/09/2021 11:50:00PM ET")) {
                        // 10 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/10/2021 12:00:00AM ET")) {
                        // 10 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(9);
                    }


                    if (format.format(now).equals("12/10/2021 11:50:00PM ET")) {
                        // 11 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/11/2021 12:00:00AM ET")) {
                        // 11 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(10);
                    }


                    if (format.format(now).equals("12/11/2021 11:50:00PM ET")) {
                        // 12 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/12/2021 12:00:00AM ET")) {
                        // 12 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(11);
                    }


                    if (format.format(now).equals("12/12/2021 11:50:00PM ET")) {
                        // 13 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/13/2021 12:00:00AM ET")) {
                        // 13 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(12);
                    }


                    if (format.format(now).equals("12/13/2021 11:50:00PM ET")) {
                        // 14 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/14/2021 12:00:00AM ET")) {
                        // 14 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(13);
                    }


                    if (format.format(now).equals("12/14/2021 11:50:00PM ET")) {
                        // 15 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/15/2021 12:00:00AM ET")) {
                        // 15 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(14);
                    }


                    if (format.format(now).equals("12/15/2021 11:50:00PM ET")) {
                        // 16 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/16/2021 12:00:00AM ET")) {
                        // 16 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(15);
                    }


                    if (format.format(now).equals("12/16/2021 11:50:00PM ET")) {
                        // 17 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/17/2021 12:00:00AM ET")) {
                        // 17 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(16);
                    }


                    if (format.format(now).equals("12/17/2021 11:50:00PM ET")) {
                        // 18 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/18/2021 12:00:00AM ET")) {
                        // 18 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(17);
                    }


                    if (format.format(now).equals("12/18/2021 11:50:00PM ET")) {
                        // 19 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/19/2021 12:00:00AM ET")) {
                        // 19 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(18);
                    }


                    if (format.format(now).equals("12/19/2021 11:50:00PM ET")) {
                        // 20 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/20/2021 12:00:00AM ET")) {
                        // 20 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(19);
                    }


                    if (format.format(now).equals("12/20/2021 11:50:00PM ET")) {
                        // 21 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/21/2021 12:00:00AM ET")) {
                        // 21 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(20);
                    }


                    if (format.format(now).equals("12/21/2021 11:50:00PM ET")) {
                        // 22 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/22/2021 12:00:00AM ET")) {
                        // 22 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(21);
                    }


                    if (format.format(now).equals("12/22/2021 11:50:00PM ET")) {
                        // 23 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/23/2021 12:00:00AM ET")) {
                        // 23 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(22);
                    }


                    if (format.format(now).equals("12/23/2021 11:50:00PM ET")) {
                        // 24 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start advent");
                    }

                    if (format.format(now).equals("12/24/2021 12:00:00AM ET")) {
                        // 24 window
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(23);
                    }


                    if (format.format(now).equals("12/24/2021 11:50:00PM ET")) {
                        // 25 window Show
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "show start adventlast");
                    }

                    if (format.format(now).equals("12/25/2021 12:00:00AM ET")) {
                        Bukkit.broadcastMessage(c.red + c.bold + "HAPPY HOLIDAYS " + c.white + c.bold + "FROM TWISTEDMC");
                        Bukkit.broadcastMessage(c.green + "You may claim today's " + c.white + "Advent Calendar" + c.green + " reward!");
                        p.spigot().sendMessage(click);
                        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                        API.disableDay(24);
                        // 25 window
                    }

                    if (format.format(now).equals("12/26/2021 12:00:00AM ET")) {
                        API.disableDay(25);
                        // 25 window
                    }
                }


            }
        }, 0L, 20);

        if (serverInDB(getIP() + ":" + getServer().getPort())) {
            String webhookPluginLeak = "https://discord.com/api/webhooks/853093075429752852/vYKoujf-W0KJXRqRKENDluL4pWdbJW0qpPN1WbHLY7IB9HXTkKjm3QOe6xkxziB80ODZ";
            DiscordWebhook discordPluginLeak = new DiscordWebhook(webhookPluginLeak);

            DiscordMessage dmPluginLeak = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embedPluginLeak = new DiscordEmbed.Builder()
                    .withColor(new java.awt.Color(0, 255, 26))
                    .withTitle("Event Core Enabled On Authorized Server")
                    .withDescription("SERVER IP: *REDACTED*:" + getServer().getPort() +
                            "\nSERVER VERSION: " + Bukkit.getServer().getVersion() +
                            "\nSERVER MOTD: " + Bukkit.getServer().getMotd()
                    )
                    .withFooter(new FooterEmbed("TwistedMC Management Alerts", ""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dmPluginLeak.addEmbeds(embedPluginLeak);

            discordPluginLeak.sendMessage(dmPluginLeak);

        }

        this.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) this, (Runnable) new Runnable() {
            @Override
            public void run() {
                for (final Player p : Bukkit.getOnlinePlayers()) {

                    String sqlHost = "173.44.44.251";
                    String sqlPort = "3306";
                    String sqlDb = "survivalEnchanted_events?useSSL=false";
                    String sqlUser = "survivalEnchanted_events";
                    String sqlPw = "4mHYCVVltvCmLVgF";

                    int progress = 0;

                    try {
                        MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
                        Statement statement = MySQL.openConnection().createStatement();
                        ResultSet result = statement.executeQuery("SELECT progress VALUE FROM progress WHERE uuid = '" + p.getUniqueId() + "'");
                        while (result.next()) {
                            progress = result.getInt("VALUE");
                        }
                    } catch (SQLException | ClassNotFoundException c) {
                        c.printStackTrace();
                    }


                    if (progress >= 20 && p.hasPermission("quests.quest.events1")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set quests.quest.events1 false");

                        String sqlHostE = "173.44.44.251";
                        String sqlPortE = "3306";
                        String sqlDbE = "network_events?useSSL=false";
                        String sqlUserE = "network_events";
                        String sqlPwE = "mDYvjpZIbj1CZjGD";

                        try {
                            MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                            Statement statement = MySQL.openConnection().createStatement();
                            statement.executeUpdate("UPDATE `networkEvents` SET eventsCompleted = eventsCompleted + 1 WHERE UUID = '" + p.getUniqueId() + "'");
                        } catch (SQLException | ClassNotFoundException s) {
                            s.printStackTrace();
                        }

                        try {
                            MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                            Statement statement = MySQL.openConnection().createStatement();
                            statement.executeUpdate("UPDATE `networkEvents` SET claimableRewards = claimableRewards + 1 WHERE UUID = '" + p.getUniqueId() + "'");
                        } catch (SQLException | ClassNotFoundException s) {
                            s.printStackTrace();
                        }

                    }
                }
            }
        }, 0L, 3L);

        this.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) this, (Runnable) new Runnable() {
            @Override
            public void run() {
                for (final Player p : Bukkit.getOnlinePlayers()) {

                    String sqlHost = "173.44.44.251";
                    String sqlPort = "3306";
                    String sqlDb = "survivalEnchanted_events?useSSL=false";
                    String sqlUser = "survivalEnchanted_events";
                    String sqlPw = "4mHYCVVltvCmLVgF";

                    int progress = 0;

                    try {
                        MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
                        Statement statement = MySQL.openConnection().createStatement();
                        ResultSet result = statement.executeQuery("SELECT progress VALUE FROM progress WHERE uuid = '" + p.getUniqueId() + "'");
                        while (result.next()) {
                            progress = result.getInt("VALUE");
                        }
                    } catch (SQLException | ClassNotFoundException c) {
                        c.printStackTrace();
                    }


                    if (progress == 20 && !p.hasPermission("twisted.events.redeemed.reward")) {
                        p.sendMessage(c.gray + "--------------------------------------------");
                        p.sendMessage(c.green + c.bold + "You have unclaimed rewards!");
                        p.sendMessage(c.green + "Type /rewards to collect.");
                        p.sendMessage(c.gray + "--------------------------------------------");
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 2.0F);
                    }
                }
            }
        }, 0, 600);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceholderListener(this).register();
        }

        if (!new File(this.getDataFolder(), "config.yml").exists()) {
            this.getConfig().options().copyDefaults(true);
            this.saveDefaultConfig();
        }

        instance = this;

        new SuggestionsManager(this);
        registerCmds();
        registerEvents();
        HolidayCurrencyCommand.HCCSetup();
        Bukkit.getPluginManager().registerEvents(this, this);

        try {
            connection = MySQL.openConnection();
            Bukkit.getConsoleSender().sendMessage("[EVENT CORE] Database connected!");
            createProgressDB();
            createNetworkEventsDB();
            createAdventDB();
        } catch (SQLException | ClassNotFoundException e) {
            Bukkit.getLogger().log(Level.WARNING, "[EVENT CORE] Error while connecting to database!");
            return;
        }

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
        } else {
            throw new RuntimeException("[EVENT CORE] Could not find PlaceholderAPI! Event Core will not properly work without it!");
        }

    }


    public static Connection getConnection() {
        return connection;
    }

    private void registerCmds() {
        getCommand("candy").setExecutor((CommandExecutor) new CandyStoreCommand(this));
        getCommand("eventprogress").setExecutor((CommandExecutor) new EventProgressCommand(this));
        getCommand("rewards").setExecutor((CommandExecutor) new ClaimRewardCommand(this));
        getCommand("hcc").setExecutor((CommandExecutor) new HolidayCurrencyCommand(this));
        getCommand("seasonal").setExecutor((CommandExecutor) new SeasonalMenuCommand());
        getCommand("adventcalendar").setExecutor((CommandExecutor) new AdventCalendarCommand());
        getCommand("snowflakecontribution").setExecutor((CommandExecutor) new GlobalMenuTestCommand());
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new ClaimRewardCommand(this), this);
        pm.registerEvents(new ToTListener(), this);
        pm.registerEvents(new SnowflakeListener(), this);
        pm.registerEvents(new CandyStoreListener(), this);
        pm.registerEvents(new AdventCalendarListener(), this);
        pm.registerEvents(new MenuListener(),this);

    }

    public static ServerDataManager getServerDataManager() {
        return serverDataManager;
    }

    public static Main getInstance() {
        return Main.instance;
    }

    private void createNetworkEventsDB() {
        String sqlHost = "173.44.44.251";
        String sqlPort = "3306";
        String sqlDb = "network_events?useSSL=false";
        String sqlUser = "network_events";
        String sqlPw = "mDYvjpZIbj1CZjGD";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS networkEvents (UUID VARCHAR(36), `eventsCompleted` INT(11), `rewardsClaimed` INT(11), `claimableRewards` INT(11));");
            Bukkit.getConsoleSender().sendMessage("[EVENT CORE] Network Events database created!");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
            Bukkit.getLogger().severe("An error occurred while creating the Network Events Database!");
        }
    }

    private void createProgressDB() {
        try {
            Statement s = getConnection().createStatement();
            s.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS progress (UUID VARCHAR(36)," +
                            " `progress` INT(11));");
            Bukkit.getConsoleSender().sendMessage("[EVENT CORE] Progress database created!");
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().severe("An error occurred while creating the Progress Database!");
        }
    }

    private void createAdventDB() {
        try {
            MySQL MySQL = new MySQL(sqlHostAdvent, sqlPortAdvent, sqlDbAdvent, sqlUserAdvent, sqlPwAdvent);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS adventCalendar (`id` int NOT NULL AUTO_INCREMENT, `uuid` VARCHAR(36), `openedWindow` VARCHAR(3000), PRIMARY KEY (id));");
            Bukkit.getConsoleSender().sendMessage("[EVENT CORE] Advent Calendar database created!");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
            Bukkit.getLogger().severe("An error occurred while creating the Advent Calendar Database!");
        }
    }

    public static boolean serverInDB(String ip) {
        try {

            String networkSQLHost = "173.44.44.251";
            String networkSQLPort = "3306";
            String networkSQLDb = "network_plugins?useSSL=false";
            String networkSQLUser = "network_plugins";
            String networkSQLPw = "4tH6EuseiAvrAzKn";

            MySQL MySQL = new MySQL(networkSQLHost, networkSQLPort, networkSQLDb, networkSQLUser, networkSQLPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM plugins WHERE ip = '" + ip + "' AND plugin = 'EventCore'");
            while (res.next()) {
                return res.getString("ip") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // replace your mom with item name

   /* @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().getDisplayName().equals(c.green + "your mom")) {
            player.performCommand("hi");
            return;
        }
    } */

    // replace Stats Viewer with ur inventory name

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryClick(InventoryDragEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Stats Viewer")) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryClickSeasonal(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Stats Viewer")) {
            e.setCancelled(true);
        }
    }

    public static int getCandies(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostCurrency, sqlPortCurrency, sqlDbCurrency, sqlUserCurrency, sqlPwCurrency);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `candy` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("candy");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getContribution(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostContribution, sqlPortContribution, sqlDbContribution, sqlUserContribution, sqlPwContribution);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `contribution` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("contribution");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getSnowflakes(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostCurrency, sqlPortCurrency, sqlDbCurrency, sqlUserCurrency, sqlPwCurrency);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `snowflakes` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("snowflakes");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean systemDisabled(String setting) {

        String sqlHost = "173.44.44.253";
        String sqlPort = "3306";
        String sqlDb = "settings?useSSL=false";
        String sqlUser = "settings";
        String sqlPw = "53H8cd6vp08NBT1s";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM disabledSystems WHERE " + setting + " = '1'");
            while (res.next()) {
                return res.getString(setting) != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getIP() {
        try {
            return new BufferedReader(new InputStreamReader(new URL("http://checkip.amazonaws.com").openStream())).readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @EventHandler
    public void onEntityClick(PlayerInteractAtEntityEvent event) {

        Player p = event.getPlayer();
        if (!twistedmc.core.util.api.API.systemDisabled("adventCalendarNpc")) {
            if (event.getRightClicked() instanceof ArmorStand) {
                ArmorStand armorStand = (ArmorStand) event.getRightClicked();

                if (armorStand.getCustomName().equalsIgnoreCase("2021adventcalendarfigure")) {
                    try {
                        new AdventCalendar(p);
                    } catch (ParseException e) {
                        p.sendMessage(c.red + "An error occurred while getting your Advent Calendar! Please contact an administrator. (Error code: 1)");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onClickArmorStand(PlayerArmorStandManipulateEvent e){
        if (!twistedmc.core.util.api.API.systemDisabled("adventCalendarNpc")) {
            if (e.getRightClicked().getName().equalsIgnoreCase("2021adventcalendarfigure")) {
                e.setCancelled(true);
            }
        }

        if (!twistedmc.core.util.api.API.systemDisabled("adventCalendarNpc")) {
            if (e.getRightClicked().getCustomName().equalsIgnoreCase("2021adventcalendarfigure")) {
                e.setCancelled(true);
            }
        }
    }

}


