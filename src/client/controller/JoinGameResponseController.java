package client.controller;

import client.view.Application;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.model.Model;
import xml.Message;
/**
 *@Zijun Xu
 */
public class JoinGameResponseController extends ControllerChain{

    public Application app;
    public Model model;

    public JoinGameResponseController(Application a, Model m){
        super();
        this.app = a;
        this.model = m;
    }

    @Override
    public boolean process(Message response) {
        String type = response.contents.getFirstChild().getLocalName();
        System.out.println(response.toString());

        if (!type.equals("joinGameResponse")){
            return next.process(response);
        }
        if (response.contents.getAttributes().getNamedItem("success").getNodeValue().equals("false")){
            app.setErrorMessege(response.contents.getAttributes().getNamedItem("reason").getNodeValue());
            return false;
        }else {
            this.model.setIsExistedGame(true);
        }
        Node boardResponse = response.contents.getFirstChild();
        NamedNodeMap map = boardResponse.getAttributes();
        String gameId = map.getNamedItem("gameId").getNodeValue();
        model.getGame().setRoomID(gameId);

        return true;
    }
}
