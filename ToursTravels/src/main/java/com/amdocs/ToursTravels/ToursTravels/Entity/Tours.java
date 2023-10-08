package com.amdocs.ToursTravels.ToursTravels.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="tours")
@Table(name="tours")
@SequenceGenerator(name="MySequence", sequenceName="tour_sequence",initialValue=50, allocationSize=1)

public class Tours {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence")
	@Column(name="tour_id")
	private int tourId;
	
	@Column(name="tour_name")
	private String tourName;
	
	@Column(name="tour_type")
	private String tourType;
	
	@Column(name="tour_departure")
	private String tourDeparture;
	
	@Column(name="tour_arrival")
	private String tourArrival;
	
	@Column(name="tour_price")
	private String tourPrice;
	
	public Tours() {
		
	}

	public Tours(int tourId, String tourName, String tourType, String tourDeparture, String tourArrival,
			String tourPrice) {
		super();
		this.tourId = tourId;
		this.tourName = tourName;
		this.tourType = tourType;
		this.tourDeparture = tourDeparture;
		this.tourArrival = tourArrival;
		this.tourPrice = tourPrice;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getTourType() {
		return tourType;
	}

	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	public String getTourDeparture() {
		return tourDeparture;
	}

	public void setTourDeparture(String tourDeparture) {
		this.tourDeparture = tourDeparture;
	}

	public String getTourArrival() {
		return tourArrival;
	}

	public void setTourArrival(String tourArrival) {
		this.tourArrival = tourArrival;
	}

	public String getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(String tourPrice) {
		this.tourPrice = tourPrice;
	}
	
}
