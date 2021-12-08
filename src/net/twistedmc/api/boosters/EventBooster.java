package net.twistedmc.api.boosters;

import net.twistedmc.api.mysql.MySQL;

import java.sql.SQLException;
import java.sql.Statement;

public class EventBooster extends NetworkBooster {

    private String reason;

    public EventBooster(long startTime, long endTime, int multiplier, String reason) {
        super(startTime, endTime, multiplier);

        this.reason = reason;
    }

    public EventBooster(long endTime, int multiplier, String reason) {
        this(System.currentTimeMillis(), endTime, multiplier, reason);

        String sqlHost = "173.44.44.251";
        String sqlPort = "3306";
        String sqlDb = "network_boosters?useSSL=false";
        String sqlUser = "network_boosters";
        String sqlPw = "MEuek6BqD3jFYvVC";

        try {
            MySQL MySQL = new MySQL(sqlHost, sqlPort, sqlDb, sqlUser, sqlPw);
            Statement statement = MySQL.openConnection().createStatement();
            statement.executeUpdate("INSERT INTO eventBoosters (endTime, startTime, multiplier, reason) VALUES ('" + endTime +
                    "','" + getStartTime() + "','" + multiplier + "','" + reason + "');");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public String getReason() {
        return reason;
    }

}