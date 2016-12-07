package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

public class FindWordController {
    /**
     *@Zijun Xu
     */
    Application app;
    Model model;

    FindWordController(Application app, Model model){
        this.app = app;
        this.model = model;
    }

    public void process(){
        String chosenCellsInfoXMLString = model.getWord().getChoseCellsXMLString();

        String xmlString = Message.requestHeader() + "<findWordRequest>" + chosenCellsInfoXMLString +
                String.format("<findWordRequest name='%s' word='%s' gameId='%s'>",
                        model.getWord().selectedWord(),
                        model.getGame().getMyName(),
                        model.getGame().getRoomID()) +
                "</request>";

        System.out.println(xmlString);

        Message m = new Message (xmlString);
        app.getRequestArea().append(m.toString());
        app.getRequestArea().append("\n");
        app.getServerAccess().sendRequest(m);
    }
}
