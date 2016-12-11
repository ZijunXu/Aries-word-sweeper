package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

/**
 *@author Zijun Xu
 */

/**
 * 
 * responsible for handling the resetGame response from server
 *
 */
public class ResetGameResponseController extends ControllerChain{

    protected Application app;
    protected Model model;

    public ResetGameResponseController(Application a, Model m){
        super();
        this.app = a;
        this.model = m;
    }
    /** when receiving the response, use resetGame() method to reset game */
    @Override
    public boolean process(Message response){
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals("resetGameResponse")) {
            return next.process(response);
        }
        model.resetGame();
        return true;
    }
}
