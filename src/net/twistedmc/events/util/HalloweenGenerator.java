package net.twistedmc.events.util;

import java.util.Random;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
public class HalloweenGenerator {
    public static String[][] tricks = {{""}};
    public static String[][] treats = {{"hcc %s add 10"},{"hcc %s add 20"},{"hcc %s add 30"},{"hcc %s add 40"},{"hcc %s add 50"}};
    public static String[] calc = {"treats","tricks"};
    public static Random r;
    String c;

   public static String[] TrickorTreat() {
        String t = calc[r.nextInt(calc.length)];
        if (t.toString() == "treats") {
            String[] treat = treats[r.nextInt(treats.length)];
            return treat;
        } else if (t.toString() == "tricks") {
            String[] trick = tricks[r.nextInt(tricks.length)];
            return trick;
        } else {
            String[] err = {"error"};
            return err;
        }
    }

    public static void FormatAndExecute(String[] commands, Player plr) {
        if (commands.length == 1 && commands[0] == "error") {Bukkit.getLogger().log(Level.SEVERE, "[Events] There was an error attempting to use the ToT system. | " + System.currentTimeMillis() + " | " + Bukkit.getServer().getName() + ":" + Bukkit.getServer().getPort());} else {
           // String cmd = String.format(command, plr.getName());
           // Bukkit.dispatchCommand(Bukkit.getConsoleSender(),cmd);
        //    for (int i=0; i < commands.length; i++) {
        //        if (commands[i].contains("%s")) {
        //         string str = StringFormatter.formatString(commands, thingtoformat)
        //         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commandLine)
        //        } else {
        //         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commandLine)
        //        }
        //    }
        }
    }
}
