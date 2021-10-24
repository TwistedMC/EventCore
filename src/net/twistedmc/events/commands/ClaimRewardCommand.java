package net.twistedmc.events.commands;


import me.clip.placeholderapi.PlaceholderAPI;
import net.ranktw.DiscordWebHooks.DiscordEmbed;
import net.ranktw.DiscordWebHooks.DiscordMessage;
import net.ranktw.DiscordWebHooks.DiscordWebhook;
import net.ranktw.DiscordWebHooks.embed.FooterEmbed;
import net.twistedmc.events.Main;
import net.twistedmc.events.MySQL;
import net.twistedmc.events.data.c;
import net.twistedmc.events.framework.essentials.StatsMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ClaimRewardCommand implements CommandExecutor, Listener {

    @SuppressWarnings("unused")
    private Main core;
    public ClaimRewardCommand(Main core) {
        this.core = core;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equals("rewards")) {
            if (sender.hasPermission("twisted.events.blocked")) {
                sender.sendMessage(c.red + "You are banned from Events!");
                return true;
            }

            Player player = (Player)sender;

            player.sendMessage(c.red + "No events are currently active.");
            new StatsMenu(player);

            /**int progress = 0;


            try {
                MySQL MySQL = new MySQL(core.sqlHost, core.sqlPort, core.sqlDb, core.sqlUser, core.sqlPw);
                Statement statement = MySQL.openConnection().createStatement();
                ResultSet result = statement.executeQuery("SELECT progress VALUE FROM progress WHERE uuid = '" + player.getUniqueId() + "'");
                while (result.next()) {
                    progress = result.getInt("VALUE");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            Inventory gui2 = Bukkit.getServer().createInventory(player, 54, "Summer Event Rewards");


            if (progress < 20) {

                ItemStack ref1 = new ItemStack(Material.DIAMOND);

                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();

                ref1.setItemMeta(metaref1);

                lore.add(c.red + c.bold + "ONE REWARD PER PLAYER.");
                lore.add(c.gray + "This reward contains a VIP Rank Voucher!");
                lore.add(c.gray + "Redeem the voucher for your account, or give the");
                lore.add(c.gray + "voucher to a friend or another player!");
                lore.add(c.red + c.bold + "MAKE SURE YOU HAVE AN OPEN SLOT IN YOUR INVENTORY.");
                lore.add("");
                lore.add(c.red + c.bold + "PLEASE NOTE:");
                lore.add(c.red + "WE WILL NOT TAKE AWAY THE RANK IF");
                lore.add(c.red + "YOU ACCIDENTALLY GIVE IT TO THE WRONG");
                lore.add(c.red + "PERSON, CLAIM IT FOR YOURSELF, ITEM CLEAR CLEARS IT. OR");
                lore.add(c.red + "CLAIMED THE WRONG REWARD.");
                lore.add("");
                lore.add(c.red + "You have not completed the Event!");

                metaref1.setLore(lore);
                metaref1.setDisplayName(c.red + "VIP Rank");

                ref1.setItemMeta(metaref1);
                gui2.setItem(20, ref1);

            }

            if (progress == 20) {

                ItemStack ref1 = new ItemStack(Material.DIAMOND);

                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();

                ref1.setItemMeta(metaref1);

                lore.add(c.red + c.bold + "ONE REWARD PER PLAYER.");
                lore.add(c.gray + "This reward contains a VIP Rank Voucher!");
                lore.add(c.gray + "Redeem the voucher for your account, or give the");
                lore.add(c.gray + "voucher to a friend or another player!");
                lore.add(c.red + c.bold + "MAKE SURE YOU HAVE AN OPEN SLOT IN YOUR INVENTORY.");
                lore.add("");
                lore.add(c.red + c.bold + "PLEASE NOTE:");
                lore.add(c.red + "WE WILL NOT TAKE AWAY THE RANK IF");
                lore.add(c.red + "YOU ACCIDENTALLY GIVE IT TO THE WRONG");
                lore.add(c.red + "PERSON, CLAIM IT FOR YOURSELF, ITEM CLEAR CLEARS IT. OR");
                lore.add(c.red + "CLAIMED THE WRONG REWARD.");
                lore.add("");
                lore.add(c.green + "CLICK TO REDEEM THIS PRIZE!");

                metaref1.setLore(lore);
                metaref1.setDisplayName(c.green + "VIP Rank");

                ref1.setItemMeta(metaref1);
                gui2.setItem(20, ref1);

            }

            //40k gold
            if (progress < 20) {

                ItemStack ref1 = new ItemStack(Material.GOLD_INGOT);

                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();

                ref1.setItemMeta(metaref1);

                lore.add(c.red + c.bold + "ONE REWARD PER PLAYER.");
                lore.add(c.gray + "This reward contains 40,000 GOLD");
                lore.add(c.gray + "YOU WILL COLLECT THE GOLD AUTOMATICALLY.");
                lore.add("");
                lore.add(c.red + c.bold + "PLEASE NOTE:");
                lore.add(c.red + "WE WILL NOT REFUND YOU IF");
                lore.add(c.red + "YOU ACCIDENTALLY CLAIMED THE WRONG REWARD.");
                lore.add("");
                lore.add(c.red + "You have not completed the Event!");

                metaref1.setLore(lore);
                metaref1.setDisplayName(c.red + "40,000 Gold");

                ref1.setItemMeta(metaref1);
                gui2.setItem(22, ref1);

            }

            if (progress == 20) {

                ItemStack ref1 = new ItemStack(Material.GOLD_INGOT);

                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();

                ref1.setItemMeta(metaref1);

                lore.add(c.red + c.bold + "ONE REWARD PER PLAYER.");
                lore.add(c.gray + "This reward contains 40,000 GOLD");
                lore.add(c.gray + "YOU WILL COLLECT THE GOLD AUTOMATICALLY.");
                lore.add("");
                lore.add(c.red + c.bold + "PLEASE NOTE:");
                lore.add(c.red + "WE WILL NOT REFUND YOU IF");
                lore.add(c.red + "YOU ACCIDENTALLY CLAIMED THE WRONG REWARD.");
                lore.add("");
                lore.add(c.green + "CLICK TO REDEEM THIS PRIZE!");

                metaref1.setLore(lore);
                metaref1.setDisplayName(c.green + "40,000 Gold");

                ref1.setItemMeta(metaref1);
                gui2.setItem(22, ref1);

            }

            //CRATE KEYS
            if (progress < 20) {

                ItemStack ref1 = new ItemStack(Material.TRIPWIRE_HOOK);

                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();

                ref1.setItemMeta(metaref1);

                lore.add(c.red + c.bold + "ONE REWARD PER PLAYER.");
                lore.add(c.gray + "This reward contains 3 ULTRA KEYS &");
                lore.add(c.gray + "2 SUMMER KEYS");
                lore.add(c.gray + "YOU WILL COLLECT THE KEYS AUTOMATICALLY.");
                lore.add(c.red + c.bold + "MAKE SURE YOU HAVE AN OPEN SLOT IN YOUR INVENTORY.");
                lore.add("");
                lore.add(c.red + c.bold + "PLEASE NOTE:");
                lore.add(c.red + "WE WILL NOT REFUND YOU IF");
                lore.add(c.red + "YOU DO NOT HAVE ENOUGH INVENTORY SPACE OR");
                lore.add(c.red + "YOU DROP THE KEYS");
                lore.add("");
                lore.add(c.red + "You have not completed the Event!");

                metaref1.setLore(lore);
                metaref1.setDisplayName(c.red + "Crate Keys");

                ref1.setItemMeta(metaref1);
                gui2.setItem(24, ref1);

            }

            if (progress == 20) {

                ItemStack ref1 = new ItemStack(Material.TRIPWIRE_HOOK);

                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();

                ref1.setItemMeta(metaref1);

                lore.add(c.red + c.bold + "ONE REWARD PER PLAYER.");
                lore.add(c.gray + "This reward contains 3 ULTRA KEYS &");
                lore.add(c.gray + "2 SUMMER KEYS");
                lore.add(c.gray + "YOU WILL COLLECT THE KEYS AUTOMATICALLY.");
                lore.add(c.red + c.bold + "MAKE SURE YOU HAVE AN OPEN SLOT IN YOUR INVENTORY.");
                lore.add("");
                lore.add(c.red + c.bold + "PLEASE NOTE:");
                lore.add(c.red + "WE WILL NOT REFUND YOU IF");
                lore.add(c.red + "YOU DO NOT HAVE ENOUGH INVENTORY SPACE OR");
                lore.add(c.red + "YOU DROP THE KEYS");
                lore.add("");
                lore.add(c.green + "CLICK TO REDEEM THIS PRIZE!");

                metaref1.setLore(lore);
                metaref1.setDisplayName(c.green + "Crate Keys");

                ref1.setItemMeta(metaref1);
                gui2.setItem(24, ref1);

            }


            player.openInventory(gui2);
             */
        }

        return true;
    }
    /*
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getView().getTitle().equals("Summer Event Rewards")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(final InventoryMoveItemEvent e) {
        if (e.getItem().getItemMeta().getDisplayName().equals(c.green + "VIP Rank"))  {
            e.setCancelled(true);
        }
        if (e.getItem().getItemMeta().getDisplayName().equals(c.green + "40,000 Gold"))  {
            e.setCancelled(true);
        }
        if (e.getItem().getItemMeta().getDisplayName().equals(c.green + "Crate Keys"))  {
            e.setCancelled(true);
        }
        if (e.getItem().getItemMeta().getDisplayName().equals(c.red + "VIP Rank"))  {
            e.setCancelled(true);
        }
        if (e.getItem().getItemMeta().getDisplayName().equals(c.red + "40,000 Gold"))  {
            e.setCancelled(true);
        }
        if (e.getItem().getItemMeta().getDisplayName().equals(c.red + "Crate Keys"))  {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(final InventoryInteractEvent e) {
        if (e.getView().getTitle().equals("Summer Event Rewards")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equals("Summer Event Rewards")) {
            e.setCancelled(true);
        }

        if (e.getClick().isShiftClick() && e.getView().equals("Summer Event Rewards")) {
            e.setCancelled(true);
        }


            if (!player.hasPermission("twisted.events.redeem.reward")) {
                player.sendMessage(c.red + "A transaction is already being processed! Please wait.");
                player.closeInventory();
                return;
            }

            int progress = 0;


            try {
                MySQL MySQL = new MySQL(core.sqlHost, core.sqlPort, core.sqlDb, core.sqlUser, core.sqlPw);
                Statement statement = MySQL.openConnection().createStatement();
                ResultSet result = statement.executeQuery("SELECT progress VALUE FROM progress WHERE uuid = '" + player.getUniqueId() + "'");
                while (result.next()) {
                    progress = result.getInt("VALUE");
                }
            } catch (SQLException | ClassNotFoundException c) {
                c.printStackTrace();
            }

            final ItemStack clickedItem = e.getCurrentItem();

            if (clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName() != null && clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName().equals(c.green + "VIP Rank") && e.getSlot() == 20 && player.hasPermission("twisted.events.redeem.reward")) {

                player.sendMessage(c.green + "Processing transaction.. Please wait.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward false");
                int finalProgress = progress;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (finalProgress == 20 && player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.red + "Nice try. You already redeemed your reward. :)");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                        if (shasta.twistedmc.restart.Main.timeRemaining <= 20 || net.twistedmc.saferestart.Main.timeRemaining <= 20) {
                            player.sendMessage(c.red + "Due to the server reboot, you are not able to redeem a reward.");
                            return;
                        }

                        if (hasEmptySlot(player) == false) {
                            player.sendMessage(c.red + "Transaction failed! Your Inventory is full!");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                        if (hasEmptySlot(player) == true && finalProgress == 20 && !player.hasPermission("twisted.events.redeem.reward") && !player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.green + "Transaction successful! " + c.yellow + "1x VIP Voucher " + c.green + "added to your inventory.");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "voucher give viprank 1 " + player.getName());
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeemed.reward true");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            Bukkit.getConsoleSender().sendMessage(c.aqua + c.bold + "[SUMMER EVENT 2021] " + c.yellow + player.getName() + c.gray + " redeemed VIP Voucher!");

                            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
                            DiscordWebhook discord = new DiscordWebhook(webhook);

                            DiscordMessage dm = new DiscordMessage.Builder()
                                    .build();

                            DiscordEmbed embed = new DiscordEmbed.Builder()
                                    .withColor(new Color(0, 159, 0))
                                    .withTitle("Event Reward Redeems")
                                    .withDescription(player.getName() + "'s redeemed the VIP Voucher!")
                                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                                    .withTimestamp(System.currentTimeMillis())
                                    .build();

                            dm.addEmbeds(embed);

                            discord.sendMessage(dm);


                            String sqlHostE = "173.44.44.251";
                            String sqlPortE = "3306";
                            String sqlDbE = "network_events?useSSL=false";
                            String sqlUserE = "network_events";
                            String sqlPwE = "mDYvjpZIbj1CZjGD";

                            try {
                                MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                                Statement statement = MySQL.openConnection().createStatement();
                                statement.executeUpdate("UPDATE `networkEvents` SET claimableRewards = claimableRewards - 1 WHERE UUID = '" + player.getUniqueId() + "'");
                            } catch (SQLException | ClassNotFoundException s) {
                                s.printStackTrace();
                            }

                            try {
                                MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                                Statement statement = MySQL.openConnection().createStatement();
                                statement.executeUpdate("UPDATE `networkEvents` SET rewardsClaimed = rewardsClaimed + 1 WHERE UUID = '" + player.getUniqueId() + "'");
                            } catch (SQLException | ClassNotFoundException s) {
                                s.printStackTrace();
                            }

                            return;
                        }

                        if (finalProgress < 20 && !player.hasPermission("twisted.events.redeem.reward") && !player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.red + "Transaction failed! You have not completed the event!");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("EventCore"), 30);
                return;
            }


            if (clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName() != null && clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName().equals(c.green + "40,000 Gold") && e.getSlot() == 22 && player.hasPermission("twisted.events.redeem.reward")) {

                player.sendMessage(c.green + "Processing transaction.. Please wait.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward false");
                int finalProgress = progress;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (finalProgress == 20 && player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.red + "Nice try. You already redeemed your reward. :)");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                        if (shasta.twistedmc.restart.Main.timeRemaining <= 20 || net.twistedmc.saferestart.Main.timeRemaining <= 20) {
                            player.sendMessage(c.red + "Due to the server reboot, you are not able to redeem a reward.");
                            return;
                        }

                        if (hasEmptySlot(player) == false) {
                            player.sendMessage(c.red + "Transaction failed! Your Inventory is full!");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                        if (hasEmptySlot(player) == true && finalProgress == 20 && !player.hasPermission("twisted.events.redeem.reward") && !player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.green + "Transaction successful! " + c.yellow + "40,000 Gold " + c.green + "added to your balance.");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 40000");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeemed.reward true");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            Bukkit.getConsoleSender().sendMessage(c.aqua + c.bold + "[SUMMER EVENT 2021] " + c.yellow + player.getName() + c.gray + " redeemed 40,000 Gold!");

                            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
                            DiscordWebhook discord = new DiscordWebhook(webhook);

                            DiscordMessage dm = new DiscordMessage.Builder()
                                    .build();

                            DiscordEmbed embed = new DiscordEmbed.Builder()
                                    .withColor(new Color(0, 159, 0))
                                    .withTitle("Event Reward Redeems")
                                    .withDescription(player.getName() + "'s redeemed the 40,000 Gold!")
                                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                                    .withTimestamp(System.currentTimeMillis())
                                    .build();

                            dm.addEmbeds(embed);

                            discord.sendMessage(dm);


                            String sqlHostE = "173.44.44.251";
                            String sqlPortE = "3306";
                            String sqlDbE = "network_events?useSSL=false";
                            String sqlUserE = "network_events";
                            String sqlPwE = "mDYvjpZIbj1CZjGD";

                            try {
                                MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                                Statement statement = MySQL.openConnection().createStatement();
                                statement.executeUpdate("UPDATE `networkEvents` SET claimableRewards = claimableRewards - 1 WHERE UUID = '" + player.getUniqueId() + "'");
                            } catch (SQLException | ClassNotFoundException s) {
                                s.printStackTrace();
                            }

                            try {
                                MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                                Statement statement = MySQL.openConnection().createStatement();
                                statement.executeUpdate("UPDATE `networkEvents` SET rewardsClaimed = rewardsClaimed + 1 WHERE UUID = '" + player.getUniqueId() + "'");
                            } catch (SQLException | ClassNotFoundException s) {
                                s.printStackTrace();
                            }

                            return;
                        }

                        if (finalProgress < 20 && !player.hasPermission("twisted.events.redeem.reward") && !player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.red + "Transaction failed! You have not completed the event!");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("EventCore"), 30);
                return;
            }

            if (clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName() != null && clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName().equals(c.green + "Crate Keys") && e.getSlot() == 24 && player.hasPermission("twisted.events.redeem.reward")) {

                player.sendMessage(c.green + "Processing transaction.. Please wait.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward false");
                int finalProgress = progress;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (finalProgress == 20 && player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.red + "Nice try. You already redeemed your reward. :)");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                        if (shasta.twistedmc.restart.Main.timeRemaining <= 20 || net.twistedmc.saferestart.Main.timeRemaining <= 20) {
                            player.sendMessage(c.red + "Due to the server reboot, you are not able to redeem a reward.");
                            return;
                        }

                        if (hasEmptySlot(player) == false) {
                            player.sendMessage(c.red + "Transaction failed! Your Inventory is full!");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                        if (hasEmptySlot(player) == true && finalProgress == 20 && !player.hasPermission("twisted.events.redeem.reward") && !player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.green + "Transaction successful! " + c.yellow + "3x Ultra Keys & 2 Summers Keys " + c.green + "added to your inventory.");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crazycrates:cc give p ultra 3 " + player.getName());
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crazycrates:cc give p summer 2 " + player.getName());
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeemed.reward true");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            Bukkit.getConsoleSender().sendMessage(c.aqua + c.bold + "[SUMMER EVENT 2021] " + c.yellow + player.getName() + c.gray + " redeemed Crate Keys!");

                            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
                            DiscordWebhook discord = new DiscordWebhook(webhook);

                            DiscordMessage dm = new DiscordMessage.Builder()
                                    .build();

                            DiscordEmbed embed = new DiscordEmbed.Builder()
                                    .withColor(new Color(0, 159, 0))
                                    .withTitle("Event Reward Redeems")
                                    .withDescription(player.getName() + "'s redeemed the Crate Keys!")
                                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                                    .withTimestamp(System.currentTimeMillis())
                                    .build();

                            dm.addEmbeds(embed);

                            discord.sendMessage(dm);

                            String sqlHostE = "173.44.44.251";
                            String sqlPortE = "3306";
                            String sqlDbE = "network_events?useSSL=false";
                            String sqlUserE = "network_events";
                            String sqlPwE = "mDYvjpZIbj1CZjGD";

                            try {
                                MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                                Statement statement = MySQL.openConnection().createStatement();
                                statement.executeUpdate("UPDATE `networkEvents` SET claimableRewards = claimableRewards - 1 WHERE UUID = '" + player.getUniqueId() + "'");
                            } catch (SQLException | ClassNotFoundException s) {
                                s.printStackTrace();
                            }

                            try {
                                MySQL MySQL = new MySQL(sqlHostE, sqlPortE, sqlDbE, sqlUserE, sqlPwE);
                                Statement statement = MySQL.openConnection().createStatement();
                                statement.executeUpdate("UPDATE `networkEvents` SET rewardsClaimed = rewardsClaimed + 1 WHERE UUID = '" + player.getUniqueId() + "'");
                            } catch (SQLException | ClassNotFoundException s) {
                                s.printStackTrace();
                            }

                            return;
                        }

                        if (finalProgress < 20 && !player.hasPermission("twisted.events.redeem.reward") && !player.hasPermission("twisted.events.redeemed.reward")) {
                            player.sendMessage(c.red + "Transaction failed! You have not completed the event!");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set twisted.events.redeem.reward true");
                            return;
                        }

                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("EventCore"), 30);
                return;
            }


            if (clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName() != null && clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName().equals(c.red + "VIP Rank") && e.getSlot() == 20 && player.hasPermission("twisted.events.redeem.reward")) {
                player.sendMessage(c.red + "You have not completed the event!");
                return;
            }

            if (clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName() != null && clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName().equals(c.red + "40,000 Gold") && e.getSlot() == 22 && player.hasPermission("twisted.events.redeem.reward")) {
                player.sendMessage(c.red + "You have not completed the event!");
                return;
            }

            if (clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName() != null && clickedItem.getItemMeta() != null && clickedItem.getItemMeta().getDisplayName().equals(c.red + "Crate Keys") && e.getSlot() == 24 && player.hasPermission("twisted.events.redeem.reward")) {
                player.sendMessage(c.red + "You have not completed the event!");
                return;
            }


        }

    public boolean hasEmptySlot(Player p)
    {
        return (p.getInventory().firstEmpty() > -1);
    }
*/


}
