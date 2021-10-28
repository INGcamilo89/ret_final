package reto3.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.Calificacion;
import reto3.api.model.Categorias;
import reto3.api.repository.categoriasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class categoriaService {

    @Autowired
    categoriasRepository CategoriasRepository;


    public List<Categorias> obtenerCategorias()
    {
        return CategoriasRepository.obtenerCategorias();
    }
    public Categorias crearCategorias(Categorias categorias){
        return CategoriasRepository.crearCategorias(categorias);

    }

    public Categorias update(Categorias categorias){
        if(categorias.getId()!=null){
            Optional<Categorias>g=CategoriasRepository.getCategorias(categorias.getId());
            if(!g.equals(null)){
                if(categorias.getDescription()!=null){
                    g.get().setDescription(categorias.getDescription());
                }
                if(categorias.getName()!=null){
                    g.get().setName(categorias.getName());
                }
                return CategoriasRepository.save(g.get());
            }
        }
        return categorias;
    }

/*
    public boolean deleteCategorias(int id){
        Boolean d=getCategorias(id).map(categorias -> {
            CategoriasRepository.delete(categorias);
            return true;
        }).orElse(false);
        return d;
    }
  */
}

