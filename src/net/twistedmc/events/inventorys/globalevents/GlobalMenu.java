package net.twistedmc.events.inventorys.globalevents;

import java.text.NumberFormat;
import java.util.Arrays;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.API;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;

public class GlobalMenu extends AbstractGUI {
    HeadDatabaseAPI HEADapi = new HeadDatabaseAPI();
    /*
    00 01 02 03 04 05 06 07 08
    09 10 11 12    14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 P1 P2 P3 P4 P5 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48    50 51 52 53
     */
    // Config
    public static int GlobalGoal = 250000;
    public static int Goal1 = 1000;
    public static int Goal2 = 2000;
    public static int Goal3 = 3000;
    public static int Goal4 = 4000;
    public static int Goal5 = 5000;
    public static String PermPrefix = "twisted.events.globalrewards.";
    NumberFormat format = NumberFormat.getInstance();
    //
    private static final int BORDER_FILL[] = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,45,44,46,47,48,50,51,52,53};

    public GlobalMenu(Player player) {
        // Placeholders

        super(6, "2021 Winter Community Challenge", player);
        fill();

        setItem(new cItemStack(Material.ARROW).setDisplayName(c.green + "Close").addLore
               (c.gray + "Close this menu")
        , 49, (s,c,p) -> { });

        setItem(new cItemStack(HEADapi.getItemHead("41106")).setDisplayName(c.white + "Snowflake Contribution Overview").addLore
               (c.gray + "Close this menu") 
        , 13, (s,c,p) -> { });

        setItems(player);
    }


    public void fill() {
        Arrays.stream(BORDER_FILL).forEach(slot -> setItem(new cItemStack(Material.BLACK_STAINED_GLASS_PANE).setDisplayName(c.black  + "").addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS), slot, (s,c,p) -> { })); 
    }
    public void setItems(Player player) {
        int contri = Main.getContribution(player);
        String prize1_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&4■_c:&a■_l:10_m:1000%"); String prize1_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:1000_d:0%");
        String prize2_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&4■_c:&a■_l:10_m:2000%"); String prize2_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:2000_d:0%");
        String prize3_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&4■_c:&a■_l:10_m:3000%"); String prize3_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:3000_d:0%");
        String prize4_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&4■_c:&a■_l:10_m:4000%"); String prize4_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:4000_d:0%");
        String prize5_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&4■_c:&a■_l:10_m:5000%"); String prize5_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:5000_d:0%");

        if (API.CanShowItem(Goal1, player, "contribution")) {
            //if(!player.hasPermission()) {
//
           // } else {
                //ItemStack i =
            //}
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39760")).setDisplayName(c.green + "Event Prize #1").addLore
                 (c.aqua + "Frozen!",c.gray + "Contribute toward the global goal using " + c.white + "Snowflakes" + c.gray + "to thaw the prize!","",
                 c.red + "Required Contribution: 1,000",
                 c.gray + "Progress:" + prize1_1 + "| (" + c.aqua + prize1_2 + c.gray + ")"
                 ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS)
            , 29, (s,c,p) -> { });
        }

        if (API.CanShowItem(Goal2, player, "contribution")) {

        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39759")).setDisplayName(c.green + "Event Prize #2").addLore
              (c.aqua + "Frozen!",c.gray + "Contribute toward the global goal using " + c.white + "Snowflakes" + c.gray + "to thaw the prize!","",
              c.red + "Required Contribution: 2,000",
                c.gray + "Progress:" + prize2_1 + "| (" + c.aqua + prize2_2 + c.gray + ")"

            ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS)
            , 30, (s,c,p) -> { });
        }

        if (API.CanShowItem(Goal3, player, "contribution")) {

        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39758")).setDisplayName(c.green + "Event Prize #3").addLore
                 (c.aqua + "Frozen!",c.gray + "Contribute toward the global goal using " + c.white + "Snowflakes" + c.gray + "to thaw the prize!","",
                 c.red + "Required Contribution: 3,000",
                 c.gray + "Progress:" + prize3_1 + "| (" + c.aqua + prize3_2 + c.gray + ")"

                 ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS)
            , 31, (s,c,p) -> { });
        }

        if (API.CanShowItem(Goal4, player, "contribution")) {

        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39757")).setDisplayName(c.green + "Event Prize #4").addLore
                 (c.aqua + "Frozen!",c.gray + "Contribute toward the global goal using " + c.white + "Snowflakes" + c.gray + "to thaw the prize!","",
                 c.red + "Required Contribution: 4,000",
                c.gray + "Progress:" + prize4_1 + "| (" + c.aqua + prize4_2 + c.gray + ")"

                 ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS)
            , 32, (s,c,p) -> { });
        }

        if (API.CanShowItem(Goal5, player, "contribution")) {

        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39756")).setDisplayName(c.green + "Event Prize #5").addLore
                 (c.aqua + "Frozen!",c.gray + "Contribute toward the global goal using " + c.white + "Snowflakes" + c.gray + "to thaw the prize!","",
                 c.red + "Required Contribution: 5,000",
                 c.gray + "Progress:" + prize5_1 + "| (" + c.aqua + prize5_2 + c.gray + ")"

                 ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS)
            , 33, (s,c,p) -> { });
        }


    }
}
