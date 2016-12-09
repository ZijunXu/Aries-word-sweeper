package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 *@author Zijun Xu
 */
public class LockGameController{

    protected Application app;
    protected Model model;

    public LockGameController(Application app, Model model){
        this.app = app;
        this.model = model;
    }

    public void process(){
        String xmlString = Message.requestHeader() + String.format("<lockGameRequest gameId='%s'/></request>",
                model.getGame().getRoomID());
        Message m = new Message(xmlString);
//        app.getRequestArea().append(m.toString());
//        app.getRequestArea().append("\n");
        System.out.println(m.toString());
        app.getServerAccess().sendRequest(m);
    }
}
