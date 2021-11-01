package reto3.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.Reservas;
import reto3.api.repository.reservaRepository;
import reto3.api.reportes.ContadorClientes;
import reto3.api.reportes.StatusReservas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public StatusReservas reporteStatusServicio (){
        List<Reservas>completed= ReservaRepository.ReservacionStatusRepositorio("completed");
        List<Reservas>cancelled= ReservaRepository.ReservacionStatusRepositorio("cancelled");

        return new StatusReservas(completed.size(), cancelled.size() );
    }


    public List<Reservas> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return ReservaRepository.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();

        }
    }
    public List<ContadorClientes> reporteClientesServicio(){
        return ReservaRepository.getClientesRepositorio();
    }

}
