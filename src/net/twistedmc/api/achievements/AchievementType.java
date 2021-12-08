package net.twistedmc.api.achievements;

public enum AchievementType {

    NORMAL(),
    TIERED(),
    SECRET();

    AchievementType() { }

    public static AchievementType find(String name) {
        for(AchievementType achievementType : values())
            if(achievementType.toString().equalsIgnoreCase(name))
                return achievementType;

        return null;
    }

}