package client.controller;
import client.view.Application;
import xml.Message;
import client_src.IMessageHandler;

/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 * 
 * Note: This one does nothing more than dump the XML message into the client window. Nothing that special.
 */
public class SampleClientMessageHandler implements IMessageHandler {

	Application app;

	// by default is the empty handler...
	ControllerChain chain = new EmptyHandler();

	/**
	 * Register new controller chain as occuring before existing chain.
	 */
	public void registerHandler(ControllerChain handler) {
		handler.next = chain;
		chain = handler;
	}

	public SampleClientMessageHandler(Application app) {
		this.app = app;
	}

	/** use chain repository */
	@Override
	public void process(Message response) {
		chain.process(response);
	}
//	public SampleClientMessageHandler(Application app) {
//		this.app = app;
//	}
//
//	@Override
//	public void process(Message response) {
//		String type = response.contents.getFirstChild().getLocalName();
//
//		// process each response that comes in with its own controller.
//		if (type.equals ("boardResponse")) {
//			// What happens now that we are connected?
//			new BoardResponseController(app, app.model).process(response);
//		} else if (type.equals ("connectResponse")) {
//			//app.getResponseArea().append(response.toString() + "\n");
//		}
//
//		// only here to show messages as they are received by the client
//		// this isn't needed.
//		System.out.println(response);
//	}
}
