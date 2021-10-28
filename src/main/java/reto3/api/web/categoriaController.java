package reto3.api.web;
import reto3.api.service.categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Categorias;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class categoriaController {

    @Autowired
    categoriaService CategoriaService;

    @GetMapping("/all")
    public List<Categorias> getCategorias(){

        return CategoriaService.obtenerCategorias();
    }
/*
    @GetMapping("/{id}")
    public Optional<Categorias>getCategoria(@PathVariable("id")int categoriaId){
        return CategoriaService.getCatEGORIAS(categoriaId);
    }*/
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorias crearCategorias(@RequestBody Categorias categorias){

        return CategoriaService.crearCategorias(categorias);
    }
}
