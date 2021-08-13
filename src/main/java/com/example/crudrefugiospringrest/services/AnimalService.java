package com.example.crudrefugiospringrest.services;

import com.example.crudrefugiospringrest.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import com.example.crudrefugiospringrest.repositories.AnimalRepository;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimales() {
        return animalRepository.findAll();
    }

    public List<Animal> findByNameContain(String name) {
        return animalRepository.findDistinctByNombreContaining(name);
    }

    public List<Animal> findByColor(String color) {
        return animalRepository.findDistinctByColor(color);
    }

    public Animal findById(Integer id) {
        return animalRepository.findByIdanimal(id);
    }

    public List<Animal> findByEdadBetween(Integer edadMin, Integer edadMax) {
        return animalRepository.findByEdadBetween(edadMin, edadMax);
    }

    public void deleteById(Integer idanimal) {
        animalRepository.deleteById(idanimal);
    }

    public void save(Animal animal) {
        animalRepository.save(animal);
    }
}