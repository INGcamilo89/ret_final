package reto3.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Calificacion;
import reto3.api.service.calificacionService;

import java.util.List;

@RestController
@RequestMapping("/api/Calification")

public class calificacionController {

    @Autowired
     calificacionService CalificacionService;

    @GetMapping("/all")
    public List<Calificacion> getCalificacion() {

        return CalificacionService.obtenerCalificacion();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion crearCalificacion(@RequestBody Calificacion calificacion){

        return CalificacionService.crearCalificacion(calificacion);
    }

}
