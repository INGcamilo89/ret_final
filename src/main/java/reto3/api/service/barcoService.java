package reto3.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.barcos;
import reto3.api.repository.barcosRepository;
import java.util.List;
import java.util.Optional;

@Service
public class barcoService {

    @Autowired
    barcosRepository BarcosRepository;

    public List<barcos> obtenerBarcos()

    {
        return BarcosRepository.obtenerBarcos();
    }

/*
    public barcos crearBarcos(barcos Barcos)

    {
        return  BarcosRepository.crearBarcos(Barcos);
    }*/

    public Optional<barcos> getBarcos(int barcosId){
        return  BarcosRepository.getBarcos(barcosId);
    }
    public barcos crearBarcos(barcos Barcos){
        if (Barcos.getId()==null){
            return BarcosRepository.crearBarcos(Barcos);
        }else{
            Optional<barcos> e=BarcosRepository.getBarcos(Barcos.getId());
            if (e.isEmpty()){
                return BarcosRepository.crearBarcos(Barcos);
            }else
            {
                return Barcos;
            }
        }
    }

    public barcos actualizarBarcos(barcos Barcos){
        if(Barcos.getId()!=null){
            Optional<barcos> e=BarcosRepository.getBarcos((Barcos.getId()));
            if (!e.isEmpty()){

                if (Barcos.getName()!=null){
                    e.get().setName((Barcos.getName()));
                }
                if(Barcos.getBrand()!=null){
                    e.get().setBrand(Barcos.getBrand());

                }
                if (Barcos.getYear()!=null){
                    e.get().setYear(Barcos.getYear());
                }
                if (Barcos.getDescription()!=null){
                    e.get().setDescription(Barcos.getDescription());
                }
                if (Barcos.getCategory()!=null){
                    e.get().setCategory((Barcos.getCategory()));
                }
                BarcosRepository.crearBarcos(e.get());
                return e.get();
            }else {
                return Barcos;}
        }else {
            return Barcos;
        }
    }

    public boolean eliminar(int BarcosId){
        Boolean aBoolean=getBarcos(BarcosId).map(Barcos ->{
            BarcosRepository.eliminarBarcos(Barcos);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}




