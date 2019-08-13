package com.project.movies;


import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.movies.DAO.MovieDao;
import com.project.movies.DAO.ScheduleDao;
import com.project.movies.DAO.TheaterDao;
import com.project.movies.pojos.Auditorium;
import com.project.movies.pojos.Movie;
import com.project.movies.pojos.Schedule;
import com.project.movies.pojos.Theater;

@Controller
public class AdminController {

	@Autowired
	TheaterDao theaterDao;
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ScheduleDao scheduleDao;
	
	@RequestMapping(value = "/addTheaterPage", method = RequestMethod.GET)
	  public String addTheaterPage(@ModelAttribute("theater") Theater theater,
			  @ModelAttribute("audi") Auditorium auditorium
			  ) {
		
		return "addTheater";
	}
	
	
	@RequestMapping(value = "/removeMovieAssigned", method = RequestMethod.GET)
	  public String removeMovieAssigned(Model model) {
		
		List<Schedule> schedule = scheduleDao.getIds();
		
		String movieName="";
		for(Schedule s : schedule) {
			long movieId = s.getMovieId();
			Movie movie = movieDao.findMovieById(movieId);
			movieName = movie.getMovieName();
			
		}
		
		model.addAttribute("movieName", movieName);
		model.addAttribute("schedule", schedule);
		
		return "removeMovieAssigned";
	}
	
	@RequestMapping(value = "/updateMoviePage", method = RequestMethod.GET)
	  public String updateMoviePage(Model model) {

		List<Movie> movies = movieDao.getMovies();
		model.addAttribute("movies", movies);
		
		return "updateMovie";
	}
	
	
	
	@RequestMapping(value = "/addMoviePage", method = RequestMethod.GET)
	  public String addMoviePage(@ModelAttribute("movie") Movie movie) {
		
		return "addMovie";
	}
	
	@RequestMapping(value = "/addAudiPage", method = RequestMethod.GET)
	  public String addAudiPage(@ModelAttribute("auditorium") Auditorium auditorium) {
		System.out.println("trye");
		return "addAudi";
	}
	
	@RequestMapping(value = "/assignMovie", method = RequestMethod.GET)
	  public String assignMovie(
			Model model) {

		System.out.println("in assign");
		List<Movie> movieList = movieDao.getMovies();
		model.addAttribute("movieList",movieList);
		
		List<Theater> theaterList = theaterDao.getTheater();
		model.addAttribute("theaterList",theaterList);
			
		return "assignMovie";
	}
	
	@RequestMapping(value = "/assignMovie", method = RequestMethod.POST)
	  public String assignAudi(
			  HttpSession session,Model model) {
			long theaterId =(Long) session.getAttribute("theaterId");
			
			String movie =(String) session.getAttribute("movie");
			String theater =(String) session.getAttribute("theater");
			
			session.setAttribute("selectedMovie", movie);
			session.setAttribute("selectedTheater", theater);
			
			List<Movie> movieList = movieDao.getMovies();
			session.setAttribute("movieList",movieList);
			
			List<Theater> theaterList = theaterDao.getTheater();
			session.setAttribute("theaterList",theaterList);
			
		List<Auditorium> audiList = theaterDao.getAuditorium(theaterId);
		for(Auditorium a : audiList) {
			System.out.println(a + " audi value");
		}
		session.setAttribute("audiList",audiList);
		
		return "assignMovie1";
	}
	
	@RequestMapping(value = "/assignAudi", method = RequestMethod.GET)
	  public String assignMovie1(
			  HttpSession session,Model model) {
		List<Auditorium> audiList =(List<Auditorium>) session.getAttribute("audiList");
		
		for(Auditorium a : audiList) {
			System.out.println(a + " audi value in assign movie1");
		}
		
		session.setAttribute("audiList",audiList);
		return "assignMovie1";
	}
	
