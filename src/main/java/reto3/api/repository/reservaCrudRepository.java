package reto3.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import reto3.api.model.Reservas;

import java.util.Date;
import java.util.List;

public interface reservaCrudRepository extends CrudRepository<Reservas,Integer> {


    public List<Reservas> findAllByStatus (String status);

    public List<Reservas> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservas AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
