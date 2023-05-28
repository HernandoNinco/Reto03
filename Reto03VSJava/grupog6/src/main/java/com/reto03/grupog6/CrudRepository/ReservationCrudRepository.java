package com.reto03.grupog6.CrudRepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reto03.grupog6.Entities.Reservation;
public interface ReservationCrudRepository  extends CrudRepository<Reservation,Integer>{
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    @Query(value="Select count(*) From Reservaciones where status = ?",nativeQuery=true)
    public Integer CountByStatus(String status);
}
