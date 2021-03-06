package reto3.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.api.model.Clientes;
import reto3.api.model.barcos;

import java.util.List;
import java.util.Optional;

@Repository
public class clienteRepository {
    @Autowired
    clienteCrudRepository ClienteCrudRepository;

    public List<Clientes> getAll(){
        return (List<Clientes>) ClienteCrudRepository.findAll();

    }

    public Clientes save(Clientes clientes) {
        return ClienteCrudRepository.save(clientes);
    }

    public Optional<Clientes> getClientes(int id){
        return ClienteCrudRepository.findById(id);
    }
    public void delete(Clientes clientes){
        ClienteCrudRepository.delete(clientes);
    }

}

