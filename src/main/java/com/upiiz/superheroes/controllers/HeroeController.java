package com.upiiz.superheroes.controllers;


import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.services.HeroeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/heroes")
public class HeroeController {
    @Autowired
    private HeroeService heroeService;
    // GET TODOS
    @GetMapping
    public ResponseEntity<List<HeroeEntity>> getHeroes(){
        return ResponseEntity.ok(heroeService.getAllHeroes());
    }
    // GET ID
    @GetMapping("/{id}")
    public ResponseEntity<HeroeEntity> getHeroeById(@RequestParam Long id){
        return ResponseEntity.ok(heroeService.getHeroesById(id));
    }
    // POST
    @PostMapping
    public ResponseEntity<HeroeEntity> createHeroe(@RequestBody HeroeEntity heroe, @RequestParam Long id){
        return ResponseEntity.ok(heroeService.createHeroe(heroe));
    }
    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<HeroeEntity> updateHeroe(@RequestBody HeroeEntity heroe, @RequestParam Long id){
        heroe.setId(id);
        return ResponseEntity.ok(heroeService.updateHeroe(heroe));
    }

    // DELETE
    @DeleteMapping
    public ResponseEntity<HeroeEntity> deleteHeroe(@PathVariable Long id){
        heroeService.deleteHeroe(id);
        return ResponseEntity.noContent().build();
    }
}
