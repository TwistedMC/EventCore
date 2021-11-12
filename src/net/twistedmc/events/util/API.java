package net.twistedmc.events.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Random;
import java.util.UUID;

import org.bukkit.entity.Player;

import net.minecraft.world.item.ItemStack;
import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;
import net.twistedmc.events.util.errors.APIException;

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
    public static boolean canGetContributionItem(int requiredContribution, Player plr) {
     int c = Main.getContribution(plr);
     if (c >= requiredContribution) {
         return true;
     } else {
         return false;
     }
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
