package net.twistedmc.events.inventorys.globalevents;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.twistedmc.events.data.c;
import net.twistedmc.events.util.item.AbstractGUI;
import net.twistedmc.events.util.item.cItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ContributeMenu extends AbstractGUI {
    HeadDatabaseAPI HEADapi = new HeadDatabaseAPI();
    private static final int BORDER_FILL[] = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,45,44,46,47,48,50,51,52,53};
    /*
    00 01 02 03 04 05 06 07 08
    09 10 11 12 13 14 15 16 17
    18 19 20 21 22 23 24 25 26
    27 28 29 30 31 32 33 34 35
    36 37 38 39 40 41 42 43 44
    45 46 47 48    50 51 52 53
     */
    public ContributeMenu(Player player) {
        super(6,"Contribute Snowflakes",player);
        setItem(new cItemStack(Material.ARROW).setDisplayName(c.green + "Back").addLore
                        (c.gray + "Close this menu")
                , 49, (s,c,p) -> { });
    }
}
