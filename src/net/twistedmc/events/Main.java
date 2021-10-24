package net.twistedmc.events;


import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import net.ranktw.DiscordWebHooks.DiscordEmbed;
import net.ranktw.DiscordWebHooks.DiscordMessage;
import net.ranktw.DiscordWebHooks.DiscordWebhook;
import net.ranktw.DiscordWebHooks.embed.FooterEmbed;
import net.twistedmc.events.commands.*;
import net.twistedmc.events.data.c;
import net.twistedmc.events.inventorys.CandyStoreListener;
import net.twistedmc.events.listeners.JoinListener;
import net.twistedmc.events.listeners.SuggestionsManager;
import net.twistedmc.events.listeners.ToTListener;
import net.twistedmc.events.placeholders.PlaceholderListener;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public class Main extends JavaPlugin implements Listener {

    public static List<UUID> mob = new ArrayList<>();
    public static List<UUID> mobSpawner = new ArrayList<>();
    
    public static String holiday = "halloween"; // halloween, christmas, newyears, (add any here)
    public static Main instance;

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

    public String sqlHostAdvent = "173.44.44.251";
    public String sqlPortAdvent = "3306";
    public String sqlDbAdvent = "events_advent?useSSL=false";
    public String sqlUserAdvent = "events_advent";
    public String sqlPwAdvent = "DdY3HkcfnT4RvP9c";

    public static Connection connection = null;

    public void onEnable() {

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

                    getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("EnchantedCore"));
                    Bukkit.getServer().shutdown();

                }
            }.runTaskLater(this, 30);
            return;
        }

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


        public static Connection getConnection() { return connection; }

    private void registerCmds() {
        getCommand("candy").setExecutor((CommandExecutor) new CurrencyStoreCommand(this));
        getCommand("eventprogress").setExecutor((CommandExecutor) new EventProgressCommand(this));
        getCommand("rewards").setExecutor((CommandExecutor) new ClaimRewardCommand(this));
        getCommand("hcc").setExecutor((CommandExecutor) new HolidayCurrencyCommand(this));
        getCommand("seasonal").setExecutor((CommandExecutor) new SeasonalMenuCommand());
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new ClaimRewardCommand(this), this);
        pm.registerEvents(new ToTListener(), this);
        pm.registerEvents(new CandyStoreListener(), this);

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

    public static boolean serverInDB(String ip){
        try {

            String networkSQLHost = "173.44.44.251";
            String networkSQLPort = "3306";
            String networkSQLDb = "network_plugins?useSSL=false";
            String networkSQLUser = "network_plugins";
            String networkSQLPw = "4tH6EuseiAvrAzKn";

            MySQL MySQL = new MySQL(networkSQLHost, networkSQLPort, networkSQLDb, networkSQLUser, networkSQLPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM plugins WHERE ip = '" + ip + "' AND plugin = 'EventCore'");
            while(res.next()){
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
            MySQL MySQL = new MySQL(sqlHostCurrency, sqlPortCurrency, sqlDbCurrency, sqlUserCurrency, sqlPwCurrency);
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

    public static boolean systemDisabled(String setting){

        String sqlHost = "173.44.44.253";
        String sqlPort = "3306";
        String sqlDb = "settings?useSSL=false";
        String sqlUser = "settings";
        String sqlPw = "53H8cd6vp08NBT1s";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM disabledSystems WHERE " + setting + " = '1'");
            while(res.next()){
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

}