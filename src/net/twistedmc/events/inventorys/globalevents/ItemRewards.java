package net.twistedmc.events.inventorys.globalevents;

import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.cItemStack;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemRewards {

    public static ItemStack displayPickaxe = new cItemStack(Material.DIAMOND_PICKAXE).setDisplayName(c.aqua + "Frosty Pickaxe").addLore(
        "","","",
        c.gold + "✮✮✮✮✮ Legendary (Event)"

    ).addEnchant(Enchantment.MENDING,1).addEnchant(Enchantment.DIG_SPEED,7).addEnchant(Enchantment.LOOT_BONUS_BLOCKS,7).addEnchant(Enchantment.DURABILITY,5).addEnchant(Enchantment.DAMAGE_ALL,3);


}

/*
cock sucker

*/