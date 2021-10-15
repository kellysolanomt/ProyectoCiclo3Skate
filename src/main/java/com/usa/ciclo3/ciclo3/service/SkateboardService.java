package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Skateboard;
import com.usa.ciclo3.ciclo3.repository.SkateboardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SkateboardService {

    @Autowired
    private SkateboardRepository skateboardRepository;

    public List<Skateboard> getAll(){
        return skateboardRepository.getAll();
    }
    public Optional<Skateboard> getSkateboard(int id){
        return skateboardRepository.getSkateboard(id);
    }
    
    public Skateboard save(Skateboard skateboard){
        if(skateboard.getId()==null){
            return skateboardRepository.save(skateboard);
        }
        else{
            Optional<Skateboard> skateAux=skateboardRepository.getSkateboard(skateboard.getId());
            if(skateAux.isEmpty()){
                return skateboardRepository.save(skateboard);
            }else{
                return skateboard;
            }
        }
    }
}
