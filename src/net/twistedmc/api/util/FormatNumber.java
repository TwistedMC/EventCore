package net.twistedmc.api.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;


public class FormatNumber
{
    public static String MakeStr(long time, int trim) { return convertString(Math.max(0L, time), trim, TimeUnit.FIT); }





    public static String convertString(long time, int trim, TimeUnit type) {
        if (time == -1L) return "Permanent";

        if (type == TimeUnit.FIT) {
            if (time < 60000L) { type = TimeUnit.SECONDS; }
            else if (time < 3600000L) { type = TimeUnit.MINUTES; }
            else if (time < 86400000L) { type = TimeUnit.HOURS; }
            else { type = TimeUnit.DAYS; }

        }

        String text;
        double num;
        if (trim == 0){
            if (type == TimeUnit.DAYS)			text = (num = trim(trim, time / 86400000d)) + " Day";
            else if (type == TimeUnit.HOURS)	text = (num = trim(trim, time / 3600000d)) + " Hour";
            else if (type == TimeUnit.MINUTES)	text = (num = trim(trim, time / 60000d)) + " Minute";
            else if (type == TimeUnit.SECONDS)	text = (int) (num = (int) trim(trim, time / 1000d)) + " Second";
            else								text = (int) (num = (int) trim(trim, time)) + " Millisecond";
        }else{
            if (type == TimeUnit.DAYS)			text = (num = trim(trim, time / 86400000d)) + " Day";
            else if (type == TimeUnit.HOURS)	text = (num = trim(trim, time / 3600000d)) + " Hour";
            else if (type == TimeUnit.MINUTES)	text = (num = trim(trim, time / 60000d)) + " Minute";
            else if (type == TimeUnit.SECONDS)	text = (num = trim(trim, time / 1000d)) + " Second";
            else								text = (int) (num = (int) trim(0, time)) + " Millisecond";
        }

        if (num != 1)
            text += "s";

        return text;
    }



    public static double trim(int degree, double d) {
        String format = "#.#";

        for (int i = 1; i < degree; i++) {
            format = String.valueOf(format) + "#";
        }
        DecimalFormatSymbols symb = new DecimalFormatSymbols(Locale.US);
        DecimalFormat twoDForm = new DecimalFormat(format, symb);
        return Double.valueOf(twoDForm.format(d)).doubleValue();
    }

    public static String convertmstoTime(long ms) {
        if (ms > 86400000) {
            return Math.round((((double) ms / (double) 86400000) * 100.0) / 10.0) / 10.0 + " days";
        } else if (ms > 3600000) {
            return Math.round((((double) ms / (double) 3600000) * 100.0) / 10.0) / 10.0 + " hours";
        } else if (ms > 60000) {
            return Math.round((((double) ms / (double) 60000) * 100.0) / 10.0) / 10.0 + " minutes";
        } else {
            return Math.round((((double) ms / (double) 1000) * 100.0) / 10.0) / 10.0 + " seconds";
        }
    }

    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
