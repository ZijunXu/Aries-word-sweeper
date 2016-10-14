import client.view.GameModePanel;
import client_src.ServerAccess;
import client.controller.SampleClientMessageHandler;
import client.model.Model;
import xml.Message;

public class ClientLauncher {
	// If requested by ClientLauncher (pass in '-server' as argument).
	public static final String serverHost = "72.249.186.243";
	
	/**
	 * Note that to simplify the coding of this command-client, it declares that it can throw an Exception,
	 * which is typically the failed connection to a server.
	 */
	public static void main(String[] args) throws Exception {
		// FIRST thing to do is register the protocol being used. There will be a single class protocol
		// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
		if (!Message.configure("wordsweeper.xsd")) {
			System.exit(0);
		}
		
		// select dedicated server with '-server' options
		String host = "localhost";
		if (args.length > 0 && args[0].equals("-server")) {
			host = serverHost;
		}
		
		// Initialize the client application and its corresponding model
		Model model = new Model();
		GameModePanel app = new GameModePanel(model);

		// try to connect to the server. Once connected, messages are going to be processed by 
		// SampleClientMessageHandler. For now we just continue on with the initialization because
		// no message is actually sent by the connect method.
		ServerAccess sa = new ServerAccess(host, 11425);
		if (!sa.connect(new SampleClientMessageHandler(app))) {
			System.out.println("Unable to connect to server (" + host + "). Exiting.");
			System.exit(0);
		}
		System.out.println("Connected to " + host);
		
		
		// Should we on the client ever need to communicate with the server, we need this ServerAccess
		// object.
		app.setServerAccess(sa);
		
		// send an introductory connect request now that we have created (but not made visible!)
		// the GUI
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message (xmlString);
		sa.sendRequest(m);
		
		// at this point, we need to make app visible, otherwise we would terminate application
		app.setVisible(true);
	}
}
