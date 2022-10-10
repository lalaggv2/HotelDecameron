package com.equipo5.reto3.service;

import com.equipo5.reto3.entities.Client;
import com.equipo5.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save (Client client) {
        if(client.getIdClient()==null) {
            return clientRepository.save(client);
        } else {
            Optional <Client> clientFound = getClient(client.getIdClient());
            if(clientFound.isEmpty()) {
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client) {
        if(client.getIdClient() != null) {
            Optional<Client> clientFound = getClient(client.getIdClient());
            if (!clientFound.isEmpty()) {
                if (client.getName() != null){
                clientFound.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                clientFound.get().setAge(client.getAge());
                 }
                if(client.getPassword()!=null) {
                clientFound.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clientFound.get());
            }
        }
        return client;
    }
@ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(int id) {
        Boolean response = getClient(id).map(element -> {
            clientRepository.delete(element);
            return true;
        }).orElse(false);
        return response;
        }

}

