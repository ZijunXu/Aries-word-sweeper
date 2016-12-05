package client.controller;

import client.model.Model;
import client.view.Application;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml.Message;

public class ListGamesResponseController extends ControllerChain{
    public Application app;
    public Model model;

    public ListGamesResponseController(Application a, Model m){
        super();
        this.app = a;
        this.model = m;
    }

    @Override
    public boolean process(Message response){
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals ("listGamesResponse")) {
            return next.process(response);
        }
        Node listGamesResponse = response.contents.getFirstChild();
        NodeList list = listGamesResponse.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            String gameName = n.getAttributes().getNamedItem("gameId").getNodeValue();
            int playerNumber = Integer.valueOf(n.getAttributes().getNamedItem("players").getNodeValue());
            model.addGameToGameList(gameName, playerNumber);
        }
        return true;
    }
}
