package reto3.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Clientes;
import reto3.api.service.clienteService;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class clienteController {

    @Autowired
    clienteService ClienteService;

    @GetMapping("/all")
    public List<Clientes> getClientes() {

        return ClienteService.obtenerClientes();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes crearClientes(@RequestBody Clientes clientes){

        return ClienteService.save(clientes);
    }



}
