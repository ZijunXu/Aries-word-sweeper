package client.controller;


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
		if (this.app.getPassword() != null){
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s' password='%s'/></request>", this.app.getPlayerName(), this.app.getPassword());
		}
		else {
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'/></request>", this.app.getPlayerName());
		}
		Message m = new Message (xmlString);
		
		
		// Request the lock (this might not succeed).
		//app.getRequestArea().append(m.toString());
		//app.getRequestArea().append("\n");
		app.getServerAccess().sendRequest(m);
	}
}
