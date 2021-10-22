package reto3.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="score")
public class Calificacion  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;


    @Column(length = 1)
    private int calification;

    @Column(length = 250)
    private String message;


    @Column(length = 100)
    private int reserv;

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getReserv() {
        return reserv;
    }

    public void setReserv(int reserv) {
        this.reserv = reserv;
    }

}
