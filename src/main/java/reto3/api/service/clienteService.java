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
        return ClienteRepository.getAll();
    }


    public Clientes save(Clientes clientes)
    {
        return  ClienteRepository.save(clientes);
    }

    public Optional<Clientes> getClientes(int CalificacionId){
        return  ClienteRepository.getClientes(CalificacionId);
    }


    public Clientes update(Clientes clientes)
    {
        if(clientes.getIdClient()!=null)
        {
            Optional<Clientes> e= ClienteRepository.getClientes(clientes.getIdClient());
            if(!e.equals(null))
            {
                if(clientes.getName()!=null)
                {
                    e.get().setName(clientes.getName());
                }
                if(clientes.getAge()!=null)
                {
                    e.get().setAge(clientes.getAge());
                }
                if(clientes.getPassword()!=null)
                {
                    e.get().setPassword(clientes.getPassword());
                }
                ClienteRepository.save(e.get());
                return e.get();
            }
            else
            {
                return clientes;
            }
        }
        else
        {
            return clientes;
        }
    }
    public boolean deleteClient(int idCliente)
    {
        Boolean aBoolean = getClientes(idCliente).map(clientes ->
        {
            ClienteRepository.delete(clientes);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
