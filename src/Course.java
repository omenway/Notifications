import java.util.ArrayList;
import Gateways.EmailGateway;
import Gateways.Gateway;
import Gateways.GatewayFactory;
import Messages.Message;
import Messages.MessageFactory;
import Messages.TaskAddedEmailMessage;
import Users.Observer;
import Users.Professor;
import Users.Student;
import Users.TA;

public class Course {

	String name;
	String code;
	ArrayList<String> announcements;
	ArrayList<String> exams;
	ArrayList<String> grades;

	//ArrayList<Professor> professorsForEmailNotification;
	//ArrayList<Professor> professorsForSMSNotification;

	//ArrayList<TA> TAsForEmailNotification;
	//ArrayList<TA> TAsForSMSNotification;

	//ArrayList<Student> studentsForEmailNotification;
	//ArrayList<Student> studentsForSMSNotification;
	ArrayList<Observer> observersforemailnotifications;
	ArrayList<Observer> observersforSMSnotifications;

	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;

		announcements = new ArrayList<String>();
		exams = new ArrayList<String>();
		grades = new ArrayList<String>();

		//professorsForEmailNotification = new ArrayList<Professor>();
		//professorsForSMSNotification = new ArrayList<Professor>();

		//TAsForEmailNotification = new ArrayList<TA>();
		//TAsForSMSNotification = new ArrayList<TA>();

		//studentsForEmailNotification = new ArrayList<Student>();
		//studentsForSMSNotification = new ArrayList<Student>();
		observersforemailnotifications=new ArrayList<Observer>();
		observersforSMSnotifications=new ArrayList<Observer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	//	public void subscribeProfessorForEmailNotification(Professor professor) {
//		professorsForEmailNotification.add(professor);
//	}
//
//	public void subscribeProfessorForSMSNotification(Professor professor) {
//		professorsForSMSNotification.add(professor);
//	}
//
//	public void subscribeTAForEmailNotification(TA ta) {
//		TAsForEmailNotification.add(ta);
//	}
//
//	public void subscribeTAForSMSNotification(TA ta) {
//		TAsForSMSNotification.add(ta);
//	}
//
//	public void subscribeStudentForEmailNotification(Student student) {
//		studentsForEmailNotification.add(student);
//	}
//
//	public void subscribeStudentForSMSNotification(Student student) {
//		studentsForSMSNotification.add(student);
//	}
	public void subscribeProfessorForEmailNotification(Observer observer) {
		observersforemailnotifications.add(observer);
	}

	public void subscribeProfessorForSMSNotification(Observer observer) {
		observersforSMSnotifications.add(observer);
	}



	public void AddAssignment(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] {assignName, assignBody};
		// do some logic here

		notifyAllUsers(placeholders);
	}

	// AddExam, PostGrades, PostAnnouncement  will be the same

	private void notifyAllUsers(String[] placeholders) {
		// notify users by email
		MessageFactory fac = MessageFactory.getins();
		Message msg = fac.getmsgtype("TaskAddedEmailMessage");
		String notification = msg.prepareMessage(placeholders);

		// open connection for Email gateway and do some configurations to the object
		GatewayFactory fact = GatewayFactory.getins();
		Gateway emailgateway= fact.getGatewaytype("Email");
		//EmailGateway emailGateway = new EmailGateway();


//		for (Professor professor : professorsForEmailNotification) {
//			professor.notifyProfessor(notification);
//			emailGateway.sendMessage(notification, professor.getEmail());
//		}
//
//		for (TA ta : TAsForEmailNotification) {
//			ta.notifyTA(notification);
//			emailGateway.sendMessage(notification, ta.getEmail());
//		}
//
//		for (Student student : studentsForSMSNotification) {
//			student.notifyStudent(notification);
//			emailGateway.sendMessage(notification, student.getEmail());
//		}
		for (Observer observer : observersforemailnotifications) {
			observer.notifyall(notification);
			emailgateway.sendMessage(msg, observer.getEmail());
		}

	}
}