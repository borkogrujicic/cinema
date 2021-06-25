package com.ftninformatika.jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.model.Tip;

@Repository
public interface TipRepository extends JpaRepository<Tip, Long>{
	
	Tip findOneById (Long id);

}
