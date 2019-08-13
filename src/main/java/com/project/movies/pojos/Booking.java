package com.project.movies.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="booking")
public class Booking {

	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "bookingId")
	private long bookingId;
	
	@Column(name = "theaterName")
	private String theaterName;
	
	@Column(name = "showtime")
	private String showtime;
	
	@Column(name = "audiName")
	private String audiName;
	
	@Column(name = "movieName")
	private String movieName;
	
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "price")
	private Integer price;
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public String getAudiName() {
		return audiName;
	}
	public void setAudiName(String audiName) {
		this.audiName = audiName;
	}
	
	
}
