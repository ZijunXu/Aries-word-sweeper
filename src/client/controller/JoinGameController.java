package client.controller;
/**
 *@author Zijun Xu
 */

import client.view.Application;
import client.model.Model;
import xml.Message;

/**
 * 
 * responsible for make a join game request to the server
 *
 */
public class JoinGameController {

	Application app;
	Model model;

	public JoinGameController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	/** also, like the create game controller, included with a judgment statement of whether included with password or not */
	public void process() {
		// send the request to create the game.
        String xmlString;
        if(app.getPassword() == null){
            xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s'/></request>",
                    app.getRoomID(),
                    model.getGame().getMyName());

        }else{
            xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s' password='%s'/></request>",
                    app.getRoomID(),
                    model.getGame().getMyName(), app.getPassword());
        }

		Message m = new Message (xmlString);
        System.out.println(m.toString());
		app.getServerAccess().sendRequest(m);
	}
}
