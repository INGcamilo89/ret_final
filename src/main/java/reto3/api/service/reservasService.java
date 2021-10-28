package reto3.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.Mensajes;
import reto3.api.model.Reservas;
import reto3.api.repository.reservaRepository;


import java.util.List;
import java.util.Optional;

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
    public Optional<Reservas> getReservas(int ReservasId){
        return  ReservaRepository.getReservas(ReservasId);
    }

    public Reservas update(Reservas reservas)
    {
        if(reservas.getIdReservation()!=null)
        {
            Optional<Reservas> e= ReservaRepository.getReservas(reservas.getIdReservation());
            if(!e.equals(null))
            {
                if(reservas.getStartDate()!=null)
                {
                    e.get().setStartDate(reservas.getStartDate());
                }
                else if(reservas.getDevolutionDate()!=null)
                {
                    e.get().setDevolutionDate(reservas.getDevolutionDate());
                }
                else if(reservas.getStatus()!=null)
                {
                    e.get().setStatus(reservas.getStatus());
                }
                ReservaRepository.save(e.get());
                return e.get();
            }
            else
            {
                return reservas;
            }
        }
        else
        {
            return reservas;
        }
    }
    public boolean deleteReservas(int reservationId)
    {
        Boolean aBoolean = getReservas(reservationId).map(reservas ->
        {
            ReservaRepository.delete(reservas);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
