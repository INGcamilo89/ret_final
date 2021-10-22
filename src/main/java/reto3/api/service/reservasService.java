package reto3.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.Reservas;
import reto3.api.repository.reservaRepository;


import java.util.List;

@Service
public class reservasService {

    @Autowired
    reservaRepository ReservaRepository;

    public List<Reservas> obtenerReservas()
    {
        return ReservaRepository.obtenerReservas();
    }


    public Reservas crearReservas(Reservas reservas)
    {

        return  ReservaRepository.crearReservas(reservas);
    }
}
