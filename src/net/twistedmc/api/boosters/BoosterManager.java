package net.twistedmc.api.boosters;

import net.twistedmc.api.framework.ServerGameType;
import net.twistedmc.api.mysql.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BoosterManager {

    private static EventBooster currentEventBooster = null;
    private static List<GameBooster> currentGameBoosters = new ArrayList<>();

    public BoosterManager() {
        refreshBoosters();
    }
    public static void refreshBoosters() {

        String sqlHost = "173.44.44.251";
        String sqlPort = "3306";
        String sqlDb = "network_boosters?useSSL=false";
        String sqlUser = "network_boosters";
        String sqlPw = "MEuek6BqD3jFYvVC";

        long startTime = 0;
        long endTime = 0;
        int multiplier = 0;
        String reason = "";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT startTime VALUE FROM eventBoosters");
            while (result.next()) {
                startTime = result.getLong("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT endTime VALUE FROM eventBoosters");
            while (result.next()) {
                endTime = result.getLong("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT multiplier VALUE FROM eventBoosters");
            while (result.next()) {
                multiplier = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT reason VALUE FROM eventBoosters");
            while (result.next()) {
                reason = result.getString("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Game Booster MySQL

        long gameEndSeconds = 0;
        long gameStartTime = 0;
        long gameEndTime = 0;
        int gameMultiplier = 0;
        String activatorUUID = "";
        String activatorName = "";
        String gameMode = "";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT endSeconds VALUE FROM gameBoosters");
            while (result.next()) {
                gameEndSeconds = result.getLong("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT startTime VALUE FROM gameBoosters");
            while (result.next()) {
                gameStartTime = result.getLong("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT endTime VALUE FROM gameBoosters");
            while (result.next()) {
                gameEndTime = result.getLong("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT multiplier VALUE FROM gameBoosters");
            while (result.next()) {
                gameMultiplier = result.getInt("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT activatorUUID VALUE FROM gameBoosters");
            while (result.next()) {
                activatorUUID = result.getString("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT activatorName VALUE FROM gameBoosters");
            while (result.next()) {
                activatorName = result.getString("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT gameMode VALUE FROM gameBoosters");
            while (result.next()) {
                gameMode = result.getString("VALUE");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        currentEventBooster = null;
        currentGameBoosters.clear();

        if(endTime > System.currentTimeMillis()) setCurrentEventBooster(
                new EventBooster(startTime, endTime, multiplier, reason));

        if(gameEndTime > System.currentTimeMillis()) addGameBooster(
                new GameBooster(gameStartTime, gameEndSeconds, gameEndTime, gameMultiplier, UUID.fromString(activatorUUID), activatorName, gameMode));
    }

    public static void setCurrentEventBooster(EventBooster currentEventBooster) {
        BoosterManager.currentEventBooster = currentEventBooster;
    }
    public boolean eventBoosterActivated(){
        return currentEventBooster != null;
    }

    public EventBooster getCurrentEventBooster() {
        return currentEventBooster;
    }

    public static void addGameBooster(GameBooster booster){
        BoosterManager.currentGameBoosters.add(booster);
    }

    public List<GameBooster> getCurrentGameBoosters(){
        return currentGameBoosters;
    }

    public boolean boosterActive(ServerGameType gameType){
        return currentGameBoosters.parallelStream().anyMatch(gameBooster -> ServerGameType.valueOf(gameBooster.getGameMode()) == gameType);
    }

    public void removeGameBooster(GameBooster gameBooster){
        this.currentGameBoosters.remove(gameBooster);
    }

    public static int getBoosters(UUID uuid, ServerGameType serverType) {
        try{
            String sqlHost = "173.44.44.251";
            String sqlPort = "3306";
            String sqlDb = "accounts?useSSL=false";
            String sqlUser = "accountsDB";
            String sqlPw = "epQvHtVoAnUDNJyh";

            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT boosters FROM `boosters` WHERE UUID = '" + uuid + "' AND server = '" + serverType + "'");
            while(result.next()){
                return result.getInt("boosters");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return 0;
    }

}