package net.twistedmc.events.inventorys.globalevents;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;

public class GlobalMenu extends AbstractGUI {

    /*
    00 01 02 03 04 05 06 07 08
    09 10 11 12    14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 29 30 31 32 33 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48    50 51 52 53
     */
    // Config
    public static int GlobalGoal = 0;
    public static int Goal1 = 0;
    public static int Goal2 = 0;
    public static int Goal3 = 0;
    public static int Goal4 = 0;
    public static int Goal5 = 0;
    // 
    private static final int BORDER_FILL[] = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,45,44,46,47,48,50,51,52,53};

    public GlobalMenu(Player player) {
        super(6, "2021 Winter Community Challenge", player);
        fill();

        setItem(new cItemStack(Material.ARROW).setDisplayName(c.green + "Close").addLore
               (c.gray + "Close this menu")
        , 49, (s,c,p) -> { });

        setItem(new cItemStack(Material.ARROW).setDisplayName(c.green + "Contribution Overview").addLore
               (c.gray + "Close this menu") // TO-DO:
                                            // LORE
        , 13, (s,c,p) -> { });


    }
    public void fill() {
        Arrays.stream(BORDER_FILL).forEach(slot -> setItem(new cItemStack(Material.BLACK_STAINED_GLASS_PANE).setDisplayName(c.black  + "").addEnchant(Enchantment.LUCK, 1).addFlags(ItemFlag.HIDE_ENCHANTS), slot, (s,c,p) -> { })); 
    }

}
