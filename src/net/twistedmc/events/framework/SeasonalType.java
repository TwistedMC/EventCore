package net.twistedmc.events.framework;

public enum SeasonalType {

    HALLOWEEN("Halloween", "halloween"),
    CHRISTMAS("Christmas", "christmas"),
    EASTER("Easter", "easter");

    private String display, prefabName;

    SeasonalType(String display, String prefabName) {
        this.display = display;
        this.prefabName = prefabName;
    }

    public String getDisplay() {
        return display;
    }

    public String getPrefabName() {
        return prefabName;
    }

    public static SeasonalType find(String name) {
        for(SeasonalType seasonalType : values())
            if(seasonalType.toString().equalsIgnoreCase(name))
                return seasonalType;

        return null;
    }

}