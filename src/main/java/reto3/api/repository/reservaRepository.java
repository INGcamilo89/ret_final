package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Reservas;
import reto3.api.model.barcos;

import java.util.List;
import java.util.Optional;

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

    public Optional<Reservas> getReservas(int id){
        return ReservaCrudRepository.findById(id);
    }
    public void eliminarReservas(Reservas reservas){
        ReservaCrudRepository.delete(reservas);
    }


}
