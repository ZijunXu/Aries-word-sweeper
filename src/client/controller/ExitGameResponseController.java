package client.controller;


import client.model.Model;
import client.view.Application;
import xml.Message;

public class ExitGameResponseController extends ControllerChain{
    protected Application app;
    protected Model model;

    public ExitGameResponseController(Application a, Model m){
        super();
        this.app = a;
        this.model = m;
    }
    public boolean process(Message response){
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals("exitGameResponse")) {
            return next.process(response);
        }

        return true;
    }

}
