package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 *@author Zijun Xu
 */
public class FindWordController {

    Application app;
    Model model;

    FindWordController(Application app, Model model){
        this.app = app;
        this.model = model;
    }

    public void process(){
        String chosenCellsInfoXMLString = model.getChoseCellsXMLString();

        String xmlString = Message.requestHeader() +
                String.format("<findWordRequest name='%s' word='%s' gameId='%s'>",
                        model.getGame().getMyName(),
                        model.getWord().selectedWord(),
                        model.getGame().getRoomID()) +
                chosenCellsInfoXMLString + "</findWordRequest></request>";

        Message m = new Message (xmlString);
        app.getServerAccess().sendRequest(m);
        System.out.println(m.toString());
    }
}
