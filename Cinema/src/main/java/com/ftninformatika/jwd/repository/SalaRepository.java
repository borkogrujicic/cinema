package com.ftninformatika.jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{
	
	Sala findOneById (Long id);
	

}
