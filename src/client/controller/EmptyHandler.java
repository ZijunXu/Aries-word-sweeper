package client.controller;

import xml.Message;
/**
 * 
 * responsible for handling error for Chain Repository
 *
 */
public final class EmptyHandler extends ControllerChain{

    @Override
    public boolean process(Message response){
        System.err.println("Not Handled:" + response);
        return true;
    }
}
