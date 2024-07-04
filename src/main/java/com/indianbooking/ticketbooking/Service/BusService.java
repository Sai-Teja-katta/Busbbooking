package com.indianbooking.ticketbooking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.indianbooking.ticketbooking.Entity.BusEntity.BusDetails;

public interface BusService {
	public Optional<BusDetails> getBusdetails(int id);
	public List<BusDetails>  getAllBuses();
	public List<BusDetails> getAvaliableBuses(String pick,String destination);
}
