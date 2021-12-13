package net.twistedmc.events.inventorys.globalevents; 

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.cItemStack;

import java.text.NumberFormat;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class ItemRewards {

    public static ItemStack displayPickaxe = new cItemStack(Material.DIAMOND_PICKAXE).setDisplayName(c.aqua + c.italics + "Frosty Pickaxe").addLore(
            c.dgray + "Event Reward",
            c.gold + "✮✮✮✮✮ Legendary (Event)",
            "",
            c.aqua + "This pickaxe has been infused with ancient",
            c.aqua + "ice magic. Thus, giving it " + c.yellow + "increased mining speeds, ",
            c.aqua + "and the " + c.yellow + "ability to regenerate" + c.aqua + ". As well",
            c.aqua + "as a " + c.yellow + "sharper edge" + c.aqua + ". It's also been",
            c.aqua + "infused with " +"a " + c.yellow + "multiplier spell" + c.aqua + ".",
            "",
            c.gray + "Efficiency VII, Fortune VII, Mending I,",
            c.gray + "Sharpness III, Unbreaking V"

    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,7).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,7).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,3).addFlags(ItemFlag.HIDE_ENCHANTS);

    public static ItemStack displayAxe = new cItemStack(Material.DIAMOND_AXE).setDisplayName(c.aqua + c.italics + "Frosty Axe").addLore(
            c.dgray + "Event Reward",
            c.dpurple + "✮✮✮✮ Epic (Event)",
            "",
            c.aqua + "This axe has been infused with ancient",
            c.aqua + "ice magic. Thus, giving it " + c.yellow + "increased mining speeds, ",
            c.aqua + "and the " + c.yellow + "ability to regenerate" + c.aqua + ". The",
            c.yellow + "sharp edge" + c.aqua + " on this axe, has been",
            c.aqua + "favored more than it's other abilities.",
            "",
            c.gray + "Efficiency V, Fortune V, Mending I,",
            c.gray + "Sharpness VII, Unbreaking V"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,5).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,5).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,7).addFlags(ItemFlag.HIDE_ENCHANTS);

    public static ItemStack displayShovel = new cItemStack(Material.DIAMOND_SHOVEL).setDisplayName(c.aqua + c.italics + "Frosty Shovel").addLore(
            c.dgray + "Event Reward",
            c.blue + "✮✮✮ Rare (Event)",
            "",
            c.aqua + "This shovel has been infused with ancient",
            c.aqua + "ice magic. Thus, giving it " + c.yellow + "increased mining speeds, ",
            c.aqua + "and the " + c.yellow + "ability to regenerate" + c.aqua + ". The",
            c.yellow + "excavation speed" + c.aqua + " on this shovel, has been",
            c.aqua + "favored more than it's other abilities.",
            "",
            c.gray + "Efficiency VIII, Fortune III, Mending I,",
            c.gray + "Sharpness II, Unbreaking IV"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,8).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,3).addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.DAMAGE_ALL,2).addFlags(ItemFlag.HIDE_ENCHANTS);

    public static ItemStack displaySword = new cItemStack(Material.DIAMOND_SWORD).setDisplayName(c.aqua + c.italics + "Frosty Sword").addLore(
            c.dgray + "Event Reward",
            c.aqua + "✮✮ Uncommon (Event)",
            "",
            c.aqua + "This sword has been infused with ancient",
            c.aqua + "ice magic. Thus, giving it " + c.yellow + "increased damage, and ",
            c.aqua + "the " + c.yellow + "ability to regenerate" + c.aqua + ". It has",
            c.aqua + "also been infused with a " + c.yellow + "higher sweeping edge" + c.aqua + ".",
            "",
            c.gray + "Mending I, Sharpness VII, Sweeping Edge V,",
            c.gray + "Unbreaking V"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,7).addEnchant(Enchantment.SWEEPING_EDGE, 5).addFlags(ItemFlag.HIDE_ENCHANTS);

    NumberFormat f = NumberFormat.getInstance();
    static HeadDatabaseAPI HAPI = new HeadDatabaseAPI();
    public static ItemStack displayGold = new cItemStack(Material.GOLD_INGOT).setDisplayName(c.gold + "Gold Cache").addLore(
        c.dgray + "Event Reward",
        c.green + "✮ Common (Event)",
        "",
        c.dgray + "+" + c.gold + "5,000 Gold"
    );
}

/*
cock sucker
  uno reverse card
*/