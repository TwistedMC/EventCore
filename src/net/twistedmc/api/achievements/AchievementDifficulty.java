package net.twistedmc.api.achievements;

import net.md_5.bungee.api.ChatColor;

public enum AchievementDifficulty {

    NOVICE(0, 10, ChatColor.GREEN, "Novice is the easiest difficulty. Most of these types of achievements can be earned in a few minutes or some even a few seconds."),
    EASY(1, 11, ChatColor.YELLOW, "Easy is the second easiest difficulty, even though it's called easy. Easy achievements like the name suggests, they're pretty easy to get."),
    MEDIUM(2, 12, ChatColor.BLUE, "Medium is the middle ground of difficulty, it's not too hard but, it's not easy for sure."),
    HARD(3, 13, ChatColor.LIGHT_PURPLE, "Hard is where it starts to get tough. You have to have some serious dedication to get to this point."),
    INSANE(4, 1, ChatColor.RED, "Insane like the name, requires you to actually be insane to complete. On completion of an insane achievement a message is broadcasted to the entire network."),
    EPIC(5, 14, ChatColor.GOLD, "Epic achievements are a true and amazing task to complete. When completed a message will be sent to the entire network telling everyone of what you managed to accomplish!\"");

    private String description;
    private int difficulty, itemstackData;
    private ChatColor chatColor;

    AchievementDifficulty(int difficulty, int itemstackData, ChatColor chatColor, String description) {
        this.difficulty = difficulty;
        this.itemstackData = itemstackData;
        this.chatColor = chatColor;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public short getItemStackData() {
        return (short) itemstackData;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }
}