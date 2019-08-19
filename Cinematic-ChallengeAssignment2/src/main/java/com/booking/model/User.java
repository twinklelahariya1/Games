package com.booking.model;


import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable {

    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @JsonView
    private Long id;

    @Column(name = "username")
    @JsonView
    private String username;

    @Column(name = "password")
    @JsonView
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonView
    private List<Seat> seatsList;


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Seat> getSeatsList() {
		return seatsList;
	}

	public void setSeatsList(List<Seat> seatsList) {
		this.seatsList = seatsList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", seatsList=" + seatsList
				+ "]";
	}


}
