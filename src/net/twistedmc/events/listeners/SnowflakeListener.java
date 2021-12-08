package net.twistedmc.events.listeners;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.md_5.bungee.api.ChatColor;
import net.twistedmc.api.API;
import net.twistedmc.api.achievements.Achievement;
import net.twistedmc.api.achievements.AchievementType;
import net.twistedmc.events.Main;
import org.bukkit.Bukkit;
import org.bukkit.block.Biome;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class SnowflakeListener implements Listener {

    static HeadDatabaseAPI api = new HeadDatabaseAPI();

    public static int minSpawner = 6;
    public static int maxSpawner = 35;

    public static int min = 35;
    public static int max = 210;

    /*@EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.SNOWMAN ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.POLAR_BEAR ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && (((Fox) event.getEntity()).getFoxType() == Fox.Type.SNOW) ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.STRAY ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.GOAT ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && (((Villager) event.getEntity()).getVillagerType() == Villager.Type.SNOW) ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && (((Villager) event.getEntity()).getVillagerType() == Villager.Type.TAIGA) ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.GLOW_SQUID ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.DOLPHIN) {
            Main.mob.add(event.getEntity().getUniqueId());
        }

        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.SNOWMAN ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.POLAR_BEAR ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && (((Fox) event.getEntity()).getFoxType() == Fox.Type.SNOW) ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.STRAY ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.GOAT ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && (((Villager) event.getEntity()).getVillagerType() == Villager.Type.SNOW) ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && (((Villager) event.getEntity()).getVillagerType() == Villager.Type.TAIGA) ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.GLOW_SQUID ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.DOLPHIN) {
            Main.mobSpawner.add(event.getEntity().getUniqueId());
        }
    }*/

    @EventHandler
    public void onKill(EntityDeathEvent event) { // ZOMBIE,HUSK,DROWNED, SKELETON, STRAY
        if (!Main.systemDisabled("christmasSurvival") /*&& Main.mob.contains(event.getEntity().getUniqueId())*/) {
            if (event.getEntity().getType() == EntityType.ENDERMAN && event.getEntity().getKiller() instanceof Player
                    || event.getEntity().getType() == EntityType.POLAR_BEAR && event.getEntity().getKiller() instanceof Player
                    || event.getEntity().getType() == EntityType.STRAY && event.getEntity().getKiller() instanceof Player
                    || event.getEntity().getType() == EntityType.GOAT && event.getEntity().getKiller() instanceof Player
                    || event.getEntity().getType() == EntityType.GLOW_SQUID && event.getEntity().getKiller() instanceof Player
                    || event.getEntity().getType() == EntityType.DOLPHIN && event.getEntity().getKiller() instanceof Player) {

                Player p = event.getEntity().getKiller().getPlayer();

                Random random = new Random();
                int randomNumber = random.nextInt(max - min) + min;

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + p.getName() + " add " + randomNumber);

                if (!net.twistedmc.api.API.hasAchievement(p, Achievement.SUGAR_RUSH)) {
                    net.twistedmc.api.API.unlockAchievement(p, Achievement.WINTERY_DEVOTION, AchievementType.NORMAL);
                }
                return;
            }

            if (event.getEntity().getType() == EntityType.FOX && (((Fox) event.getEntity()).getFoxType() == Fox.Type.SNOW) && event.getEntity().getKiller() instanceof Player) {

                Player p = event.getEntity().getKiller().getPlayer();

                Random random = new Random();
                int randomNumber = random.nextInt(max - min) + min;

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + p.getName() + " add " + randomNumber);

                if (!net.twistedmc.api.API.hasAchievement(p, Achievement.SUGAR_RUSH)) {
                    net.twistedmc.api.API.unlockAchievement(p, Achievement.WINTERY_DEVOTION, AchievementType.NORMAL);
                }
                return;
            }

            if (event.getEntity().getType() == EntityType.VILLAGER && (((Villager) event.getEntity()).getVillagerType() == Villager.Type.SNOW) && event.getEntity().getKiller() instanceof Player) {

                Player p = event.getEntity().getKiller().getPlayer();

                Random random = new Random();
                int randomNumber = random.nextInt(max - min) + min;

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + p.getName() + " add " + randomNumber);

                if (!net.twistedmc.api.API.hasAchievement(p, Achievement.SUGAR_RUSH)) {
                    net.twistedmc.api.API.unlockAchievement(p, Achievement.WINTERY_DEVOTION, AchievementType.NORMAL);
                }
                return;
            }

            if (event.getEntity().getType() == EntityType.VILLAGER &&(((Villager) event.getEntity()).getVillagerType() == Villager.Type.TAIGA) && event.getEntity().getKiller() instanceof Player) {

                Player p = event.getEntity().getKiller().getPlayer();

                Random random = new Random();
                int randomNumber = random.nextInt(max - min) + min;

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + p.getName() + " add " + randomNumber);

                if (!net.twistedmc.api.API.hasAchievement(p, Achievement.SUGAR_RUSH)) {
                    net.twistedmc.api.API.unlockAchievement(p, Achievement.WINTERY_DEVOTION, AchievementType.NORMAL);
                }
                return;
            }
        }
    }

    public static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String format(String msg) {
        if (Bukkit.getVersion().contains("1.17")) {
            //hex colors
            Matcher match = pattern.matcher(msg);
            while (match.find()) {
                String color = msg.substring(match.start(), match.end());
                msg = msg.replace(color, ChatColor.of(color) + "");
                match = pattern.matcher(msg);
            }
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }



}
