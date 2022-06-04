package Messages;

public class GradesAnnouncementEmailMessage implements Message {
	@Override
	public String prepareMessage(String placeHolders[]) {
		// code to replace place holders of this type
		return "";
	}
	
	public boolean verifyGrades() {
		// code to verify Grades before announcement
		
		return true;
	}
}
