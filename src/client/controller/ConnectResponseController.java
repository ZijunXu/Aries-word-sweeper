package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

/**
 * 
 * Connect Response after receiving the corresponding message from server
 * 
 */
public class ConnectResponseController extends ControllerChain {
	public Application app;
	public Model model;

	public ConnectResponseController(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}

	/**
	 * included in Chain Repository
	 */
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("connectResponse")) {
			return next.process(response);
		}
		return true;
	}
}
