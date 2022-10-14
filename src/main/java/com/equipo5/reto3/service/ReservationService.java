package com.equipo5.reto3.service;

import com.equipo5.reto3.entities.Reservation;
import com.equipo5.reto3.entities.customDTO.CountClient;
import com.equipo5.reto3.entities.customDTO.StatusAmount;
import com.equipo5.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    //RETO 5

    // Reporte 1: total de Reservas entre fecha 1 y fecha 2

    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a=parser.parse(dateA);
            b=parser.parse(dateB);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)) {
            return reservationRepository.getReservationPeriod(a,b);
        } else {
            return new ArrayList<>();
        }
    }

    //cantidad de reservas por room

//    public List<CountRoom> getTopRoom() { return reservationRepository.getTopRooms();}

    //cantidad de resrvas por cliente
    public List<CountClient> getTopClients() { return reservationRepository.getTopClients();}



    //Cantidad de reservas completas vs canceladas

    public StatusAmount getReservationsStatusReport(){
        List<Reservation>completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReservationByStatus("cancelled");

        int cantidadCompleted = completed.size();
        int cantidadCancelled = cancelled.size();

        return new StatusAmount ( cantidadCompleted,  cantidadCancelled);

    }

//    public StatusAmount getReservationsStatusReport(){
//        List<Reservation>completed=reservationRepository.getReservationByStatus("completed");
//        List<Reservation>cancelled=reservationRepository.getReservationByStatus("cancelled");
//
//        return  new StatusAmount(completed.size(), cancelled.size());
//    }

}


