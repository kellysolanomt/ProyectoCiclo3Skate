package com.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.ciclo3.model.Reservations;
import com.usa.ciclo3.ciclo3.repository.ContadorClientes;
import com.usa.ciclo3.ciclo3.repository.ReservationsRepository;
import com.usa.ciclo3.ciclo3.repository.StatusReservas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<Reservations> getAll() {

		return reservationsRepository.getAll();
	}

	public Optional<Reservations> getResevation(int id) {
		return reservationsRepository.getRegistranion(id);
	}

	public Reservations save(Reservations reserv) {
		if (reserv.getIdReservation() == null) {
			return reservationsRepository.save(reserv);
		} else {
			Optional<Reservations> reserveAuxOptional = reservationsRepository
					.getRegistranion(reserv.getIdReservation());
			if (reserveAuxOptional.isEmpty()) {
				return reservationsRepository.save(reserv);
			} else {
				return reserv;
			}

		}
	}

	public Reservations update(Reservations reservation) {
		if (reservation.getIdReservation() != null) {
			Optional<Reservations> reservationEjemplo = reservationsRepository
					.getRegistranion(reservation.getIdReservation());
			if (!reservationEjemplo.isEmpty()) {
				if (reservation.getStartDate() != null) {
					reservationEjemplo.get().setStartDate(reservation.getStartDate());
				}
				if (reservation.getDevolutionDate() != null) {
					reservationEjemplo.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				if (reservation.getStatus() != null) {
					reservationEjemplo.get().setStatus(reservation.getStatus());
				}
//				if (reservation.getClient() != null) {
//					reservationEjemplo.get().setClient(reservation.getClient());
//				}
				
				reservationsRepository.save(reservationEjemplo.get());
				return reservationEjemplo.get();
			} else {
				return reservation;
			}
		} else {
			return reservation;
		}
	}

	public boolean deleteReservation(int id) {
		Boolean aBoolean = getResevation(id).map(reservation -> {
			reservationsRepository.delete(reservation);
			return true;
		}).orElse(false);
		return aBoolean;
	}
        public StatusReservas getReporteEstatusReservaciones(){
            //	{"completed":3,"cancelled":1}guia 
            //List<Reservations>completed= metodosCrud.ReservationStatus("completed");
            //List<Reservations>cancelled= metodosCrud.ReservationStatus("cancelled");
            //return new StatusReservas(completed.size(), cancelled.size());
            
            List<Reservations>completed= reservationsRepository.ReservacionStatus("completed");
            List<Reservations>cancelled= reservationsRepository.ReservacionStatus("cancelled");
            return new StatusReservas(completed.size(), cancelled.size());
        }
        public List<Reservations> getReportesTiempoReservaciones(String dateA, String dateB){
            SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
            Date datoUno = new Date();
            Date datoDos = new Date();
            
            try{
                datoUno= parser.parse(dateA);
                datoDos= parser.parse(dateB);
            }catch(ParseException evt){
                evt.printStackTrace();
                
                           
            }if(datoUno.before (datoDos)){
                return reservationsRepository.ReservacionTiempo(datoUno, datoDos);
           
                
            }else{
                return new ArrayList<>();
            }
        }
         public List<ContadorClientes> servicioTopClientes(){
            return reservationsRepository.getTopClientes();
    }
        
}
