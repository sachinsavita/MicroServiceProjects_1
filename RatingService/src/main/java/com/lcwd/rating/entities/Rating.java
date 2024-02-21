package com.lcwd.rating.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	@Id
	@Column(name="RATING_ID")
	private String ratingId;
	@Column(name="USER_ID")
	private String userId;
	@Column(name="HOTEL_ID")
	private String hotelId;
	@Column(name="RATING")
	private int rating;
	@Column(name="FEEDBACK")
	private String feedback;
	@Transient
	private Hotel hotel;

}
