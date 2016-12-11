package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 *@author Zijun Xu
 */
/**
 * 
 * responsible for sending a reset game request to server
 *
 */
public class ResetGameController {

    protected Application app;
    protected Model model;

    public ResetGameController(Application app, Model model){
        this.app = app;
        this.model = model;
    }

    public void process(){
        String xmlString = Message.requestHeader() + String.format("<resetGameRequest gameId='%s'/></request>",
                model.getGame().getRoomID());
        Message m = new Message(xmlString);
        System.out.println(m.toString());
        app.getServerAccess().sendRequest(m);
    }
}
