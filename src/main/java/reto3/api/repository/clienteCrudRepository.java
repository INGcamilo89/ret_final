package reto3.api.repository;

import org.springframework.data.repository.CrudRepository;
import reto3.api.model.Clientes;

public interface clienteCrudRepository extends CrudRepository<Clientes,Integer> {
}
