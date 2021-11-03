package net.twistedmc.events.inventorys.store;

import net.minecraft.tags.Tag.f;
import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.API;
import net.twistedmc.events.util.item.cItemStack;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import net.twistedmc.events.util.item.AbstractGUI;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemFlag;
@SuppressWarnings("unused")
public class CandyStore extends AbstractGUI {

    /*
    00 01 02 03 04 05 06 07 08
    09    11    13    15    17
    18    20    22    24    26
    27 28 29    31    33    35
    36 37 38 39 40 41 42 43 44
    45 46 47 48 49 50 51 52 53
     */
    private static final int BORDER_FILL[] = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,45,44,46,47,48,50,51,52,53};

    public CandyStore(Player player) {
        super(6, "Halloween Store", player);
        
        fill(); // i hope i did this right.
        
        setItem(new cItemStack(Material.ARROW).setDisplayName(c.green + "Go Back").addLore
               (c.gray + "To Currency Menu")
        , 49, (s,c,p) -> { });

//////////////////////////////////////////////////////////////////////////////////////////////////////

        if (player.hasPermission("rank.vip") && API.canBuy(10000, "candy", player) || player.hasPermission("rank.vip") && !API.canBuy(10000, "candy", player)) {
            setItem(new cItemStack(Material.PAPER).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.dred + "VIP Rank (30 Days)").addLore
                            (c.gray + "VIP Rank provides basic",
                                    c.gray + "perks which improve the",
                                    c.gray + "TwistedMC experience!",
                                    "",
                                    c.gray + "Cost: " + c.red + c.strike + "70,000" + c.reset + c.gold + " 10,000 Candy",
                                    "",
                                    c.red + "Already owned!")
                    , 10, (s, c, p) -> {
                    });
        }

        if (API.canBuy(10000, "candy", player) && !player.hasPermission("rank.vip")) {
            setItem(new cItemStack(Material.PAPER).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.aqua + "VIP Rank (30 Days)").addLore
                            (c.gray + "VIP Rank provides basic",
                                    c.gray + "perks which improve the",
                                    c.gray + "TwistedMC experience!",
                                    "",
                                    c.gray + "Cost: " + c.red + c.strike + "70,000" + c.reset + c.gold + " 10,000 Candy",
                                    "",
                                    c.yellow + "Click to purchase VIP Rank!")
                    , 10, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(10000, "candy", player) && !player.hasPermission("rank.vip")) {
            setItem(new cItemStack(Material.PAPER).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "VIP Rank (30 Days)").addLore
                            (c.gray + "VIP Rank provides basic",
                                    c.gray + "perks which improve the",
                                    c.gray + "TwistedMC experience!",
                                    "",
                                    c.gray + "Cost: " + c.red + c.strike + "70,000" + c.reset + c.gold + " 10,000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 10, (s, c, p) -> {
                    });
        }

        //

        if (player.hasPermission("rank.vip+") && API.canBuy(35000, "candy", player) || player.hasPermission("rank.vip+") && !API.canBuy(35000, "candy", player)) {
            setItem(new cItemStack(Material.PAPER).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.dred + "VIP+ Rank (30 Days)").addLore
                            (c.gray + "VIP+ Rank contains",
                                    c.gray + "every perk from VIP",
                                    c.gray + "and then more!",
                                    "",
                                    c.gray + "Cost: " + c.red + c.strike + "100,000" + c.reset + c.gold + " 35,000 Candy",
                                    "",
                                    c.red + "Already owned!")
                    , 19, (s, c, p) -> {
                    });
        }

        if (API.canBuy(35000, "candy", player) && !player.hasPermission("rank.vip+")) {
            setItem(new cItemStack(Material.PAPER).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.aqua + "VIP+ Rank (30 Days)").addLore
                            (c.gray + "VIP+ Rank contains",
                                    c.gray + "every perk from VIP",
                                    c.gray + "and then more!",
                                    "",
                                    c.gray + "Cost: " + c.red + c.strike + "100,000" + c.reset + c.gold + " 35,000 Candy",
                                    "",
                                    c.yellow + "Click to purchase VIP+ Rank!")
                    , 19, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(35000, "candy", player) && !player.hasPermission("rank.vip+")) {
            setItem(new cItemStack(Material.PAPER).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "VIP+ Rank (30 Days)").addLore
                            (c.gray + "VIP+ Rank contains",
                                    c.gray + "every perk from VIP",
                                    c.gray + "and then more!",
                                    "",
                                    c.gray + "Cost: " + c.red + c.strike + "100,000" + c.reset + c.gold + " 35,000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 19, (s, c, p) -> {
                    });
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////

        if (API.canBuy(2200, "candy", player)) {
            setItem(new cItemStack(Material.TRIPWIRE_HOOK, 3).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "3x Autumn Crate Keys").addLore
                            (c.gray + "Win special Halloween",
                                    c.gray + "Cosmetics in this crate!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "2200 Candy",
                                    "",
                                    c.yellow + "Click to purchase 3x Autumn Crate Keys!")
                    , 12, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(2200, "candy", player)) {
            setItem(new cItemStack(Material.TRIPWIRE_HOOK, 3).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "3x Autumn Crate Keys").addLore
                            (c.gray + "Win special Halloween",
                                    c.gray + "Cosmetics in this crate!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "2200 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 12, (s, c, p) -> {
                    });
        }

        //

        if (API.canBuy(6000, "candy", player)) {
            setItem(new cItemStack(Material.TRIPWIRE_HOOK, 10).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "10x Autumn Crate Keys").addLore
                            (c.gray + "Win special Halloween",
                                    c.gray + "Cosmetics and Tools in",
                                    c.gray + "this crate!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "6000 Candy",
                                    "",
                                    c.yellow + "Click to purchase 10x Autumn Crate Keys!")
                    , 21, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(6000, "candy", player)) {
            setItem(new cItemStack(Material.TRIPWIRE_HOOK, 10).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "10x Autumn Crate Keys").addLore
                            (c.gray + "Win special Halloween",
                                    c.gray + "Cosmetics and Tools in",
                                    c.gray + "this crate!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "6000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 21, (s, c, p) -> {
                    });
        }

        //

        if (API.canBuy(2000, "candy", player)) {
            setItem(new cItemStack(Material.TRIPWIRE_HOOK, 3).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "3x Ultra Crate Keys").addLore
                            (c.gray + "Win special Cosmetics",
                                    c.gray + "and Tools in this crate",
                                    "",
                                    c.gray + "Cost: " + c.red + c.strike + "5000" + c.reset + c.gold + " 2000 Candy",
                                    "",
                                    c.yellow + "Click to purchase 3x Ultra Crate Keys!")
                    , 30, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(2000, "candy", player)) {
            setItem(new cItemStack(Material.TRIPWIRE_HOOK, 3).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "3x Ultra Crate Keys").addLore
                            (c.gray + "Win special Cosmetics",
                                    c.gray + "and Tools in this crate",
                                    "",
                                    c.gray + "Cost: " + c.red + c.strike + "5000" + c.reset + c.gold + " 2000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 30, (s, c, p) -> {
                    });
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////

        if (API.canBuy(7000, "candy", player)) {
            setItem(new cItemStack(Material.GOLD_NUGGET, 5).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "5,000 Gold").addLore
                            (c.gray + "Gold can be used for",
                                    c.gray + "the villager shops at spawn!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "7,000 Candy",
                                    "",
                                    c.yellow + "Click to purchase 5,000 Gold!")
                    , 14, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(7000, "candy", player)) {
            setItem(new cItemStack(Material.GOLD_NUGGET, 5).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "5,000 Gold").addLore
                            (c.gray + "Gold can be used for",
                                    c.gray + "the villager shops at spawn!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "7,000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 14, (s, c, p) -> {
                    });
        }

        //

        if (API.canBuy(19000, "candy", player)) {
            setItem(new cItemStack(Material.GOLD_NUGGET, 15).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "15,000 Gold").addLore
                            (c.gray + "Gold can be used for",
                                    c.gray + "the villager shops at spawn!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "19,000 Candy",
                                    "",
                                    c.yellow + "Click to purchase 15,000 Gold!")
                    , 23, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(19000, "candy", player)) {
            setItem(new cItemStack(Material.GOLD_NUGGET, 15).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "15,000 Gold").addLore
                            (c.gray + "Gold can be used for",
                                    c.gray + "the villager shops at spawn!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "19,000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 23, (s, c, p) -> {
                    });
        }

        //

        if (API.canBuy(30000, "candy", player)) {
            setItem(new cItemStack(Material.GOLD_NUGGET, 45).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "45,000 Gold").addLore
                            (c.gray + "Gold can be used for",
                                    c.gray + "the villager shops at spawn!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "30,000 Candy",
                                    "",
                                    c.yellow + "Click to purchase 45,000 Gold!")
                    , 32, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(30000, "candy", player)) {
            setItem(new cItemStack(Material.GOLD_NUGGET, 45).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "45,000 Gold").addLore
                            (c.gray + "Gold can be used for",
                                    c.gray + "the villager shops at spawn!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "30,000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 32, (s, c, p) -> {
                    });
        }

