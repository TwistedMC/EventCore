package net.twistedmc.events.util;

import org.bukkit.entity.Player;

import net.twistedmc.events.Main;

public class CanBuyItem {

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

}
