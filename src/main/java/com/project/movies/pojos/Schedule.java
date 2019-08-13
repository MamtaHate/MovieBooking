package com.project.movies.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {

	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "scheduleId")
	private long scheduleId;
	
	@Column(name = "movieId")
	private long movieId;
	
	@Column(name = "theaterId")
	private long theaterId;
	
	@Column(name = "auditoriumId")
	private long auditoriumId;
	
	@Column(name = "showtime")
	private String showtime;
	
	@Column(name = "price")
	private Integer price;
	
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Schedule() {
		
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public long getAuditoriumId() {
		return auditoriumId;
	}

	public void setAuditoriumId(long auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	
}
