package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 *@author Zijun Xu
 */
public class ResetGameController {

    protected Application app;
    protected Model model;

    public ResetGameController(Application app, Model model){
        this.app = app;
        this.model = model;
    }

    public void process(){
        String xmlString = Message.requestHeader() + String.format("<restGameRequest gameID='%s'/></request>",
                model.getGame().getRoomID());
        Message m = new Message(xmlString);
        //app.getRequestArea().append(m.toString());
        //app.getRequestArea().append("\n");
        app.getServerAccess().sendRequest(m);
    }

}
