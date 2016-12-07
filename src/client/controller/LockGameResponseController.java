package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 *@author Zijun Xu
 */
public class LockGameResponseController extends ControllerChain{

    protected Application app;
    protected Model model;

    public LockGameResponseController(Application a, Model m){
        super();
        this.app = a;
        this.model = m;
    }

    @Override
    public boolean process(Message response){
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals("lockGameResponse")){
            return next.process(response);
        }
        model.getGame().lockGame();
        return true;
    }
}
