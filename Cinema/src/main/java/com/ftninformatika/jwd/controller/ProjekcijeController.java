package com.ftninformatika.jwd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.model.Projekcija;
import com.ftninformatika.jwd.service.ProjekcijaService;
import com.ftninformatika.jwd.support.ProjekcijaDtoToProjekcija;
import com.ftninformatika.jwd.support.ProjekcijaToProjekcijaDto;
import com.ftninformatika.jwd.web.dto.ProjekcijaDTO;

@RestController
@RequestMapping(value = "/api/projekcije", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ProjekcijeController {
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private ProjekcijaToProjekcijaDto toDto;
	
	@Autowired
	private ProjekcijaDtoToProjekcija toProjekcija;
	
	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjekcijaDTO> create(@Valid @RequestBody ProjekcijaDTO projekcijaDTO){
    	projekcijaDTO.setId(null);
        Projekcija projekcija = toProjekcija.convert(projekcijaDTO);

        if(projekcija.getFilm() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }        
        Projekcija sacuvanaProjekcija = projekcijaService.save(projekcija);

        return new ResponseEntity<>(toDto.convert(sacuvanaProjekcija), HttpStatus.CREATED);
    }
    
    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjekcijaDTO> update(@PathVariable Long id, @Valid @RequestBody ProjekcijaDTO projekcijaDTO){

        if(!id.equals(projekcijaDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Projekcija projekcija = toProjekcija.convert(projekcijaDTO);

        if(projekcija.getFilm() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Projekcija sacuvanaProjekcija = projekcijaService.update(projekcija);

        return new ResponseEntity<>(toDto.convert(sacuvanaProjekcija),HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Projekcija obrisanaProjekcija = projekcijaService.delete(id);

        if(obrisanaProjekcija != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProjekcijaDTO> getOne(@PathVariable Long id){
        Projekcija projekcija = projekcijaService.findOne(id);

        if(projekcija != null) {
            return new ResponseEntity<>(toDto.convert(projekcija), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<ProjekcijaDTO>> getAll(
    		@RequestParam (value = "pageNo", defaultValue = "0") int pageNo){

        Page <Projekcija> projekcije = projekcijaService.findAll(pageNo);

//        if(datumIVremeOdParametar != null && datumIVremeDoParametar != null) {
//        	
//            LocalDateTime datumIVremeOd =  getLocalDateTime(datumIVremeOdParametar);
//            LocalDateTime datumIVremeDo =  getLocalDateTime(datumIVremeDoParametar);
//
//            projekcije = projekcijaService.find(datumIVremeOd,datumIVremeDo,filmId,tip,sala,cenaKarteOd,cenaKarteDo);
//        }
//        else{
//            projekcije = projekcijaService.findAll();
//        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(projekcije.getTotalPages()));

        return new ResponseEntity<>(toDto.convert(projekcije.getContent()), headers, HttpStatus.OK);
    }

//    private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
//        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
//        return LocalDateTime.of(datum, vreme);
//    }

}
