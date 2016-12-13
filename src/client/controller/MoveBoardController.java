package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

/**
 * controller that is responsible to send a moveBoard request to server
 *
 * the{@link #process()}send the repositionRequest to server according to which button(left, right, up or down) pressed
 *@author Zijun Xu
 */
public class MoveBoardController {
    int columnChange;
    int rowChange;
    Application app;
    Model model;

    public MoveBoardController(Application app, Model model, int columnChange, int rowChange){
        this.app = app;
        this.model = model;
        this.columnChange = columnChange;
        this.rowChange = rowChange;
    }
    /** according to which button(left, right, up or down) pressed, send a corresponding request */
    public void process(){
        String xmlString = Message.requestHeader() + String.format("<repositionBoardRequest name='%s' gameId='%s' " +
                        "rowChange='%d' colChange='%d'/></request>", model.getGame().getMyName(),
                model.getGame().getRoomID(), rowChange, columnChange);
        Message m = new Message (xmlString);
        System.out.println(m.toString());
        app.getServerAccess().sendRequest(m);
    }
}
