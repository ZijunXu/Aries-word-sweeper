package client.controller;


import client.model.Model;
import client.view.Application;
import xml.Message;
/**
 *@author Zijun Xu
 */

/**
 * 
 * responsible for making a request of listing current games in server
 *
 */
public class ListGamesController {

    protected Application app;
    protected Model model;

    public ListGamesController(Application a, Model m) {
    	this.app = a;
        this.model = m;
	}

    public void process(){
        String xmlString = Message.requestHeader() + "<listGamesRequest /></request>";
        Message m = new Message(xmlString);
        app.getServerAccess().sendRequest(m);
    }
}
