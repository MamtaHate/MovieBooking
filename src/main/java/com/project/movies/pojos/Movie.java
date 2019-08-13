package com.project.movies.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
*
* @author mamta
*/
@Entity
@Table(name="movie")
public class Movie {
	
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "movieId")
    private long movieId;
	
	@Column(name = "movieName")
    private String movieName;
   
	@Column(name = "description")
	private String description;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "fileName")
	private String fileName;
	
//	@Column(name = "price")
//	private int price;
//	
//	@Column(name = "showtime")
//	private String showtime;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Auditorium auditorium;	
//
//   public Auditorium getAuditorium() {
//		return auditorium;
//	}

	

public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


		public long getMovieId() {
		return movieId;
	}

		public void setMovieId(long movieId) {
			this.movieId = movieId;
		}
	
	public String getMovieName() {
	       return movieName;
	   }

   public void setMovieName(String movieName) {
       this.movieName = movieName;
   }

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

   
   
}

