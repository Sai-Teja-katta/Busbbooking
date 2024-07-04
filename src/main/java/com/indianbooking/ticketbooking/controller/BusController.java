package com.indianbooking.ticketbooking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.indianbooking.ticketbooking.Service.BusService;

@Controller
public class BusController {
	@Autowired
	private BusService busService;
	
}
