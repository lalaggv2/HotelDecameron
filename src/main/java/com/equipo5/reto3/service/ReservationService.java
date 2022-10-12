package com.equipo5.reto3.service;

import com.equipo5.reto3.entities.Reservation;
import com.equipo5.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    public ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save (Reservation reservation) {
        if(reservation.getIdReservation()==null) {
            return reservationRepository.save(reservation);
        } else {
            Optional <Reservation> reservationFound = getReservation(reservation.getIdReservation());
            if(reservationFound.isEmpty()) {
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if(reservation.getIdReservation() != null) {
            Optional<Reservation> reservationFound = getReservation(reservation.getIdReservation());
            if (!reservationFound.isEmpty()) {
                if (reservation.getStartDate() != null){
                    reservationFound.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationFound.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null) {
                    reservationFound.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(reservationFound.get());
            }
        }
        return reservation;
    }

    public boolean delete(int idReservation) {
        Boolean response = getReservation(idReservation).map(element -> {
            reservationRepository.delete(element);
            return true;
        }).orElse(false);
        return response;
    }

}


