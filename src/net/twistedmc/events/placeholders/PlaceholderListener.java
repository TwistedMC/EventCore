package net.twistedmc.events.placeholders;


import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.API;

import org.apache.logging.log4j.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlaceholderListener extends PlaceholderExpansion {

    private Main plugin;

    public PlaceholderListener(Main plugin) {
    }

    @Override
    public boolean canRegister(){
        return (plugin = (Main) Bukkit.getPluginManager().getPlugin(getRequiredPlugin())) != null;
    }

    @Override
    public String getAuthor(){
        return Main.instance.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier(){
        return "events";
    }

    @Override
    public String getRequiredPlugin(){
        return "EventCore1.17";
    }

    @Override
    public String getVersion(){
        return Main.instance.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier){

        if(player == null){
            return "No player found! Player offline?";
        }

        if(identifier.equals("progresstotal")){
            return "20";
        }
        if(identifier.equalsIgnoreCase("registered")) {
            return c.green + c.bold + "REGISTERED";
        }

        if(identifier.equals("progress")){

            int progress = 0;

            try{
                MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                Statement statement = MySQL.openConnection().createStatement();
                ResultSet result = statement.executeQuery("SELECT progress VALUE FROM progress WHERE uuid = '" + player.getUniqueId() + "'");
                while(result.next()){
                    progress = result.getInt("VALUE");
                }
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }


            return String.valueOf(progress);
        }
        if(identifier.equals("contribution")){

            int contribution = 0;

            try{
                MySQL MySQL = new MySQL(Main.sqlHostContribution, Main.sqlPortContribution, Main.sqlDbContribution, Main.sqlUserContribution, Main.sqlPwContribution);
                Statement statement = MySQL.openConnection().createStatement();
                ResultSet result = statement.executeQuery("SELECT `contribution` VALUE FROM `contribution` WHERE uuid = '" + player.getUniqueId() + "'");
                while(result.next()){
                    contribution = result.getInt("VALUE");
                }
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }


            return String.valueOf(contribution);
        }
        if(identifier.equals("globalcontributionraw")) {
           return "" + API.getTotalContributionRAW() + ""; 
        }
        if (identifier.equals("globalcontributionf")) {
            return API.getTotalContributionFormatted();
        }

        if(identifier.equals("color")) {
            if (Main.holiday == "halloween") {
                return "" + c.gold;
            } else if (Main.holiday == "christmas") {
                return "" + c.white; // not final
                //} else if (Main.holiday == "newyears") {
                //   return "Firework Charges"; // not final
                //} else if (Main.holiday == "halloween") { // add any others here
                //return "Candies";
            }
        }

        if(identifier.equals("holidaycurrency")) {
            if (Main.holiday == "halloween") {
                return "" + c.gold + "candies";
            } else if (Main.holiday == "christmas") {
                return "" + c.white + "snowflakes"; // not final
            //} else if (Main.holiday == "newyears") {
             //   return "Firework Charges"; // not final
            //} else if (Main.holiday == "halloween") { // add any others here
                //return "Candies";
            }
        }

        if(identifier.equals("holidaycurrencynocolor")) {
            if (Main.holiday == "halloween") {
                return "" + "candies";
            } else if (Main.holiday == "christmas") {
                return "" + "snowflakes"; // not final
                //} else if (Main.holiday == "newyears") {
                //   return "Firework Charges"; // not final
                //} else if (Main.holiday == "halloween") { // add any others here
                //return "Candies";
            }
        }
        
        if(identifier.equals("candiesamount")) {
            int candies = 0;

            try{
                MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                Statement statement = MySQL.openConnection().createStatement();
                ResultSet result = statement.executeQuery("SELECT candies VALUE FROM candies WHERE uuid = '" + player.getUniqueId() + "'");
                while(result.next()){
                    candies = result.getInt("VALUE");
                }
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }


            return String.valueOf(candies);
        }

        if(identifier.equals("snowflakesamount")) {
            int snowflakes = 0;

            try{
                MySQL MySQL = new MySQL(plugin.sqlHost, plugin.sqlPort, plugin.sqlDb, plugin.sqlUser, plugin.sqlPw);
                Statement statement = MySQL.openConnection().createStatement();
                ResultSet result = statement.executeQuery("SELECT snowflakes VALUE FROM snowflakes WHERE uuid = '" + player.getUniqueId() + "'");
                while(result.next()){
                    snowflakes = result.getInt("VALUE");
                }
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }


            return String.valueOf(snowflakes);
        }

        return null;
    }
}

