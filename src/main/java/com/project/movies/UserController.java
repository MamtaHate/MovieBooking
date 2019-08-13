package com.project.movies;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movies.DAO.MovieDao;
import com.project.movies.DAO.ScheduleDao;
import com.project.movies.DAO.TheaterDao;
import com.project.movies.DAO.UserDao;
import com.project.movies.pojos.Auditorium;
import com.project.movies.pojos.Booking;
import com.project.movies.pojos.BookingSchedule;
import com.project.movies.pojos.Movie;
import com.project.movies.pojos.Schedule;
import com.project.movies.pojos.Theater;
import com.project.movies.pojos.User;


@Controller
public class UserController {
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ScheduleDao scheduleDao;
	
	@Autowired
	TheaterDao theaterDao;
	
	@RequestMapping(value = "/browseMovies", method = RequestMethod.GET)
	  public String browsePage() {
		return "userHome";
	}
	@RequestMapping(value = "/viewBooking", method = RequestMethod.GET)
	  public String getBookings(HttpServletRequest req ,Model model) {
		HttpSession session=req.getSession();
		String username=(String) session.getAttribute("username");
		List<Booking> booking=scheduleDao.getBooking(username);
		model.addAttribute("booking", booking);
		return "bookingView";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	  public String homePage(@ModelAttribute("movie") Movie movie) {
		return "userHome";
	}
	
	
	@RequestMapping(value = "/bookShow", method = RequestMethod.GET)
	  public String bookPage(HttpSession session,HttpServletRequest req,Model model) {
		
		System.out.println(req.getParameter("movieId")+ " movie id in book page");
		long movieId= Long.parseLong(req.getParameter("movieId"));
		String movieName = req.getParameter("movieName");
		List<Schedule> movies =scheduleDao.getScheduleIds(movieId);
		
		List<Theater> theaterName = new ArrayList<Theater>();
		List<Auditorium> audiName = new ArrayList<Auditorium>();
		List<String> showtime = new ArrayList<String>();
		List<Integer> movieprice = new ArrayList<Integer>();
		
		List<BookingSchedule> schedules = new ArrayList<BookingSchedule>();
		
		Theater theater=null;
		Auditorium audi=null;
		
		for(Schedule m : movies) {
			long audiId =m.getAuditoriumId();
			long theaterId = m.getTheaterId();
			
			showtime.add(m.getShowtime()) ;
			movieprice.add(m.getPrice());
			String showTime = m.getShowtime();
			int price = m.getPrice();
			
			 theater = theaterDao.getTheaterFromId(theaterId);
			 String theatername = theater.getTheaterName();
			 
			 audi = theaterDao.getAudiFromId(audiId);
			 String audiname = audi.getAudiName();
			 int audicap = audi.getAudiCap();

			 BookingSchedule schedule = scheduleDao.addScheduleBooking(theatername,audiname,showTime,price);
			 theaterName.add(theater);
			 audiName.add(audi);
			 schedules.add(schedule);
			 
			System.out.println(theater.getTheaterName() + "theater name ");


		}
		model.addAttribute("schedules", schedules);
		model.addAttribute("theater", theaterName);
		model.addAttribute("audi", audiName);
		model.addAttribute("showtime",showtime);
		model.addAttribute("movieprice",movieprice);
		model.addAttribute("movieId", movieId);
		model.addAttribute("movieName", movieName);
		
		return "bookShow";
	}
	
	@RequestMapping(value = "/browseMovies", method = RequestMethod.POST)
	  public String browseMoviesPage(@ModelAttribute("movie") Movie movie,
			  @RequestParam("searchBy") String search, 
			  HttpSession session,Model model) {
		System.out.println("inside browse movies");
		
		String movies = movie.getMovieName();
		Movie movieObj = null;
		List<Movie> moviesList=null;
		
		if(search.equals("searchByGenre")) {
			System.out.println("genre works");
			moviesList = movieDao.findMovieByGenre(movies);
			model.addAttribute("moviesList", moviesList);
			System.out.println(moviesList.size());
		}else if(search.equals("searchByMovie")) {
			movieObj = movieDao.findMovie(movies);
			System.out.println(movie.getDescription()+"movie object desc");
			//session.setAttribute("movieName",movieObj);
			model.addAttribute("movieOne",movieObj);
		}		
		
		return "userHome";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	  public String bookShow(@ModelAttribute("movie") Movie movie,HttpServletRequest req,
			  HttpSession session,Model model) {
		long movieId= (Long)session.getAttribute("movieId");
		session.setAttribute("movieId", movieId);
		String movieName= req.getParameter("movieName");
		String theaterName = req.getParameter("theaterName");
		String audiName = req.getParameter("audiName");
		String showtime = req.getParameter("showtime");
		
		User userObj = (User)session.getAttribute("user");
		String user = userObj.getName();
		System.out.println(movieName+ "user in book");
		
		System.out.println(theaterName+ audiName+ showtime +movieName);	
		
		int t = userDao.addBooking(theaterName,audiName,showtime,movieName,user);
		
		if(t == 0) {
			 model.addAttribute("Error", "Error Booking! Try Again");
			 return "userHome";
		 }
		
		model.addAttribute("success", "Booking successful!");
		return "errorLogin";
	}
	

	
	
}
