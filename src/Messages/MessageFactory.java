package Messages;

public class MessageFactory {
    private static MessageFactory ins;
    private MessageFactory(){};
    public static MessageFactory getins(){
        if(ins==null){
            return new MessageFactory();
        }
        else{
            return ins;
        }
    }
        public Message getmsgtype(String type){
           if(type=="DailyNewsEmailMessage")
           {
               return new DailyNewsEmailMessage();
           }
           else if(type=="DailyNewsMobileMessage")
           {
               return new DailyNewsMobileMessage();
           }
           else if(type=="GradesAnnouncmentEmailMessage")
           {
               return new GradesAnnouncementEmailMessage();
           }
           else if(type=="GradesAnnouncementMobileMessage")
           {
               return new GradesAnnouncementMobileMessage();
           }
           else if(type=="TaskAddedEmailMessage")
            {
                return new TaskAddedEmailMessage();
            }
           else if(type=="TaskAddedMobileMessage")
           {
               return new TaskAddedMobileMessage();
           }
           return null;

        }
}
