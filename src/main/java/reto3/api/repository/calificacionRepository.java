package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Calificacion;
import reto3.api.model.barcos;

import java.util.List;
import java.util.Optional;

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
    public Optional<Calificacion> getCalificacion(int id){
        return CalificacionCrudRepository.findById(id);
    }
    public void eliminarCalificacion(Calificacion calificacion){
        CalificacionCrudRepository.delete(calificacion);
    }


}
