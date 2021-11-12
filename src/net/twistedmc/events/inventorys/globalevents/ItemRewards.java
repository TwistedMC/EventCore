package net.twistedmc.events.inventorys.globalevents; 

import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.cItemStack;

import java.text.NumberFormat;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemRewards {

    public static ItemStack displayPickaxe = new cItemStack(Material.DIAMOND_PICKAXE).setDisplayName(c.aqua + c.italics + "Frosty Pickaxe").addLore(
        c.aqua + "This pickaxe has been infused with ancient ice magic.",
        c.aqua + "Thus, giving it increased mining speeds, and the ability to regenerate.",
        c.aqua + "As well as a sharper edge, it's also been infused with a multiplier magic.",
        "",
        c.gold + "✮✮✮✮✮ Legendary (Event)"

    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,7).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,7).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,3);

    public static ItemStack displayAxe = new cItemStack(Material.DIAMOND_AXE).setDisplayName(c.aqua + c.italics + "Frosty Axe").addLore(
        c.aqua + "This axe has been infused with ancient ice magic.",
        c.aqua + "Thus, giving it increased mining speeds, and the ability to regenerate.",
        c.aqua + "This axe's sharp edge has been favored more then it's other abilities. ",
        "",
        c.dpurple + "✮✮✮✮ Very Rare (Event)"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,5).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,5).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,7);

    public static ItemStack displayShovel = new cItemStack(Material.DIAMOND_SHOVEL).setDisplayName(c.aqua + c.italics + "Frosty Shovel").addLore(
        c.aqua + "This shovel has been infused with ancient ice magic.",
        c.aqua + "Thus, giving it increased mining speeds, and the ability to regenerate.",
        c.aqua + "This shovel's excavation speed has been favored more then it's other abilities. ",
        "",
        c.blue + "✮✮✮ Rare (Event)"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,8).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,3).addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.DAMAGE_ALL,2);

    public static ItemStack displaySword = new cItemStack(Material.DIAMOND_SHOVEL).setDisplayName(c.aqua + c.italics + "Frosty Sword").addLore(
        c.aqua + "This sword has been infused with ancient ice magic.",
        c.aqua + "Thus, giving it increased damage, and the ability to regenerate.",
        c.aqua + "It has also been infused with a higher sweeping edge. ",
        "",
        c.green + "✮✮ Uncommon (Event)"
    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,7).addEnchant(Enchantment.SWEEPING_EDGE, 5);

    NumberFormat f = NumberFormat.getInstance();
    public static ItemStack displayGold = new cItemStack(Material.BUNDLE).setDisplayName(c.gold + "Gold Cache").addLore(
        c.gray + "Receive " + c.gold + "5,000 Gold" + c.gray + " upon opening this cache.",
        "",
        c.gray + "✮ Common (Event)");
}

/*
cock sucker
  uno reverse card
*/