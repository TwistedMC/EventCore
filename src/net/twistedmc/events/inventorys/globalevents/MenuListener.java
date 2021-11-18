package net.twistedmc.events.inventorys.globalevents;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;


public class MenuListener implements Listener{
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("2021 Winter Community Challenge")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + "Close")) {
                e.getWhoClicked().closeInventory();
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Snowflake Contribution Overview")) {
                Player plr = (Player) e.getWhoClicked();
                new ContributeMenu(plr);
            }
            if (e.getCurrentItem().getItemMeta().getLore().contains(c.aqua + "Frozen!")) {
                e.getWhoClicked().sendMessage(c.gray + "This prize is " + c.aqua + "Frozen!");
                e.getWhoClicked().sendMessage(c.gray + "Contribute toward the global goal using" + c.white + "Snowflakes " + c.gray + "to thaw the prize!");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase("Contribute Snowflakes")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + "Back")) {
                new GlobalMenu((Player) e.getWhoClicked());
                return;
            }

        }
    }
}
