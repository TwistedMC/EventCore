package net.twistedmc.events.framework;

public enum ServerGameType {

    SEASONAL("Seasonal", "seasonal"),
    GENERAL("General", "general"),
    ARCADE("Arcade", "arcade"),
    ENCHANTED("Survival", "enchanted"),
    BEDWARS("Bed Wars", "bedwars"),
    SKYBLOCK("SkyBlock", "skyblock"),
    EVENTS("Events", "events");

    private String display, prefabName;

    ServerGameType(String display, String prefabName) {
        this.display = display;
        this.prefabName = prefabName;
    }

    public String getDisplay() {
        return display;
    }

    public String getPrefabName() {
        return prefabName;
    }

    public static ServerGameType find(String name) {
        for(ServerGameType serverGameType : values())
            if(serverGameType.toString().equalsIgnoreCase(name))
                return serverGameType;

        return null;
    }

}