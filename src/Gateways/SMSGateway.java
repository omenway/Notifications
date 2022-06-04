package Gateways;

import Messages.DailyNewsMobileMessage;
import Messages.GradesAnnouncementMobileMessage;
import Messages.Message;
import Messages.TaskAddedMobileMessage;

public class SMSGateway implements Gateway {
	@Override
	public void sendMessage(Message message, String user) {
		String[] placeHolders = new String[] {}; // set some place holders here 
		message.prepareMessage(placeHolders);
		//some code to send message
//		if(message instanceof DailyNewsMobileMessage) {
//			DailyNewsMobileMessage msg = (DailyNewsMobileMessage) message;
//
//			msg.prepareMessage(placeHolders);
//
//			// some code to send message
//		}
//
//		else if(message instanceof GradesAnnouncementMobileMessage) {
//			GradesAnnouncementMobileMessage msg = (GradesAnnouncementMobileMessage) message;
//
//			msg.prepareMessage(placeHolders);
//
//			// some code to send message
//		}
//
//		else if(message instanceof TaskAddedMobileMessage) {
//			TaskAddedMobileMessage msg = (TaskAddedMobileMessage) message;
//
//			msg.prepareMessage(placeHolders);
//
//			// some code to send message to user
//		}
		
	}
}
