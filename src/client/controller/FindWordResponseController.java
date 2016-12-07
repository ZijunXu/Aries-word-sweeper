package client.controller;

import client.view.Application;
import client.model.Model;
import xml.Message;

import java.awt.*;
/**
 *@author Zijun Xu
 */
public class FindWordResponseController extends ControllerChain{

    public Application app;
    public Model model;

    public FindWordResponseController(Application a, Model m) {
        super();
        this.app = a;
        this.model = m;
    }

    public boolean process(Message response){
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals("findWordResponse")) {
            return next.process(response);
        }
        if (response.contents.getAttributes().getNamedItem("success").getNodeValue().equals("false")){
            model.getWord().resetWord();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    model.getBoard().cells[i][j].disselectCell();
                    model.getGrid()[i][j].setBackground(Color.white);
                }
            }
            return false;
        }
//        Node boardResponse = response.contents.getFirstChild();
//        NamedNodeMap map = boardResponse.getAttributes();
//
//        String gameId = map.getNamedItem("gameId").getNodeValue();
//        String score = map.getNamedItem("score").getNodeValue();
//        String pname = map.getNamedItem("name").getNodeValue();
//
//        app.getResponseArea().append("Board Message received for game:" + boardResponse.toString() + "\n");
//        model.getGame().setScore(Integer.valueOf(score));
        model.getWord().resetWord();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                model.getBoard().cells[i][j].disselectCell();
                model.getGrid()[i][j].setBackground(Color.white);
            }
        }
        return true;
    }
}
