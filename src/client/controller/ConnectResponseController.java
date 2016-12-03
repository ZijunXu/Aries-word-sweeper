package client.controller;

import client.model.Model;
import client.view.GameModePanel;
import xml.Message;

public class ConnectResponseController extends ControllerChain {
	public GameModePanel app;
	public Model model;

	public ConnectResponseController(GameModePanel a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}

	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("connectResponse")) {
			return next.process(response);
		}

		app.getResponseArea().append(response.toString() + "\n");
		return true;
	}

}
