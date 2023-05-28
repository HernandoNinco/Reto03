package com.reto03.grupog6.Services;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto03.grupog6.DTO.StatusReport;
import com.reto03.grupog6.Entities.Reservation;
import com.reto03.grupog6.Repository.ReservationRepository;



@Service
public class ReservationService  {
    @Autowired
    private ReservationRepository reservationRepository;
    public Reservation addReservation(Reservation reservation) {
        Boolean bGrabar = true;

        if (reservation.getStatus() == null) {
            reservation.setStatus("created");
        }
            

        if (reservation.getStartDate() == null)
            bGrabar = false;

        if (reservation.getDevolutionDate() == null)
            bGrabar = false;

        if (reservation.getCar().getIdCar() == null)
            bGrabar = false;

        if (reservation.getClient().getIdClient() == null)
            bGrabar = false;


        if (bGrabar == true)
            return reservationRepository.addReservation(reservation);
        else
            return reservation;

    }


    public List<Reservation> getAll() {
        return (List<Reservation>) reservationRepository.getall();
    }

    public Reservation updReservation(Reservation reservation) {
        return reservationRepository.updReservation(reservation);
    }

    public Reservation getReservation(Integer id) {
        return reservationRepository.getReservation(id);
    }

    public void delReservation(Integer id) {
        reservationRepository.delReservation(id);
    }

    public List<Reservation> getReportReservation(String dateOne, String dateTwo) {
        SimpleDateFormat convertidor = new SimpleDateFormat("yyyy-MM-dd");
        Date duno = new Date();
        Date ddos = new Date();
        try {
            duno = convertidor.parse(dateOne);
            ddos = convertidor.parse(dateTwo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (duno.before(ddos)) {
            return reservationRepository.getReportReservation(duno, ddos);
        } else
            return new ArrayList<>();

    }

    public StatusReport getStatusReport() {
        List<Reservation> listReservations = reservationRepository.getall();
        Integer completas = 0;
        Integer canceladas = 0;
        StatusReport statusReport = new StatusReport();

        for (Reservation reservation : listReservations) {
            if (reservation.getStatus().equalsIgnoreCase("completed"))
                completas++;
            if (reservation.getStatus().equalsIgnoreCase("cancelled"))
                canceladas++;
        }
        statusReport.setCancelled(canceladas);
        statusReport.setCompleted(completas);
        return statusReport;
    }

    public StatusReport getStatusReportQuery() {

        Integer completas = reservationRepository.getReportStatusbyQuery("completed");
        Integer canceladas = reservationRepository.getReportStatusbyQuery("cancelled");
        StatusReport statusReport = new StatusReport();

        statusReport.setCancelled(canceladas);
        statusReport.setCompleted(completas);
        return statusReport;
    }
}
