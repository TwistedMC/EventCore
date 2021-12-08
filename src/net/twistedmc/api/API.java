package net.twistedmc.api;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.twistedmc.api.achievements.Achievement;
import net.twistedmc.api.achievements.AchievementType;
import net.twistedmc.api.achievements.AchievementUnlockEvent;
import net.twistedmc.api.boosters.GameBooster;
import net.twistedmc.api.framework.SeasonalType;
import net.twistedmc.api.framework.ServerGameType;
import net.twistedmc.api.framework.ServerType;
import net.twistedmc.api.mysql.MySQL;
import net.twistedmc.api.util.c;
import net.twistedmc.enchanted.Core;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import shasta.twistedmc.coins.CoinsAPI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.UUID;

public class API {

    // MYSQL //

    public static String sqlHost = "173.44.44.251";
    public static String sqlPort = "3306";
    public static String sqlDb = "accounts";
    public static String sqlUser = "accountsDB";
    public static String sqlPw = "epQvHtVoAnUDNJyh";

    public static String sqlDbBW = "bedwars?useSSL=false";
    public static String sqlUserBW = "bedwars";
    public static String sqlPwBW = "pio4fyTqGPbhW5h0";

    public static String sqlHostStats = "173.44.44.253";
    public static String sqlPortStats = "3306";
    public static String sqlDbStats = "networkStats?useSSL=false";
    public static String sqlUserStats = "networkStats";
    public static String sqlPwStats = "gKEB57G.jxu3_xAB";

    public static String sqlDbV = "vanished";
    public static String sqlUserV = "vanished";
    public static String sqlPwV = "ZgNwQhu2s2YArjZm";

    public static String sqlDbT = "survivalEnchanted_tokens?useSSL=false";
    public static String sqlUserT = "survivalEnchanted_tokens";
    public static String sqlPwT = "bhuD1KIfkyiqXk0B";

    // MYSQL //

