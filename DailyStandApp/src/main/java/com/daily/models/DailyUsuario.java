package com.daily.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "DailysUsuarios")
public class DailyUsuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definimos estos valores como PK
    private Long id;

    private String mensajeAyer;

    private String mensajeHoy;

    private String mensajeObstaculo;

    //Opcionales, sirven para la gestión de base de datos, NO SE AÑADEN A LOS CONSTRUCTORES NI GET AND SET
    @Column(updatable = false) //Propiedad de la columna, updatetable define si se actualiza o no
    private Date createdAt; //Fecha de creación
    @Column(updatable = true)
    private Date updatedAt; //Fecha de actualización
    @Column(updatable = true)
    private Date deletedAt; //Fecha de eliminación

    //Relacion ManyToOne con Daily
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="daily_id") //Desde donde se va a unir a la otra tabla
    private Daily daily; // El objeto al que se hace referencia


    //Relacion ManyToOne con Usuario
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id") //Desde donde se va a unir a la otra tabla
    private Usuario usuario; // El objeto al que se hace referencia

    //Constructor Vacío
    public DailyUsuario() {
    }

    //Constructor con atributos
    public DailyUsuario(String mensajeAyer, String mensajeHoy, String mensajeObstaculo) {
        this.mensajeAyer = mensajeAyer;
        this.mensajeHoy = mensajeHoy;
        this.mensajeObstaculo = mensajeObstaculo;
    }

    public String getMensajeAyer() {
        return mensajeAyer;
    }

    public void setMensajeAyer(String mensajeAyer) {
        this.mensajeAyer = mensajeAyer;
    }

    public String getMensajeHoy() {
        return mensajeHoy;
    }

    public void setMensajeHoy(String mensajeHoy) {
        this.mensajeHoy = mensajeHoy;
    }

    public String getMensajeObstaculo() {
        return mensajeObstaculo;
    }

    public void setMensajeObstaculo(String mensajeObstaculo) {
        this.mensajeObstaculo = mensajeObstaculo;
    }

    // Insertará en el atributo, la fecha antes de insertar a la base de datos
    @PrePersist
    protected void onCreate(){
    this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
    this.updatedAt = new Date();
    }

    
}
