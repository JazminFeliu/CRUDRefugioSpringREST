package com.example.crudrefugiospringrest.repositories;

import com.example.crudrefugiospringrest.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findDistinctByNombreContaining(String nombre);

    List<Animal> findDistinctByColor(String color);

    Animal findByIdanimal(Integer id);

    List<Animal>findByEdadBetween(Integer edadMin, Integer edadMax);

}
