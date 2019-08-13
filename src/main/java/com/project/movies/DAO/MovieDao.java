package com.project.movies.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.query.Query;

import com.project.movies.pojos.Movie;

public class MovieDao extends DAO {

	public int addMovie(String movieName,String desc,String genre,String fileName) {
        Movie movie = null;
        int success = 0;
        
        try {
            begin();
           
            movie = new Movie();
            movie.setMovieName(movieName);
            movie.setDescription(desc);
            movie.setGenre(genre);
            movie.setFileName(fileName);
            
            getSession().save(movie);
           
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
	
	public List<Movie> getMovies() {
		List<Movie> result=null;
		try {
			begin();
			Query q = getSession().createQuery("from Movie");
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
	
	
	public Movie findMovie(String movie)
	{ 
		Movie result=null;
		 try {
	        begin();       
	        Criteria criteria = getSession().createCriteria(Movie.class);
	        criteria.add(Restrictions.like("movieName", movie, MatchMode.ANYWHERE));

	      	result= (Movie)criteria.uniqueResult();
	      	System.out.println(result.getFileName() + " filename in dao");
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
	
	public List<Movie> findMovieByGenre(String search)
	{ 
		List<Movie> result=null;
		 try {
	        begin();       
	        Criteria criteria = getSession().createCriteria(Movie.class);
	        criteria.add(Restrictions.like("genre", search, MatchMode.ANYWHERE));
//	      	LogicalExpression orExp = Restrictions.or(c1,c2);
	        
	        result= criteria.list();
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
	
	public Movie findMovieById(long movieId)
	{ 
		Movie result=null;
		 try {
	              
	        
		 begin();
			Query q = getSession().createQuery("from Movie where movieId=:movieId");
			q.setParameter("movieId", movieId);
			result = (Movie) q.uniqueResult();
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
	
	public int updateMovie(long movieId,String movieName,String genre,String description)
	{ 
		int result=0;
		 try {
	              
	        
		 begin();
			Query q = getSession().createQuery("update Movie set movieName=:movieName,"
					+ "genre=:genre, description=:description where movieId=:movieId");
			q.setParameter("movieId", movieId);
			q.setParameter("movieName", movieName);
			q.setParameter("genre", genre);
			q.setParameter("description", description);
			
			result = q.executeUpdate();
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
