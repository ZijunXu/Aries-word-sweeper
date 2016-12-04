package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.view.GameModePanel;
import client.model.Model;
import client.model.Game;
import xml.Message;

public class FindWordResponseController extends ControllerChain{
    public GameModePanel app;
    public Model model;

    public FindWordResponseController(GameModePanel a, Model m) {
        super();
        this.app = a;
        this.model = m;
    }

    public boolean process(Message response){
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals("findWordResponse")) {
            return next.process(response);
        }
        if (response.contents.getAttributes().getNamedItem("success").getNodeValue().equals("false"))
            return false;

        Node boardResponse = response.contents.getFirstChild();
        NamedNodeMap map = boardResponse.getAttributes();

        String gameId = map.getNamedItem("gameId").getNodeValue();
        String score = map.getNamedItem("score").getNodeValue();
        String pname = map.getNamedItem("name").getNodeValue();

        app.getResponseArea().append("Board Message received for game:" + boardResponse.toString() + "\n");
//        model.getGame().getPlayer().setWordscore(Integer.valueOf(score));
//
//        ((LeftBoardPanel) app.getMultiGame().getLeftBoardPanel()).refreshBoard();
//        ((RightGameInfoBoard) app.getMultiGame().getRightGameInfoPanel()).updateGameInfoBoard();

        return true;
    }
}
