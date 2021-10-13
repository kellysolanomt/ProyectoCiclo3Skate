package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.repository.MessageRepository;
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
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }
        else{
            Optional<Message> messageAux=messageRepository.getMessage(message.getIdMessage());
            if(messageAux.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
}
