package com.indianbooking.ticketbooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indianbooking.ticketbooking.Entity.UserEntity.UserDetails;
import com.indianbooking.ticketbooking.Entity.UserEntity.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
public UserRepository userRepository;
@Autowired
public UserDetailsServiceImpl (UserRepository userRepository) {
	this.userRepository=userRepository;
}
@Override
public UserDetails save(UserDetails userDetails) {
	
	return userRepository.save(userDetails);
}

}
