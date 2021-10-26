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
    public Optional<Categorias> getCatEGORIAS(int CategoriaId){
        return  CategoriasRepository.getCalificacion(CategoriaId);
    }

}

