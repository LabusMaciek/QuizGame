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
			// create a student object
			System.out.println("Creating new student object...");
			Question newQuestion = new Question(null, null, null, null, null);
		
			// start a transaction
			session.beginTransaction();
			
			// save the student object
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
			
			//retrieve student based on the id: primary key
			System.out.println("Getting student with id: "+questionId);
		
			Question myQuestion = session.get(Question.class, questionId);
			
			System.out.println("Get complete: "+myQuestion);
			System.out.println("Updating question");
			myQuestion.setContentQuestion("Jaka srednice ma najwiekszy krater na Merkurym?");
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
			
			//retrieve student based on the id: primary key
			System.out.println("Getting student with id: "+questionId);
		
			Question myQuestion = session.get(Question.class, questionId);
			
			System.out.println("Get complete: "+myQuestion);
			System.out.println("Deleting the student");
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
