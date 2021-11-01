package net.twistedmc.events.util;


import java.util.Random;

import org.bukkit.inventory.ItemStack;

public class GenerateRandomItem {
    public static Random r = new Random(); // dumb as fuck that i had to intialize it here but whatever. -nation
    public static ItemStack generateRandomItem(ItemStack[] items) {
        int ran = r.nextInt(items.length);
        ItemStack item = items[ran];
        return item;
    }
}