	/**
	 * @param theater
	 * @param auditorium
	 * @param session
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/addTheater", method = RequestMethod.POST)
	  public String addTheaterDetails(@ModelAttribute("theater") Theater theater,@ModelAttribute("auditorium") Auditorium auditorium,
			  
			  HttpSession session,
			  Model model) {
		
		
		String theaterName = theater.getTheaterName();
		int NumOfAudi = theater.getNumOfAudi();
		String location = theater.getLocation();
		
		int t = theaterDao.addTheater(theaterName,NumOfAudi,location);
		
		if(t == 0) {
			 model.addAttribute("Error", "Error Inserting Theater Entry! Try Again");
			 return "addTheater";
		 }
		 session.setAttribute("AddedTheater", theater);
		 
		 Theater t_id = theaterDao.getTheaterName(theaterName);

		 model.addAttribute("theaterid", t_id.getTheaterId() );
		 model.addAttribute("NumOfAudi", NumOfAudi);
		 
		 System.out.println("hello");
			 return "addAudi";
			 
	}
	
	
	
	@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
	  public String addMovie(@ModelAttribute("movie") Movie movie, Model model,
			  HttpSession session, @RequestParam("fileUpload") MultipartFile file,
			  HttpServletRequest request) {
		
		String movieName = movie.getMovieName();
		String desc = movie.getDescription();
		String genre = movie.getGenre();
		int m=0;
		File file1;
		try {
			file1 = multipartToFile(file);
			String fileName = file1.getAbsolutePath();
			
			m = movieDao.addMovie(movieName,desc,genre,fileName);
			
			
			if(m == 0) {
				 model.addAttribute("loginError", "Error Inserting Movie Entry! Try Again");
				 return "addMovie";
			 }
			 session.setAttribute("AddedTheater", m);
			 
			return "adminHome";
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	    File convFile = new File( multipart.getOriginalFilename());
	    multipart.transferTo(convFile);
	    return convFile;
	}
	
	
	@RequestMapping(value = "/addAudi", method = RequestMethod.POST)
	  public String addAuditoriumDetails(
			  HttpServletRequest request,
			  HttpSession session,
			  Model model) {
		int t=0;
		System.out.println("hello now");		
//		Theater theater = (Theater)session.getAttribute("theater");
//		System.out.println(theater.getTheaterName());
		
		int n = Integer.parseInt(session.getAttribute("NumOfAudi").toString());
		System.out.println("number of audi  " + n);
		Set<Auditorium> audi = new HashSet<Auditorium>();
		long theaterId = (Long) session.getAttribute("theaterid");
		System.out.println(theaterId + "  theaterid");
		
		String[] audiVal=request.getParameterValues("audiName");
		String[] audicap=request.getParameterValues("audiCap");
		
//		for(String a:audiVal) {
//			//String audiName = request.getParameter("audiName");
//			System.out.println(a);
//			Auditorium au = new Auditorium();
//			au.setAudiName(a);
//			au.setTheaterId(theaterId);
//
//			System.out.println(au.getAudiName());
//			audi.add(au);
//			
//		}
//		for(String cap: audicap ) {
//			au.setAudiCap(Integer.parseInt(cap));;
//		}
		for(int i =0 ; i<audiVal.length; i++) {
			Auditorium au = new Auditorium();
			au.setAudiName(audiVal[i]);
			au.setTheaterId(theaterId);
			au.setAudiCap(Integer.parseInt(audicap[i]));
			audi.add(au);
		}
		
		for (Auditorium au:audi)
		{
			 t = theaterDao.addAuditorium(au);
		}
	
		
		if(t == 0) {
			 model.addAttribute("loginError", "Error Inserting Theater Entry! Try Again");
			 return "addTheater";
		 }
		 session.setAttribute("AddedTheater", t);
			 return "adminHome";
			 
	}
	
	@RequestMapping(value = "/assignAudi", method = RequestMethod.POST)
	  public String assignMovies(
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("in assignMovie");

		String movie = request.getParameter("movie");
		String theater = request.getParameter("theater");
		String audi = request.getParameter("audi");
		String showtime = request.getParameter("showtime");	
		int price = Integer.parseInt(request.getParameter("price"));
		
		Movie movieObj = movieDao.findMovie(movie);
		long movieid = movieObj.getMovieId();
		System.out.println(movieid + " movieid");
		
		Theater theaterObj = theaterDao.findTheater(theater);
		long theaterid = theaterObj.getTheaterId();
		System.out.println(theaterid + " theaterid");
		
		Auditorium audiObj = theaterDao.findAudi(audi);
		long audiid = audiObj.getAuditoriumId();
		System.out.println(audiid + " audiid");
		
		
		int t = scheduleDao.addSchedule(movieid,theaterid,audiid,showtime,price);
		
		if(t == 0) {
			 model.addAttribute("loginError", "Error Inserting Entry! Try Again");
			 return "addTheater";
		 }
		 session.setAttribute("AddedTheater", theater);
		 
		 System.out.println("movie assigned");
			 
		 
		return "adminHome";
	}
	
	@RequestMapping(value = "/updateMovie", method = RequestMethod.GET)
	  public String updateMovies(Model model, HttpServletRequest request) {
		System.out.println("in update movie");
		
		Long movieId = Long.parseLong(request.getParameter("movieId"));
		System.out.println(movieId);
		
		Movie movie = movieDao.findMovieById(movieId);
		model.addAttribute("movie",movie);
				
		return "movieUpdateForm";
	}
	
	@RequestMapping(value = "/updateMovie", method = RequestMethod.POST)
	  public String updateMovie(Model model, HttpServletRequest request,
			  HttpSession session) {
		System.out.println("in update movie");
		
		Long movieId = Long.parseLong(session.getAttribute("movieId").toString());
		System.out.println(movieId);
		
		String movieName = request.getParameter("movieName");
		String genre = request.getParameter("genre");
		String description = request.getParameter("description");
				
		int t = movieDao.updateMovie(movieId, movieName, genre, description);		
		if(t == 0) {
			 model.addAttribute("Error", "Error Inserting Entry! Try Again");
			 return "movieUpdateForm";
		 }
		 
		 System.out.println("movie updated");	 
				
		return "adminHome";
	}
	
	@RequestMapping(value = "/removeMovieId", method = RequestMethod.GET)
	  public String removeMoviesAssigned(Model model, HttpServletRequest request,
			  HttpSession session) {
		System.out.println("int removeMovieid");
		
		Long scheduleId = Long.parseLong(request.getParameter("scheduleId"));
		System.out.println(scheduleId);
		
		int t = scheduleDao.deleteMovie(scheduleId);
		
		if(t == 0) {
			 model.addAttribute("Error", "Error Inserting Entry! Try Again");
			 return "removeMovieAssigned";
		 }
		 
		 System.out.println("movie updated");	
		 
		
		return "adminHome";
	}
	
	
}
;