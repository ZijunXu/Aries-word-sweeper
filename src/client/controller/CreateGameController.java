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
		String xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'/></request>",
				this.model.getGame().getMyName());
		Message m = new Message (xmlString);
//		app.getRequestArea().append(m.toString());
//		app.getRequestArea().append("\n");
        System.out.println(m.toString());
		app.getServerAccess().sendRequest(m);
	}
}
