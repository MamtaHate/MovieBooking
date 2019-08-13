package com.project.movies.pojos;

public class AdminSchedule {

	private Movie movie;
	private Theater theater;
	private Auditorium audi;
	private String showtime;
	
	public AdminSchedule() {
		this.movie = new Movie();
		this.theater = new Theater();
		this.audi = new Auditorium();
			
	}
	
	
	public String getShowtime() {
		return showtime;
	}


	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}


	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public Auditorium getAudi() {
		return audi;
	}
	public void setAudi(Auditorium audi) {
		this.audi = audi;
	}
	
}
