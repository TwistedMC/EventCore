package net.twistedmc.events.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;
import net.twistedmc.events.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.twistedmc.events.data.c;
import org.bukkit.scheduler.BukkitRunnable;

public class ToTListener implements Listener {


    public static int minCandySpawner = 6;
    public static int maxCandySpawner = 35;

    public static int minCandy = 35;
    public static int maxCandy = 210;

    // CONFIG
    boolean CandyDropsEnabled = true;
    boolean NetherCandyDropsEnabled = true; // Unimplemented
    //

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.ENDERMAN ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.ZOMBIE ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.HUSK ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.SKELETON ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.DROWNED ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.STRAY ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.GHAST ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.ZOMBIFIED_PIGLIN ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && event.getEntity().getType() == EntityType.WITHER_SKELETON) {
            Main.mob.add(event.getEntity().getUniqueId());
        }

        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.ENDERMAN ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.ZOMBIE ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.HUSK ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.SKELETON ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.DROWNED ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.STRAY ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.GHAST ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.ZOMBIFIED_PIGLIN ||
                event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER && event.getEntity().getType() == EntityType.WITHER_SKELETON) {
            Main.mobSpawner.add(event.getEntity().getUniqueId());
        }
    }

    @EventHandler
    public void onKill(EntityDeathEvent event) { // ZOMBIE,HUSK,DROWNED, SKELETON, STRAY
        if (CandyDropsEnabled == true && !Main.systemDisabled("halloweenSurvival") && Main.mob.contains(event.getEntity().getUniqueId())) {
            if (event.getEntity().getType() == EntityType.ENDERMAN && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.ZOMBIE && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.HUSK && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.DROWNED && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.SKELETON && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.STRAY && event.getEntity().getKiller() instanceof Player) {

                Player p = event.getEntity().getKiller().getPlayer();

                Main.mob.remove(event.getEntity().getUniqueId());

                Random random = new Random();
                int randomNumber = random.nextInt(maxCandy - minCandy) + minCandy;

                if (Math.random() < 0.4) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + event.getEntity().getKiller().getName() + " add " + randomNumber);
                } else {
                    p.sendMessage(c.red + "You got " + c.red + c.bold + "TRICKED!");

                    Entity entity = event.getEntity();

                    Bat bat1 = entity.getWorld().spawn(entity.getLocation(), Bat.class);
                    Bat bat2 = entity.getWorld().spawn(entity.getLocation(), Bat.class);
                    Bat bat3 = entity.getWorld().spawn(entity.getLocation(), Bat.class);

                    bat1.setNoDamageTicks(3);
                    bat2.setNoDamageTicks(3);
                    bat3.setNoDamageTicks(3);

                    new BukkitRunnable() {

                        @Override
                        public void run() {

                            bat1.getWorld().playEffect(bat1.getLocation(), Effect.SMOKE, 1);
                            bat1.getWorld().playEffect(bat2.getLocation(), Effect.SMOKE, 1);
                            bat1.getWorld().playEffect(bat3.getLocation(), Effect.SMOKE, 1);

                            bat1.remove();
                            bat2.remove();
                            bat3.remove();

                        }

                    }.runTaskLater(Main.getInstance(), 50);
                }


            } else if (event.getEntity().getType() == EntityType.GHAST && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.ZOMBIFIED_PIGLIN && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.WITHER_SKELETON && event.getEntity().getKiller() instanceof Player) {
                Main.mob.remove(event.getEntity().getUniqueId());

                Player p = event.getEntity().getKiller().getPlayer();

                Random random = new Random();
                int randomNumber = random.nextInt(400 - minCandy * 2) + minCandy * 2;

                if (Math.random() < 0.4) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + event.getEntity().getKiller().getName() + " add " + randomNumber);
                } else {
                    p.sendMessage(c.red + "You got " + c.red + c.bold + "TRICKED!");

                    Entity entity = event.getEntity();

                    Bat bat1 = entity.getWorld().spawn(entity.getLocation(), Bat.class);
                    Bat bat2 = entity.getWorld().spawn(entity.getLocation(), Bat.class);
                    Bat bat3 = entity.getWorld().spawn(entity.getLocation(), Bat.class);

                    bat1.setNoDamageTicks(3);
                    bat2.setNoDamageTicks(3);
                    bat3.setNoDamageTicks(3);

                    new BukkitRunnable() {

                        @Override
                        public void run() {

                            bat1.getWorld().playEffect(bat1.getLocation(), Effect.SMOKE, 1);
                            bat1.getWorld().playEffect(bat2.getLocation(), Effect.SMOKE, 1);
                            bat1.getWorld().playEffect(bat3.getLocation(), Effect.SMOKE, 1);

                            bat1.remove();
                            bat2.remove();
                            bat3.remove();

                        }

                    }.runTaskLater(Main.getInstance(), 50);
                }
            }
        }
    }

    @EventHandler
    public void onKillSpawner(EntityDeathEvent event) { // ZOMBIE,HUSK,DROWNED, SKELETON, STRAY
        if (CandyDropsEnabled == true && !Main.systemDisabled("halloweenSurvival") && Main.mobSpawner.contains(event.getEntity().getUniqueId())) {
            if (event.getEntity().getType() == EntityType.ENDERMAN && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.ZOMBIE && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.HUSK && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.DROWNED && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.SKELETON && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.STRAY && event.getEntity().getKiller() instanceof Player) {

                Player p = event.getEntity().getKiller().getPlayer();

                Main.mobSpawner.remove(event.getEntity().getUniqueId());

                Random random = new Random();
                int randomNumber = random.nextInt(maxCandySpawner - minCandySpawner) + minCandySpawner;

                if (Math.random() < 0.4) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + event.getEntity().getKiller().getName() + " add " + randomNumber);
                } else {
                    p.sendMessage(c.red + "You got " + c.red + c.bold + "TRICKED!");

                    Entity entity = event.getEntity();

                    Bat bat1 = entity.getWorld().spawn(entity.getLocation(), Bat.class);
                    Bat bat2 = entity.getWorld().spawn(entity.getLocation(), Bat.class);
                    Bat bat3 = entity.getWorld().spawn(entity.getLocation(), Bat.class);

                    bat1.setNoDamageTicks(3);
                    bat2.setNoDamageTicks(3);
                    bat3.setNoDamageTicks(3);

                    new BukkitRunnable() {

                        @Override
                        public void run() {

                            bat1.getWorld().playEffect(bat1.getLocation(), Effect.SMOKE, 1);
                            bat1.getWorld().playEffect(bat2.getLocation(), Effect.SMOKE, 1);
                            bat1.getWorld().playEffect(bat3.getLocation(), Effect.SMOKE, 1);

                            bat1.remove();
                            bat2.remove();
                            bat3.remove();

                        }

                    }.runTaskLater(Main.getInstance(), 50);
                }


            } else if (event.getEntity().getType() == EntityType.GHAST && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.ZOMBIFIED_PIGLIN && event.getEntity().getKiller() instanceof Player || event.getEntity().getType() == EntityType.WITHER_SKELETON && event.getEntity().getKiller() instanceof Player) {
                Main.mobSpawner.remove(event.getEntity().getUniqueId());

                Player p = event.getEntity().getKiller().getPlayer();

                Random random = new Random();
                int randomNumber = random.nextInt(maxCandySpawner - minCandySpawner) + minCandySpawner;

                if (Math.random() < 0.4) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hcc " + event.getEntity().getKiller().getName() + " add " + randomNumber);
                } else {
                    p.sendMessage(c.red + "You got " + c.red + c.bold + "TRICKED!");

                    Entity entity = event.getEntity();

                    Bat bat1 = entity.getWorld().spawn(entity.getLocation(), Bat.class);
                    Bat bat2 = entity.getWorld().spawn(entity.getLocation(), Bat.class);
                    Bat bat3 = entity.getWorld().spawn(entity.getLocation(), Bat.class);

                    bat1.setNoDamageTicks(3);
                    bat2.setNoDamageTicks(3);
                    bat3.setNoDamageTicks(3);

                    new BukkitRunnable() {

                        @Override
                        public void run() {

                            bat1.getWorld().playEffect(bat1.getLocation(), Effect.SMOKE, 1);
                            bat1.getWorld().playEffect(bat2.getLocation(), Effect.SMOKE, 1);
                            bat1.getWorld().playEffect(bat3.getLocation(), Effect.SMOKE, 1);

                            bat1.remove();
                            bat2.remove();
                            bat3.remove();

                        }

                    }.runTaskLater(Main.getInstance(), 50);
                }
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
