package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Mensajes;

import java.util.List;

@Repository
public class mensajeRepository {



    @Autowired
    mensajesCrudRepository MensajesCrudRepository;

    public List<Mensajes> obtenerMensajes() {

        return (List<Mensajes>) MensajesCrudRepository.findAll();
    }

    public Mensajes crearMensaje(Mensajes mensajes) {
        return MensajesCrudRepository.save(mensajes);
    }
}
