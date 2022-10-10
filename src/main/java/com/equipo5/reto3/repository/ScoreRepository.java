package com.equipo5.reto3.repository;

import com.equipo5.reto3.entities.Score;
import com.equipo5.reto3.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    //el optional me permite evitar errores si se mandan datos nulos o id que no existen
    public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score) {
        return scoreCrudRepository.save(score);
    }

    public void delete(Score score) {
        scoreCrudRepository.delete(score);
    }

}
