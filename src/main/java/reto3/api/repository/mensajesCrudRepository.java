package reto3.api.repository;

import org.springframework.data.repository.CrudRepository;
import reto3.api.model.Mensajes;

public interface mensajesCrudRepository extends CrudRepository<Mensajes,Integer> {
}
