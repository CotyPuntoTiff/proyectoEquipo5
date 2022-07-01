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
@Table (name= "gruposUsuarios")
public class GrupoUsuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definimos estos valores como PK
    private Long id;
    
    //Definir las relaciones con usuarios y grupos
    //Relacion ManyToOne con Usuario
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id") //Desde donde se va a unir a la otra tabla
    private Usuario usuario; // El objeto al que se hace referencia

    //Relacion ManyToOne con Grupo
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="grupo_id") //Desde donde se va a unir a la otra tabla
    private Grupo grupo; // El objeto al que se hace referencia


    //Usar constructor vacío.
    public GrupoUsuario() {
    }


    //Opcionales, sirven para la gestión de base de datos, NO SE AÑADEN A LOS CONSTRUCTORES NI GET AND SET
    @Column(updatable = false) //Propiedad de la columna, updatetable define si se actualiza o no
    private Date createdAt; //Fecha de creación
    @Column(updatable = true)
    private Date updatedAt; //Fecha de actualización
    @Column(updatable = true)
    private Date deletedAt; //Fecha de eliminación

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
