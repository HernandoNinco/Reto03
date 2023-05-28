package com.reto03.grupog6.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto03.grupog6.DTO.StatusReport;
import com.reto03.grupog6.Entities.Reservation;
import com.reto03.grupog6.Services.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all") 
    public List<Reservation> getall(){
        return reservationService.getAll();
    }
    @GetMapping("/save")
      public Reservation addReservation(Reservation reservation){
        return reservationService.addReservation(reservation);
        
      }
    @PutMapping("/update")
    public Reservation updReservation(@RequestBody Reservation reservation) {
        return reservationService.updReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void delReservation(@PathVariable Integer id) {
         reservationService.delReservation(id);
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Integer id) {
        return reservationService.getReservation(id);
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne,
            @PathVariable("dateTwo") String dateTwo) {
        return reservationService.getReportReservation(dateOne, dateTwo);
    }

    @GetMapping("/report-status")
    public StatusReport getStatusReport() {
        //        return reservationService.getStatusReport();
        return reservationService.getStatusReportQuery();
    }

}