    public void messageStaff(String msg) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player != null && player.isOnline() && player.hasPermission("staff.alert")) {
                player.sendMessage(msg);
            }
        }
    }

    public static void resetTotalCoins(Player player) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `globalStats` SET totalCoins = '0' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
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

    public static void disableSystem(String setting) {

        String sqlHost = "173.44.44.253";
        String sqlPort = "3306";
        String sqlDb = "settings?useSSL=false";
        String sqlUser = "settings";
        String sqlPw = "53H8cd6vp08NBT1s";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `disabledSystems` SET " + setting + " = 1");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static void enableSystem(String setting) {

        String sqlHost = "173.44.44.253";
        String sqlPort = "3306";
        String sqlDb = "settings?useSSL=false";
        String sqlUser = "settings";
        String sqlPw = "53H8cd6vp08NBT1s";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `disabledSystems` SET " + setting + " = 0");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static int getTotalWins(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `arcade` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("totalWins");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void addPumpkinsBrought(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `bedwars` SET pumpkinsBroughtBack2021 = pumpkinsBroughtBack2021 + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("BedWarsCore"), new Runnable(){
            @Override
            public void run(){
                if (getPumpkinsBroughtBack(player) >= 5 && !hasAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_I)) {
                    unlockAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_I, AchievementType.TIERED);
                }

                if (getPumpkinsBroughtBack(player) >= 25 && !hasAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_II)) {
                    unlockAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_II, AchievementType.TIERED);
                }

                if (getPumpkinsBroughtBack(player) >= 100 && !hasAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_III)) {
                    unlockAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_III, AchievementType.TIERED);
                }

                if (getPumpkinsBroughtBack(player) >= 250 && !hasAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_IV)) {
                    unlockAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_IV, AchievementType.TIERED);
                }

                if (getPumpkinsBroughtBack(player) >= 1000 && !hasAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_V)) {
                    unlockAchievement(player, Achievement.PUMPKINATOR_COLLECTOR_V, AchievementType.TIERED);
                }
            }
        }, 40L);

    }

    public static int getPumpkinsBroughtBack(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `bedwars` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("pumpkinsBroughtBack2021");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // candy baskets

    public static void addCandyBasket(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `lobbyHalloween` SET basketsOpened = basketsOpened + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("Hub"), new Runnable(){
            @Override
            public void run(){
                if (getBasketsOpened(player) >= 5 && !hasAchievement(player, Achievement.FIVE_BASKETS)) {
                    unlockAchievement(player, Achievement.FIVE_BASKETS, AchievementType.NORMAL);
                }

                if (getBasketsOpened(player) >= 45 && !hasAchievement(player, Achievement.ALL_BASKETS)) {
                    unlockAchievement(player, Achievement.ALL_BASKETS, AchievementType.NORMAL);
                }
            }
        }, 40L);

    }

    public static int getBasketsOpened(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `lobbyHalloween` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("basketsOpened");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //

    public static void addPresent(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `lobbyChristmas` SET presentsOpened = presentsOpened + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("TwistedAPI"), new Runnable(){
            @Override
            public void run(){
                if (getPresentsOpened(player) >= 41 && !hasAchievement(player, Achievement.REAL_SANTA)) {
                    unlockAchievement(player, Achievement.REAL_SANTA, AchievementType.NORMAL);
                }
            }
        }, 40L);

    }

    public static int getPresentsOpened(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `lobbyChristmas` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("presentsOpened");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //

    public static int getBoosters(UUID uuid, ServerGameType gamemode) {

        String sqlHost = "173.44.44.251";
        String sqlPort = "3306";
        String sqlDb = "accounts?useSSL=false";
        String sqlUser = "accountsDB";
        String sqlPw = "epQvHtVoAnUDNJyh";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM boosters WHERE UUID = '" + uuid + "' AND SERVER = '" + gamemode + "'");
            while (result.next()) {
                return result.getInt("boosters");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getTotalBoosters(UUID uuid) {

        String sqlHost = "173.44.44.251";
        String sqlPort = "3306";
        String sqlDb = "accounts?useSSL=false";
        String sqlUser = "accountsDB";
        String sqlPw = "epQvHtVoAnUDNJyh";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM boosters WHERE UUID = '" + uuid + "'");
            while (result.next()) {
                return result.getInt("boosters");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean settingDisabled(Player player, String setting){

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM accountpreferences WHERE UUID = '" + player.getUniqueId() + "' AND " + setting + " = '0'");
            while(res.next()){
                return res.getString(setting) != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean settingEnabled(Player player, String setting){

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM accountpreferences WHERE UUID = '" + player.getUniqueId() + "' AND " + setting + " = '1'");
            while(res.next()){
                return res.getString(setting) != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getFriendID(Player player) {
        int id = 0;

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT player_id VALUE FROM friends_players WHERE player_uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                id = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static boolean friendRequestsEnabled(Player player){

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `friends_settings` WHERE player_id = '" + getFriendID(player) + "' AND settings_id = '0' and settings_worth = '1'");
            while(result.next()){
                return result.getString("settings_worth") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void enableFriendRequests(Player player) {
        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `friends_settings` SET settings_worth = 1 WHERE player_id = '" + getFriendID(player) + "' AND settings_id = '0'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static void disableFriendRequests(Player player) {
        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `friends_settings` SET settings_worth = 0 WHERE player_id = '" + getFriendID(player) + "' AND settings_id = '0'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static int getTotalCandy(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("candyCollected2021");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getTotalCandyShopPurchases(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("candyShopPurchases");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getSeasonalShopPurchases(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("seasonalShopPurchases");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getSurvivalItemsBought(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("itemsBought");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getSurvivalPlayerKills(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("playerKills");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getSurvivalDeaths(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("ownDeaths");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getSurvivalMobKills(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("mobKills");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }





































    public static void notifyStaff() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player != null && player.isOnline() && player.hasPermission("staff.alert")) {
                //player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0F, 2.0F);
            }
        }
    }

    public static boolean hasAchievement(Player player, Achievement achievement) {

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `achievements` WHERE uuid = '" + player.getUniqueId() + "' AND achievement = '" + achievement + "'");
            while (result.next()) {
                return result.getString("achievement") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void addAchievement(Player player, Achievement achievement) {
        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("INSERT INTO achievements (uuid, achievement) VALUES ('" + player.getUniqueId() + "', '" + achievement + "')");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static void addAchievementPoints(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `achievementPoints` SET points = points + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static int getAchievementPoints(Player player) {
        int points = 0;

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT points VALUE FROM achievementPoints WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                points = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return points;
    }

    public static int getTokens(Player player) {
        int tokens = 0;

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDbT, sqlUserT, sqlPwT);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT tokens VALUE FROM tokenmanager WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                tokens = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tokens;
    }

    public static void setTokens(Player player, int tokens) {
        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDbT, sqlUserT, sqlPwT);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `tokenmanager` set `tokens`='" + tokens + "' WHERE uuid = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static int getUnlockedAchievements(Player player, ServerGameType serverGameType, AchievementType achievementType) {
        int unlocked = 0;

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT unlockedAchievements VALUE FROM achievements WHERE uuid = '" + player.getUniqueId() + "' AND server = '" + serverGameType + "' AND type = '" + achievementType + "'");
            while (result.next()) {
                unlocked = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return unlocked;
    }

    public static int getAllUnlockedAchievements(Player player, ServerGameType serverGameType, AchievementType achievementType) {
        int unlocked = 0;

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT unlockedAchievements VALUE FROM achievements WHERE uuid = '" + player.getUniqueId() + "' AND server = '" + serverGameType + "' AND type = '" + achievementType + "'");
            while (result.next()) {
                unlocked = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return unlocked;
    }

    public static int getAllUnlockedSeasonalAchievements(Player player, String season, AchievementType achievementType) {
        int unlocked = 0;

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT unlockedAchievements VALUE FROM seasonalAchievements WHERE uuid = '" + player.getUniqueId() + "' AND season = '" + season + "' AND type = '" + achievementType + "'");
            while (result.next()) {
                unlocked = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return unlocked;
    }

    public static void addUnlockedAchievement(Player player, ServerGameType server, AchievementType achievementType) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `achievements` SET unlockedAchievements = unlockedAchievements + '1' WHERE `uuid` = '" + player.getUniqueId() + "' AND `server` = '" + server + "' AND `type` = '" + achievementType + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static void addTotalCoins(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `globalStats` SET totalCoins = totalCoins + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static int getTotalCoins(Player player) {
        int points = 0;

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT totalCoins VALUE FROM globalStats WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                points = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return points;
    }

    public static void addUnlockedAchievementSeasonal(Player player, SeasonalType seasonalType, AchievementType achievementType) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `seasonalAchievements` SET unlockedAchievements = unlockedAchievements + '1' WHERE `uuid` = '" + player.getUniqueId() + "' AND `season` = '" + seasonalType + "' AND `type` = '" + achievementType + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public static int getUnlockedAchievementsSeasonal(Player player, SeasonalType seasonalType, AchievementType achievementType) {
        int unlocked = 0;

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT unlockedAchievements VALUE FROM seasonalAchievements WHERE uuid = '" + player.getUniqueId() + "' AND season = '" + seasonalType + "' AND type = '" + achievementType + "'");
            while (result.next()) {
                unlocked = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return unlocked;
    }

    public static void unlockAchievement(Player player, Achievement achievement, AchievementType achievementType) {

        if (Core.getServerDataManager().getServerType() == ServerType.DEV) {
            player.sendMessage(c.red + "Dev info:");
            player.sendMessage(c.yellow + achievement + " " + achievementType);
        }

        if (hasAchievement(player, achievement))
            return;

        Bukkit.getScheduler().runTask(Core.getInstance(), () -> {
            Bukkit.getServer().getPluginManager().callEvent(new AchievementUnlockEvent(player, achievement));
        });

        addAchievement(player, achievement);
        addAchievementPoints(player, achievement.getPointsAmount());

        if (achievement.getServerGameType() == ServerGameType.SEASONAL) {
            addUnlockedAchievementSeasonal(player, achievement.getSeason(), achievementType);
            addUnlockedAchievement(player, achievement.getServerGameType(), achievementType);
        }

        if (achievement.getServerGameType() != ServerGameType.SEASONAL) {
            addUnlockedAchievement(player, achievement.getServerGameType(), achievementType);
        }

        // Send centered message to the player

        TextComponent achievementGet = new TextComponent(c.yellow + c.scramble + "a" + c.reset + c.green + ">> " +
                "Achievement Unlocked: " + achievement.getAchievementDifficulty().getChatColor() + achievement.getDisplay() +
                c.green + " <<" + c.yellow + c.scramble + "a" + c.reset);

        achievementGet.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(achievement.getAchievementDifficulty().getChatColor() + achievement.getDisplay() +
                "\n" + c.white + achievement.getDescription() +
                "\n" +
                "\n" + c.gray + "Reward:" +
                "\n" + c.dgray + "+" + c.yellow + achievement.getPointsAmount() + c.gray + " Achievement Points" +
                "\n" + "" +
                "\n" + c.yellow + "Click to open your achievements!").create()));

        achievementGet.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/achievements"));

        player.spigot().sendMessage(achievementGet);
        //player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1F, 1F);
        //player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1F, 1F);
    }

    public static void addStatItemsBought(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET itemsBought = itemsBought + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("EnchantedCore"), new Runnable(){
            @Override
            public void run(){
                if (getStatItemsBought(player) >= 1000 && !hasAchievement(player, Achievement.SHOPPING_SPREE_I)) {
                    unlockAchievement(player, Achievement.SHOPPING_SPREE_I, AchievementType.TIERED);
                }

                if (getStatItemsBought(player) >= 25000 && !hasAchievement(player, Achievement.SHOPPING_SPREE_II)) {
                    unlockAchievement(player, Achievement.SHOPPING_SPREE_II, AchievementType.TIERED);
                }

                if (getStatItemsBought(player) >= 45000 && !hasAchievement(player, Achievement.SHOPPING_SPREE_III)) {
                    unlockAchievement(player, Achievement.SHOPPING_SPREE_III, AchievementType.TIERED);
                }

                if (getStatItemsBought(player) >= 65000 && !hasAchievement(player, Achievement.SHOPPING_SPREE_IV)) {
                    unlockAchievement(player, Achievement.SHOPPING_SPREE_IV, AchievementType.TIERED);
                }

                if (getStatItemsBought(player) >= 95000 && !hasAchievement(player, Achievement.SHOPPING_SPREE_V)) {
                    unlockAchievement(player, Achievement.SHOPPING_SPREE_V, AchievementType.TIERED);
                }
            }
        }, 40L);

    }

    public static int getStatItemsBought(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("itemsBought");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getOpenedWindows(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("openedWindows");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void addCandyOffline(OfflinePlayer player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyCollected2021 = candyCollected2021 + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void addCandy(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyCollected2021 = candyCollected2021 + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("EnchantedCore"), new Runnable(){
            @Override
            public void run(){
                if (getCandy(player) >= 70 && !hasAchievement(player, Achievement.SUGAR_RUSH)) {
                    unlockAchievement(player, Achievement.SUGAR_RUSH, AchievementType.NORMAL);
                }

                if (getCandy(player) >= 50 && !hasAchievement(player, Achievement.CANDY_HOARDER_I)) {
                    unlockAchievement(player, Achievement.CANDY_HOARDER_I, AchievementType.TIERED);
                }

                if (getCandy(player) >= 250 && !hasAchievement(player, Achievement.CANDY_HOARDER_II)) {
                    unlockAchievement(player, Achievement.CANDY_HOARDER_II, AchievementType.TIERED);
                }

                if (getCandy(player) >= 750 && !hasAchievement(player, Achievement.CANDY_HOARDER_III)) {
                    unlockAchievement(player, Achievement.CANDY_HOARDER_III, AchievementType.TIERED);
                }

                if (getCandy(player) >= 1500 && !hasAchievement(player, Achievement.CANDY_HOARDER_IV)) {
                    unlockAchievement(player, Achievement.CANDY_HOARDER_IV, AchievementType.TIERED);
                }

                if (getCandy(player) >= 3000 && !hasAchievement(player, Achievement.CANDY_HOARDER_V)) {
                    unlockAchievement(player, Achievement.CANDY_HOARDER_V, AchievementType.TIERED);
                }
            }
        }, 40L);

    }

    public static void removeCandy(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyCollected2021 = candyCollected2021 - '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void setCandy(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyCollected2021 = '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void resetCandy(Player player) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyCollected2021 = '0' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void removeCandy(OfflinePlayer player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyCollected2021 = candyCollected2021 - '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void setCandy(OfflinePlayer player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyCollected2021 = '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void resetCandy(OfflinePlayer player) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyCollected2021 = '0' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static int getCandy(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("candyCollected2021");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getCandyShopPurchases(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("candyShopPurchases");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //

    public static void addSnowflakesOffline(OfflinePlayer player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET flakesCollected2021 = flakesCollected2021 + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void addSnowflakes(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET flakesCollected2021 = flakesCollected2021 + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("EnchantedCore"), new Runnable(){
            @Override
            public void run(){
                if (getSnowflakes(player) >= 1000 && !hasAchievement(player, Achievement.MY_SNOWFLAKE_COLLECTION)) {
                    unlockAchievement(player, Achievement.MY_SNOWFLAKE_COLLECTION, AchievementType.NORMAL);
                }

                if (getSnowflakes(player) >= 2000 && !hasAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_I)) {
                    unlockAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_I, AchievementType.TIERED);
                }

                if (getSnowflakes(player) >= 4000 && !hasAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_II)) {
                    unlockAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_II, AchievementType.TIERED);
                }

                if (getSnowflakes(player) >= 5000 && !hasAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_III)) {
                    unlockAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_III, AchievementType.TIERED);
                }

                if (getSnowflakes(player) >= 8000 && !hasAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_IV)) {
                    unlockAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_IV, AchievementType.TIERED);
                }

                if (getSnowflakes(player) >= 10000 && !hasAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_V)) {
                    unlockAchievement(player, Achievement.SNOWFLAKE_COLLECTOR_V, AchievementType.TIERED);
                }
            }
        }, 40L);

    }

    public static void removeSnowflakes(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET flakesCollected2021 = flakesCollected2021 - '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void setSnowflakes(Player player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET flakesCollected2021 = '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void resetSnowflakes(Player player) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET flakesCollected2021 = '0' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void removeSnowflakes(OfflinePlayer player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET flakesCollected2021 = flakesCollected2021 - '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void setSnowflakes(OfflinePlayer player, int amount) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET flakesCollected2021 = '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static void resetSnowflakes(OfflinePlayer player) {
        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET flakesCollected2021 = '0' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public static int getSnowflakes(Player player) {

        try {
            MySQL MySQL = new MySQL(sqlHostStats, sqlPortStats, sqlDbStats, sqlUserStats, sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `enchanted` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("flakesCollected2021");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }




    //////////////////////////////////////////////////////////////





    public static void giveCoins(Player p, ServerGameType serverGameType, int amount, boolean tell, String reason) {

        int booster = 1, eventBooster = 0;
        if (Core.getBoosterManager().eventBoosterActivated() && Core.getServerDataManager().getServerType() != ServerType.HUB)
            eventBooster = Core.getBoosterManager().getCurrentEventBooster().getMultiplier();

        booster = eventBooster > 0 ? eventBooster : 1;

        String player = null;
        if (Core.getBoosterManager().getCurrentGameBoosters().size() > 0)
            for (GameBooster gameBooster : Core.getBoosterManager().getCurrentGameBoosters())
                if (ServerGameType.valueOf(gameBooster.getGameMode()) == serverGameType) {
                    booster += gameBooster.getMultiplier();
                    player = gameBooster.getActivatorName();
                    break;
                }

        if (Core.getServerDataManager().getServerType() == ServerType.DEV) {
            p.sendMessage(c.red + "[Alert] You would've been given " + c.yellow + amount * booster + c.red + " coins but this is a DEV server.");
            return;
        }

        if (serverGameType == ServerGameType.ENCHANTED) {
            CoinsAPI.addSurvivalCoins(String.valueOf(p.getUniqueId()), amount * booster);
        }

        if (serverGameType == ServerGameType.BEDWARS) {
            CoinsAPI.addBedWarsCoins(String.valueOf(p.getUniqueId()), amount * booster);
        }


        API.addTotalCoins(p, amount * booster);

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_I)) {
            if (API.getTotalCoins(p) >= 1000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_I, AchievementType.TIERED);
            }
        }

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_II)) {
            if (API.getTotalCoins(p) >= 30000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_II, AchievementType.TIERED);
            }
        }

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_III)) {
            if (API.getTotalCoins(p) >= 95000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_III, AchievementType.TIERED);
            }
        }

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_IV)) {
            if (API.getTotalCoins(p) >= 150000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_IV, AchievementType.TIERED);
            }
        }

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_V)) {
            if (API.getTotalCoins(p) >= 350000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_V, AchievementType.TIERED);
            }
        }

        if (tell) {

            NumberFormat formatter = NumberFormat.getIntegerInstance();

            String message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + reason + c.gold + ")";

            if (player == null && eventBooster == 0)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + reason + c.gold + ")";

            else if (player != null && eventBooster == 2)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + "Double Coins Event, " + player + "'s Booster" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            else if (player != null && eventBooster == 3)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + "Triple Coins Event, " + player + "'s Booster" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            else if (player != null && eventBooster == 4)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + "Quadruple Coins Event, " + player + "'s Booster" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            else if (eventBooster == 2)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + "Double Coins Event" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            else if (eventBooster == 3)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + "Triple Coins Event" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            else if (eventBooster == 4)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + "Quadruple Coins Event" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            else if (player != null && eventBooster > 0)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + eventBooster + "x Event Booster, " + player + "'s Booster" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            else if (player == null && eventBooster > 0)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + eventBooster + "x Event Booster" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            else if (player != null && eventBooster == 0)
                message = c.yellow + "+" + formatter.format((amount * booster)) + c.gold + " coins! (" + c.yellow + player + "'s Booster" + c.gold + ") (" + c.yellow + reason + c.gold + ")";

            //p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(c.gold + "+" + formatter.format((amount * booster)) + " coins!"));
            p.sendMessage(message);
        }

        if (p.hasPermission("twisted.rank.gamemaster")) {
            giveMultiplier(p, amount, 2, serverGameType);
        }

        if (p.hasPermission("twisted.rank.admin")) {
            giveMultiplier(p, amount, 5, serverGameType);
        }

        if (p.hasPermission("twisted.rank.owner")) {
            giveMultiplier(p, amount, 10, serverGameType);
        }
    }

    public static void giveMultiplier(Player p, int amount, int multiplier, ServerGameType serverGameType) {

        NumberFormat formatter = NumberFormat.getIntegerInstance();

        if (Core.getServerDataManager().getServerType() == ServerType.DEV) {
            p.sendMessage(c.red + "[Alert] You would've been given an extra " + c.yellow + amount * multiplier + c.red + " coins but this is a DEV server.");
            return;
        }

        if (serverGameType == ServerGameType.ENCHANTED) {
            CoinsAPI.addSurvivalCoins(String.valueOf(p.getUniqueId()), amount * multiplier);
        }

        if (serverGameType == ServerGameType.BEDWARS) {
            CoinsAPI.addBedWarsCoins(String.valueOf(p.getUniqueId()), amount * multiplier);
        }

        API.addTotalCoins(p, amount * multiplier);

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_I)) {
            if (API.getTotalCoins(p) >= 1000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_I, AchievementType.TIERED);
            }
        }

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_II)) {
            if (API.getTotalCoins(p) >= 30000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_II, AchievementType.TIERED);
            }
        }

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_III)) {
            if (API.getTotalCoins(p) >= 95000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_III, AchievementType.TIERED);
            }
        }

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_IV)) {
            if (API.getTotalCoins(p) >= 150000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_IV, AchievementType.TIERED);
            }
        }

        if (hasJoinedAchievements(p.getUniqueId()) && !API.hasAchievement(p, Achievement.TOTAL_COINS_V)) {
            if (API.getTotalCoins(p) >= 350000) {
                API.unlockAchievement(p, Achievement.TOTAL_COINS_V, AchievementType.TIERED);
            }
        }

        String message = c.gold + c.bold + "EXTRA! " + c.yellow + "+" + formatter.format((amount * multiplier)) + c.gold + " Coins (" + c.yellow + "Null Rank Multiplier" + c.gold + ")";

        if (multiplier == 2)
            message = c.gold + c.bold + "EXTRA! " + c.yellow + "+" + formatter.format((amount * multiplier)) + c.gold + " Coins (" + c.yellow + "Game Master Rank Multiplier" + c.gold + ")";

        else if (multiplier == 5)
            message = c.gold + c.bold + "EXTRA! " + c.yellow + "+" + formatter.format((amount * multiplier)) + c.gold + " Coins (" + c.yellow + "Admin Rank Multiplier" + c.gold + ")";

        else if (multiplier == 10)
            message = c.gold + c.bold + "EXTRA! " + c.yellow + "+" + formatter.format((amount * multiplier)) + c.gold + " Coins (" + c.yellow + "Owner Rank Multiplier" + c.gold + ")";

        p.sendMessage(message);
    }

    public static boolean hasJoinedAchievements(UUID uuid){
        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM achievementPoints WHERE UUID = '" + uuid.toString() + "'");
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
