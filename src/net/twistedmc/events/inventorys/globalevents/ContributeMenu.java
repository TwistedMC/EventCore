package net.twistedmc.events.inventorys.globalevents;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.API;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.text.NumberFormat;
import java.util.Arrays;

public class ContributeMenu extends AbstractGUI {
    HeadDatabaseAPI HEADapi = new HeadDatabaseAPI();
    static int GlobalGoal = GlobalMenu.GlobalGoal;
    NumberFormat format = NumberFormat.getInstance();
    private static final int BORDER_FILL[] = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,45,44,46,47,48,50,51,52,53};
    private static final int INSIDE_FILL[] = {10,11,12,14,15,16,19,20,21,22,23,24,25,28,34,37,38,39,40,41,42,43};
    /*
    00 01 02 03 04 05 06 07 08
    09 10 11 12    14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 29 30 31 32 33 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48    50 51 52 53
     */
    public ContributeMenu(Player player) {
        super(6,"Contribute Snowflakes",player);
        fill();
        // Placeholders
        String global1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_globalcontributionraw}_r:&c■_c:&a■_p:&c■_l:10_m:"+ GlobalGoal+ "%"); String global2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_globalcontributionraw}_m:"+ GlobalGoal + "_d:2%");

        setItem(new cItemStack(Material.ARROW).setDisplayName(c.red + "Go Back").addLore
                        (c.gray + "To the Main Menu")
                , 49, (s,c,p) -> { });
        int sf = Main.getSnowflakes(player);
        setItem(new cItemStack(HEADapi.getItemHead("41106")).setDisplayName(c.white + c.line + "Snowflake Contribution Overview").addLore(
                        c.gray + "Goal: " + c.white + format.format(GlobalGoal) + "❄",
                        c.gray + "Progress: " + global1 + c.gray + " (" + c.aqua + global2 + "%" + c.gray + ")",
                        "",
                        c.gray + "Total Snowflakes Contributed: " + c.white + API.getTotalContributionFormatted() + "❄",
                        c.gray + "Your Contributed Snowflakes: " + c.white + format.format(Main.getContribution(player)) + "❄",
                        c.gray + "You currently have: " + c.white + format.format(sf) + "❄"
                )
                , 13, (s,c,p) -> { });

    setItems(player);
    }
    public void fill() {
        Arrays.stream(BORDER_FILL).forEach(slot -> setItem(new cItemStack(Material.BLACK_STAINED_GLASS_PANE).setDisplayName(c.black  + "").addFlags(ItemFlag.HIDE_ENCHANTS), slot, (s, c, p) -> { }));
        ItemStack Cyan = new cItemStack(Material.CYAN_STAINED_GLASS_PANE).setDisplayName(c.black + "").addFlags(ItemFlag.HIDE_ENCHANTS).addFlags(ItemFlag.HIDE_ATTRIBUTES);
        ItemStack White = new cItemStack(Material.WHITE_STAINED_GLASS_PANE).setDisplayName(c.black + "").addFlags(ItemFlag.HIDE_ENCHANTS).addFlags(ItemFlag.HIDE_ATTRIBUTES);
        ItemStack LBlue = new cItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setDisplayName(c.black + "").addFlags(ItemFlag.HIDE_ENCHANTS).addFlags(ItemFlag.HIDE_ATTRIBUTES);
        ItemStack[] items = {Cyan,White,LBlue};
        Arrays.stream(INSIDE_FILL).forEach(slot -> setItem(API.generateRandomItem(items),slot, (s,c,p) -> { }));
    }
    public void setItems(Player plr) {
        if (API.canBuy(50,"snowflakes",plr)) {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 50❄").addLore("",c.yellow + "Click to Contribute!")
                    ,29, (s,c,p) -> { });
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 50❄").addLore("",c.red + "Not enough "+c.white+"Snowflakes"+c.red+"!")
                    ,29, (s,c,p) -> { });
        }
        if (API.canBuy(100,"snowflakes",plr)) {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 100❄").addLore("",c.yellow + "Click to Contribute!")
                    ,30, (s,c,p) -> { });
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 100❄").addLore("",c.red + "Not enough "+c.white+"Snowflakes"+c.red+"!")
                    ,30, (s,c,p) -> { });

        }
        if (API.canBuy(200,"snowflakes",plr)) {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 200❄").addLore("",c.yellow + "Click to Contribute!")
                    ,31, (s,c,p) -> { });
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 200❄").addLore("",c.red + "Not enough "+c.white+"Snowflakes"+c.red+"!")
                    ,31, (s,c,p) -> { });
        }
        if (API.canBuy(500,"snowflakes",plr)) {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 500❄").addLore("",c.yellow + "Click to Contribute!")
                    ,32, (s,c,p) -> { });
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 500❄").addLore("", c.red + "Not enough " + c.white + "Snowflakes" + c.red + "!")
                    , 32, (s, c, p) -> {
                    });
        }
        if (API.canBuy(1000,"snowflakes",plr)) {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 1,000❄").addLore("",c.yellow + "Click to Contribute!")
                    ,33, (s,c,p) -> { });
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39739")).setDisplayName(c.white + "Contribute 1,000❄").addLore("",c.red + "Not enough "+c.white+"Snowflakes"+c.red+"!")
                    ,33, (s,c,p) -> { });
        }
    }
}