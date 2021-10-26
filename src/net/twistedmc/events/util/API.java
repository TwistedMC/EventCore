package net.twistedmc.events.util;

import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

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
    
    
}
