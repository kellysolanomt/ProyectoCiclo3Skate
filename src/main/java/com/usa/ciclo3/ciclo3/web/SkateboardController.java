package com.usa.ciclo3.ciclo3.web;

import com.usa.ciclo3.ciclo3.model.Skateboard;
import com.usa.ciclo3.ciclo3.service.SkateboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SkateboardController {

    @Autowired
    private SkateboardService skateboardService;

    @GetMapping("/all")
    public List<Skateboard> getSkateboards(){
        return skateboardService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Skateboard> getSkateboard(@PathVariable("id") int id){
        return skateboardService.getSkateboard(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skateboard saveSkateboard(@RequestBody Skateboard skate){
        return skateboardService.save(skate);
    }
}
