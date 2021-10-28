package reto3.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto3.api.model.Clientes;
import reto3.api.service.clienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class clienteController {

    @Autowired
    clienteService ClienteService;

    @GetMapping("/all")
    public List<Clientes> getClientes() {

        return ClienteService.obtenerClientes();
    }
    @GetMapping("/{id}")
    public Optional<Clientes> getClient(@PathVariable("id") int idClient)
    {
        return ClienteService.getClientes(idClient);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes crearClientes(@RequestBody Clientes clientes){

        return ClienteService.save(clientes);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes update(@RequestBody Clientes clientes)
    {
        return ClienteService.update(clientes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idClient)
    {
        return ClienteService.deleteClient(idClient);
    }



}
