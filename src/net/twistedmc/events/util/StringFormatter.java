package net.twistedmc.events.util;

@Deprecated
public class StringFormatter {
    public static String formatString(String stringtoformat,String thingtoformat) {
        String str = String.format(stringtoformat, thingtoformat);
        return str;
    }

   /*  public static String formatStringBoolean(String stringtoformat,Boolean thingtoformat) {
        String str = stringtoformat.format(stringtoformat, thingtoformat);
        return str;
    }
    public static String formatStringInt(String stringtoformat,String thingtoformat) {
        String str = stringtoformat.format(stringtoformat, thingtoformat);
        return str;
    }
    public static String formatString(String stringtoformat,String thingtoformat) {
        String str = stringtoformat.format(stringtoformat, thingtoformat);
        return str;
    }*/
} 
