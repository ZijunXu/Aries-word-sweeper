package com.wpi.client_src;

import com.wpi.xml.Message;

public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(Message response);
}