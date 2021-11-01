package reto3.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Reservas;
import reto3.api.service.reservasService;
import reto3.api.reportes.StatusReservas;
import reto3.api.reportes.ContadorClientes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")

public class reservasController {
    @Autowired
    reservasService ReservasService;

    @GetMapping("/all")
    public List<Reservas> getAll() {

        return ReservasService.obtenerReservas();
    }
    @GetMapping("/{id}")
    public Optional<Reservas> getReservas(@PathVariable("id") int idReservation)
    {
        return ReservasService.getReservas(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas crearBarcos(@RequestBody Reservas reservas){

        return ReservasService.crearReservas(reservas);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas update(@RequestBody Reservas reservas)
    {
        return ReservasService.update(reservas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation)
    {
        return ReservasService.deleteReservas(idReservation);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return ReservasService.reporteStatusServicio();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservas> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
        return ReservasService.reporteTiempoServicio(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return ReservasService.reporteClientesServicio();
    }

}
