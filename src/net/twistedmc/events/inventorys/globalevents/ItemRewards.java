package net.twistedmc.events.inventorys.globalevents; 

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.cItemStack;

import java.text.NumberFormat;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemRewards {

    public static ItemStack displayPickaxe = new cItemStack(Material.DIAMOND_PICKAXE).setDisplayName(c.aqua + c.italics + "Frosty Pickaxe").addLore(
        c.aqua + "This pickaxe has been infused", c.aqua + "with ancient ice magic.",
        c.aqua + "Thus, giving it increased mining speeds,", c.aqua + "and the ability to regenerate.",
        c.aqua + "As well as a sharper edge,", c.aqua + "it's also been infused with", c.aqua + " a multiplier spell.",
        "",
        c.gold + "✮✮✮✮✮ Legendary (Event)"

    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,7).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,7).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,3);

    public static ItemStack displayAxe = new cItemStack(Material.DIAMOND_AXE).setDisplayName(c.aqua + c.italics + "Frosty Axe").addLore(
        c.aqua + "This axe has been infused", c.aqua + " with ancient ice magic.",
        c.aqua + "Thus, giving it increased mining speeds,", c.aqua + "and the ability to regenerate.",
        c.aqua + "This axe's sharp edge has been", c.aqua + "favored more then", c.aqua + " it's other abilities. ",
        "",
        c.dpurple + "✮✮✮✮ Very Rare (Event)"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,5).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,5).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,7);

    public static ItemStack displayShovel = new cItemStack(Material.DIAMOND_SHOVEL).setDisplayName(c.aqua + c.italics + "Frosty Shovel").addLore(
        c.aqua + "This shovel has been infused", c.aqua + "with ancient ice magic.",
        c.aqua + "Thus, giving it increased mining speeds,", c.aqua + "and the ability to regenerate.",
        c.aqua + "This shovel's excavation speed has been", c.aqua + "favored more then", c.aqua + " it's other abilities. ",
        "",
        c.blue + "✮✮✮ Rare (Event)"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,8).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,3).addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.DAMAGE_ALL,2);

    public static ItemStack displaySword = new cItemStack(Material.DIAMOND_SWORD).setDisplayName(c.aqua + c.italics + "Frosty Sword").addLore(
        c.aqua + "This sword has been infused", c.aqua + "with ancient ice magic.",
        c.aqua + "Thus, giving it increased damage,", c.aqua + "and the ability to regenerate.",
        c.aqua + "It has also been infused ", c.aqua + "with a higher sweeping edge.",
        "",
        c.green + "✮✮ Uncommon (Event)"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,7).addEnchant(Enchantment.SWEEPING_EDGE, 5);

    NumberFormat f = NumberFormat.getInstance();
    static HeadDatabaseAPI HAPI = new HeadDatabaseAPI();
    public static ItemStack displayGold = new cItemStack(HAPI.getItemHead("46945")).setDisplayName(c.gold + "Gold Cache").addLore(
        c.gray + "Receive " + c.gold + "5,000 Gold" + c.gray + " upon opening this cache.",
        "",
        c.gray + "✮ Common (Event)");
}

/*
cock sucker
  uno reverse card
*/