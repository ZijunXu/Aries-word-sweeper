package client.controller;


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
        if(this.model.getGame().getPassword() == null){
            xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s'/></request>",
                    this.model.getGame().getRoomID(),
                    this.model.getGame().getMyName());

        }else{
            xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s password='%s'/></request>",
                    this.model.getGame().getRoomID(),
                    this.model.getGame().getMyName(), this.model.getGame().getPassword());
        }

		Message m = new Message (xmlString);
		//app.getRequestArea().append(m.toString());
		//app.getRequestArea().append("\n");
		app.getServerAccess().sendRequest(m);
	}
}
