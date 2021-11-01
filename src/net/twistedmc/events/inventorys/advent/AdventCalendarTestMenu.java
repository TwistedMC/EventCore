package net.twistedmc.events.inventorys.advent;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.API;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class AdventCalendarTestMenu extends AbstractGUI {
/*
    00 01 02 03 04 05 06 07 08
    09 10 11 12 13 14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 29 30 31 32 33 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48 49 50 51 52 53
     */

    private static final int RED_FILL[] = {0, 2, 4, 6, 8, 26, 44, 52, 50, 48, 46, 36, 18, 42};
    private static final int GREEN_FILL[] = {1, 3, 5, 7, 17, 35, 53, 51, 49, 47, 45, 27, 9, 43};

    HeadDatabaseAPI api = new HeadDatabaseAPI();
    public AdventCalendarTestMenu(Player pp) throws ParseException {
        super(6, "2021 Advent Calendar", pp);

        fillRed();
        fillGreen();

        Calendar c1 = Calendar.getInstance();

        //if (c1.get(Calendar.MONTH) != Calendar.DECEMBER) {
        //    setItem(new cItemStack(Material.RED_STAINED_GLASS_PANE).setDisplayName(c.red + c.bold + "It's not time yet!"), 22, (s,c,p) -> { });
        //}

        // December 1 R
        setItem(new cItemStack(api.getItemHead("39760")).setDisplayName(c.aqua + c.bold + "December 1st").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Oops! Reward missed!",
                "",
                c.aqua + "Frozen!"
        ), 10, (s,c,p) -> { });

        // December 2 G

        setItem(new cItemStack(api.getItemHead("39759")).setDisplayName(c.aqua + c.bold + "December 2nd").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Oops! Reward missed!",
                "",
                c.aqua + "Frozen!"
        ), 11, (s,c,p) -> { });

        // December 3 R

        setItem(new cItemStack(api.getItemHead("23990")).setDisplayName(c.white + c.bold + "December 3rd").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "???",
                "",
                c.white + "Reward claimed!"
        ), 12, (s,c,p) -> { });

        // December 4 G
        setItem(new cItemStack(api.getItemHead("2487")).setDisplayName(c.green + c.bold + "December 4th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "???",
                "",
                c.green + "Click to open!"
        ), 13, (s,c,p) -> { });


        // December 5 R
        setItem(new cItemStack(api.getItemHead("24015")).setDisplayName(c.red + c.bold + "December 5th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 14, (s,c,p) -> { });


        // December 6 G
        setItem(new cItemStack(api.getItemHead("24014")).setDisplayName(c.red + c.bold + "December 6th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 15, (s,c,p) -> { });


        // December 7 R
        setItem(new cItemStack(api.getItemHead("24013")).setDisplayName(c.red + c.bold + "December 7th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 16, (s,c,p) -> { });


        // December 8 G
        setItem(new cItemStack(api.getItemHead("24012")).setDisplayName(c.red + c.bold + "December 8th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 19, (s,c,p) -> { });


        // December 9 R
        setItem(new cItemStack(api.getItemHead("24011")).setDisplayName(c.red + c.bold + "December 9th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 20, (s,c,p) -> { });


        // December 10 G
        setItem(new cItemStack(api.getItemHead("24010")).setDisplayName(c.red + c.bold + "December 10th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 21, (s,c,p) -> { });


        // December 11 R
        setItem(new cItemStack(api.getItemHead("24009")).setDisplayName(c.red + c.bold + "December 11th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 22, (s,c,p) -> { });


        // December 12 G
        setItem(new cItemStack(api.getItemHead("24008")).setDisplayName(c.red + c.bold + "December 12th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 23, (s,c,p) -> { });


        // December 13 R
        setItem(new cItemStack(api.getItemHead("24007")).setDisplayName(c.red + c.bold + "December 13th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 24, (s,c,p) -> { });


        // December 14 G
        setItem(new cItemStack(api.getItemHead("24006")).setDisplayName(c.red + c.bold + "December 14th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 25, (s,c,p) -> { });


        // December 15 R
        setItem(new cItemStack(api.getItemHead("24005")).setDisplayName(c.red + c.bold + "December 15th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 28, (s,c,p) -> { });


        // December 16 G
        setItem(new cItemStack(api.getItemHead("24004")).setDisplayName(c.red + c.bold + "December 16th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 29, (s,c,p) -> { });


        // December 17 R
        setItem(new cItemStack(api.getItemHead("24003")).setDisplayName(c.red + c.bold + "December 17th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 30, (s,c,p) -> { });


        // December 18 G
        setItem(new cItemStack(api.getItemHead("24002")).setDisplayName(c.red + c.bold + "December 18th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 31, (s,c,p) -> { });


        // December 19 R
        setItem(new cItemStack(api.getItemHead("24001")).setDisplayName(c.red + c.bold + "December 19th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 32, (s,c,p) -> { });


        // December 20 G
        setItem(new cItemStack(api.getItemHead("24000")).setDisplayName(c.red + c.bold + "December 20th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 33, (s,c,p) -> { });


        // December 21 R
        setItem(new cItemStack(api.getItemHead("23999")).setDisplayName(c.red + c.bold + "December 21st").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 34, (s,c,p) -> { });


        // December 22 G
        setItem(new cItemStack(api.getItemHead("23998")).setDisplayName(c.red + c.bold + "December 22nd").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 37, (s,c,p) -> { });


        // December 23 R
        setItem(new cItemStack(api.getItemHead("23997")).setDisplayName(c.red + c.bold + "December 23rd").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 38, (s,c,p) -> { });


        // December 24 G
        setItem(new cItemStack(api.getItemHead("23996")).setDisplayName(c.red + c.bold + "December 24th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 39, (s,c,p) -> { });


        // December 25 R
        setItem(new cItemStack(api.getItemHead("23995")).setDisplayName(c.red + c.bold + "December 25th").addLore(
                c.dgray + "Advent Reward",
                "",
                c.gray + "Reward still a mystery!",
                "",
                c.red + "Locked!"
        ), 40, (s,c,p) -> { });

        //
        setItem(new cItemStack(api.getItemHead("22837")).setDisplayName(c.gold + c.bold + "Use Super Claim").addLore(
                c.dgray + "Super Claim",
                "",
                c.gray + "Missed a reward?",
                c.gray + "Spend some coins and use a",
                c.gray + "super claim to claim it!",
                c.gray + "",
                c.gray + "Note: Super Claims only work on the last missed reward!",
                c.gray + "You will not be able to claim all missed rewards.",
                "",
                c.yellow + "Your super claims: " + c.white + "0",
                "",
                c.red + "You do not have any super claims!"
        ), 41, (s,c,p) -> { });


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
