package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageCrudRepository extends JpaRepository<Message, Integer> {
}
