package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.model.Skateboard;
import com.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Reto 4: el equipo desarrollará los servicios de backend para realizar edición y borrado de las entidades, ahora, los
 * servicios que serán implementados son los servicios PUT y DELETE. Se debe incluir en el frontend la posibilidad de
 * editar las entidades y permitir el borrado de las mismas. Posteriormente se implementará el ejercicio de autenticación
 * con oauth2.
 *
 * @author David Ballen, Nicolas Caicedo, Liliana Torres, Kelly Solano, Ruben Ramos.
 * @version 1.0
 * @since 25/10/2021
 */
/**
 * Servicio Reservacion
 *
 * @author David Ballen, Nicolas Caicedo, Liliana Torres, Kelly Solano, Ruben Ramos.
 * @version 1.0
 * @since 25/10/2021
 */
@Service
/**Clase ReservationsService*/
public class ReservationService {
    //Anotacion Autowired
    @Autowired
    /**
     * Se instancia el repositorio de reservaciones.
     * */
    private ReservationRepository reservationRepository;

    /**
     * Función obtener reservaciones: retorna lista de reservas.
     * */
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    /**
     * Función obtener reserva: retorna la reserva segun ID.
     * */
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    /**
     * Función guardar reserva: almacena nueva reserva.
     * */
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }
        else{
            Optional<Reservation> reservationAux=reservationRepository.getReservation(reservation.getIdReservation());
            if(reservationAux.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    /**
     * Función actualizar reserva: modifica una reserva.
     * */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> reservationEjemplo=reservationRepository.getReservation(reservation.getIdReservation());
            if(!reservationEjemplo.isEmpty()){
                if(reservation.getStartDate()!=null){
                    reservationEjemplo.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    reservationEjemplo.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    reservationEjemplo.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(reservationEjemplo.get());
                return reservationEjemplo.get();
            }
            else{
                return reservation;
            }
        }
        else{
            return reservation;
        }
    }

    /**
     * Función eliminar reserva: borra una reserva.
     * */
    public boolean deleteReservation(int id){
        Boolean aBoolean = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
