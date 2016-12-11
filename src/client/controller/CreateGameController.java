package client.controller;
/**
 *@author Zijun Xu
 */

import client.view.Application;
import xml.Message;
import client.model.Model;

public class CreateGameController {

	Application app;
	Model model;

	public CreateGameController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
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
		
		
		// alternative version
		/*
		String xmlString;
		if (this.app.getPassword() != null){
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s' password='%s'/></request>", this.app.getPlayerName(), this.app.getPassword());
		}
		else {
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'/></request>", this.app.getPlayerName());
		}*/

		Message m = new Message (xmlString);
        System.out.println(m.toString());
		app.getServerAccess().sendRequest(m);
	}
}
