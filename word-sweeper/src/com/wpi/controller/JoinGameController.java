package com.wpi.controller;


import com.wpi.xml.Message;
import com.wpi.models.Model;
import com.wpi.layout.HomeLayout;

public class JoinGameController {

	HomeLayout app;
	Model model;

	public JoinGameController(HomeLayout app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<joinGameRequest gameId='somePlace' name='nextOne'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
	}
}
