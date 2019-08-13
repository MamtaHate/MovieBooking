package com.project.movies.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="bookingSchedule")
public class BookingSchedule {

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
	
	@Column(name = "price")
	private Integer price;
	

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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
