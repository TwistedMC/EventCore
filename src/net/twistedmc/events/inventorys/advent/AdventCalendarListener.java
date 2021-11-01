package net.twistedmc.events.inventorys.advent;


import net.twistedmc.events.data.c;
import net.twistedmc.events.util.CanBuyItem;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class AdventCalendarListener implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryClick(InventoryDragEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 4th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 4th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            player.closeInventory();
        }

    }

}
