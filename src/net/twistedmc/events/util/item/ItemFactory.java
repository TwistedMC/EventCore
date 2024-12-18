package net.twistedmc.events.util.item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ItemFactory {

    private Material material;
    private Integer amount = 1;
    private int data = 0;
    private String displayname, playerName;
    private List<String> lore = new ArrayList<>();
    private boolean unbreakable = false;

    public ItemFactory(Material material) {
        this.material = material;
    }

    public ItemStack buildItem() {
        if (material == Material.LEGACY_SKULL_ITEM) {
            if (playerName == null){
                Bukkit.getLogger().log(Level.WARNING, "[EVENT CORE] Tried to build a skull with no player name associated with it!");
                return null;
            }
            ItemStack item = new ItemStack(Material.LEGACY_SKULL_ITEM, amount, (byte) 3);
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta.setOwner(playerName);
            if (displayname!= null) meta.setDisplayName(displayname);
            meta.setLore(lore);
            meta.setUnbreakable(unbreakable);
            item.setItemMeta(meta);
            return item;
        } else {
            ItemStack item = new ItemStack(material, amount, (byte) data);
            ItemMeta meta = item.getItemMeta();
            if (displayname!= null) meta.setDisplayName(displayname);
            meta.setLore(lore);
            meta.setUnbreakable(unbreakable);
            item.setItemMeta(meta);
            return item;
        }
    }

    public ItemFactory displayName(String name) {
        displayname = name;
        return this;
    }

    public ItemFactory lore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemFactory data(int data) {
        this.data = data;
        return this;
    }

    public ItemFactory unbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    public ItemFactory amount(Integer amount) {
        this.amount = amount;
        return this;
    }
    public ItemFactory playerName(String playerName) {
        this.playerName = playerName;
        return this;
    }
}