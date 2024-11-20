package com.upiiz.superheroes.services;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.repositories.HeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

    // GET DE TODOS
    public List<HeroeEntity> getAllHeroes(){
        return heroeRepository.findAll();
    }
    // GET DE UNO
    public HeroeEntity getHeroesById(Long id){
        return heroeRepository.findById(id).orElse(null);
    }
    // POST DE UNO
    public HeroeEntity createHeroe(HeroeEntity heroe){
        return heroeRepository.save(heroe);
    }
    // PUT DE HEROE
    public HeroeEntity updateHeroe(HeroeEntity heroe){
        return heroeRepository.save(heroe);
    }
    // DELETE DE HEROE
    public void deleteHeroe(Long id){
        heroeRepository.deleteById(id);
    }
}
