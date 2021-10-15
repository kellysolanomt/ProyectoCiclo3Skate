package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationCrudRepository extends JpaRepository<Reservation, Integer> {
}
