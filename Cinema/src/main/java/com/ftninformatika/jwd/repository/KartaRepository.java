package com.ftninformatika.jwd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.model.Karta;

@Repository
public interface KartaRepository extends JpaRepository<Karta, Long>{
	
	Karta findOneById (Long id);
	
	List <Karta> findByProjekcijaId (Long projekcijaId);
	

}
