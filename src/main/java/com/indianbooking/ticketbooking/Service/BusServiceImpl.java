package com.indianbooking.ticketbooking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indianbooking.ticketbooking.Entity.BusEntity.BusDetails;
import com.indianbooking.ticketbooking.Entity.BusEntity.BusRepository;

@Service
public  class BusServiceImpl implements BusService {
@Autowired
private BusRepository busRepository;

@Override
public Optional<BusDetails> getBusdetails(int id) {
      
	return busRepository.findById(id);
}

@Override
public List<BusDetails> getAllBuses() {
	return busRepository.findAll();
}

@Override
public List<BusDetails> getAvaliableBuses(String pick, String destination) {
	return busRepository.findAvaliableBuses(pick, destination);
}
}
