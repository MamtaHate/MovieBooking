package com.project.movies.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.project.movies.pojos.Auditorium;
import com.project.movies.pojos.Movie;
import com.project.movies.pojos.Theater;
import com.project.movies.pojos.User;

public class TheaterDao extends DAO {

	public int addTheater(String theaterName,int NumOfAudi,String location) {
        Theater theater = null;
        int success = 0;
        
        try {
            begin();
           
            theater = new Theater();
            theater.setTheaterName(theaterName);
            theater.setNumOfAudi(NumOfAudi);
            theater.setLocation(location);
            getSession().save(theater);
           
            commit();
            success = 1;        
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } 
        finally {
            close();
        }
       return success;

    }
	
	public int addAuditorium(Auditorium theater) {
//        Auditorium audi = null;
        int success = 0;
        
        try {
            begin();
//            for(Auditorium t: theater.getAuditorium()) {
//            	System.out.println(t.getTheater().getTheaterId());
//            }   
            getSession().save(theater);
           
            commit();
            success = 1;        
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } 
        finally {
            close();
        }
       return success;

    }
	
	
	public List<Theater> getTheater() {
		List<Theater> result=null;
		try {
			begin();
			Query q = getSession().createQuery("from Theater");
			result = q.list();
			commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
            rollback();
        } 
        finally {
            close();
        }
		return result;
	}
	
	public Theater getTheaterName(String theaterName)
	{ 
		Theater result=null;
		 try {
	        begin();       
	        Query query = getSession().createQuery("from Theater where theaterName=:theaterName");
	      	query.setParameter("theaterName", theaterName);
	      	result= (Theater)query.list().get(0);
	            commit();       
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	        } 
	        finally {
	            close();
	        }
		 return result;
	  
	}
	
	
	public List<Auditorium> getAuditorium(long theaterId) {
		List<Auditorium> result=null;
		try {
			begin();
			Query q = getSession().createQuery("from Auditorium where theaterId=:theaterId");
			q.setParameter("theaterId", theaterId);
			result = q.list();
			commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
            rollback();
        } 
        finally {
            close();
        }
		return result;
	}
	
	public Auditorium findAudi(String audi)
	{ 
		Auditorium result=null;
		 try {
	        begin();       
	        Query query = getSession().createQuery("from Auditorium where audiName=:audiName");
	      	query.setParameter("audiName", audi);
	      	result= (Auditorium)query.list().get(0);
	            commit();       
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	        } 
	        finally {
	            close();
	        }
		 return result;
	  
	}
	
	public Theater findTheater(String theater)
	{ 
		Theater result=null;
		 try {
	        begin();       
	        Query query = getSession().createQuery("from Theater where theaterName=:theaterName");
	      	query.setParameter("theaterName", theater);
	      	System.out.println(theater + " theater name");
	      	System.out.println(query.list().size());
	      	result= (Theater)query.list().get(0);
	            commit();       
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	        } 
	        finally {
	            close();
	        }
		 return result;
	  
	}
	
	public Theater getTheaterFromId(long theater)
	{ 
		Theater result=null;
		 try {
	        begin();       
	        Query query = getSession().createQuery("from Theater where theaterId=:theater");
	      	query.setParameter("theater", theater);
	      	System.out.println(theater + " theater");
//	      	System.out.println(query.list().size());
	      	result= (Theater)query.list().get(0);
	            commit();       
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	        } 
	        finally {
	            close();
	        }
		 return result;
	  
	}
	
	public Auditorium getAudiFromId(long audi)
	{ 
		Auditorium result=null;
		 try {
	        begin();       
	        Query query = getSession().createQuery("from Auditorium where auditoriumId=:audi");
	      	query.setParameter("audi", audi);
	      	System.out.println(audi + " audi");
//	      	System.out.println(query.list().size());
	      	result= (Auditorium)query.list().get(0);
	            commit();       
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	        } 
	        finally {
	            close();
	        }
		 return result;
	  
	}
	
	
	
	
	
	
}
