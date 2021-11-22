package net.twistedmc.events.inventorys.advent;


import net.twistedmc.events.data.c;
import net.twistedmc.events.util.API;
import net.twistedmc.events.util.CanBuyItem;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
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

        if (e.getCurrentItem() == null) {
            return;
        }
        if (e.getCurrentItem().getItemMeta() == null) {
            return;
        }

        if (e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 1st") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 1st" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 1);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate give p winter 3 " + player.getName());
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 2nd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 2nd" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 2);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givebooster " + player.getName() + " ENCHANTED 1 2 3");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 3rd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 3rd" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 3);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "coins add " + player.getName() + " 10000");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 4th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 4th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 4);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate give p ultra 3 " + player.getName());
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 5th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 5th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 5);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + player.getName() + " permission set arrowtrail.effect.flash true");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givegold " + player.getName() + " 3000 Advent Reward");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 6th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 6th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 6);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givebooster " + player.getName() + " ENCHANTED 1 2 3");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 7th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 7th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 7);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "coins add " + player.getName() + " 10000");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 8th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 8th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 8);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givegold " + player.getName() + " 5000 Advent Reward");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 9th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 9th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 9);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate give p winter 3 " + player.getName());
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 10th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 10th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 10);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + player.getName() + " permission set killeffects.lightning true");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givegold " + player.getName() + " 3000 Advent Reward");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 11th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 11th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 11);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + player.getName() + " permission set twisted.hub.punch.snowball true");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "coins add " + player.getName() + " 10000");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 12th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 12th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 12);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gmysterybox give " + player.getName() + " 3 3");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 13th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 13th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 13);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + player.getName() + " permission set twisted.chatemotes.snow true");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 14th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 14th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 14);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gmenu addperm miniature reindeer " + player.getName());
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givegold " + player.getName() + " 3000 Advent Reward");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 15th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 15th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 15);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gmenu addperm gadget let_it_snow " + player.getName());
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givegold " + player.getName() + " 3000 Advent Reward");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 16th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 16th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 16);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givebooster " + player.getName() + " BEDWARS 1 2 3");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 17th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 17th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 17);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givexpbooster " + player.getName() + " ENCHANTED 1 2 1");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 18th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 18th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 18);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "hcc " + player.getName() + " add 300");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 19th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 19th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 19);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givegold " + player.getName() + " 15000 Advent Reward");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 20th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 20th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 20);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate give p winter 3 " + player.getName());
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 21st") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 21st" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 21);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate give p rare 3 " + player.getName());
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 22nd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 22nd" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 22);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "coins add " + player.getName() + " 50000");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 23rd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 23rd" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 23);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givegold " + player.getName() + " 3-000 Advent Reward");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 24th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 24th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 24);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "consolegive " + player.getName() + " netherite_ingot 5");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givexpbooster " + player.getName() + " ENCHANTED 1 3 1");
            player.closeInventory();
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.green + c.bold + "December 25th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.green + "You claimed the " + c.aqua + "Advent Calendar " + c.green + "reward for " + c.aqua + "December 25th" + c.green + "!");
            player.sendMessage(c.green + "Happy Holidays!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            API.addAdvent(player, 25);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "giverankgift " + player.getName() + " vip");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gmysterybox give " + player.getName() + " 6 3");
            player.closeInventory();
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 1st") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 2nd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 3rd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 4th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 5th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 6th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 7th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 8th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 9th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 10th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 11th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 12th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 13th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 14th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 15th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 16th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 17th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 18th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 19th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 20th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 21st") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 22nd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 23rd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 24th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.white + c.bold + "December 25th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry! " + c.red + "Looks like you've already claimed this reward!");
            player.closeInventory();
            return;
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 1st") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 1st!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 2nd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 2nd!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 3rd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 3rd!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 4th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 4th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 5th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 5th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 6th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 6th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 7th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 7th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 8th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 8th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 9th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 9th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 10th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 10th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 11th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 11th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 12th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 12th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 13th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 13th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 14th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 14th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 15th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 15th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 16th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 16th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 17th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 17th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 18th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 18th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 19th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 19th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 20th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 20th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 21st") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 21st!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 22nd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 22nd!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 23rd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 23rd!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 24th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 24th!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + c.bold + "December 25th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.red + c.bold + "Sorry!" + c.red + " Reward is still a mystery! Check back on December 25th!");
            player.closeInventory();
            return;
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 1st") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 2nd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 3rd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 4th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 5th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 6th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 7th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 8th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 9th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 10th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 11th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 12th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 13th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 14th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 15th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 16th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 17th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 18th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 19th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 20th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 21st") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 22nd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 23rd") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 24th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + c.bold + "December 25th") && e.getView().getTitle().equalsIgnoreCase("2021 Advent Calendar")) {
            player.sendMessage(c.aqua + c.bold + "Oops!" + c.aqua + " Seems like you've missed this reward!");
            player.closeInventory();
            return;
        }

    }

}
