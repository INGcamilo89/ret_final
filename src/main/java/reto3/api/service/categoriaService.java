package reto3.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.Categorias;
import reto3.api.repository.categoriasRepository;

import java.util.List;

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

}

