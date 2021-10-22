package reto3.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Mensajes;
import reto3.api.service.mensajeService;

import java.util.List;

@RestController
@RequestMapping("/api/Message")

public class mensajeController {
    @Autowired
    mensajeService MensajeService;

    @GetMapping("/all")
    public List<Mensajes> getMensajes() {

        return MensajeService.obtenerMensajes();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes crearMensajes(@RequestBody Mensajes mensajes){

        return MensajeService.crearMensajes(mensajes);
    }



}
