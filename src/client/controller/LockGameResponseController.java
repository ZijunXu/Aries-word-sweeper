package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 *@author Zijun Xu
 */
/**
 * 
 * responsible for handling the lock game response from server
 *
 */
public class LockGameResponseController extends ControllerChain{

    protected Application app;
    protected Model model;

    public LockGameResponseController(Application a, Model m){
        super();
        this.app = a;
        this.model = m;
    }

    /** when receiving the response from server, lock the game and set lockgame button grey */
    @Override
    public boolean process(Message response){
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals("lockGameResponse")){
            return next.process(response);
        }
        model.getGame().lockGame();
        app.getPlayingPanel().lockGame();
        return true;
    }
}
