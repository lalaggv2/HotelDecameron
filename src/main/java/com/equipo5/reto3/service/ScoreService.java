package com.equipo5.reto3.service;

import com.equipo5.reto3.entities.Score;
import com.equipo5.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save (Score score) {
        if(score.getIdScore()==null) {
            return scoreRepository.save(score);
        } else {
            Optional <Score> scoreFound = getScore(score.getIdScore());
            if(scoreFound.isEmpty()) {
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }

    public Score update(Score score) {
        if(score.getIdScore() != null) {
            Optional<Score> scoreFound = getScore(score.getIdScore());
            if (!scoreFound.isEmpty()) {
                if (score.getMessageText() != null){
                    scoreFound.get().setMessageText(score.getMessageText());
                }
                if (score.getPoints() != null) {
                    scoreFound.get().setPoints(score.getPoints());
                }
                return scoreRepository.save(scoreFound.get());
            }
        }
        return score;
    }

    public boolean delete(int idScore) {
        Boolean response = getScore(idScore).map(element -> {
            scoreRepository.delete(element);
            return true;
        }).orElse(false);
        return response;
    }

}


