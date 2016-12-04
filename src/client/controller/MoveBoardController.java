package client.controller;

import client.model.Model;
import client.view.GameModePanel;
import xml.Message;

public class MoveBoardController {
    GameModePanel app;
    Model model;

    public MoveBoardController(GameModePanel app, Model model){
        this.app = app;
        this.model = model;
    }

    public void process(){
        String xmlString = Message.requestHeader() + String.format("<repositionBoardRequest name='%s' gameID='%s'") +
                "'rowChange='"+
                "' colChange='" +  "'/></request>";
        Message m = new Message (xmlString);
        app.getRequestArea().append(m.toString());
        app.getRequestArea().append("\n");
        app.getServerAccess().sendRequest(m);
    }
}
