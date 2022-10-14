package com.equipo5.reto3.repository.crud;

import com.equipo5.reto3.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    //RETO 5

//    /*Reporte 1
//
//    Cantidad de resrvas en un tiempo determinado
//
//     esto es lo mismo q decir (select * from Reservation where idReservation esta entre fechaA y fechaB;
//    public void findAllByIdReservationBetweenAnd(Integer a, Integer b);
//
//  SELECT * FROM Reservation WHERE startDate AFTER dateOne AND devolutionDate BEFORE dateTwo
//
//     */
//    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC"  )
    public List<Object[]> countTotalReservationByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation> findAllByStatus(String status);

    //
//    /* REPORTE 2
//     * cantidad de reservas completas vs canceladas
//     *
//     * SELECT * FROM Reservation WHERE status = 'cancelled'
//     *
//     */
//    public List<Reservation> findAllByStatus (String status);
//
//
//    /*  Reporte 3
//
//     *   Cantidad de reservas por cliente
//     *  select clientId, count(*) as "total" from reservation group by clientId by total desc;
//     *
//     */
//    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
//    public List<Object[]> countTotalReservationByClient();

/* Reporte Opcional
 *  Cantidad de reservas por Room
 *      @Query("SELECT c.room, COUNT (c.room) from Reservation AS c group by c.room order by COUNT(c.room) DESC")
 */
//    public List<Object[]> countTotalReservationByRoom();





//    @Query("SELECT c.c, COUNT(c.farm) from Reservation AS c group by c.farm order by COUNT(c.farm) DESC")
//    public List<Object[]> countTotalReservationsByFarm();


//    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;
//    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
//    public List<Object[]> countTotalReservationsByClient();
//
//    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo );
//
//    public List<Reservation>findAllByStatus(String status);



}






