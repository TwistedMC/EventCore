package net.twistedmc.api.achievements;


import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class AchievementUnlockEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private Achievement achievement;

    public AchievementUnlockEvent(Player player, Achievement achievement) {
        this.player = player;
        this.achievement = achievement;
    }

    public Player getUser() {
        return player;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}