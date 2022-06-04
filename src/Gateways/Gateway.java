package Gateways;

import Messages.Message;

public interface Gateway {
    public void sendMessage(Message message, String user);
}
