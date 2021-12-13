package net.twistedmc.events.inventorys;

import net.twistedmc.events.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;
import org.bukkit.inventory.ItemFlag;

import java.text.NumberFormat;

public class MainMenu extends AbstractGUI implements Listener {
/*
    00 01 02 03 04 05 06 07 08
    09 10 11 12 USED 14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 29 30 31 32 33 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48 49 50 51 52 53
     */

    HeadDatabaseAPI api = new HeadDatabaseAPI();
    public MainMenu(Player pp) {
        super(4, "Seasonal Menu", pp);

        NumberFormat formatter = NumberFormat.getIntegerInstance();

        String candies = formatter.format(Main.getCandies(pp));
        String snowflakes = formatter.format(Main.getSnowflakes(pp));

            setItem(new cItemStack(Material.CANDLE).setDisplayName(c.purple + "Your Halloween " + c.gold + "Candies " + c.purple + "Chest").addLore(
                    c.gray + "All your Halloween seasonal currency",
                    c.gray + "has been contained in this chest, for safe keeping.",
                    c.gray + "This chest has been imbued with a magic to only allow",
                    c.gray + "you to open it and use it in the Candies shop.",
                    "",
                    c.gray + "This chest is holding " + c.gold + candies + " Candies",
                    "",
                    c.red + "Closed!"
            ), 14, (s,c,p) -> { });

            setItem(new cItemStack(Material.SNOWBALL).setDisplayName(c.purple + "Your Winter " + c.white + "Snowflakes " + c.purple + "Snowglobe").addLore(
                    c.gray + "All your Winter seasonal currency",
                    c.gray + "has been contained in this chest, for safe keeping.",
                    c.gray + "This globe has been imbued with a magic to only allow",
                    c.gray + "you to open it and use it in the Snowflakes shop.",
                    "",
                    c.gray + "This chest is holding " + c.white + snowflakes + "❄",
                    "",
                    c.yellow + "Click to open Snowflake Contribution!"
            ), 12, (s,c,p) -> { });

        setItem(new cItemStack(Material.WRITTEN_BOOK).setDisplayName(c.yellow + "Information").addFlags(ItemFlag.HIDE_ATTRIBUTES).addLore(
                c.gray + "Simply put, this menu will allow you to access",
                c.gray + "the two currency stores for limited time rewards.",
                "",
                c.gray + "For more information, please head to:",
                c.aqua + "https://twistedmc.net/seasonal-info/"
        ), 31, (s,c,p) -> { });
    }
}
