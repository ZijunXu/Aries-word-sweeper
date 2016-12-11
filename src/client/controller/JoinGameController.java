package client.controller;
/**
 *@author Zijun Xu
 */

import client.view.Application;
import client.model.Model;
import xml.Message;

public class JoinGameController {

	Application app;
	Model model;

	public JoinGameController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
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
