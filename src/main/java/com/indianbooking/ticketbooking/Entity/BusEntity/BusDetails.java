package com.indianbooking.ticketbooking.Entity.BusEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="bus_info")
@Data
public class BusDetails {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="pick_up")
	private String pickUp;
	@Column(name="destination")
	private String destination;
	@Column (name="bus_no")
	private String busNo;
	@Column(name="no_of_seats_avaliable")
	private int noOfSeatsAvaliable;
	@Column(name="no_of_seats_booked")
	private int noOfSeatsBooked;
	@Column(name="owner_name")
	private String ownerName;
}
