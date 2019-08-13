package com.project.movies.pojos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mamta
 */

@Entity
@Table(name="theater")
public class Theater {
    @Id   
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "theaterId")
    private long theaterId;
    
    @Column(name = "theaterName" )
    private String theaterName;
    
    @Column(name = "location" )
    private String location;
    
    @Column(name = "NumOfAudi" )
    private int NumOfAudi;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="theaterId")
    private Set<Auditorium> auditorium;

    public Theater(){
    	this.auditorium = new HashSet<Auditorium>(); 
    }	

	public Set<Auditorium> getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Set<Auditorium> auditorium) {
		this.auditorium = auditorium;
	}



	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }
   

    public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumOfAudi() {
        return NumOfAudi;
    }

    public void setNumOfAudi(int NumOfAudi) {
        this.NumOfAudi = NumOfAudi;
    }
    
    
}
