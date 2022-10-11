package com.equipo5.reto3.controllers;

import com.equipo5.reto3.entities.Client;
import com.equipo5.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //  /api/Client/all para traerlos todos
    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }

// para traerlos por id
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){
        return clientService.getClient(id);
    }

    //el post la ruta es /api/Client/save
    @PostMapping("/save")
    public Client save (@RequestBody Client client) {
        return clientService.save(client);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save1 (@RequestBody Client client) {
        return clientService.save(client);
    }

    //el put  la ruta es /api/Client/update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update (@RequestBody Client client) {
        return clientService.update(client);
    }

}
