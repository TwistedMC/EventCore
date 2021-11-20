package net.twistedmc.events.inventorys.globalevents;

import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class MenuListener implements Listener{
    @EventHandler(priority = EventPriority.LOW)
    public void onInventoryClick(InventoryClickEvent e) {
        Player pp = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("2021 Winter Community Challenge")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "Close")) {
                e.getWhoClicked().closeInventory();
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white+ c.line + "Snowflake Contribution Overview")) {
              if (API.getTotalContributionRAW() < Main.GlobalGoal && !Main.AllContributionGetsPrize) {
                Player plr = (Player) e.getWhoClicked();
                new ContributeMenu(plr);
                return;
             }
            }
            if (e.getCurrentItem().getItemMeta().getLore().contains(c.aqua + "Frozen!")) {
                e.getWhoClicked().sendMessage(c.gray + "This prize is " + c.aqua + "Frozen!");
                e.getWhoClicked().sendMessage(c.gray + "Contribute toward the global goal using " + c.white + "Snowflakes " + c.gray + "to thaw the prize!");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase("Contribute Snowflakes")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "Go Back")) {
                new GlobalMenu(pp);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getLore().contains(c.red + "Not enough "+c.white+"Snowflakes"+c.red+"!")) {
                e.getWhoClicked().sendMessage(c.red + "You do not have enough "+c.white+"Snowflakes"+ c.red+" to do this!");
            }
            if (e.getCurrentItem().getItemMeta().getLore().contains(c.yellow + "Click to Contribute!")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 50❄")) {
                    API.ContributionTransaction(pp,50);
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 100❄")) {
                    API.ContributionTransaction(pp,100);
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 200❄")) {
                    API.ContributionTransaction(pp,200);
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 500❄")) {
                    API.ContributionTransaction(pp,500);
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 1000❄")) {
                    API.ContributionTransaction(pp,1000);
                    return;
                }
            }
        }
    }
}