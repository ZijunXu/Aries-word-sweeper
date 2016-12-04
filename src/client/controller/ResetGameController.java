package client.controller;

import client.model.Model;
import client.view.GameModePanel;
import xml.Message;

public class ResetGameController {
    GameModePanel app;
    Model model;

    public ResetGameController(GameModePanel app, Model model){
        this.app = app;
        this.model = model;
    }

   // String request = Message.requestHeader() + String.format("<restGameRequest gameID='%s'/></request>", model.getGame().getRoomID());
   // System.o
}
