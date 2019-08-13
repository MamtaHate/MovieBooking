package com.project.movies.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.project.movies.pojos.Auditorium;
import com.project.movies.pojos.Booking;
import com.project.movies.pojos.BookingSchedule;
import com.project.movies.pojos.Movie;
import com.project.movies.pojos.Schedule;
import com.project.movies.pojos.Theater;

public class ScheduleDao extends DAO{
	
	public int addSchedule(long movieid,long theaterid, long audiid, String showtime,
			int price){
		 Schedule schedule = null;
	        int success = 0;
	        
	        try {
	            begin();           
	            schedule = new Schedule();          
	            schedule.setMovieId(movieid);
	            schedule.setTheaterId(theaterid);
	            schedule.setAuditoriumId(audiid);
	            schedule.setShowtime(showtime);
	            schedule.setPrice(price);
//	            System.out.println("showtime in addschedule" + showtime);
	            getSession().save(schedule);
	           
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
	
	 public List<Schedule> getIds() {
		 List<Schedule> schedule = new ArrayList<Schedule>() ;
       try {
           begin();
           Query q= getSession().createQuery("from Schedule");
           
//           q.setString("username", searchString);
           schedule = q.list();
           
           commit();
       } catch (HibernateException e) {
           e.printStackTrace();
           rollback();
       } 
       finally {
           close();
       }
       return schedule;
   }
	 
	 public List<Booking> getBooking(String user){
		 List<Booking> booking = new ArrayList<Booking>() ;
       try {
           begin();
           Query q= getSession().createQuery("from Booking where user=:user");
           
         q.setParameter("user", user);
         booking = q.list();
           
           commit();
       } catch (HibernateException e) {
           e.printStackTrace();
           rollback();
       } 
       finally {
           close();
       }
       return booking;
   }
	
	
	 public List<Schedule> getScheduleIds(long movieId) {
		 List<Schedule> schedule = new ArrayList<Schedule>() ;
       try {
           begin();
           Query q= getSession().createQuery("from Schedule where movieId=:movieId");
           
           q.setParameter("movieId", movieId);
           schedule = q.list();
           
           commit();
       } catch (HibernateException e) {
           e.printStackTrace();
           rollback();
       } 
       finally {
           close();
       }
       return schedule;
	 }
	
	 
	 public BookingSchedule addScheduleBooking(String theatername,String audiname, String showtime,
			 int price){
		 BookingSchedule schedule = null;
	        int success = 0;
	        
	        try {
	            begin();           
	            schedule = new BookingSchedule();          
	            schedule.setTheaterName(theatername);
	            schedule.setAudiName(audiname);
	            schedule.setShowtime(showtime);
	            schedule.setPrice(price);
	            
	            getSession().save(schedule);            
	           
	            commit();
	            success = 1;        
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	        } 
	        finally {
	            close();
	        }
	       return schedule;
    
}
	 
	 public int deleteMovie(long scheduleId) {
		 int result=0;
       try {
           begin();
           Query q= getSession().createQuery("delete from Schedule where scheduleId=:scheduleId");
           
           q.setParameter("scheduleId", scheduleId);
           result=q.executeUpdate();
           
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
