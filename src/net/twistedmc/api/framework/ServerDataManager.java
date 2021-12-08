package net.twistedmc.api.framework;



public class ServerDataManager {

    private ServerGameType serverGameType = null;
    private HubType whatHub = null;
    private ServerType serverType = null;


    public ServerGameType getServerGameType() {
        return serverGameType;
    }

    public void setServerGameType(ServerGameType serverGameType) {
        this.serverGameType = serverGameType;
    }

    public ServerType getServerType(){
        return serverType;
    }

    public HubType getHub() {
        return whatHub;
    }

    public void setHub(HubType whatHub) {
        this.whatHub = whatHub;
    }

    public void setServerType(ServerType gameType) {
        this.serverType = gameType;
    }
}