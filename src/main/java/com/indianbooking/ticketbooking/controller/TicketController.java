package com.indianbooking.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.indianbooking.ticketbooking.Entity.BusEntity.BusDetails;
import com.indianbooking.ticketbooking.Service.BusService;

@Controller

public class TicketController {
	@Autowired
	private BusService busService;

	@GetMapping("/userinfo")
	public String getUserdetails(Model model) {
		return "homepage";
	}

	@GetMapping("/availablebuses")
	public String showBusAvaliable(Model model, @RequestParam("pickup") String pickup,
			@RequestParam("destination") String destination) {
		List<BusDetails> ob = busService.getAvaliableBuses(pickup, destination);
		model.addAttribute("busdetails", ob);
		return "buseslist";
	}
}