/* //////////////////////////////////////////////////////////////////////////////////////////////////////

        if (API.canBuy(10000, "candy", player)) {
            setItem(new cItemStack(Material.ENDER_EYE, 10).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "10,000 Coins").addLore
                            (c.gray + "Coins is the network",
                                    c.gray + "currency!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "10,000 Candy",
                                    "",
                                    c.yellow + "Click to purchase 10,000 Coins!")
                    , 16, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(10000, "candy", player)) {
            setItem(new cItemStack(Material.ENDER_EYE, 10).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "10,000 Coins").addLore
                            (c.gray + "Coins is the network",
                                    c.gray + "currency!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "10,000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 16, (s, c, p) -> {
                    });
        }

        //

        if (API.canBuy(25000, "candy", player)) {
            setItem(new cItemStack(Material.ENDER_EYE, 30).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "30,000 Coins").addLore
                            (c.gray + "Coins is the network",
                                    c.gray + "currency!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "25,000 Candy",
                                    "",
                                    c.yellow + "Click to purchase 30,000 Coins!")
                    , 25, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(25000, "candy", player)) {
            setItem(new cItemStack(Material.ENDER_EYE, 30).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "30,000 Coins").addLore
                            (c.gray + "Coins is the network",
                                    c.gray + "currency!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "25,000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 25, (s, c, p) -> {
                    });
        }

        //

        if (API.canBuy(40000, "candy", player)) {
            setItem(new cItemStack(Material.ENDER_EYE, 60).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.gold + "60,000 Coins").addLore
                            (c.gray + "Coins is the network",
                                    c.gray + "currency!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "40,000 Candy",
                                    "",
                                    c.yellow + "Click to purchase 60,000 Coins!")
                    , 34, (s, c, p) -> {
                    });
        }

        if (!API.canBuy(40000, "candy", player)) {
            setItem(new cItemStack(Material.ENDER_EYE, 60).addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setDisplayName(c.red + "60,000 Coins").addLore
                            (c.gray + "Coins is the network",
                                    c.gray + "currency!",
                                    "",
                                    c.gray + "Cost: " + c.gold + "40,000 Candy",
                                    "",
                                    c.red + "Not enough candy!")
                    , 34, (s, c, p) -> {
                    });
        }*/

    }
    private void fill() {
        Arrays.stream(BORDER_FILL).forEach(slot -> setItem(new cItemStack(Material.BLACK_STAINED_GLASS_PANE).setDisplayName(c.black  + "").addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS), slot, (s,c,p) -> { }));
    }
}
