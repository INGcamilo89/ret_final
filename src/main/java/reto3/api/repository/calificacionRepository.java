package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Calificacion;

import java.util.List;

@Repository
public class calificacionRepository {


    @Autowired
    calificacionCrudRepository CalificacionCrudRepository;

    public List<Calificacion> obtenerCalificacion() {

        return (List<Calificacion>) CalificacionCrudRepository.findAll();
    }

    public Calificacion crearCalificacion(Calificacion calificacion) {
        return CalificacionCrudRepository.save(calificacion);
    }
}
