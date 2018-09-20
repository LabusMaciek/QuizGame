package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class crudData {

	// create session factory	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Question.class).buildSessionFactory();
	
	// create session
	Session session = factory.getCurrentSession();	
	
	
	public void createQuestion() {
		
		try {
			// create a question object
			System.out.println("Creating new question object...");
			Question newQuestion = new Question(null, null, null, null, null);
		
			// start a transaction
			session.beginTransaction();
			
			// save the question object
			System.out.println("Saving new question...");
			session.save(newQuestion);
		
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			}
		finally {
			factory.close();
		}
	}
	
	public void readQuestion(int questionId) {
		
		try {						
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();		
			
			//retrieve question based on the id: primary key
			System.out.println("\nGetting question with id: "+questionId);
			
			Question myQuestion = session.get(Question.class, questionId);
			
			System.out.println("Get complete: "+ myQuestion);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			}
		finally {
			factory.close();
		}
		
	}
	
	public void updateQuestion(int questionId) {
		
		try {		
			// start a transaction
			session.beginTransaction();
			
			//retrieve quesition based on the id: primary key
			System.out.println("Getting question with id: "+questionId);
		
			Question myQuestion = session.get(Question.class, questionId);
			
			System.out.println("Get complete: "+myQuestion);
			System.out.println("Updating question");
			myQuestion.setContentQuestion(null);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			}
		finally {
			factory.close();
		}
	}
	
	public void deleteQuestion(int questionId) {
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//retrieve question based on the id: primary key
			System.out.println("Getting student with id: "+questionId);
		
			Question myQuestion = session.get(Question.class, questionId);
			
			System.out.println("Get complete: "+myQuestion);
			System.out.println("Deleting the question");
			session.delete(myQuestion);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");		
			}
		finally {
			factory.close();
		}
		
	}
	
}
