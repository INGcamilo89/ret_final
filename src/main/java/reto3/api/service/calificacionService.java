package reto3.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.Calificacion;
import reto3.api.model.barcos;
import reto3.api.repository.calificacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class calificacionService {

    @Autowired
    calificacionRepository CalificacionRepository;

    public List<Calificacion> obtenerCalificacion()
    {
        return CalificacionRepository.obtenerCalificacion();
    }


    public Calificacion crearCalificacion(Calificacion calificacion)
    {
        return  CalificacionRepository.crearCalificacion(calificacion);
    }


}
