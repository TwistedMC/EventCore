package net.twistedmc.events.inventorys.advent;

import net.twistedmc.events.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdventCalendar extends AbstractGUI implements Listener {
/*
    00 01 02 03 04 05 06 07 08
    09 10 11 12 13 14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 29 30 31 32 33 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48 49 50 51 52 53
     */

    private static final int RED_FILL[] = {0, 2, 4, 6, 8, 26, 44, 52, 50, 48, 46, 36, 18};
    private static final int GREEN_FILL[] = {1, 3, 5, 7, 17, 35, 53, 51, 49, 47, 45, 27, 9};

    private static final int DEC1[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};

    HeadDatabaseAPI api = new HeadDatabaseAPI();
    public AdventCalendar(Player pp) throws ParseException {
        super(6, "2021 Advent Calendar", pp);

        fillRed();
        fillGreen();

        Calendar c1 = Calendar.getInstance();

        //if (c1.get(Calendar.MONTH) != Calendar.DECEMBER) {
        //    setItem(new cItemStack(Material.RED_STAINED_GLASS_PANE).setDisplayName(c.red + c.bold + "It's not time yet!"), 22, (s,c,p) -> { });
        //}

        // December 1 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 1 && isDateInBetween("10/02/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39760")).setDisplayName(c.aqua + c.bold + "December 1st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 10, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 1 && !isDateInBetween("10/02/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24019")).setDisplayName(c.red + c.bold + "December 1st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 10, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 1) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 1st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 10, (s,c,p) -> { });
        }

        // December 2 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 2 && isDateInBetween("10/03/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39759")).setDisplayName(c.aqua + c.bold + "December 2nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 11, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 2 && !isDateInBetween("10/03/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24018")).setDisplayName(c.red + c.bold + "December 2nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 11, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 2) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 2nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 11, (s,c,p) -> { });
        }

        // December 3 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 3 && isDateInBetween("10/04/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39758")).setDisplayName(c.aqua + c.bold + "December 3rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 12, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 3 && !isDateInBetween("10/04/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24017")).setDisplayName(c.red + c.bold + "December 3rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 12, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 3) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 3rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 12, (s,c,p) -> { });
        }

        // December 4 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 4 && isDateInBetween("10/05/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39757")).setDisplayName(c.aqua + c.bold + "December 4th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 13, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 4 && !isDateInBetween("10/05/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24016")).setDisplayName(c.red + c.bold + "December 4th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 13, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 4) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 4th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 13, (s,c,p) -> { });
        }

        // December 5 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 5 && isDateInBetween("10/06/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39756")).setDisplayName(c.aqua + c.bold + "December 5th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 14, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 5 && !isDateInBetween("10/06/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24015")).setDisplayName(c.red + c.bold + "December 5th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 14, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 5) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 5th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 14, (s,c,p) -> { });
        }

        // December 6 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 6 && isDateInBetween("10/07/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39755")).setDisplayName(c.aqua + c.bold + "December 6th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 15, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 6 && !isDateInBetween("10/07/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24014")).setDisplayName(c.red + c.bold + "December 6th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 15, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 6) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 6th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 15, (s,c,p) -> { });
        }

        // December 7 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 7 && isDateInBetween("10/08/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39754")).setDisplayName(c.aqua + c.bold + "December 7th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 16, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 7 && !isDateInBetween("10/08/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24013")).setDisplayName(c.red + c.bold + "December 7th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 16, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 7) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 7th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 16, (s,c,p) -> { });
        }

        // December 8 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 8 && isDateInBetween("10/09/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39753")).setDisplayName(c.aqua + c.bold + "December 8th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 19, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 8 && !isDateInBetween("10/09/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24012")).setDisplayName(c.red + c.bold + "December 8th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 19, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 8) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 8th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 19, (s,c,p) -> { });
        }

        // December 9 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 9 && isDateInBetween("10/10/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39752")).setDisplayName(c.aqua + c.bold + "December 9th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 20, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 9 && !isDateInBetween("10/10/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24011")).setDisplayName(c.red + c.bold + "December 9th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 20, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 9) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 9th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 20, (s,c,p) -> { });
        }

        // December 10 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 10 && isDateInBetween("10/11/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39806")).setDisplayName(c.aqua + c.bold + "December 10th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 21, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 10 && !isDateInBetween("10/11/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24010")).setDisplayName(c.red + c.bold + "December 10th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 21, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 10) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 10th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 21, (s,c,p) -> { });
        }

        // December 11 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 11 && isDateInBetween("10/12/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39805")).setDisplayName(c.aqua + c.bold + "December 11th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 22, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 11 && !isDateInBetween("10/12/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24009")).setDisplayName(c.red + c.bold + "December 11th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 22, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 11) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 11th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 22, (s,c,p) -> { });
        }

        // December 12 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 12 && isDateInBetween("10/13/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39804")).setDisplayName(c.aqua + c.bold + "December 12th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 23, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 12 && !isDateInBetween("10/13/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24008")).setDisplayName(c.red + c.bold + "December 12th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 23, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 12) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 12th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 23, (s,c,p) -> { });
        }

        // December 13 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 13 && isDateInBetween("10/14/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39803")).setDisplayName(c.aqua + c.bold + "December 13th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 24, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 13 && !isDateInBetween("10/14/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24007")).setDisplayName(c.red + c.bold + "December 13th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 24, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 13) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 13th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 24, (s,c,p) -> { });
        }

        // December 14 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 14 && isDateInBetween("10/15/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39802")).setDisplayName(c.aqua + c.bold + "December 14th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 25, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 14 && !isDateInBetween("10/15/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24006")).setDisplayName(c.red + c.bold + "December 14th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 25, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 14) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 14th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 25, (s,c,p) -> { });
        }

        // December 15 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 15 && isDateInBetween("10/16/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39801")).setDisplayName(c.aqua + c.bold + "December 15th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 28, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 15 && !isDateInBetween("10/16/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24005")).setDisplayName(c.red + c.bold + "December 15th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 28, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 15) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 15th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 28, (s,c,p) -> { });
        }

        // December 16 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 16 && isDateInBetween("10/17/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39800")).setDisplayName(c.aqua + c.bold + "December 16th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 29, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 16 && !isDateInBetween("10/17/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24004")).setDisplayName(c.red + c.bold + "December 16th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 29, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 16) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 16th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 29, (s,c,p) -> { });
        }

        // December 17 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 17 && isDateInBetween("10/18/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39799")).setDisplayName(c.aqua + c.bold + "December 17th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 30, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 17 && !isDateInBetween("10/18/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24003")).setDisplayName(c.red + c.bold + "December 17th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 30, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 17) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 17th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 30, (s,c,p) -> { });
        }

        // December 18 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 18 && isDateInBetween("10/19/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39798")).setDisplayName(c.aqua + c.bold + "December 18th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 31, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 18 && !isDateInBetween("10/19/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24002")).setDisplayName(c.red + c.bold + "December 18th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 31, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 18) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 18th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 31, (s,c,p) -> { });
        }

        // December 19 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 19 && isDateInBetween("10/20/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39797")).setDisplayName(c.aqua + c.bold + "December 19th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 32, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 19 && !isDateInBetween("10/20/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24001")).setDisplayName(c.red + c.bold + "December 19th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 32, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 19) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 19th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 32, (s,c,p) -> { });
        }

        // December 20 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 20 && isDateInBetween("10/21/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39796")).setDisplayName(c.aqua + c.bold + "December 20th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 33, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 20 && !isDateInBetween("10/21/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("24000")).setDisplayName(c.red + c.bold + "December 20th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 33, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 20) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 20th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 33, (s,c,p) -> { });
        }

        // December 21 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 21 && isDateInBetween("10/22/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39795")).setDisplayName(c.aqua + c.bold + "December 21st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 34, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 21 && !isDateInBetween("10/22/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("23999")).setDisplayName(c.red + c.bold + "December 21st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 34, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 21) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 21st").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 34, (s,c,p) -> { });
        }

        // December 22 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 22 && isDateInBetween("10/23/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39794")).setDisplayName(c.aqua + c.bold + "December 22nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 37, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 22 && !isDateInBetween("10/23/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("23998")).setDisplayName(c.red + c.bold + "December 22nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 37, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 22) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 22nd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 37, (s,c,p) -> { });
        }

        // December 23 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 23 && isDateInBetween("10/24/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39793")).setDisplayName(c.aqua + c.bold + "December 23rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 38, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 23 && !isDateInBetween("10/24/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("23997")).setDisplayName(c.red + c.bold + "December 23rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 38, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 23) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 23rd").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 38, (s,c,p) -> { });
        }

        // December 24 G

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 24 && isDateInBetween("10/25/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39792")).setDisplayName(c.aqua + c.bold + "December 24th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 39, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 24 && !isDateInBetween("10/25/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("23996")).setDisplayName(c.red + c.bold + "December 24th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 39, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 24) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 24th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
                    "",
                    c.green + "Click to open!"
            ), 39, (s,c,p) -> { });
        }

        // December 25 R

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 25 && isDateInBetween("10/26/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("39791")).setDisplayName(c.aqua + c.bold + "December 25th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "You missed this day!",
                    "",
                    c.aqua + "Frozen!"
            ), 40, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) != 25 && !isDateInBetween("10/26/2021", "10/31/2021")) {
            setItem(new cItemStack(api.getItemHead("23995")).setDisplayName(c.red + c.bold + "December 25th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "Reward still a mystery!",
                    "",
                    c.red + "Locked!"
            ), 40, (s,c,p) -> { });
        }

        if (c1.get(Calendar.MONTH) == Calendar.OCTOBER && c1.get(Calendar.DAY_OF_MONTH) == 25) {
            setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 25th").addLore(
                    c.dgray + "Advent Reward",
                    "",
                    c.gray + "",
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
