package com.equipo5.reto3.controllers;

import com.equipo5.reto3.entities.Score;
import com.equipo5.reto3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    //  /api/Score/all para traerlos todos
    @GetMapping("/all")
    public List<Score> getAll() {
        return scoreService.getAll();
    }

// para traerlos por id
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int id){
        return scoreService.getScore(id);
    }

    //el post la ruta es /api/Score/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save (@RequestBody Score score) {
        return scoreService.save(score);
    }
    
    //el put  la ruta es /api/Score/update
    @PutMapping("/update")
    public Score update (@RequestBody Score score) {
        return scoreService.update(score);
    }

}
