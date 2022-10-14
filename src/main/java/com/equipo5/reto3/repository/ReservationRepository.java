package com.equipo5.reto3.repository;

import com.equipo5.reto3.entities.Client;
import com.equipo5.reto3.entities.Reservation;
import com.equipo5.reto3.entities.customDTO.CountClient;
import com.equipo5.reto3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    //el optional me permite evitar errores si se mandan datos nulos o id que no existen
    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCrudRepository.delete(reservation);
    }

    //RETO 5
    //Reporte de reservas entre dos fechas
    public List<Reservation> getReservationPeriod(Date a, Date b) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    //Reporte de reservas segun estado
    public List<Reservation>getReservationByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    //Top de clientes con mas reservations
    public List<CountClient> getTopClients() {
        List<CountClient>reserva=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {
            reserva.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return reserva;
    }


//    //Top de Rooms con mas reservations
//    public List<CountRoom> getTopRooms() {
//        List<CountRoom>reserva=new ArrayList<>();
//        List<Object[]>report=reservationCrudRepository.countTotalReservationByRoom();
//        for (int i = 0; i < report.size(); i++) {
//            reserva.add(new CountRoom( (Long) report.get(i)[1], (Room) report.get(i)[0]));
//        }
//        return reserva;
//    }


}