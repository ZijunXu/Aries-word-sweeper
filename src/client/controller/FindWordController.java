package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 * responsible for send the findWordRequest, send the fond words' XML to server
 *
 * the {@link #process()}send the fond words in XML format and sent to the server
 *@author Zijun Xu
 */
public class FindWordController {

    Application app;
    Model model;

    FindWordController(Application app, Model model){
        this.app = app;
        this.model = model;
    }
    
    /** chosenCellsInfoXMLString is the set of cells which were selected */
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
