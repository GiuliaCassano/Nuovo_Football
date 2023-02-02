package com.digitazon.nuovo_football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.nuovo_football.model.Pitch;
import com.digitazon.nuovo_football.repository.PitchRepository;

@Service
public class PitchService {
    @Autowired
    PitchRepository pitchRepository;

    public List<Pitch> findAll(){
        return pitchRepository.findAll();
    }

    public Pitch savePitch(Pitch pitch){
        return pitchRepository.save(pitch);
    }

    public void deletePitch(Long id){
        pitchRepository.deleteById(id);
    }
}
