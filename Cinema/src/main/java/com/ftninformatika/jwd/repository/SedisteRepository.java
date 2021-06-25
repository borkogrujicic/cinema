package com.ftninformatika.jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.model.Sediste;

@Repository
public interface SedisteRepository extends JpaRepository<Sediste, Integer>{
	
	Sediste findOneById (int id);
	

}
