package com.reto03.grupog6.CrudRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reto03.grupog6.Entities.Client;

public interface ClientCrudRepository  extends CrudRepository<Client,Integer>{
    @Query(value="Select count(*) From Reservaciones where Status = ?",nativeQuery=true)
    public Integer CountReservations(String status);  
}
