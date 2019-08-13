/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.movies.DAO;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.movies.pojos.Booking;
import com.project.movies.pojos.User;

public class UserDao extends DAO{
    

    public User authenticateLogin(String username, String password) {
        User loggedInUser = null;
        try {
            begin();
            Query q= getSession().createQuery("from User where username= :username AND password= :password");
            q.setString("username", username);
            q.setString("password", password);
            loggedInUser = (User)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } 
        finally {
            close();
        }
        return loggedInUser;
    }

//    public List<Login> getUsers(String searchString) {
//        List<Login> matchedUsers = new ArrayList<Login>() ;
//        try {
//            beginTransaction();
//            Query q= getSession().createQuery("from Login where username= :username");
//            q.setString("username", searchString);
//            matchedUsers = q.list();
//            commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            rollbackTransaction();
//        } 
//        finally {
//            close();
//        }
//        return matchedUsers;
//    }

    public int addUser(String name, String username, String password) {
        User newUser = null;
        int registerSuccess = 0;
        try {
            begin();
            
            newUser = new User();
            newUser.setName(name);
            newUser.setUsername(username);
            newUser.setPassword(password);
            getSession().save(newUser);
            commit();
            registerSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } 
        finally {
            close();
        }

        return registerSuccess;

    }
    
    public int addBooking(String theaterName,String audiName,String showtime,
    		String movieName,String user) {
    	
        Booking newUser = null;
        int registerSuccess = 0;
        try {
            begin();
            
            newUser = new Booking();
            newUser.setTheaterName(theaterName);
            newUser.setAudiName(audiName);
            newUser.setShowtime(showtime);
            newUser.setMovieName(movieName);
            newUser.setUser(user);
//            newUser.setUserId(user);
            getSession().save(newUser);
            commit();
            registerSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } 
        finally {
            close();
        }

        return registerSuccess;

    }
    
}
