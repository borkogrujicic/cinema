package com.ftninformatika.jwd.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.model.Film;
import com.ftninformatika.jwd.service.FilmService;
import com.ftninformatika.jwd.support.FilmDtoToFilm;
import com.ftninformatika.jwd.support.FilmToFilmDto;
import com.ftninformatika.jwd.web.dto.FilmDTO;

@RestController
@RequestMapping(value = "/api/filmovi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class FilmoviController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private FilmToFilmDto toDto;
	
	@Autowired
	private FilmDtoToFilm toFilm;
	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> create(@Valid @RequestBody FilmDTO filmDTO){
        Film film = toFilm.convert(filmDTO);
        Film sacuvanFilm = filmService.save(film);

        return new ResponseEntity<>(toDto.convert(sacuvanFilm), HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @Valid @RequestBody FilmDTO filmDTO){

        if(!id.equals(filmDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Film film = toFilm.convert(filmDTO);
        Film sacuvanFilm = filmService.update(film);

        return new ResponseEntity<>(toDto.convert(sacuvanFilm),HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Film obrisanFilm = filmService.delete(id);

        if(obrisanFilm != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getOne(@PathVariable Long id){
       Film film = filmService.findOne(id);

        if(film != null) {
            return new ResponseEntity<>(toDto.convert(film), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAll(){

    	Iterable <Film> filmoviIt = filmService.findAllMovies();
    	List<Film> filmovi = 
    			  StreamSupport.stream(filmoviIt.spliterator(), false)
    			    .collect(Collectors.toList());

//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toDto.convert(filmovi), HttpStatus.OK);
    }


}
