package com.wpi.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.wpi.xml.Message;
import com.wpi.models.Model;
import com.wpi.layout.HomeLayout;

/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT. This will never be returned to a client
 * to tell him that HE has the model locked (that is job of LockResponse).
 */
public class BoardResponseController {

	public HomeLayout app;
	public Model model;
	
	public BoardResponseController(HomeLayout a, Model m) {
		this.app = a;
		this.model = m;
	}
	
	public void process(Message response) {
		// this refers to the outer node of the Message DOM (in this case, updateResponse).
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		NodeList list = boardResponse.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname = n.getAttributes().getNamedItem("name").getNodeValue();
		}
	}

}
