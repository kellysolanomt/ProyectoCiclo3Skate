package com.usa.ciclo3.ciclo3.service;

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

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> messageEjemplo=messageRepository.getMessage(message.getIdMessage());
            if(!messageEjemplo.isEmpty()){
                if(message.getMessageText()!=null){
                    messageEjemplo.get().setMessageText(message.getMessageText());
                }
                if(message.getClient()!=null){
                    messageEjemplo.get().setClient(message.getClient());
                }
                if(message.getSkate()!=null){
                    messageEjemplo.get().setSkate(message.getSkate());
                }
                messageRepository.save(messageEjemplo.get());
                return messageEjemplo.get();
            }
            else{
                return message;
            }
        }
        else{
            return message;
        }
    }

    public boolean deleteMessage(int id){
        Boolean aBoolean = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
