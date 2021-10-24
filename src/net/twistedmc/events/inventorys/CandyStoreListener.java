package net.twistedmc.events.inventorys;

import net.ranktw.DiscordWebHooks.DiscordEmbed;
import net.ranktw.DiscordWebHooks.DiscordMessage;
import net.ranktw.DiscordWebHooks.DiscordWebhook;
import net.ranktw.DiscordWebHooks.embed.FooterEmbed;
import net.twistedmc.events.Main;
import net.twistedmc.events.data.c;
import net.twistedmc.events.inventorys.store.CandyStore;
import net.twistedmc.events.util.CanBuyItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import twistedmc.core.framework.ServerGameType;
import twistedmc.core.util.api.APICoins;
import twistedmc.core.util.api.APIMoney;

import java.awt.*;
import java.text.NumberFormat;

public class CandyStoreListener implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryClick(InventoryDragEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Halloween Store")) {
            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        NumberFormat formatter = NumberFormat.getIntegerInstance();

        if (e.getView().getTitle().equalsIgnoreCase("Halloween Store")) {
            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getLore().contains(c.gray + "To Currency Menu") && e.getView().getTitle().equalsIgnoreCase("Halloween Store")) {
            new MainMenu(player);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.purple + "Your Halloween " + c.gold + "Candies " + c.purple + "Chest") && e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            new CandyStore(player);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.purple + "Your Winter " + c.white + "Snowflakes " + c.purple + "Snowglobe") && e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            player.sendMessage(c.red + "Winter event not active!");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.yellow + "Information") && e.getView().getTitle().equalsIgnoreCase("Seasonal Menu")) {
            player.sendMessage(c.yellow + "More information: https://twistedmc.net/seasonal-info/");
            player.closeInventory();
            return;
        }

        int a1 = 70000 - Main.getCandies(player);
        int a2 = 10000 - Main.getCandies(player);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.dred + "VIP Rank (30 Days)") && e.getView().getTitle().equalsIgnoreCase("Halloween Store")) {

            if (player.hasPermission("rank.vip")) {
                player.sendMessage(c.red + "You already have this rank or a higher rank!");
                return;
            }
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.dred + "VIP+ Rank (30 Days)") && e.getView().getTitle().equalsIgnoreCase("Halloween Store")) {

            if (player.hasPermission("rank.vip")) {
                player.sendMessage(c.red + "You already have this rank or a higher rank!");
                return;
            }
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + "VIP Rank (30 Days)") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(10000, "candy", player)) {

            if (player.hasPermission("rank.vip")) {
                player.sendMessage(c.red + "You already have this rank or a higher rank!");
                return;
            }

            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "VIP Rank (30 Days)" + c.green + "!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent addtemp vip 30d");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 10000");
            player.closeInventory();

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased VIP Rank (30 Days)")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.aqua + "VIP+ Rank (30 Days)") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(35000, "candy", player)) {

            if (player.hasPermission("rank.vip+")) {
                player.sendMessage(c.red + "You already have this rank or a higher rank!");
                return;
            }

            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "VIP+ Rank (30 Days)" + c.green + "!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent addtemp vip+ 30d");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 35000");
            player.closeInventory();

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased VIP+ Rank (30 Days)")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "VIP Rank (30 Days)") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(10000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(a1) + " Candy)");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "VIP+ Rank (30 Days)") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(35000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(a2) + " Candy)");
            return;
        }

        //

        int b1 = 1500 - Main.getCandies(player);
        int b2 = 3500 - Main.getCandies(player);
        int b3 = 5000 - Main.getCandies(player);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "3x Autumn Crate Keys") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(2200, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "3x Autumn Crate Keys" + c.green + "!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crazycrates:cc give p autumn 3 " + player.getName());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 2200");
            player.closeInventory();

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 3x Autumn Crate Keys!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "10x Autumn Crate Keys") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(6000, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "10x Autumn Crate Keys" + c.green + "!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crazycrates:cc give p autumn 10 " + player.getName());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 6000");
            player.closeInventory();

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 10x Autumn Crate Keys!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "3x Ultra Crate Keys") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(2000, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "3x Ultra Crate Keys" + c.green + "!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crazycrates:cc give p autumn 3 " + player.getName());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 2000");
            player.closeInventory();

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 3x Ultra Crate Keys!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "3x Autumn Crate Keys") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(2200, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(b1) + " Candy)");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "10x Autumn Crate Keys") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(6000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(b2) + " Candy)");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "3x Ultra Crate Keys") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(2000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(b3) + " Candy)");
            return;
        }

        //

        int c1 = 7000 - Main.getCandies(player);
        int c2 = 19000 - Main.getCandies(player);
        int c3 = 30000 - Main.getCandies(player);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "5,000 Gold") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(7000, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "5,000 Gold" + c.green + "!");
            APIMoney.giveMoney(player, ServerGameType.ENCHANTED, 5000, true, "Seasonal Purchase");
            player.closeInventory();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 7000");

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 5,000 Gold!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "15,000 Gold") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(19000, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "15,000 Gold" + c.green + "!");
            APIMoney.giveMoney(player, ServerGameType.ENCHANTED, 15000, true, "Seasonal Purchase");
            player.closeInventory();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 19000");

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 15,000 Gold!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "45,000 Gold") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(30000, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "45,000 Gold" + c.green + "!");
            APIMoney.giveMoney(player, ServerGameType.ENCHANTED, 45000, true, "Seasonal Purchase");
            player.closeInventory();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 30000");

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 45,000 Gold!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "5,000 Gold") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(7000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(c1) + " Candy)");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "15,000 Gold") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(19000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(c2) + " Candy)");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "45,000 Gold") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(45000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(c3) + " Candy)");
            return;
        }

        //

        int d1 = 10000 - Main.getCandies(player);
        int d2 = 25000 - Main.getCandies(player);
        int d3 = 40000 - Main.getCandies(player);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "10,000 Coins") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(10000, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "10,000 Coins" + c.green + "!");
            APICoins.giveCoins(player, ServerGameType.ENCHANTED, 10000, true, "Seasonal Purchase");
            player.closeInventory();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 10000");

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 10,000 Coins!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "30,000 Coins") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(25000, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "30,000 Coins" + c.green + "!");
            APICoins.giveCoins(player, ServerGameType.ENCHANTED, 30000, true, "Seasonal Purchase");
            player.closeInventory();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 25000");

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 30,000 Coins!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.gold + "60,000 Coins") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && CanBuyItem.canBuy(40000, "candy", player)) {
            player.sendMessage(c.green + "Thank you for your purchase of " + c.gold + "60,000 Coins" + c.green + "!");
            APICoins.giveCoins(player, ServerGameType.ENCHANTED, 60000, true, "Seasonal Purchase");
            player.closeInventory();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + player.getName() + " remove 40000");

            String webhook = "https://discord.com/api/webhooks/849092250717913088/rfZXFwj7ONq2OpIqFjB6JC0QuVdxFcGm0Y-z8ZIMIRC-zX1MxsCKombdmUFc6tSgsE0P";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            DiscordMessage dm = new DiscordMessage.Builder()
                    .build();

            DiscordEmbed embed = new DiscordEmbed.Builder()
                    .withColor(new Color(0, 159, 0))
                    .withTitle("Seasonal Store")
                    .withDescription(player.getName() + "'s purchased 60,000 Coins!")
                    .withFooter(new FooterEmbed("TwistedMC Staff Alerts",""))
                    .withTimestamp(System.currentTimeMillis())
                    .build();

            dm.addEmbeds(embed);

            discord.sendMessage(dm);
            return;
        }

        //

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "10,000 Coins") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(10000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(d1) + " Candy)");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "30,000 Coins") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(25000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(d2) + " Candy)");
            return;
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c.red + "60,000 Coins") && e.getView().getTitle().equalsIgnoreCase("Halloween Store") && !CanBuyItem.canBuy(40000, "candy", player)) {
            player.sendMessage(c.red + "You do not have enough candy! (Need " + formatter.format(d3) + " Candy)");
            return;
        }


    }

}
