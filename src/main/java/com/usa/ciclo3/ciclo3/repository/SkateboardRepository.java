package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Skateboard;
import com.usa.ciclo3.ciclo3.repository.crud.SkateboardCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SkateboardRepository {

    @Autowired
    private SkateboardCrudRepository skateboardCrudRepository;
    public List<Skateboard> getAll(){
        return (List<Skateboard>) skateboardCrudRepository.findAll();

    }

    public Optional<Skateboard> getSkateboard(int id){
        return skateboardCrudRepository.findById(id);
    }

    public Skateboard save(Skateboard skate){
        return skateboardCrudRepository.save(skate);
    }
}
