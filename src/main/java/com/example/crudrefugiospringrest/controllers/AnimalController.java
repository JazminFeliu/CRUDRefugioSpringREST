package com.example.crudrefugiospringrest.controllers;

import com.example.crudrefugiospringrest.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.crudrefugiospringrest.services.AnimalService;

import java.util.List;

@RestController
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("animales")
    public List<Animal> getAnimales(){
        return animalService.getAnimales();
    }

    @GetMapping("animales/nombre/{name}")
    public List<Animal>findByNameContain(@PathVariable String name){
        return animalService.findByNameContain(name);
    }

    @GetMapping("animales/id/{id}")
        public Animal findbyId(@PathVariable Integer id){
            return animalService.findById(id);
        }

    @GetMapping("animales/color/{color}")
    public List<Animal>findByColor(@PathVariable String color){
        return animalService.findByColor(color);
    }

    @GetMapping("animales/edad/{edadMin}/{edadMax}")
    public List<Animal>findByEdadBetween(@PathVariable  Integer edadMin, @PathVariable Integer edadMax){
        return animalService.findByEdadBetween(edadMin, edadMax);
    }

    @PostMapping("animales/nuevo")
    public Animal crear(@RequestBody Animal animal) {
        animalService.save(animal);
        return animal;
    }

    @DeleteMapping("animales/borrar/{idanimal}")
    public String borrar(@PathVariable Integer idanimal) {
        animalService.deleteById(idanimal);
        return "animal borrado";
    }

    @PostMapping("animales/guardar")
    public String guardar(@RequestBody Animal animal){
        animalService.save(animal);
        return "animal Guardado";
    }

}
