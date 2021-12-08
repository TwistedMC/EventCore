package net.twistedmc.api.framework;

public enum HubType {

    HUB1("Lobby #1", "#1"),
    HUB2("Lobby #2", "#2"),
    HUB3("Lobby #3", "#3"),
    HUB4("Lobby #4", "#4"),
    BEDWARSHUB1("Bed Wars Lobby #1", "#1");

    private String display, prefabName;

    HubType(String display, String prefabName) {
        this.display = display;
        this.prefabName = prefabName;
    }

    public String getDisplay() {
        return display;
    }

    public String getPrefabName() {
        return prefabName;
    }

    public static HubType find(String name) {
        for(HubType whatHub : values())
            if(whatHub.toString().equalsIgnoreCase(name))
                return whatHub;

        return null;
    }

}