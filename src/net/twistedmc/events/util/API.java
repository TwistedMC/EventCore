package net.twistedmc.events.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.*;
import java.util.logging.Level;

import net.twistedmc.events.data.c;
import net.twistedmc.events.inventorys.globalevents.ContributeMenu;
import net.twistedmc.events.inventorys.globalevents.GlobalMenu;
import net.twistedmc.events.util.api_annotations.Unused;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;
import net.twistedmc.events.util.errors.APIException;
import twistedmc.core.util.api.APICoins;

public class API {

    public static boolean adventOpenedAlready(UUID uuid, int openedWindow){
        try {
            MySQL MySQL = new MySQL(Main.sqlHostAdvent, Main.sqlPortAdvent, Main.sqlDbAdvent, Main.sqlUserAdvent, Main.sqlPwAdvent);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM adventCalendar WHERE UUID = '" + uuid.toString() + "' AND openedWindow = '" + openedWindow + "'");
            while(res.next()){
                return res.getString("uuid") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void addAdvent(Player player, int window) {

        if (!adventOpenedAlready(player.getUniqueId(), window)) {
            try {
                MySQL MySQL = new MySQL(Main.sqlHostAdvent, Main.sqlPortAdvent, Main.sqlDbAdvent, Main.sqlUserAdvent, Main.sqlPwAdvent);
                Statement statement = MySQL.openConnection().createStatement();
                statement.executeUpdate("INSERT INTO `adventCalendar` (uuid, openedWindow) VALUES ('" + player.getUniqueId() + "', '" + window + "')");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }

        try {
            MySQL MySQL = new MySQL(Main.sqlHostStats, Main.sqlPortStats, Main.sqlDbStats, Main.sqlUserStats, Main.sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET openedWindows = openedWindows + '1' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }
    /**
     *
     *
     *
     * */
    public static boolean isReady(int window){
        try {
            MySQL MySQL = new MySQL(Main.sqlHostAdvent, Main.sqlPortAdvent, Main.sqlDbAdvent, Main.sqlUserAdvent, Main.sqlPwAdvent);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM `adventStatus` WHERE day = '" + window + "' AND status = 'READY'");
            while(res.next()){
                return res.getString("day") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isMissed(int window){
        try {
            MySQL MySQL = new MySQL(Main.sqlHostAdvent, Main.sqlPortAdvent, Main.sqlDbAdvent, Main.sqlUserAdvent, Main.sqlPwAdvent);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM `adventStatus` WHERE day = '" + window + "' AND status = 'MISSED'");
            while(res.next()){
                return res.getString("day") != null;
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void disableDay(int window) {

        try {
            MySQL MySQL = new MySQL(Main.sqlHostStats, Main.sqlPortStats, Main.sqlDbStats, Main.sqlUserStats, Main.sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `adventStatus` SET status = 'MISSED' WHERE `day` = '" + window + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }
    public static ArrayList<String> CTDebounce = new ArrayList<>();
    public static HashMap<String, String> CTDAntiSpam = new HashMap<>();
    public static void ContributionTransaction(Player player,int contributed) throws APIException {
        boolean isGood = false;
        NumberFormat f = NumberFormat.getInstance();
        player.sendMessage(c.green + "Processing Transaction...");
        if (!CTDebounce.contains(player.getUniqueId().toString())) {
            CTDebounce.add(player.getUniqueId().toString());
            int s = Main.getSnowflakes(player);
            if (s >= contributed) {  // Safeguard
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"hcc "+ player.getName() + " remove " +contributed);
                try {
                    MySQL MySQL = new MySQL(Main.sqlHostContribution, Main.sqlPortContribution, Main.sqlDbContribution, Main.sqlUserContribution, Main.sqlPwContribution);
                    Statement statement = MySQL.openConnection().createStatement();
                    statement.executeUpdate("UPDATE `contribution` SET `contribution` = `contribution` + "+ contributed +" WHERE UUID = '" + player.getUniqueId() + "'");
                   if (!GlobalMenu.AllContributionGetsPrize) {
                    if (API.getTotalContributionRAW() < GlobalMenu.GlobalGoal) {
                       Statement statement1 = MySQL.openConnection().createStatement();
                       ResultSet res = statement1.executeQuery("SELECT `canGetPrize` VALUE FROM `contribution` WHERE `UUID` = '"+player.getUniqueId() + "'");
                       while (res.next()){
                           int a = res.getInt("VALUE");
                           if (a == 0) {
                              Statement statement2 = MySQL.openConnection().createStatement();
                              statement2.executeUpdate("UPDATE `contribution` SET `canGetPrize` = 1 WHERE `UUID` = '" +player.getUniqueId()+"'");
                           }
                       }
                    }
                   }
                   isGood = true;
                } catch (SQLException | ClassNotFoundException exp) {
                    exp.printStackTrace();
                    player.sendMessage(c.red + "There was an error processing your transaction.");
                    isGood = false;
                }
            }
            if (isGood) {
                new ContributeMenu(player);
                player.sendMessage(c.green + "Transaction successful!");
                player.sendMessage("-" + f.format(contributed) +"❄ "+c.gray+"("+c.white+"Winter Event Contribution"+c.gray+")");
                API.GoalCheck();
            } else {
                player.sendMessage(c.red + "Transaction failed, please try again later.");
            }
            CTDAntiSpam.remove(player.getUniqueId().toString());
            CTDebounce.remove(player.getUniqueId().toString());
        } else {
            player.sendMessage(c.red + "You already have a transaction in progress!");
            if (CTDAntiSpam.get(player.getUniqueId().toString()) == "7") {
                player.kickPlayer("ur gay"); // beautiful. -N
            } else {
                Integer inte = Integer.parseInt(CTDAntiSpam.get(player.getUniqueId().toString()));
                CTDAntiSpam.put(player.getUniqueId().toString(),"" + (inte + 1) + "");
            }
        }


    }

    /**
     * @param items - The Array of given ItemStack(s) to randomly decide on.
     * @return ItemStack - The randomly chosen item
     * @since API 0.1.0
     * */
    public static ItemStack generateRandomItem(ItemStack[] items) {
        Random r = new Random();
        int ran = r.nextInt(items.length);
        ItemStack item = items[ran];
        return item;
    }

    public static boolean canBuy(int price, String currency, Player plr) {
        if (currency == "candies" || currency == "candy") {
            int candy = Main.getCandies(plr);
            if (candy >= price) {
                return true;
            } else {
                return false;
            }
        } else if (currency == "snowflakes") {
            int flakes = Main.getSnowflakes(plr);
            if (flakes >= price) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static String[] PrizeCommands = {"rankgive %s","givecoins %s 20000 Winter Event Reward"};
    //Elimination of the requirement for a playername made it possible to make this static. ^
    /**
     * {@code Prize Dispatcher} is a function to either add a standby permission
     *                          or dispatch rewards for those eligible.
     * @return void
     * @throws APIException
     * */
    public static void PrizeDispatcher() throws APIException {
        //String[] PrizeCommands = {"givegold %s 5 Test 1","givegold %s 10 Test 2",""};
        if (PrizeCommands.length == 0) {
            throw new APIException("Commands list empty. Please add some to the prize!");
        }
        try {
            MySQL m = new MySQL(Main.sqlHostContribution, Main.sqlPortContribution, Main.sqlDbContribution, Main.sqlUserContribution, Main.sqlPwContribution);
            Statement s = m.openConnection().createStatement();
            ResultSet set = s.executeQuery("SELECT `UUID` VALUE FROM `contribution` WHERE `canGetPrize` = 1");
            while (set.next()) {
                UUID id = UUID.fromString(set.getString("VALUE"));
                if (Bukkit.getServer().getPlayer(id) == null) {
                    OfflinePlayer op = Bukkit.getOfflinePlayer(id);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + op.getName() + " permission set twisted.events.global.joinrewards true");
                } else {
                    Player plr = Bukkit.getServer().getPlayer(id);
                    plr.playSound(plr.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 2.0F);
                    plr.sendMessage(c.aqua + "You were eligible for the Winter 2021 Community Challenge's rewards! They are being dispensed to you!");
                    for (int i = 0; i < PrizeCommands.length; i++) {
                        String command = PrizeCommands[i];
                        if (command.contains("%s")) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), String.format(command, plr.getName()));
                        } else {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                        }

                    }
                }
            }
            m.closeConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Bukkit.getLogger().log(Level.SEVERE, "Error Dispensing prize!");
        }
    }
    public static boolean rankChecker(String rankperm,Player p) {
        if (p.hasPermission(rankperm)) {
            return true;
        } else {
            return false;
        }
    }
    public static void PrizeDispatchJoin(Player p) {
        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 2.0F);
        p.sendMessage(c.green + "You were eligible for the Winter 2021 Community Challenge's rewards! They are being dispensed to you!");
        for (int i=0;i<PrizeCommands.length; i++) {
            String command = PrizeCommands[i];
            if (command.contains("%s")) {
                String newcmd = String.format(command,p.getName());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),newcmd);
            } else {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),command);
            }
        }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user " + p.getName() + " permission set twisted.events.global.joinrewards false");
    }

    public static void GoalCheck() throws APIException {
        if (API.getTotalContributionRAW() >= GlobalMenu.GlobalGoal) {
            Bukkit.getServer().broadcastMessage(c.green + "The Winter 2021 Community Challenge has been completed! Prizes will be dispatched!");
            API.PrizeDispatcher();
        }
    }
    /**
     * 
     * @param requiredContribution - The amount of contribution to unlock {@code <item>}
     * @param userCantHavePerm - The permission the player can't have, it will return {@code False} if the player has it. 
     * @param plr - The {@code Player}
     * @param checkPerms - Not setting this or setting it to false will skip the {@code userCantHavePerm} variable. 
     * @see org.bukkit.entity.Player
     * @return {@code Boolean (True/False)}
     * @since API 0.1.1
     */
    public static boolean canGetContributionItem(int requiredContribution, String userCantHavePerm, Player plr, boolean checkPerms) {
     int c = Main.getContribution(plr);
     if (checkPerms == true) {
        if (c >= requiredContribution && !plr.hasPermission(userCantHavePerm)) {
            return true;
        } else {
            return false;
        }
     } else {
        if (c >= requiredContribution) {
            return true;
        } else {
            return false;
        }
     }
    }
    /**
     * 
     * @param price
     * @param player
     * @param currencyType
     * @return {@code Boolean} 
     * @since {@code API 0.1.2}
     */
    public static boolean CanShowItem(int price,Player player,String currencyType) {
        if (currencyType == "contribution") {
            int c = Main.getContribution(player);
            if (c >= price) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static int getTotalContributionRAW() {
        int int_ = 0;
        try { //TO-DO: UPDATE LOGIN CREDIIALS FOR CONTRIBUTION/EVENTS DATABASE. - DONE 11/9/2021
            MySQL MySQL = new MySQL(Main.sqlHostContribution, Main.sqlPortContribution, Main.sqlDbContribution, Main.sqlUserContribution, Main.sqlPwContribution);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT contribution VALUE FROM `contribution` WHERE `contribution` > 1");
            while (result.next()) {
                int res = result.getInt("VALUE");
                int_ = int_ + res;
            }
            MySQL.closeConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return int_;
    }

    public static String getTotalContributionFormatted() {
        int int_ = 0;
        try {
            MySQL MySQL = new MySQL(Main.sqlHostContribution, Main.sqlPortContribution, Main.sqlDbContribution, Main.sqlUserContribution, Main.sqlPwContribution);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT contribution VALUE FROM `contribution` WHERE `contribution` > 1");
            while (result.next()) {
                int res = result.getInt("VALUE");
                int_ = int_ + res;
            }
            MySQL.closeConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        NumberFormat f = NumberFormat.getInstance();
        return f.format(int_);
    }

    public static boolean inCandyStorePurchasesDB(UUID uuid){
        try {
            MySQL MySQL = new MySQL(Main.sqlHostCP, Main.sqlPortCP, Main.sqlDbCP, Main.sqlUserCP, Main.sqlPwCP);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM `candyStorePurchases` WHERE UUID = '" + uuid.toString() + "'");
            while(res.next()){
                return res.getString("uuid") != null;
            }

            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getCandyStorePurchases(Player player) {

        try {
            MySQL MySQL = new MySQL(Main.sqlHostCP, Main.sqlPortCP, Main.sqlDbCP, Main.sqlUserCP, Main.sqlPwCP);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `candyStorePurchases` WHERE uuid = '" + player.getUniqueId() + "'");
            while (result.next()) {
                return result.getInt("purchases");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void addCandyStorePurchase(Player player, int amount) {

        if (!API.inCandyStorePurchasesDB(player.getUniqueId())) {
            try {
                MySQL MySQL = new MySQL(Main.sqlHostCP, Main.sqlPortCP, Main.sqlDbCP, Main.sqlUserCP, Main.sqlPwCP);
                Statement statement = MySQL.openConnection().createStatement();
                statement.executeUpdate("INSERT INTO `candyStorePurchases` (uuid, purchases) VALUES ('" + player.getUniqueId() + "', '0')");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }

        try {
            MySQL MySQL = new MySQL(Main.sqlHostCP, Main.sqlPortCP, Main.sqlDbCP, Main.sqlUserCP, Main.sqlPwCP);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `candyStorePurchases` SET purchases = purchases + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(Main.sqlHostStats, Main.sqlPortStats, Main.sqlDbStats, Main.sqlUserStats, Main.sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET candyShopPurchases = candyShopPurchases + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(Main.sqlHostStats, Main.sqlPortStats, Main.sqlDbStats, Main.sqlUserStats, Main.sqlPwStats);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `enchanted` SET seasonalShopPurchases = seasonalShopPurchases + '" + amount + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }



    public static String convertUUIDToName(String uuid) {
        UUID id = UUID.fromString(uuid);
        OfflinePlayer plr = Bukkit.getOfflinePlayer(id);
        return plr.getName();
    }
    /** 
     *    For any of TwistedMC's plugins that use databases with playernames.
     *    For use with TwistedMC & Specified Partner Servers (If any) only. DO NOT DISTRIBUTE.
     *    <p>
     *     Function & Javadoc Written by MCEpic_Nation
     *    <p>
     *    @param sqlLoginInfo The string table/array that will contain the login information for the desired Database, follows the format of:
     *                          <code>MySQL(Host,Port,Database,Username,Password)</code>
     *    @param tableName The name of the table to search for the playername colum.
     *    @param uuidColumLabel The name of the colum where the UUID value is stored (Usually "uuid" or "UUID")
     *    @param PlayerNameColumIndex The name of the colum where the Player's name value is stored
     *    @param player The player object/entity to use as the UUID and Name.
     *    @return Returns nothing, ever.
     *    @see <code>MySQL.MySQL</code>
     *    @see <code>org.bukkit.entity.Player</code>
     *    @since 0.1.0
     *    @throws SQLException
     *    @throws ClassNotFoundException
     *    @throws APIException
    */
    public static void updateDatabasePlayerName(String[] sqlLoginInfo,String tableName,String uuidColumLabel,String PlayerNameColumIndex,Player player) throws APIException {
        if (sqlLoginInfo.length < 5) {
            throw new APIException("Login Array does not match minimum length of 5.");  // Incorrect Login Info (Does not have all 5 key parts)
        }

        String sqlHost = sqlLoginInfo[0];
        String sqlPort = sqlLoginInfo[1];
        String sqlDatabase = sqlLoginInfo[2];
        String sqlUser = sqlLoginInfo[3];
        String sqlPW = sqlLoginInfo[4];
        String name = "";
        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDatabase, sqlUser, sqlPW);
            Statement st = MySQL.openConnection().createStatement();
            ResultSet res = st.executeQuery("SELECT " + PlayerNameColumIndex + " VALUE FROM `" + tableName + "` WHERE `" + uuidColumLabel +"` = '" + player.getUniqueId() + "'");
            while (res.next()) {
                name = res.getString("VALUE");
            }
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        if (player.getName() != name) {
            // Name does not match database, attempting to update!
            try {
                MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDatabase, sqlUser, sqlPW);
                Statement st = MySQL.openConnection().createStatement();
                st.executeUpdate("UPDATE `" + tableName + "` SET " + PlayerNameColumIndex + " = " + player.getName() + " WHERE `" + uuidColumLabel + "` = `" + player.getUniqueId() + "`");
            } catch (SQLException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }
    }


} // End of API Class
