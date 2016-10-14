package client_src;

import xml.Message;

public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(Message response);
}