package net.twistedmc.events.util;

import net.minecraft.world.item.ItemStack;
import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Random;
import java.util.UUID;

import org.bukkit.entity.Player;

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
        try { //TO-DO: UPDATE LOGIN CREDIIALS FOR CONTRIBUTION/EVENTS DATABASE.
            MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
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
            MySQL MySQL = new MySQL(Main.sqlHostCurrency, Main.sqlPortCurrency, Main.sqlDbCurrency, Main.sqlUserCurrency, Main.sqlPwCurrency);
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
}
