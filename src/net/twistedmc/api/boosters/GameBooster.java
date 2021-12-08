package net.twistedmc.api.boosters;

import net.twistedmc.api.mysql.MySQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class GameBooster extends NetworkBooster {

    private String gameMode;
    private UUID activatorUUID;
    private String activatorName;

    public GameBooster(long startTime, long endSeconds, long endTime, int multiplier, UUID activatorUUID, String activatorName, String gameMode) {
        super(startTime, endSeconds, endTime, multiplier);

        this.gameMode = gameMode;
        this.activatorName = activatorName;
        this.activatorUUID = activatorUUID;
    }

    public GameBooster(long endSeconds, long endTime, int multiplier, UUID activatorUUID, String activatorName, String gameMode) {
        this(System.currentTimeMillis(), endSeconds, endTime, multiplier, activatorUUID, activatorName, gameMode);

        String sqlHost = "173.44.44.251";
        String sqlPort = "3306";
        String sqlDb = "network_boosters?useSSL=false";
        String sqlUser = "network_boosters";
        String sqlPw = "MEuek6BqD3jFYvVC";

        String sqlHostA = "173.44.44.251";
        String sqlPortA = "3306";
        String sqlDbA = "accounts?useSSL=false";
        String sqlUserA = "accountsDB";
        String sqlPwA = "epQvHtVoAnUDNJyh";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("INSERT INTO gameBoosters (endSeconds, endTime, startTime, multiplier, activatorUUID, activatorName, gameMode) VALUES " +
                    "('" + endSeconds + "','" + endTime + "','" + getStartTime() + "','" + multiplier + "','" + activatorUUID + "','" + activatorName + "','" + gameMode + "');");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

        try {
            MySQL MySQL = new MySQL(sqlHostA, sqlPortA, sqlDbA, sqlUserA, sqlPwA);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("UPDATE `boosters` SET boosters = boosters - 1 WHERE UUID = '" + activatorUUID + "' AND server = '" + gameMode + "'");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public String getActivatorName() {
        return activatorName;
    }

    public String getGameMode() {
        return gameMode;
    }

    public UUID getActivatorUUID() {
        return activatorUUID;
    }
}