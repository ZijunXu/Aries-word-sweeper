package client.controller;


import xml.Message;
import client.model.Model;
import client.view.GameModePanel;

public class CreateGameController {

	GameModePanel app;
	Model model;

	public CreateGameController(GameModePanel app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<createGameRequest name='samplePlayer'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
	}
}
