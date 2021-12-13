package net.twistedmc.events.inventorys.globalevents;

import net.twistedmc.events.data.c;
import net.twistedmc.events.inventorys.MainMenu;
import net.twistedmc.events.util.EventAPI;
import net.twistedmc.events.util.errors.APIException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;


public class MenuListener implements Listener{

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryDrag(InventoryDragEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("2021 Winter Community Challenge")) {
            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase("Contribute Snowflakes")) {
            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryDrag(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("2021 Winter Community Challenge")) {
            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase("Contribute Snowflakes")) {
            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getLore().contains(c.gray + "To Currency Menu") && e.getView().getTitle().equalsIgnoreCase("Halloween Store")) {
            new MainMenu((Player) e.getWhoClicked());
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.purple + "Your Halloween " + c.gold + "Candies " + c.purple + "Chest") && e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            e.getWhoClicked().sendMessage(c.red + c.bold + "Sorry! " + c.red + "The Candy Store is currently disabled!");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.purple + "Your Winter " + c.white + "Snowflakes " + c.purple + "Snowglobe") && e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            new GlobalMenu((Player) e.getWhoClicked());
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.yellow + "Information") && e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            e.getWhoClicked().sendMessage(c.yellow + "More information: https://twistedmc.net/seasonal-info/");
            e.getWhoClicked().closeInventory();
            return;
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onInventoryClick(InventoryClickEvent e) throws APIException {
        if (e.getCurrentItem() == null) {
            return;
        }
        if (e.getCurrentItem().getItemMeta() == null) {
            return;
        }
        Player pp = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("2021 Winter Community Challenge")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "Close")) {
                e.getWhoClicked().closeInventory();
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white+ c.line + "Snowflake Contribution Overview")) {
             //if (API.getTotalContributionRAW() < GlobalMenu.GlobalGoal && !GlobalMenu.AllContributionGetsPrize) {
                Player plr = (Player) e.getWhoClicked();
                new ContributeMenu(plr);
                return;
             //} // Eligibility locked out in API, this will let players still get the completion reward

            }
            if (e.getCurrentItem().getItemMeta().getLore().contains(c.red + "Already claimed!")) {
                pp.sendMessage(c.red + "You have already claimed this prize!");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getLore().contains(c.yellow + "Click to claim!")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "Gold Cache")) {
                    pp.sendMessage(c.green + "Claimed Event Reward 1!");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"givegold " + pp.getName() + " 5000 Winter Event Reward");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user " + pp.getName() + " permission set " + GlobalMenu.PermPrefix + "prize1 true");
                    new GlobalMenu(pp);
                    return;
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
                        pp.sendMessage(c.red + "Your inventory is full!");
                    }
                    new GlobalMenu(pp);
                    return;
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
                        pp.sendMessage(c.red + "Your inventory is full!");
                    }
                    new GlobalMenu(pp);
                    return;
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
                        pp.sendMessage(c.red + "Your inventory is full!");
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
                        pp.sendMessage(c.red + "Your inventory is full!");
                    }
                    new GlobalMenu(pp);
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
                    EventAPI.ContributionTransaction(pp,50);
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 100❄")) {
                    EventAPI.ContributionTransaction(pp,100);
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 200❄")) {
                    EventAPI.ContributionTransaction(pp,200);
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 500❄")) {
                    EventAPI.ContributionTransaction(pp,500);
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + "Contribute 1,000❄")) {
                    EventAPI.ContributionTransaction(pp,1000);
                    return;
                }
            }
        }
    }
}