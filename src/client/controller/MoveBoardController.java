package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 *@author Zijun Xu
 */
public class MoveBoardController {

    Application app;
    Model model;

    public MoveBoardController(Application app, Model model){
        this.app = app;
        this.model = model;
    }

    public void process(){
        String xmlString = Message.requestHeader() + String.format("<repositionBoardRequest name='%s' gameID='%s'",
                model.getGame().getMyName(), model.getGame().getRoomID())
                + "'rowChange='"+
                "' colChange='" +  "'/></request>";
        Message m = new Message (xmlString);
//        app.getRequestArea().append(m.toString());
//        app.getRequestArea().append("\n");
        app.getServerAccess().sendRequest(m);
    }
}
