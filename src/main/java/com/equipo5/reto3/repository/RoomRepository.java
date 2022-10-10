package com.equipo5.reto3.repository;

import com.equipo5.reto3.entities.Room;
import com.equipo5.reto3.repository.crud.RoomCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepository {

    @Autowired
    private RoomCrudRepository roomCrudRepository;

    public List<Room> getAll() {
        return (List<Room>) roomCrudRepository.findAll();
    }

    //el optional me permite evitar errores si se mandan datos nulos o id que no existen
    public Optional<Room> getRoom(int id) {
        return roomCrudRepository.findById(id);
    }

    public Room save(Room room) {
        return roomCrudRepository.save(room);
    }

    public void delete(Room room) {
        roomCrudRepository.delete(room);
    }

}