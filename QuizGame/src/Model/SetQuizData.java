package Model;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SetQuizData {

	List<Question> theQuestions = Arrays.asList();
	
	private static int Status;

	public SetQuizData() {
	
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Question.class).buildSessionFactory();
						
		// create session
		Session session = factory.getCurrentSession();	

			try {
								
				// start a transaction
				session.beginTransaction();
						
				//query students
				theQuestions = session.createQuery("from Question").getResultList();
															
				// commit transaction
				session.getTransaction().commit();
				System.out.println("Done!");
				}
			finally {
	
				factory.close();
				}		
	}
	
				
	public List<Question> getTheQuestions() {
		return theQuestions;
	}

	public void setTheQuestions(List<Question> theQuestions) {
		this.theQuestions = theQuestions;
	}
	
	
	public static int getStatus() {
		return Status;
	}


	public static void setStatus(int status) {
		Status = status;
	}

	

	public  void displayQuestions() {
		
		System.out.println("Below questions taken from database: ");
		for (int i=0; i<theQuestions.size();i++) {
			System.out.println(theQuestions.get(i));
			}
		}

	
}
