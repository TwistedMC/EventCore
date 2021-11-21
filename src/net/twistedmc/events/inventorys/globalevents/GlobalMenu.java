package net.twistedmc.events.inventorys.globalevents;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import me.clip.placeholderapi.PlaceholderAPI;
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
    public static boolean AllContributionGetsPrize = false; // Anybody who donates any snowflakes (even after the goal is reached) will get the prize
    public static int Goal1 = 1000;
    public static int Goal2 = 2000;
    public static int Goal3 = 3000;
    public static int Goal4 = 4000;
    public static int Goal5 = 5000;
    public static String PermPrefix = "twisted.events.globalrewards.";
    NumberFormat format = NumberFormat.getInstance();
    // 
    private static final int BORDER_FILL[] = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,45,44,46,47,48,50,51,52,53};
    private static final int INSIDE_FILL[] = {10,11,12,14,15,16,19,20,21,22,23,24,25,28,34,37,38,39,40,41,42,43};

    public GlobalMenu(Player player) {
        super(6, "2021 Winter Community Challenge", player);
        fill();
        //Placeholders
        String global1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_globalcontributionraw}_r:&c■_c:&a■_p:&c■_l:10_m:"+ GlobalGoal+ "%"); String global2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_globalcontributionraw}_m:"+ GlobalGoal + "_d:2%");

        setItem(new cItemStack(Material.ARROW).setDisplayName(c.red + "Close"), 49, (s,c,p) -> { });

        setItem(new cItemStack(HEADapi.getItemHead("41106")).setDisplayName(c.white + c.line + "Snowflake Contribution Overview").addLore(
                        c.gray + "Progress towards the global goal,",
                        c.gray + "which if unlocked, will give ALL players",
                        c.gray + "who participated a reward!",
                        "",
                        c.gray + "Goal: " + c.white + format.format(GlobalGoal) + "❄",
                        c.gray + "Progress: " + global1 + c.gray + " (" + c.aqua + global2 + "%" + c.gray + ")",
                        "",
                        c.gray + "Total Snowflakes Contributed: " + c.white + API.getTotalContributionFormatted() + "❄",
                        c.gray + "Your Contributed Snowflakes: " + c.white + format.format(Main.getContribution(player)) + "❄",
                        "",
                        c.yellow + "Click to contribute " + c.white + "Snowflakes" + c.gray + "!" // Open the contribute menu
               ) 
        , 13, (s,c,p) -> { });

        setItems(player);
    }
    public void fill() {
        Arrays.stream(BORDER_FILL).forEach(slot -> setItem(new cItemStack(Material.BLACK_STAINED_GLASS_PANE).setDisplayName(c.black  + "").addFlags(ItemFlag.HIDE_ENCHANTS), slot, (s,c,p) -> { }));
        ItemStack Green = new cItemStack(Material.GREEN_STAINED_GLASS_PANE).setDisplayName(c.green + "").addFlags(ItemFlag.HIDE_ENCHANTS);
        ItemStack Red = new cItemStack(Material.RED_STAINED_GLASS_PANE).setDisplayName(c.red + "").addFlags(ItemFlag.HIDE_ENCHANTS);
        ItemStack[] items = {Green,Red,Red,Green};
        Arrays.stream(INSIDE_FILL).forEach(slot -> setItem(API.generateRandomItem(items),slot, (s,c,p) -> { }));
    }
    public void setItems(Player player) {
        // Prizes:
        // 1 - Gold; 2 - Sword; 3 - Shovel; 4 - Axe; 5 - Pickaxe // TO-DO: put frozen on bottom and replace it on top with prize rarity (Maybe prize rarity)
        // Placeholders
        String prize1_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&c■_c:&a■_l:10_p:&c■_m:"+ Goal1 +"%"); String prize1_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:"+ Goal1 +"_d:0%");
        String prize2_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&c■_c:&a■_l:10_p:&c■_m:"+ Goal2 +"%"); String prize2_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:"+ Goal2 +"_d:0%");
        String prize3_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&c■_c:&a■_l:10_p:&c■_m:"+ Goal3 +"%"); String prize3_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:"+ Goal3 +"_d:0%");
        String prize4_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&c■_c:&a■_l:10_p:&c■_m:"+ Goal4 +"%"); String prize4_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:"+ Goal4 +"_d:0%");
        String prize5_1 = PlaceholderAPI.setPlaceholders(player, "%progress_bar_{events_contribution}_r:&c■_c:&a■_l:10_p:&c■_m:"+ Goal5 +"%"); String prize5_2 = PlaceholderAPI.setPlaceholders(player, "%progress_percentage_{events_contribution}_m:"+ Goal5 +"_d:0%");
        if (API.CanShowItem(Goal1, player, "contribution")) {
            if(!player.hasPermission(PermPrefix + "prize1")) {
                ItemStack i = ItemRewards.displayGold.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.yellow + "Click to claim!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 29, (s,c,p) -> { });
            } else {
                ItemStack i = ItemRewards.displayGold.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.red + "Already claimed!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 29, (s,c,p) -> { });
            }
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39760")).setDisplayName(c.green + "Event Prize #1").addLore(
                            c.dgray + "Event Reward",
                            c.gray + "✮ Common (Event)",
                            "",
                            c.gray + "Contribute toward the global goal using",
                            c.white + "Snowflakes " + c.gray + "to thaw the prize!",
                            "",
                            c.red + "Required Contribution: " + c.white + "1,000❄",
                            c.gray + "Progress: " + prize1_1 + c.gray + " | (" + c.aqua + prize1_2 + "%"+ c.gray + ")",
                            "",
                            c.aqua + "Frozen!"
                 ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).addFlags(ItemFlag.HIDE_ATTRIBUTES)
            , 29, (s,c,p) -> { });
        }

        if (API.CanShowItem(Goal2, player, "contribution")) {
            if(!player.hasPermission(PermPrefix + "prize2")) {
                ItemStack i = ItemRewards.displaySword.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.yellow + "Click to claim!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 30, (s,c,p) -> { });
            } else {
                ItemStack i = ItemRewards.displaySword.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.red + "Already claimed!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 30, (s,c,p) -> { });
            }
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39759")).setDisplayName(c.green + "Event Prize #2").addLore(
                            c.dgray + "Event Reward",
                            c.green + "✮✮ Uncommon (Event)",
                            "",
                            c.gray + "Contribute toward the global goal using",
                            c.white + "Snowflakes " + c.gray + "to thaw the prize!",
                            "",
                            c.red + "Required Contribution: " + c.white + "2,000❄",
                            c.gray + "Progress: " + prize2_1 + c.gray + " | (" + c.aqua + prize2_2 + "%"+ c.gray + ")",
                            "",
                            c.aqua + "Frozen!"
                    ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).addFlags(ItemFlag.HIDE_ATTRIBUTES)
                    , 30, (s,c,p) -> { });
        }

        if (API.CanShowItem(Goal3, player, "contribution")) {
            if(!player.hasPermission(PermPrefix + "prize3")) {
                ItemStack i = ItemRewards.displayShovel.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.yellow + "Click to claim!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 31, (s,c,p) -> { });
            } else {
                ItemStack i = ItemRewards.displayShovel.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.red + "Already claimed!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 31, (s,c,p) -> { });
            }
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39758")).setDisplayName(c.green + "Event Prize #3").addLore(
                            c.dgray + "Event Reward",
                            c.blue + "✮✮✮ Rare (Event)",
                            "",
                            c.gray + "Contribute toward the global goal using",
                            c.white + "Snowflakes " + c.gray + "to thaw the prize!",
                            "",
                            c.red + "Required Contribution: " + c.white + "3,000❄",
                            c.gray + "Progress: " + prize3_1 + c.gray + " | (" + c.aqua + prize3_2 + "%"+ c.gray + ")",
                            "",
                            c.aqua + "Frozen!"
                    ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).addFlags(ItemFlag.HIDE_ATTRIBUTES)
                    , 31, (s,c,p) -> { });
        }

        if (API.CanShowItem(Goal4, player, "contribution")) {
            if(!player.hasPermission(PermPrefix + "prize4")) {
                ItemStack i = ItemRewards.displayAxe.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.yellow + "Click to claim!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 32, (s,c,p) -> { });
            } else {
                ItemStack i = ItemRewards.displayAxe.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.red + "Already claimed!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 32, (s,c,p) -> { });
            }
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39757")).setDisplayName(c.green + "Event Prize #4").addLore(
                            c.dgray + "Event Reward",
                            c.dpurple + "✮✮✮✮ Epic (Event)",
                            "",
                            c.gray + "Contribute toward the global goal using",
                            c.white + "Snowflakes " + c.gray + "to thaw the prize!",
                            "",
                            c.red + "Required Contribution: " + c.white + "4,000❄",
                            c.gray + "Progress: " + prize4_1 + c.gray + " | (" + c.aqua + prize4_2 + "%"+ c.gray + ")",
                            "",
                            c.aqua + "Frozen!"
                    ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).addFlags(ItemFlag.HIDE_ATTRIBUTES)
                    , 32, (s,c,p) -> { });
        }

        if (API.CanShowItem(Goal5, player, "contribution")) {
            if(!player.hasPermission(PermPrefix + "prize5")) {
                ItemStack i = ItemRewards.displayPickaxe.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.yellow + "Click to claim!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 33, (s,c,p) -> { });
            } else {
                ItemStack i = ItemRewards.displayPickaxe.clone();
                ItemMeta im = i.getItemMeta();
                List<String> il = im.getLore();
                il.add("");
                il.add(c.red + "Already claimed!");
                im.setLore(il);
                i.setItemMeta(im);
                setItem(i, 33, (s,c,p) -> { });
            }
        } else {
            setItem(new cItemStack(HEADapi.getItemHead("39756")).setDisplayName(c.green + "Event Prize #5").addLore(
                            c.dgray + "Event Reward",
                            c.gold + "✮✮✮✮✮ Legendary (Event)",
                            "",
                            c.gray + "Contribute toward the global goal using",
                            c.white + "Snowflakes " + c.gray + "to thaw the prize!",
                            "",
                            c.red + "Required Contribution: " + c.white + "5,000❄",
                            c.gray + "Progress: " + prize5_1 + c.gray + " | (" + c.aqua + prize5_2 + "%"+ c.gray + ")",
                            "",
                            c.aqua + "Frozen!"
                    ).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).addFlags(ItemFlag.HIDE_ATTRIBUTES)
                    , 33, (s,c,p) -> { });
        }
/*
    00 01 02 03 04 05 06 07 08
    09 10 11 12    14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 P1 P2 P3 P4 P5 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48    50 51 52 53
     */

    }
}
