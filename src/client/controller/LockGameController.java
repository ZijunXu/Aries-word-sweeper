package client.controller;

import client.model.Model;
import client.view.GameModePanel;
import xml.Message;

public class LockGameController{
    public GameModePanel app;
    public Model model;

    public LockGameController(GameModePanel app, Model model){
        this.app = app;
        this.model = model;
    }

    public void process(){
        String xmlString = Message.requestHeader() + String.format("<lockGameRequest gameID='%s'/></request>", model.getGame().getRoomID());
        Message m = new Message(xmlString);
        app.getRequestArea().append(m.toString());
        app.getRequestArea().append("\n");
        app.getServerAccess().sendRequest(m);
    }
}
