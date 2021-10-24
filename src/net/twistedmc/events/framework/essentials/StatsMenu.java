package net.twistedmc.events.framework.essentials;

import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class StatsMenu extends AbstractGUI {

    /*
    00 01 02 03 04 05 06 07 08
    09 10 11 12 13 14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 29 30 31 32 33 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48 49 50 51 52 53
     */
    public StatsMenu(Player pp) {
        super(5, "Stats Viewer", pp);

        setItem(new cItemStack(Material.BOOK).setDisplayName(c.green + "Total Stats").addLore(
                c.gray + "Kills: " + c.white + "0",
                c.gray + "Deaths: " + c.white + "0",
                c.gray + "Wins: " + c.white + "0",
                "",
                c.gray + "Coins: " + c.white
        ), 4, (s,c,p) -> { });

        setItem(new cItemStack(Material.TNT).setDisplayName(c.green + "your mom").addLore(
                c.gray + "hi"
        ), 37, (s,c,p) -> { });



        // to open:
        //new StatsMenu(player);

    }
}