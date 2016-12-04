package client.controller;


import client.view.GameModePanel;
import client.model.Model;
import xml.Message;

public class ExitGameController {
    GameModePanel app;
    Model model;
    public ExitGameController(GameModePanel app, Model model){
        this.app = app;
        this.model = model;
    }
    public void process() {

        String xmlString = Message.requestHeader() + String.format("<exitGameRequest name='%s' gameId='%s'/></request>",
                model.getGame().getMyName(),
                model.getGame().getRoomID());

        Message m = new Message (xmlString);
        app.getRequestArea().append(m.toString());
        app.getRequestArea().append("\n");
        app.getServerAccess().sendRequest(m);
    }
}
