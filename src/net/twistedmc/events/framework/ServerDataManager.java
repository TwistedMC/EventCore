package net.twistedmc.events.framework;



public class ServerDataManager {

    private ServerGameType serverGameType = null;
    private ServerType serverType = ServerType.HUB;


    public ServerGameType getServerGameType() {
        return serverGameType;
    }

    public void setServerGameType(ServerGameType serverGameType) {
        this.serverGameType = serverGameType;
    }

    public ServerType getServerType(){
        return serverType;
    }

    public void setServerType(ServerType gameType) {
        this.serverType = gameType;
    }
}