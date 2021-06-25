package com.ftninformatika.jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.model.Film;

@Repository
public interface FilmRepository extends JpaRepository <Film, Long>{
	
	Film findOneById (Long id);

}
