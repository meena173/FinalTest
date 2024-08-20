package com.example.demo;
import jakarta.persistence.*;


public class Guest
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	private String name;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="checkin-id")
	
	private CheckIn checkin;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CheckIn getCheckin() {
		return checkin;
	}

	public void setCheckin(CheckIn checkin) {
		this.checkin = checkin;
	}

	public void setGuest(Guest ge) {
		// TODO Auto-generated method stub
		
	}
	
	

}
