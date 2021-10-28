package reto3.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Mensajes;
import reto3.api.model.Reservas;
import reto3.api.service.mensajeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")

public class mensajeController {
    @Autowired
    mensajeService MensajeService;

    @GetMapping("/all")
    public List<Mensajes> getMensajes() {

        return MensajeService.obtenerMensajes();
    }
    @GetMapping("/{id}")
    public Optional<Mensajes> getMensaje(@PathVariable("id") int idMessage) {

        return MensajeService.getMensaje(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes crearMensajes(@RequestBody Mensajes mensajes){

        return MensajeService.crearMensajes(mensajes);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes update(@RequestBody Mensajes mensajes) {
        return MensajeService.update(mensajes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idMessage) {
        return MensajeService.deleteMessage(idMessage);
    }



}
