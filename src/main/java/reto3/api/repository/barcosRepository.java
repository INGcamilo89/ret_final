package reto3.api.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.barcos;
import java.util.List;
import java.util.Optional;

@Repository
public class barcosRepository{
        @Autowired
        barcosCrudRepository BarcosCrudRepository;
        //obtiene lista de barcos
        public List<barcos> obtenerBarcos() {

            return (List<barcos>) BarcosCrudRepository.findAll();
        }
        //crea lista de barcos
        public barcos crearBarcos(barcos Barcos)
        {
        return BarcosCrudRepository.save(Barcos);
    }   //actualiza un barco con id especifico
        public Optional<barcos> getBarcos(int id){
            return BarcosCrudRepository.findById(id);
        }
        //elimina lista de barcos
        public void eliminarBarcos(barcos Barcos)
        {
            BarcosCrudRepository.delete(Barcos);
        }

}