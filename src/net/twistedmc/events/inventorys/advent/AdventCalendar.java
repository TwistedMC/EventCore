package net.twistedmc.events.inventorys.advent;

import net.twistedmc.events.util.API;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class AdventCalendar extends AbstractGUI {
/*
    00 01 02 03 04 05 06 07 08
    09 10 11 12 13 14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 29 30 31 32 33 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48 49 50 51 52 53
     */

    private static final int RED_FILL[] = {0, 2, 4, 6, 8, 26, 44, 52, 50, 48, 46, 36, 18, 42};
    private static final int GREEN_FILL[] = {1, 3, 5, 7, 17, 35, 53, 51, 49, 47, 45, 27, 9, 41, 43};

    HeadDatabaseAPI api = new HeadDatabaseAPI();
    public AdventCalendar(Player pp) throws ParseException {
        super(6, "2021 Advent Calendar", pp);

        fillRed();
        fillGreen();

        Calendar c1 = Calendar.getInstance();
        if (c1.get(Calendar.MONTH) == Calendar.NOVEMBER) {
            setItem(new cItemStack(Material.RED_STAINED_GLASS_PANE).setDisplayName(c.red + c.bold + "It's not time yet!"), 22, (s,c,p) -> { });
        }

        // December 1 R

        if (pp.getUniqueId().equals("5c208957-df9b-40f7-a4cf-38df9c0d1774")) {
            if (API.adventOpenedAlready(pp.getUniqueId(), 1) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
                setItem(new cItemStack(api.getItemHead("23992")).setDisplayName(c.white + c.bold + "December 1st").addLore(
                        c.dgray + "Advent Reward",
                        "",
                        c.dgray + "+" + c.aqua + "1x" + c.gray + " Pharaoh Rank",
                        "",
                        c.white + "Reward claimed!"
                ), 10, (s, c, p) -> {
                });
            }
        }

        if (!pp.getUniqueId().equals("5c208957-df9b-40f7-a4cf-38df9c0d1774")) {
            if (API.adventOpenedAlready(pp.getUniqueId(), 1) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
                setItem(new cItemStack(api.getItemHead("23992")).setDisplayName(c.white + c.bold + "December 1st").addLore(
                        c.dgray + "Advent Reward",
                        "",
                        c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                        "",
                        c.white + "Reward claimed!"
                ), 10, (s, c, p) -> {
                });
            }
        }

        if (pp.getUniqueId().equals("5c208957-df9b-40f7-a4cf-38df9c0d1774")) {
            if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(1) && !API.adventOpenedAlready(pp.getUniqueId(), 1)) {
                setItem(new cItemStack(api.getItemHead("39760")).setDisplayName(c.aqua + c.bold + "December 1st").addLore(
                        c.dgray + "Advent Reward",
                        "",
                        c.dgray + "+" + c.aqua + "1x" + c.gray + " Pharaoh Rank",
                        "",
                        c.aqua + "Oops! Reward missed!"
                ), 10, (s, c, p) -> {
                });
            }
        }

        if (!pp.getUniqueId().equals("5c208957-df9b-40f7-a4cf-38df9c0d1774")) {
            if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(1) && !API.adventOpenedAlready(pp.getUniqueId(), 1)) {
                setItem(new cItemStack(api.getItemHead("39760")).setDisplayName(c.aqua + c.bold + "December 1st").addLore(
                        c.dgray + "Advent Reward",
                        "",
                        c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                        "",
                        c.aqua + "Oops! Reward missed!"
                ), 10, (s, c, p) -> {
                });
            }
        }

        if (!pp.getUniqueId().equals("5c208957-df9b-40f7-a4cf-38df9c0d1774")) {
            if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(1) && c1.get(Calendar.DAY_OF_MONTH) != 1 && !API.adventOpenedAlready(pp.getUniqueId(), 1)) {
                setItem(new cItemStack(api.getItemHead("24019")).setDisplayName(c.red + c.bold + "December 1st").addLore(
                        c.dgray + "Advent Reward",
                        "",
                        c.gray + "Reward still a mystery!",
                        "",
                        c.red + "Locked!"
                ), 10, (s, c, p) -> {
                });
            }
        }

        if (pp.getUniqueId().equals("5c208957-df9b-40f7-a4cf-38df9c0d1774")) {
            if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 1 && !API.adventOpenedAlready(pp.getUniqueId(), 1)) {
                setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.gold + c.bold + "December 1st").addLore(
                        c.dgray + "Advent Reward",
                        "",
                        c.dgray + "+" + c.aqua + "1x" + c.gray + " Pharaoh Rank",
                        "",
                        c.green + "Click to open!"
                ), 10, (s, c, p) -> {
                });
            }
        }

        if (!pp.getUniqueId().equals("5c208957-df9b-40f7-a4cf-38df9c0d1774")) {
            if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 1 && !API.adventOpenedAlready(pp.getUniqueId(), 1)) {
                setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 1st").addLore(
                        c.dgray + "Advent Reward",
                        "",
                        c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                        "",
                        c.green + "Click to open!"
                ), 10, (s, c, p) -> {
                });
            }
        }

        // December 2 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 2) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23991")).setDisplayName(c.white + c.bold + "December 2nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.green + "3,000" + c.gray + " GEXP",
                    "",
                    c.white + "Reward claimed!"
            ), 11, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(2) && !API.adventOpenedAlready(pp.getUniqueId(), 2)) {
            setItem(new cItemStack(api.getItemHead("39759")).setDisplayName(c.aqua + c.bold + "December 2nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.green + "3,000" + c.gray + " GEXP",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 11, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(2) && c1.get(Calendar.DAY_OF_MONTH) != 2 && !API.adventOpenedAlready(pp.getUniqueId(), 2)) {
            setItem(new cItemStack(api.getItemHead("24018")).setDisplayName(c.red + c.bold + "December 2nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 11, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 2 && !API.adventOpenedAlready(pp.getUniqueId(), 2)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 2nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.green + "3,000" + c.gray + " GEXP",
                    "",
                    c.green + "Click to open!"
            ), 11, (s,c,p) -> { });
        }

        // December 3 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 3) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23990")).setDisplayName(c.white + c.bold + "December 3rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "10,000" + c.gray + " Bed Wars Coins",
                    "",
                    c.white + "Reward claimed!"
            ), 12, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(3) && !API.adventOpenedAlready(pp.getUniqueId(), 3)) {
            setItem(new cItemStack(api.getItemHead("39758")).setDisplayName(c.aqua + c.bold + "December 3rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "10,000" + c.gray + " Bed Wars Coins",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 12, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(3) && c1.get(Calendar.DAY_OF_MONTH) != 3 && !API.adventOpenedAlready(pp.getUniqueId(), 3)) {
            setItem(new cItemStack(api.getItemHead("24017")).setDisplayName(c.red + c.bold + "December 3rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 12, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 3 && !API.adventOpenedAlready(pp.getUniqueId(), 3)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 3rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "10,000" + c.gray + " Bed Wars Coins",
                    "",
                    c.green + "Click to open!"
            ), 12, (s,c,p) -> { });
        }

        // December 4 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 4) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23989")).setDisplayName(c.white + c.bold + "December 4th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Ultra Crate Keys",
                    "",
                    c.white + "Reward claimed!"
            ), 13, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(4) && !API.adventOpenedAlready(pp.getUniqueId(), 4)) {
            setItem(new cItemStack(api.getItemHead("39757")).setDisplayName(c.aqua + c.bold + "December 4th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Ultra Crate Keys",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 13, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(4) && c1.get(Calendar.DAY_OF_MONTH) != 4 && !API.adventOpenedAlready(pp.getUniqueId(), 4)) {
            setItem(new cItemStack(api.getItemHead("24016")).setDisplayName(c.red + c.bold + "December 4th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 13, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 4 && !API.adventOpenedAlready(pp.getUniqueId(), 4)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 4th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Ultra Crate Keys",
                    "",
                    c.green + "Click to open!"
            ), 13, (s,c,p) -> { });
        }

        // December 5 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 5) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23988")).setDisplayName(c.white + c.bold + "December 5th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.yellow + "Flash Bow Effect " + c.gray + "(" + c.aqua + "/boweffects" + c.gray + ")",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.white + "Reward claimed!"
            ), 14, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(5) && !API.adventOpenedAlready(pp.getUniqueId(), 5)) {
            setItem(new cItemStack(api.getItemHead("39756")).setDisplayName(c.aqua + c.bold + "December 5th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.yellow + "Flash Bow Effect " + c.gray + "(" + c.aqua + "/boweffects" + c.gray + ")",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 14, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(5) && c1.get(Calendar.DAY_OF_MONTH) != 5 && !API.adventOpenedAlready(pp.getUniqueId(), 5)) {
            setItem(new cItemStack(api.getItemHead("24015")).setDisplayName(c.red + c.bold + "December 5th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 14, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 5 && !API.adventOpenedAlready(pp.getUniqueId(), 5)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 5th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.yellow + "Flash Bow Effect " + c.gray + "(" + c.aqua + "/boweffects" + c.gray + ")",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.green + "Click to open!"
            ), 14, (s,c,p) -> { });
        }

        // December 6 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 6) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23987")).setDisplayName(c.white + c.bold + "December 6th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Survival Coins and Gold Booster (" + c.aqua + "Three Hours" + c.gray + ")",
                    "",
                    c.white + "Reward claimed!"
            ), 15, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(6) && !API.adventOpenedAlready(pp.getUniqueId(), 6)) {
            setItem(new cItemStack(api.getItemHead("39755")).setDisplayName(c.aqua + c.bold + "December 6th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Survival Coins and Gold Booster (" + c.aqua + "Three Hours" + c.gray + ")",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 15, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(6) && c1.get(Calendar.DAY_OF_MONTH) != 6 && !API.adventOpenedAlready(pp.getUniqueId(), 6)) {
            setItem(new cItemStack(api.getItemHead("24014")).setDisplayName(c.red + c.bold + "December 6th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 15, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 6 && !API.adventOpenedAlready(pp.getUniqueId(), 6)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 6th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Survival Coins and Gold Booster (" + c.aqua + "Three Hours" + c.gray + ")",
                    "",
                    c.green + "Click to open!"
            ), 15, (s,c,p) -> { });
        }

        // December 7 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 7) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23986")).setDisplayName(c.white + c.bold + "December 7th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "10,000" + c.gray + " Survival Coins",
                    "",
                    c.white + "Reward claimed!"
            ), 16, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(7) && !API.adventOpenedAlready(pp.getUniqueId(), 7)) {
            setItem(new cItemStack(api.getItemHead("39754")).setDisplayName(c.aqua + c.bold + "December 7th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 16, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(7) && c1.get(Calendar.DAY_OF_MONTH) != 7 && !API.adventOpenedAlready(pp.getUniqueId(), 7)) {
            setItem(new cItemStack(api.getItemHead("24013")).setDisplayName(c.red + c.bold + "December 7th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 16, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 7 && !API.adventOpenedAlready(pp.getUniqueId(), 7)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 7th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.green + "Click to open!"
            ), 16, (s,c,p) -> { });
        }

        // December 8 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 8) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23985")).setDisplayName(c.white + c.bold + "December 8th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "5,000" + c.gray + " Gold",
                    "",
                    c.white + "Reward claimed!"
            ), 19, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(8) && !API.adventOpenedAlready(pp.getUniqueId(), 8)) {
            setItem(new cItemStack(api.getItemHead("39753")).setDisplayName(c.aqua + c.bold + "December 8th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "5,000" + c.gray + " Gold",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 19, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(8) && c1.get(Calendar.DAY_OF_MONTH) != 8 && !API.adventOpenedAlready(pp.getUniqueId(), 8)) {
            setItem(new cItemStack(api.getItemHead("24012")).setDisplayName(c.red + c.bold + "December 8th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 19, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 8 && !API.adventOpenedAlready(pp.getUniqueId(), 8)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 8th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "5,000" + c.gray + " Gold",
                    "",
                    c.green + "Click to open!"
            ), 19, (s,c,p) -> { });
        }

        // December 9 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 9) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23984")).setDisplayName(c.white + c.bold + "December 9th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                    "",
                    c.white + "Reward claimed!"
            ), 20, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(9) && !API.adventOpenedAlready(pp.getUniqueId(), 9)) {
            setItem(new cItemStack(api.getItemHead("39752")).setDisplayName(c.aqua + c.bold + "December 9th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 20, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(9) && c1.get(Calendar.DAY_OF_MONTH) != 9 && !API.adventOpenedAlready(pp.getUniqueId(), 9)) {
            setItem(new cItemStack(api.getItemHead("24011")).setDisplayName(c.red + c.bold + "December 9th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 20, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 9 && !API.adventOpenedAlready(pp.getUniqueId(), 9)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 9th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                    "",
                    c.green + "Click to open!"
            ), 20, (s,c,p) -> { });
        }

        // December 10 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 10) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23983")).setDisplayName(c.white + c.bold + "December 10th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.yellow + "Lightning Kill Effect " + c.gray + "(" + c.aqua + "/killeffects" + c.gray + ")",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.white + "Reward claimed!"
            ), 21, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(10) && !API.adventOpenedAlready(pp.getUniqueId(), 10)) {
            setItem(new cItemStack(api.getItemHead("39806")).setDisplayName(c.aqua + c.bold + "December 10th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.yellow + "Lightning Kill Effect " + c.gray + "(" + c.aqua + "/killeffects" + c.gray + ")",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 21, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(10) && c1.get(Calendar.DAY_OF_MONTH) != 10 && !API.adventOpenedAlready(pp.getUniqueId(), 10)) {
            setItem(new cItemStack(api.getItemHead("24010")).setDisplayName(c.red + c.bold + "December 10th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 21, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 10 && !API.adventOpenedAlready(pp.getUniqueId(), 10)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 10th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.yellow + "Lightning Kill Effect " + c.gray + "(" + c.aqua + "/killeffects" + c.gray + ")",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.green + "Click to open!"
            ), 21, (s,c,p) -> { });
        }

        // December 11 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 11) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23982")).setDisplayName(c.white + c.bold + "December 11th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.green + "Snowball Punch Messages",
                    c.dgray + "+" + c.gold + "10,000" + c.gray + " Bed Wars Coins",
                    "",
                    c.dgray + "Requires Titan to use Punch",
                    c.dgray + "Messages. Find Customize Appearance",
                    c.dgray + "in your Profile.",
                    "",
                    c.white + "Reward claimed!"
            ), 22, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(11) && !API.adventOpenedAlready(pp.getUniqueId(), 11)) {
            setItem(new cItemStack(api.getItemHead("39805")).setDisplayName(c.aqua + c.bold + "December 11th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.green + "Snowball Punch Messages",
                    c.dgray + "+" + c.gold + "10,000" + c.gray + " Network Coins",
                    "",
                    c.dgray + "Requires Titan to use Punch",
                    c.dgray + "Messages. Find Customize Appearance",
                    c.dgray + "in your Profile.",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 22, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(11) && c1.get(Calendar.DAY_OF_MONTH) != 11 && !API.adventOpenedAlready(pp.getUniqueId(), 11)) {
            setItem(new cItemStack(api.getItemHead("24009")).setDisplayName(c.red + c.bold + "December 11th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 22, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 11 && !API.adventOpenedAlready(pp.getUniqueId(), 11)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 11th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.green + "Snowball Punch Messages",
                    c.dgray + "+" + c.gold + "10,000" + c.gray + " Network Coins",
                    "",
                    c.dgray + "Requires Titan to use Punch",
                    c.dgray + "Messages. Find Customize Appearance",
                    c.dgray + "in your Profile.",
                    "",
                    c.green + "Click to open!"
            ), 22, (s,c,p) -> { });
        }

        // December 12 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 12) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23981")).setDisplayName(c.white + c.bold + "December 12th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x " + c.red + "3-star Mystery Box",
                    "",
                    c.dgray + "Open Mystery Boxes in",
                    c.dgray + "the Main Lobby",
                    "",
                    c.white + "Reward claimed!"
            ), 23, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(12) && !API.adventOpenedAlready(pp.getUniqueId(), 12)) {
            setItem(new cItemStack(api.getItemHead("39804")).setDisplayName(c.aqua + c.bold + "December 12th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x " + c.red + "3-star Mystery Box",
                    "",
                    c.dgray + "Open Mystery Boxes in",
                    c.dgray + "the Main Lobby",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 23, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(12) && c1.get(Calendar.DAY_OF_MONTH) != 12 && !API.adventOpenedAlready(pp.getUniqueId(), 12)) {
            setItem(new cItemStack(api.getItemHead("24008")).setDisplayName(c.red + c.bold + "December 12th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 23, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 12 && !API.adventOpenedAlready(pp.getUniqueId(), 12)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 12th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x " + c.red + "3-star Mystery Box",
                    "",
                    c.dgray + "Open Mystery Boxes in",
                    c.dgray + "the Main Lobby",
                    "",
                    c.green + "Click to open!"
            ), 23, (s,c,p) -> { });
        }

        // December 13 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 13) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23980")).setDisplayName(c.white + c.bold + "December 13th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "☃ Chat Emote " + c.gray + "(" + c.aqua + ":snow:" + c.gray + ")",
                    "",
                    c.white + "Reward claimed!"
            ), 24, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(13) && !API.adventOpenedAlready(pp.getUniqueId(), 13)) {
            setItem(new cItemStack(api.getItemHead("39803")).setDisplayName(c.aqua + c.bold + "December 13th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "☃ Chat Emote " + c.gray + "(" + c.aqua + ":snow:" + c.gray + ")",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 24, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(13) && c1.get(Calendar.DAY_OF_MONTH) != 13 && !API.adventOpenedAlready(pp.getUniqueId(), 13)) {
            setItem(new cItemStack(api.getItemHead("24007")).setDisplayName(c.red + c.bold + "December 13th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 24, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 13 && !API.adventOpenedAlready(pp.getUniqueId(), 13)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 13th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "☃ Chat Emote " + c.gray + "(" + c.aqua + ":snow:" + c.gray + ")",
                    "",
                    c.green + "Click to open!"
            ), 24, (s,c,p) -> { });
        }

        // December 14 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 14) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23979")).setDisplayName(c.white + c.bold + "December 14th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.dred + "Reindeer Miniature",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.dgray + "Unique miniatures that follow",
                    c.dgray + "you around in every lobby!",
                    "",
                    c.white + "Reward claimed!"
            ), 25, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(14) && !API.adventOpenedAlready(pp.getUniqueId(), 14)) {
            setItem(new cItemStack(api.getItemHead("39802")).setDisplayName(c.aqua + c.bold + "December 14th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.dred + "Reindeer Miniature",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.dgray + "Unique miniatures that follow",
                    c.dgray + "you around in every lobby!",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 25, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(14) && c1.get(Calendar.DAY_OF_MONTH) != 14 && !API.adventOpenedAlready(pp.getUniqueId(), 14)) {
            setItem(new cItemStack(api.getItemHead("24006")).setDisplayName(c.red + c.bold + "December 14th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 25, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 14 && !API.adventOpenedAlready(pp.getUniqueId(), 14)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 14th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.dred + "Reindeer Miniature",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.dgray + "Unique miniatures that follow",
                    c.dgray + "you around in every lobby!",
                    "",
                    c.green + "Click to open!"
            ), 25, (s,c,p) -> { });
        }

        // December 15 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 15) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23978")).setDisplayName(c.white + c.bold + "December 15th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.purple + "Let It Snow Gadget",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.dgray + "Releases a small snowstorm",
                    c.dgray + "around you, covering the",
                    c.dgray + "area in white for a short",
                    c.dgray + "amount of time in every lobby!",
                    "",
                    c.white + "Reward claimed!"
            ), 28, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(15) && !API.adventOpenedAlready(pp.getUniqueId(), 15)) {
            setItem(new cItemStack(api.getItemHead("39801")).setDisplayName(c.aqua + c.bold + "December 15th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.purple + "Let It Snow Gadget",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.dgray + "Releases a small snowstorm",
                    c.dgray + "around you, covering the",
                    c.dgray + "area in white for a short",
                    c.dgray + "amount of time in every lobby!",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 28, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(15) && c1.get(Calendar.DAY_OF_MONTH) != 15 && !API.adventOpenedAlready(pp.getUniqueId(), 15)) {
            setItem(new cItemStack(api.getItemHead("24005")).setDisplayName(c.red + c.bold + "December 15th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 28, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 15 && !API.adventOpenedAlready(pp.getUniqueId(), 15)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 15th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.purple + "Let It Snow Gadget",
                    c.dgray + "+" + c.gold + "3,000" + c.gray + " Gold",
                    "",
                    c.dgray + "Releases a small snowstorm",
                    c.dgray + "around you, covering the",
                    c.dgray + "area in white for a short",
                    c.dgray + "amount of time in every lobby!",
                    "",
                    c.green + "Click to open!"
            ), 28, (s,c,p) -> { });
        }

        // December 16 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 16) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23977")).setDisplayName(c.white + c.bold + "December 16th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Bed Wars Coins Booster (" + c.aqua + "Three Hours" + c.gray + ")",
                    "",
                    c.white + "Reward claimed!"
            ), 29, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(16) && !API.adventOpenedAlready(pp.getUniqueId(), 16)) {
            setItem(new cItemStack(api.getItemHead("39800")).setDisplayName(c.aqua + c.bold + "December 16th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Bed Wars Coins Booster (" + c.aqua + "Three Hours" + c.gray + ")",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 29, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(16) && c1.get(Calendar.DAY_OF_MONTH) != 16 && !API.adventOpenedAlready(pp.getUniqueId(), 16)) {
            setItem(new cItemStack(api.getItemHead("24004")).setDisplayName(c.red + c.bold + "December 16th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 29, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 16 && !API.adventOpenedAlready(pp.getUniqueId(), 16)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 16th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Bed Wars Coins Booster (" + c.aqua + "Three Hours" + c.gray + ")",
                    "",
                    c.green + "Click to open!"
            ), 29, (s,c,p) -> { });
        }

        // December 17 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 17) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23976")).setDisplayName(c.white + c.bold + "December 17th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Survival EXP Booster (" + c.aqua + "One Hour" + c.gray + ")",
                    "",
                    c.white + "Reward claimed!"
            ), 30, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(17) && !API.adventOpenedAlready(pp.getUniqueId(), 17)) {
            setItem(new cItemStack(api.getItemHead("39799")).setDisplayName(c.aqua + c.bold + "December 17th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Survival EXP Booster (" + c.aqua + "One Hour" + c.gray + ")",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 30, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(17) && c1.get(Calendar.DAY_OF_MONTH) != 17 && !API.adventOpenedAlready(pp.getUniqueId(), 17)) {
            setItem(new cItemStack(api.getItemHead("24003")).setDisplayName(c.red + c.bold + "December 17th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 30, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 17 && !API.adventOpenedAlready(pp.getUniqueId(), 17)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 17th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 2.0x " + c.gray + "Survival EXP Booster (" + c.aqua + "One Hour" + c.gray + ")",
                    "",
                    c.green + "Click to open!"
            ), 30, (s,c,p) -> { });
        }

        // December 18 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 18) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23975")).setDisplayName(c.white + c.bold + "December 18th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "300" + c.gray + " Snowflakes " + c.gray + "(" + c.aqua + "/seasonal" + c.gray + ")",
                    "",
                    c.dgray + "Snowflakes - A seasonal currency",
                    c.dgray + "which allows you to buy in-game",
                    c.dgray + "items through the seasonal shop!",
                    "",
                    c.white + "Reward claimed!"
            ), 31, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(18) && !API.adventOpenedAlready(pp.getUniqueId(), 18)) {
            setItem(new cItemStack(api.getItemHead("39798")).setDisplayName(c.aqua + c.bold + "December 18th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "300" + c.gray + " Snowflakes " + c.gray + "(" + c.aqua + "/seasonal" + c.gray + ")",
                    "",
                    c.dgray + "Snowflakes - A seasonal currency",
                    c.dgray + "which allows you to buy in-game",
                    c.dgray + "items through the seasonal shop!",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 31, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(18) && c1.get(Calendar.DAY_OF_MONTH) != 18 && !API.adventOpenedAlready(pp.getUniqueId(), 18)) {
            setItem(new cItemStack(api.getItemHead("24002")).setDisplayName(c.red + c.bold + "December 18th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 31, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 18 && !API.adventOpenedAlready(pp.getUniqueId(), 18)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 18th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "300" + c.gray + " Snowflakes " + c.gray + "(" + c.aqua + "/seasonal" + c.gray + ")",
                    "",
                    c.dgray + "Snowflakes - A seasonal currency",
                    c.dgray + "which allows you to buy in-game",
                    c.dgray + "items through the seasonal shop!",
                    "",
                    c.green + "Click to open!"
            ), 31, (s,c,p) -> { });
        }

        // December 19 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 19) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23974")).setDisplayName(c.white + c.bold + "December 19th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "15,000" + c.gray + " Gold",
                    "",
                    c.white + "Reward claimed!"
            ), 32, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(19) && !API.adventOpenedAlready(pp.getUniqueId(), 19)) {
            setItem(new cItemStack(api.getItemHead("39797")).setDisplayName(c.aqua + c.bold + "December 19th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "15,000" + c.gray + " Gold",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 32, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(19) && c1.get(Calendar.DAY_OF_MONTH) != 19 && !API.adventOpenedAlready(pp.getUniqueId(), 19)) {
            setItem(new cItemStack(api.getItemHead("24001")).setDisplayName(c.red + c.bold + "December 19th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 32, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 19 && !API.adventOpenedAlready(pp.getUniqueId(), 19)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 19th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "15,000" + c.gray + " Gold",
                    "",
                    c.green + "Click to open!"
            ), 32, (s,c,p) -> { });
        }

        // December 20 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 20) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23973")).setDisplayName(c.white + c.bold + "December 20th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                    "",
                    c.white + "Reward claimed!"
            ), 33, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(20) && !API.adventOpenedAlready(pp.getUniqueId(), 20)) {
            setItem(new cItemStack(api.getItemHead("39796")).setDisplayName(c.aqua + c.bold + "December 20th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 33, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(20) && c1.get(Calendar.DAY_OF_MONTH) != 20 && !API.adventOpenedAlready(pp.getUniqueId(), 20)) {
            setItem(new cItemStack(api.getItemHead("24000")).setDisplayName(c.red + c.bold + "December 20th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 33, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 20 && !API.adventOpenedAlready(pp.getUniqueId(), 20)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 20th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Winter Crate Keys",
                    "",
                    c.green + "Click to open!"
            ), 33, (s,c,p) -> { });
        }

        // December 21 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 21) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23972")).setDisplayName(c.white + c.bold + "December 21st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Rare Crate Keys",
                    "",
                    c.white + "Reward claimed!"
            ), 34, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(21) && !API.adventOpenedAlready(pp.getUniqueId(), 21)) {
            setItem(new cItemStack(api.getItemHead("39795")).setDisplayName(c.aqua + c.bold + "December 21st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Rare Crate Keys",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 34, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(21) && c1.get(Calendar.DAY_OF_MONTH) != 21 && !API.adventOpenedAlready(pp.getUniqueId(), 21)) {
            setItem(new cItemStack(api.getItemHead("23999")).setDisplayName(c.red + c.bold + "December 21st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 34, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 21 && !API.adventOpenedAlready(pp.getUniqueId(), 21)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 21st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "3x" + c.gray + " Rare Crate Keys",
                    "",
                    c.green + "Click to open!"
            ), 34, (s,c,p) -> { });
        }

        // December 22 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 22) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23971")).setDisplayName(c.white + c.bold + "December 22nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "50,000" + c.gray + " Survival Coins",
                    "",
                    c.white + "Reward claimed!"
            ), 37, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(22) && !API.adventOpenedAlready(pp.getUniqueId(), 22)) {
            setItem(new cItemStack(api.getItemHead("39794")).setDisplayName(c.aqua + c.bold + "December 22nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "50,000" + c.gray + " Network Coins",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 37, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(22) && c1.get(Calendar.DAY_OF_MONTH) != 22 && !API.adventOpenedAlready(pp.getUniqueId(), 22)) {
            setItem(new cItemStack(api.getItemHead("23998")).setDisplayName(c.red + c.bold + "December 22nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 37, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 22 && !API.adventOpenedAlready(pp.getUniqueId(), 22)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 22nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "50,000" + c.gray + " Network Coins",
                    "",
                    c.green + "Click to open!"
            ), 37, (s,c,p) -> { });
        }

        // December 23 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 23) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23970")).setDisplayName(c.white + c.bold + "December 23rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "30,000" + c.gray + " Gold",
                    "",
                    c.white + "Reward claimed!"
            ), 38, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(23) && !API.adventOpenedAlready(pp.getUniqueId(), 23)) {
            setItem(new cItemStack(api.getItemHead("39793")).setDisplayName(c.aqua + c.bold + "December 23rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "30,000" + c.gray + " Gold",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 38, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(23) && c1.get(Calendar.DAY_OF_MONTH) != 23 && !API.adventOpenedAlready(pp.getUniqueId(), 23)) {
            setItem(new cItemStack(api.getItemHead("23997")).setDisplayName(c.red + c.bold + "December 23rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 38, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 23 && !API.adventOpenedAlready(pp.getUniqueId(), 23)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 23rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.gold + "30,000" + c.gray + " Gold",
                    "",
                    c.green + "Click to open!"
            ), 38, (s,c,p) -> { });
        }

        // December 24 G

        if (API.adventOpenedAlready(pp.getUniqueId(), 24) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23969")).setDisplayName(c.white + c.bold + "December 24th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "5x" + c.gray + " Netherite Ingots",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 3.0x " + c.gray + "Survival EXP Booster (" + c.aqua + "One Hour" + c.gray + ")",
                    "",
                    c.white + "Reward claimed!"
            ), 39, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(24) && !API.adventOpenedAlready(pp.getUniqueId(), 24)) {
            setItem(new cItemStack(api.getItemHead("39792")).setDisplayName(c.aqua + c.bold + "December 24th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "5x" + c.gray + " Netherite Ingots",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 3.0x " + c.gray + "Survival EXP Booster (" + c.aqua + "One Hour" + c.gray + ")",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 39, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(24) && c1.get(Calendar.DAY_OF_MONTH) != 24 && !API.adventOpenedAlready(pp.getUniqueId(), 24)) {
            setItem(new cItemStack(api.getItemHead("23996")).setDisplayName(c.red + c.bold + "December 24th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 39, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 24 && !API.adventOpenedAlready(pp.getUniqueId(), 24)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 24th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "5x" + c.gray + " Netherite Ingots",
                    c.dgray + "+" + c.aqua + "1x" + c.gold + " 3.0x " + c.gray + "Survival EXP Booster (" + c.aqua + "One Hour" + c.gray + ")",
                    "",
                    c.green + "Click to open!"
            ), 39, (s,c,p) -> { });
        }

        // December 25 R

        if (API.adventOpenedAlready(pp.getUniqueId(), 25) && c1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            setItem(new cItemStack(api.getItemHead("23968")).setDisplayName(c.white + c.bold + "December 25th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x " + c.gray + "VIP Rank Gift " + c.gray + "(" + c.aqua + "/gift" + c.gray + ")",
                    c.dgray + "+" + c.aqua + "6x " + c.red + "3-star Mystery Box",
                    "",
                    c.dgray + "Open Mystery Boxes in",
                    c.dgray + "the Main Lobby",
                    "",
                    c.white + "Reward claimed!"
            ), 40, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isMissed(25) && !API.adventOpenedAlready(pp.getUniqueId(), 25)) {
            setItem(new cItemStack(api.getItemHead("39791")).setDisplayName(c.aqua + c.bold + "December 25th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x " + c.gray + "VIP Rank Gift " + c.gray + "(" + c.aqua + "/gift" + c.gray + ")",
                    c.dgray + "+" + c.aqua + "3x " + c.red + "3-star Mystery Box",
                    "",
                    c.dgray + "Open Mystery Boxes in",
                    c.dgray + "the Main Lobby",
                    "",
                    c.aqua + "Oops! Reward missed!"
            ), 40, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && API.isReady(25) && c1.get(Calendar.DAY_OF_MONTH) != 25 && !API.adventOpenedAlready(pp.getUniqueId(), 25)) {
            setItem(new cItemStack(api.getItemHead("23995")).setDisplayName(c.red + c.bold + "December 25th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 40, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.DECEMBER && c1.get(Calendar.DAY_OF_MONTH) == 25 && !API.adventOpenedAlready(pp.getUniqueId(), 25)) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 25th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.dgray + "+" + c.aqua + "1x " + c.gray + "VIP Rank Gift " + c.gray + "(" + c.aqua + "/gift" + c.gray + ")",
                    c.dgray + "+" + c.aqua + "3x " + c.red + "3-star Mystery Box",
                    "",
                    c.dgray + "Open Mystery Boxes in",
                    c.dgray + "the Main Lobby",
                    "",
                    c.green + "Click to open!"
            ), 40, (s,c,p) -> { });
        }

    }

    private void fillRed() {
        Arrays.stream(RED_FILL).forEach(slot -> setItem(new cItemStack(Material.RED_STAINED_GLASS_PANE).setDisplayName(""), slot, (s,c,p) -> { }));
    }

    private void fillGreen() {
        Arrays.stream(GREEN_FILL).forEach(slot -> setItem(new cItemStack(Material.GREEN_STAINED_GLASS_PANE).setDisplayName(""), slot, (s,c,p) -> { }));
    }

    public static boolean isDateInBetween(String startDateStr, String endDateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);

        startDateStr = startDateStr.concat(year.toString());
        endDateStr = endDateStr.concat(year.toString());

        Date startDate = sdf.parse(startDateStr);
        Date endDate = sdf.parse(endDateStr);

        Date d = new Date();
        String currDt = sdf.format(d);

        return !((d.after(startDate) && (d.before(endDate))) || (currDt.equals(sdf.format(startDate)) || currDt.equals(sdf.format(endDate))));
    }
}
