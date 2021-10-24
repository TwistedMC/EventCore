package net.twistedmc.events.util.item;

import java.util.UUID;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
public class SkullGen {
    public static ItemStack getCustomSkull(String headURL) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        if (headURL.isEmpty()) return head;
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", headURL));
        try {
            Method mtd = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
            mtd.setAccessible(true);
            mtd.invoke(skullMeta, profile);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        head.setItemMeta(skullMeta);
        return head;
    }
}
