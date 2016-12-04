package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.model.Model;
import client.view.GameModePanel;
import xml.Message;

public class JoinGameResponseController extends ControllerChain{
    public GameModePanel app;
    public Model model;

    public JoinGameResponseController(GameModePanel a, Model m){
        super();
        this.app = a;
        this.model = m;
    }

    @Override
    public boolean process(Message response) {
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals("JoinGameResponse")){
            return next.process(response);
        }
        if (response.contents.getAttributes().getNamedItem("success").getNodeValue().equals("false")){
            return false;
        }else {
            this.model.existedGame = true;
        }
        Node boardResponse = response.contents.getFirstChild();
        NamedNodeMap map = boardResponse.getAttributes();
        String gameId = map.getNamedItem("gameId").getNodeValue();
        app.getResponseArea().append(response.toString() + "\n");
        model.getGame().setRoomID(gameId);
        return true;
    }
}
