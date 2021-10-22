package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Reservas;

import java.util.List;

@Repository
public class reservaRepository {
    @Autowired
    reservaCrudRepository ReservaCrudRepository;

    public List<Reservas> obtenerReservas() {

        return (List<Reservas>) ReservaCrudRepository.findAll();
    }

    public Reservas crearReservas(Reservas reservas) {
        return ReservaCrudRepository.save(reservas);
    }


}
