package com.project.movies.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mamta
 */
@Entity
@Table(name = "auditorium")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditoriumId")
    private long auditoriumId;

    @Column(name = "audiName")
    private String audiName;

    @Column(name = "audiCap")
    private Integer audiCap;

    @ManyToOne(cascade = CascadeType.ALL)
    private Theater theater;

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
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

    public void setAuditoriumId(int auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public String getAudiName() {
        return audiName;
    }

    public void setAudiName(String audiName) {
        this.audiName = audiName;
    }

    public void setAuditoriumId(long auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public Integer getAudiCap() {
        return audiCap;
    }

    public void setAudiCap(Integer audiCap) {
        this.audiCap = audiCap;
    }

}
