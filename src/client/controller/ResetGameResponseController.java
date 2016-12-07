package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

/**
 *@author Zijun Xu
 */
public class ResetGameResponseController extends ControllerChain{

    protected Application app;
    protected Model model;

    public ResetGameResponseController(Application a, Model m){
        super();
        this.app = a;
        this.model = m;
    }

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
