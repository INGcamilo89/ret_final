package reto3.api.reportes;

import reto3.api.model.Clientes;

public class ContadorClientes {
    private Long total;
    private Clientes client;

    public ContadorClientes(Long total, Clientes client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Clientes getClient() {
        return client;
    }

    public void setClient(Clientes client) {
        this.client = client;
    }


}
