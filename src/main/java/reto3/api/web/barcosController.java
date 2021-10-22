package reto3.api.web;

import reto3.api.model.barcos;
import reto3.api.service.barcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/Boat")
public class barcosController {

    @Autowired
    barcoService BarcosService;

    @GetMapping("/all")
    public List<barcos> getbarcos() {

        return BarcosService.obtenerBarcos();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public barcos crearBarcos(@RequestBody barcos Barcos){

        return BarcosService.crearBarcos(Barcos);
    }

}
