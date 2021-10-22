package reto3.api.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.barcos;
import java.util.List;

@Repository
public class barcosRepository{
        @Autowired
        barcosCrudRepository BarcosCrudRepository;

        public List<barcos> obtenerBarcos() {

            return (List<barcos>) BarcosCrudRepository.findAll();
        }

        public barcos crearBarcos(barcos Barcos) {
        return BarcosCrudRepository.save(Barcos);
    }



}