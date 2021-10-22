package reto3.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Reservas;
import reto3.api.service.reservasService;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")

public class reservasController {
    @Autowired
    reservasService ReservasService;

    @GetMapping("/all")
    public List<Reservas> getReservas() {

        return ReservasService.obtenerReservas();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas crearBarcos(@RequestBody Reservas reservas){

        return ReservasService.crearReservas(reservas);
    }
}
