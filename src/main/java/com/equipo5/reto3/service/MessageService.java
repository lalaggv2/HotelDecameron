package com.equipo5.reto3.service;

import com.equipo5.reto3.entities.Message;
import com.equipo5.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save (Message message) {
        if(message.getIdMessage()==null) {
            return messageRepository.save(message);
        } else {
            Optional <Message> messageFound = getMessage(message.getIdMessage());
            if(messageFound.isEmpty()) {
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message) {
        if(message.getIdMessage() != null) {
            Optional<Message> messageFound = getMessage(message.getIdMessage());
            if (!messageFound.isEmpty()) {
                if (message.getMessageText() != null){
                    messageFound.get().setMessageText(message.getMessageText());
                }
                return messageRepository.save(messageFound.get());
            }
        }
        return message;
    }

    public boolean delete(int id) {
        Boolean response = getMessage(id).map(element -> {
            messageRepository.delete(element);
            return true;
        }).orElse(false);
        return response;
    }

}

