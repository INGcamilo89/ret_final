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
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class barcosController {

    @Autowired
    barcoService BarcosService;

    @GetMapping("/all")
    public List<barcos> getbarcos() {

        return BarcosService.obtenerBarcos();
    }

    @GetMapping("/{id}")
    public Optional<barcos> getBarcos(@PathVariable("id") int BarcosId){
        return  BarcosService.getBarcos(BarcosId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public barcos crearBarcos(@RequestBody barcos Barcos){

        return BarcosService.crearBarcos(Barcos);

    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public barcos update(@RequestBody barcos Barcos)
    {
        return BarcosService.update(Barcos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id)
    {
        return BarcosService.deleteBarcos(id);
    }
}
