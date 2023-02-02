package com.digitazon.nuovo_football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.nuovo_football.model.Pitch;
import com.digitazon.nuovo_football.service.PitchService;

@CrossOrigin // IMPORTANT: to join back-end and front-end
@RestController
@RequestMapping("/pitch")
public class PitchController {
    
    @Autowired
    PitchService pitchService;

    @GetMapping("/all")
    public ResponseEntity<List<Pitch>> getAll(){ //ResponseEntity è la risposta che si apre nella pagina web
        return new ResponseEntity<>(pitchService.findAll(), HttpStatus.OK);
    } 

    @PostMapping("/create")
    public ResponseEntity<Pitch> createPitch(@RequestBody Pitch pitch){
        return new ResponseEntity<>(pitchService.savePitch(pitch), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePitch(@RequestParam Long id){
        pitchService.deletePitch(id);
        return new ResponseEntity<>("Pitch deleted", HttpStatus.OK);
    }

}
