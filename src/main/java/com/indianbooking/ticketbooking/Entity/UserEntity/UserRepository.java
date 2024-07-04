package com.indianbooking.ticketbooking.Entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indianbooking.ticketbooking.Entity.UserEntity.UserDetails;


@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

}
