package com.equipo5.reto3.controllers;

import com.equipo5.reto3.entities.Room;
import com.equipo5.reto3.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    //  /api/Room/all para traerlos todos
    @GetMapping("/all")
    public List<Room> getAll() {
        return roomService.getAll();
    }

    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int id) {
        return roomService.getRoom(id);
    }

    //el post la ruta es /api/Room/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room room) {
        return roomService.save(room);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save1(@RequestBody Room room) {
        return roomService.save(room);
    }

    //el put  la ruta es /api/Room/update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room room) {
        return roomService.update(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return roomService.delete(id);
    }
}