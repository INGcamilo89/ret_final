package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Clientes;
import reto3.api.model.Reservas;
import reto3.api.model.barcos;
import reto3.api.reportes.ContadorClientes;
import reto3.api.reportes.StatusReservas;
import reto3.api.reportes.StatusReservas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.List;

@Repository
public class reservaRepository {
    @Autowired
    reservaCrudRepository ReservaCrudRepository;

    public List<Reservas> obtenerReservas() {

        return (List<Reservas>) ReservaCrudRepository.findAll();
    }
    public List<Reservas> ReservacionStatusRepositorio (String status)
    {
        return ReservaCrudRepository.findAllByStatus(status);
    }
    public List<Reservas> ReservacionTiempoRepositorio (Date a, Date b){
        return ReservaCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);

    }
    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = ReservaCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Clientes) report.get(i)[0]));
        }
        return res;
    }

    public Reservas crearReservas(Reservas reservas) {
        return ReservaCrudRepository.save(reservas);
    }

    public Optional<Reservas> getReservas(int id){
        return ReservaCrudRepository.findById(id);
    }

    public List<Reservas> getAll(){
        return (List<Reservas>) ReservaCrudRepository.findAll();
    }
    public Optional<Reservas> getReserva(int id){
        return ReservaCrudRepository.findById(id);
    }

    public Reservas save(Reservas reservas){
        return ReservaCrudRepository.save(reservas);
    }
    public void delete(Reservas message){
        ReservaCrudRepository.delete(message);
    }

}
