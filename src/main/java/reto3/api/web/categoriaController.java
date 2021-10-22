package reto3.api.web;
import reto3.api.service.categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Categorias;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class categoriaController {

    @Autowired
    categoriaService CategoriaService;

    @GetMapping("/all")
    public List<Categorias> getCategorias(){

        return CategoriaService.obtenerCategorias();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorias crearCategorias(@RequestBody Categorias categorias){

        return CategoriaService.crearCategorias(categorias);
    }
}
