package com.daily.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definimos estos valores como PK
    private Long id;
    @NotNull
    private String nombre;
    
    private String observaciones;

    //Relacion OneToMany con GrupoUsuario
    @OneToMany(mappedBy ="grupo",cascade=CascadeType.ALL ,fetch=FetchType.LAZY) //CASCADE ES UNA RESTRICCION QUE IMPIDE ELIMINAR EL USUARIO SI NO SE HA ROTO LA RELACION
    private List<GrupoUsuario> gruposUsuarios;

    //Relacion OneToMany con Daily
    @OneToMany(mappedBy ="grupo",cascade=CascadeType.ALL ,fetch=FetchType.LAZY) //CASCADE ES UNA RESTRICCION QUE IMPIDE ELIMINAR EL USUARIO SI NO SE HA ROTO LA RELACION
    private List<Daily> daily;


    @Column(updatable = false) //Propiedad de la columna, updatetable define si se actualiza o no
    private Date createdAt; //Fecha de creación
    @Column
    private Date updatedAt; //Fecha de actualización
    @Column
    private Date deletedAt; //Fecha de eliminación
    
    //Constructor Vacío
    public Grupo() {
    }

    //Constructor con atributos
    public Grupo(@NotNull String nombre, String observaciones) {
        this.nombre = nombre;
        this.observaciones = observaciones;
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
}
