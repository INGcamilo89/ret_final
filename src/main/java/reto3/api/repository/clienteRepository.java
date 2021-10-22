package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Clientes;

import java.util.List;
@Repository
public class clienteRepository {
    @Autowired
    clienteCrudRepository ClienteCrudRepository;

    public List<Clientes> obtenerClientes(){
        return (List<Clientes>) ClienteCrudRepository.findAll();

    }

    public Clientes crearClientes(Clientes clientes) {
        return ClienteCrudRepository.save(clientes);
    }


}

