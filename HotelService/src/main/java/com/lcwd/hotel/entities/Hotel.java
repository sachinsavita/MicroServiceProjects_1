package com.lcwd.hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="micro_hotels")
@Data
public class Hotel {
	
	@Id
	@Column(name="ID")
	private String hotelId;
	
	@Column(name="NAME", length = 20)
	private String name;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="ABOUT")
	private String about;

}
