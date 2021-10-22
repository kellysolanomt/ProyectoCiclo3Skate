package com.usa.ciclo3.ciclo3.web;

import com.usa.ciclo3.ciclo3.model.Score;
import com.usa.ciclo3.ciclo3.model.Skateboard;
import com.usa.ciclo3.ciclo3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getScores(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int id){
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score saveScore(@RequestBody Score score){
        return scoreService.save(score);
    }

    @PutMapping("/update")
    public Score updateScore(@RequestBody Score score){ return scoreService.update(score);}

    @DeleteMapping("/{id}")
    public boolean deleteScore(@PathVariable("id") int scoreId){ return scoreService.deleteSkate(scoreId);}
}
