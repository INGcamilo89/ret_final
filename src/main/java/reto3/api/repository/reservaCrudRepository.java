package reto3.api.repository;

import org.springframework.data.repository.CrudRepository;
import reto3.api.model.Reservas;

public interface reservaCrudRepository extends CrudRepository<Reservas,Integer> {
}
