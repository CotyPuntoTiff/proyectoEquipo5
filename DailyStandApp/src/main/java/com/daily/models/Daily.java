package com.daily.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "dailys")
public class Daily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definimos estos valores como PK
    private Long id;
    
    @Column(updatable = false) //Propiedad de la columna, updatetable define si se actualiza o no
    private Date createdAt; //Fecha de creación
    
    private String notasDaily;

    //Constructor vacío
    public Daily() {
    }
    //Constructor con Atributos
    public Daily(Date createdAt, String notasDaily) {
        this.createdAt = createdAt;
        this.notasDaily = notasDaily;
    }
    
    //Preguntar si van los get and set
    //Getter and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getNotasDaily() {
        return notasDaily;
    }

    public void setNotasDaily(String notasDaily) {
        this.notasDaily = notasDaily;
    }


}
