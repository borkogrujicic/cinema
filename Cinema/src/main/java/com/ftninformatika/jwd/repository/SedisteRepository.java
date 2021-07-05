package com.ftninformatika.jwd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.model.Sediste;

@Repository
public interface SedisteRepository extends JpaRepository<Sediste, Integer>{
	
	Sediste findOneById (Long id);
	List <Sediste> findBySalaId (Long id);
	

}
