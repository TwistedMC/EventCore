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
import org.bukkit.inventory.ItemStack;


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
              if (API.getTotalContributionRAW() < GlobalMenu.GlobalGoal && !GlobalMenu.AllContributionGetsPrize) {
                Player plr = (Player) e.getWhoClicked();
                new ContributeMenu(plr);
                return;
             }
            }
            if (e.getCurrentItem().getItemMeta().getLore().contains(c.red + "Already claimed!")) {
                pp.sendMessage(c.red + "You have already claimed this prize!");
            }
            if (e.getCurrentItem().getItemMeta().getLore().contains(c.yellow + "Click to claim!")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "Gold Cache")) {
                    pp.sendMessage(c.green + "Claimed Event Reward 1!");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"givegold " + pp.getName() + " 5000 Winter Event Reward");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user " + pp.getName() + " permission set " + GlobalMenu.PermPrefix + "prize1 true");
                    new GlobalMenu(pp);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.italics + "Frosty Sword")) {
                    if (pp.getInventory().firstEmpty() != -1){
                    // there is at least one empty slot so you can add items.
                        ItemStack item = ItemRewards.displaySword.clone();
                        int slot = pp.getInventory().firstEmpty();
                        pp.getInventory().setItem(slot,item);
                        pp.sendMessage(c.green + "Claimed Event Reward 2!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user " + pp.getName() + " permission set " + GlobalMenu.PermPrefix + "prize2 true");
                    } else {
                    // no empty slot found.
                        pp.sendMessage("Please have at least one empty slot.");
                    }
                    new GlobalMenu(pp);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.italics + "Frosty Shovel")) {
                    if (pp.getInventory().firstEmpty() != -1){
                        // there is at least one empty slot so you can add items.
                        ItemStack item = ItemRewards.displayShovel.clone();
                        int slot = pp.getInventory().firstEmpty();
                        pp.getInventory().setItem(slot,item);
                        pp.sendMessage(c.green + "Claimed Event Reward 3!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user " + pp.getName() + " permission set " + GlobalMenu.PermPrefix + "prize3 true");
                    } else {
                        // no empty slot found.
                        pp.sendMessage("Please have at least one empty slot.");
                    }
                    new GlobalMenu(pp);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.italics + "Frosty Axe")) {
                    if (pp.getInventory().firstEmpty() != -1){
                        // there is at least one empty slot so you can add items.
                        ItemStack item = ItemRewards.displayAxe.clone();
                        int slot = pp.getInventory().firstEmpty();
                        pp.getInventory().setItem(slot,item);
                        pp.sendMessage(c.green + "Claimed Event Reward 4!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user " + pp.getName() + " permission set " + GlobalMenu.PermPrefix + "prize4 true");
                    } else {
                        // no empty slot found.
                        pp.sendMessage("Please have at least one empty slot.");
                    }
                    new GlobalMenu(pp);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.italics + "Frosty Pickaxe")) {
                    if (pp.getInventory().firstEmpty() != -1){
                        // there is at least one empty slot so you can add items.
                        ItemStack item = ItemRewards.displayPickaxe.clone();
                        int slot = pp.getInventory().firstEmpty();
                        pp.getInventory().setItem(slot,item);
                        pp.sendMessage(c.green + "Claimed Event Reward 5!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user " + pp.getName() + " permission set " + GlobalMenu.PermPrefix + "prize5 true");
                    } else {
                        // no empty slot found.
                        pp.sendMessage("Please have at least one empty slot.");
                    }
                    new GlobalMenu(pp);
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
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 1,000❄")) {
                    API.ContributionTransaction(pp,1000);
                    return;
                }
            }
        }
    }
}