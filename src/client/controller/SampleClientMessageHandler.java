package client.controller;
import xml.Message;
import client_src.IMessageHandler;
import client.view.GameModePanel;

/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 * 
 * Note: This one does nothing more than dump the XML message into the client window. Nothing that special.
 */
public class SampleClientMessageHandler implements IMessageHandler {

	GameModePanel app;
	
	// by default is the empty handler...
	ControllerChain chain = new EmptyHandler();
	
	/**
	 * Register new controller chain as occuring before existing chain.
	 */
	public void registerHandler(ControllerChain handler) {
		handler.next = chain;
		chain = handler;
	}
	
	public SampleClientMessageHandler(GameModePanel app) {
		this.app = app;
	}
	
	
	@Override
	public void process(Message response) {
		chain.process(response);
	}

}
