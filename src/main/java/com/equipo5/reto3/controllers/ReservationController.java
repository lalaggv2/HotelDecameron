package com.equipo5.reto3.controllers;

import com.equipo5.reto3.entities.Reservation;
import com.equipo5.reto3.entities.customDTO.CountClient;
import com.equipo5.reto3.entities.customDTO.StatusAmount;
import com.equipo5.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    //  /api/Reservation/all para traerlos todos
    @GetMapping("/all")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return reservationService.getReservation(id);
    }

    //el post la ruta es /api/Reservation/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save1(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    //RETO 4

    //el put  la ruta es /api/Reservation/update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return reservationService.delete(id);
    }

    //RETO 5

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne, dateTwo);
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationStatusReport (){
        return reservationService.getReservationsStatusReport();
    }

//    @GetMapping("/report-room")
//    public  List<CountRoom> getReservationsReportRoom() {return reservationService.getTopRoom();}

    //Reporte de cliente mas rentable
    @GetMapping("/report-clients")
    public List<CountClient> getReservationReportClient() { return reservationService.getTopClients();}


}
