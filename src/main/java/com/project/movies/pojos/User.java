package com.project.movies.pojos;

import javax.persistence.*;  
import java.util.Set; 

/**
 *
 * @author mamta
 */
@Entity
@Table(name="user")
public class User {
    
    @Id   
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//   	        name = "seatBooking",
//   	        joinColumns = @JoinColumn(
//   	                name = "userId",
//   	                referencedColumnName = "userId"
//   	        ),
//   	        inverseJoinColumns = @JoinColumn(
//   	                name = "seatId",
//   	                referencedColumnName = "seatId"
//   	        )
//   	) 
//    private Set<Seat> seat;
    
    

    public long getUserId() {
        return userId;
    }

   
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
	
