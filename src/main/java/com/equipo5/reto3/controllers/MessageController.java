package com.equipo5.reto3.controllers;

import com.equipo5.reto3.entities.Message;
import com.equipo5.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //  /api/Message/all para traerlos todos
    @GetMapping("/all")
    public List<Message> getAll() {
        return messageService.getAll();
    }

// para traerlos por id
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }

    //el post la ruta es /api/Message/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save (@RequestBody Message message) {
        return messageService.save(message);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save1 (@RequestBody Message message) {
        return messageService.save(message);
    }
    
    //el put  la ruta es /api/Message/update
    @PutMapping("/update")
    public Message update (@RequestBody Message message) {
        return messageService.update(message);
    }

}
