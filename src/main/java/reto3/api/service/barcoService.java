package reto3.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.barcos;
import reto3.api.repository.barcosRepository;
import java.util.List;
@Service
public class barcoService {

    @Autowired
    barcosRepository BarcosRepository;

    public List<barcos> obtenerBarcos()
    {
        return BarcosRepository.obtenerBarcos();
    }


    public barcos crearBarcos(barcos Barcos)
    {
        return  BarcosRepository.crearBarcos(Barcos);
    }


}




