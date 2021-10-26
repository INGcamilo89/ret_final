package reto3.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.api.model.Calificacion;
import reto3.api.model.Clientes;
import reto3.api.repository.clienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class clienteService {

    @Autowired
    clienteRepository ClienteRepository;

    public List<Clientes> obtenerClientes()
    {
        return ClienteRepository.obtenerClientes();
    }


    public Clientes crearClientes(Clientes clientes)
    {
        return  ClienteRepository.crearClientes(clientes);
    }

    public Optional<Clientes> getClientes(int CalificacionId){
        return  ClienteRepository.getClientes(CalificacionId);
    }

}
