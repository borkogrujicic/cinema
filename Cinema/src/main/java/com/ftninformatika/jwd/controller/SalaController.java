package com.ftninformatika.jwd.controller;

import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.model.Sala;
import com.ftninformatika.jwd.model.Sediste;
import com.ftninformatika.jwd.model.Tip;
import com.ftninformatika.jwd.service.SalaService;
import com.ftninformatika.jwd.service.SedisteService;
import com.ftninformatika.jwd.support.SalaToSalaDto;
import com.ftninformatika.jwd.support.SedisteToSedisteDto;
import com.ftninformatika.jwd.web.dto.SalaDTO;
import com.ftninformatika.jwd.web.dto.SedisteDTO;
import com.ftninformatika.jwd.web.dto.TipDTO;

@RestController
@RequestMapping(value = "/api/sale", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SalaToSalaDto toDto;
	
	@Autowired
	private SedisteService sedisteService;
	
	@Autowired
	private SedisteToSedisteDto toSedisteDto;
	
    @GetMapping("/{id}")
    public ResponseEntity<List<SedisteDTO>> findBySalaId(@PathVariable @Positive(message = "Id must be positive.")  Long id){
        List<Sediste> projekcije = sedisteService.findBySala(id);

        return new ResponseEntity<>(toSedisteDto.convert(projekcije), HttpStatus.OK);
    }
    
	@GetMapping
    public ResponseEntity<List<SalaDTO>> getAll(){

	        List <Sala> sale = salaService.findAll();

	        return new ResponseEntity<>(toDto.convert(sale), HttpStatus.OK);
	    }

}
