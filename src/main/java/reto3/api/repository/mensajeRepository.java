package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Mensajes;
import reto3.api.model.barcos;

import java.util.List;
import java.util.Optional;

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

    public Optional<Mensajes>getMensaje(int id)
    {
        return MensajesCrudRepository.findById(id);
    }
    public void delete(Mensajes mensajes)
    {
        MensajesCrudRepository.delete(mensajes);
    }
    public List<Mensajes> getAll(){
        return (List<Mensajes>) MensajesCrudRepository.findAll();
    }
    public Optional<Mensajes> getMessage(int id){
        return MensajesCrudRepository.findById(id);
    }

    public Mensajes save(Mensajes mensajes){
        return MensajesCrudRepository.save(mensajes);
    }
}
