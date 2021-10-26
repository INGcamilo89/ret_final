package reto3.api.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Calificacion;
import reto3.api.model.Categorias;
import reto3.api.model.barcos;
import reto3.api.repository.crud.CategoriaCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class categoriasRepository {
    @Autowired
    CategoriaCrudRepository categoriasCrudRepository;

    public List<Categorias> obtenerCategorias(){
        return (List<Categorias>) categoriasCrudRepository.findAll();

    }

    public Categorias crearCategorias(Categorias categorias) {
        return categoriasCrudRepository.save(categorias);
    }

    public Optional<Categorias> getCalificacion(int id){
        return categoriasCrudRepository.findById(id);
    }
    public void eliminarCategorias(Categorias categorias){
        categoriasCrudRepository.delete(categorias);
    }


}




