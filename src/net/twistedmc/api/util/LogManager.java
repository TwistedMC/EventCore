package net.twistedmc.api.util;

import org.bukkit.Bukkit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogManager {

    public static void logConsole(String message) {
        System.out.println("[LOG]" + "[" + FormatNumber.getDate() + "] " + message);
    }

    public static void logError(String message) {
        System.out.println("[ERROR]");
        System.out.println("[ERROR]" + "[" + FormatNumber.getDate() + "] " + message);
        System.out.println("[ERROR]");
        logFile("[ERROR]");
        logFile("[ERROR]" + "[" + FormatNumber.getDate() + "] " + message);
        logFile("[ERROR]");
    }

    public static void logWarning(String message) {
        System.out.println("[WARNING]" + "[" + FormatNumber.getDate() + "] " + message);
        logFile("[WARNING]" + "[" + FormatNumber.getDate() + "] " + message);
    }

    public static void logFile(String message) {
        SimpleDateFormat fileDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String FILENAME = Bukkit.getServer().getWorldContainer().getAbsolutePath() + "/coreLogs/" + fileDateFormat.format(new Date()) + ".log";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            SimpleDateFormat messageDateFormat = new SimpleDateFormat("HH:mm:ss");
            bw.write("[" + messageDateFormat.format(new Date()) + "] " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}