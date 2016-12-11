package client.controller;

import client.model.Player;
import client.view.Application;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.Message;
import client.model.Model;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT. This will never be returned to a client
 * to tell him that HE has the model locked (that is job of LockResponse).
 *
 * @author Zijun Xu
 */
public class BoardResponseController extends ControllerChain{

	public Application app;
	public Model model;
	
	public BoardResponseController(Application a, Model m) {
		this.app = a;
		this.model = m;
	}

	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("boardResponse")) {
			return next.process(response);
		}
        model.setIsExistedGame(true);
		// this refers to the outer node of the Message DOM (in this case, updateResponse).
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();

		String gameId = map.getNamedItem("gameId").getNodeValue();
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		String bonus = map.getNamedItem("bonus").getNodeValue();

		int[] bonusGlobalPosition = extractPosition(bonus);
        this.model.getGame().clearPlayers();

        NodeList list = boardResponse.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname = n.getAttributes().getNamedItem("name").getNodeValue();
            String pposition = n.getAttributes().getNamedItem("position").getNodeValue();
			String pboard = n.getAttributes().getNamedItem("board").getNodeValue();
			Long pscore = Long.valueOf(n.getAttributes().getNamedItem("score").getNodeValue());
            int[] globalPosition = extractPosition(pposition);

            if (pname.equals(this.model.getGame().getMyName())){
                this.model.getBoard().setGlobalPosition(globalPosition);
                this.model.getGame().setScore(pscore);
                int[] bonusPosition;
                bonusPosition = new int[2];
                bonusPosition[0] = bonusGlobalPosition[0] - globalPosition[0];
                bonusPosition[1] = bonusGlobalPosition[1] - globalPosition[1];
                model.getBoard().setBoard(pboard);

                if(bonusPosition[0] < 4 && bonusPosition[0] > -1 &&
                        bonusPosition[1] < 4 && bonusPosition[1] > -1){
                    this.model.getBoard().cells[bonusPosition[0]][bonusPosition[1]].setBonus();
                }
            }else {
                Player a = new Player();
                if(pname.equals(managingUser)){
                    a.setAsManagingUser();
                }
                a.setName(pname);
                a.setScore(pscore);
                a.setGlobalPosition(globalPosition);
                model.getGame().addPlayers(a);
            }
		}
		model.setSharedCells();
        model.getGame().setManagingUser(managingUser);
        model.getGame().setRoomID(gameId);
        if (model.getBoard().getCouldRefresh()){
            PaintCellController refreshBoard = new PaintCellController(model);
            refreshBoard.repaint();
            app.getPlayingPanel().setManagingUser(managingUser, model.getGame().getMyName().equals(managingUser));
            app.getPlayingPanel().setGameId(gameId);
        }

        System.out.println(response.toString());
		return true;
	}

	public int[] extractPosition(String xmlPosition){

        Pattern p = Pattern.compile("\\d+");
        Matcher m =p.matcher(xmlPosition);
        int position[] = new int[2];
        int j = 0;
        while (m.find()){
            position[j] = Integer.parseInt(m.group());
            j +=1;
        }
	    return position;
    }
}
