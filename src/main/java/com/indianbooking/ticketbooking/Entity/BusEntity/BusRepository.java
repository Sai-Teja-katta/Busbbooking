package com.indianbooking.ticketbooking.Entity.BusEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indianbooking.ticketbooking.Entity.BusEntity.BusDetails;
@Repository
public interface BusRepository extends JpaRepository<BusDetails, Integer> {
	@Query("select e from BusDetails e where e.pickUp =:pick and e.destination=:destination ")
	List<BusDetails> findAvaliableBuses(@Param("pick") String name,@Param("destination") String destiantion);
}
