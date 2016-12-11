package client.controller;
/**
 *@author Zijun Xu
 */

import client.view.Application;
import xml.Message;
import client.model.Model;
/**
 * 
 * the Controller of making a request of Create Game
 *
 */
public class CreateGameController {

	Application app;
	Model model;

	public CreateGameController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** 
	 * Make the request on the server and wait for response. 
	 * included with a judgment statement of whether included with password or not
	 * support with or without password to create a game
	 */
	public void process() {
		// send the request to create the game.
		String xmlString;
		if (this.model.getGame().getPassword() != null){
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s' password='%s'/></request>",
				this.model.getGame().getMyName(), this.model.getGame().getPassword());
		}
		else {
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'/></request>",
					this.model.getGame().getMyName());
		}

		Message m = new Message (xmlString);
        System.out.println(m.toString());
		app.getServerAccess().sendRequest(m);
	}
}
