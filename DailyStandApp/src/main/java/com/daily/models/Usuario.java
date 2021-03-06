package com.daily.models;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuarios")
public class Usuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definimos estos valores como PK
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String rut;
    @NotNull
    private String fechaDeNacimiento;
    @NotNull
    private String correo; 
    @NotNull
    private String password;

    //Relacion OneToMany con GrupoUsuario
    @OneToMany(mappedBy ="usuario",cascade=CascadeType.ALL ,fetch=FetchType.LAZY) //CASCADE ES UNA RESTRICCION QUE IMPIDE ELIMINAR EL USUARIO SI NO SE HA ROTO LA RELACION
    private List<GrupoUsuario> gruposUsuarios;

    //Relacion OneToMany con DailyUsuario
    @OneToMany(mappedBy ="usuario",cascade=CascadeType.ALL ,fetch=FetchType.LAZY) //CASCADE ES UNA RESTRICCION QUE IMPIDE ELIMINAR EL USUARIO SI NO SE HA ROTO LA RELACION
    private List<DailyUsuario> dailysUsuarios;

    //Opcionales, sirven para la gestión de base de datos, NO SE AÑADEN A LOS CONSTRUCTORES NI GET AND SET
    @Column(updatable = false) //Propiedad de la columna, updatetable define si se actualiza o no
    private String createdAt; //Fecha de creación
    @Column(updatable = true)
    private String updatedAt; //Fecha de actualización
    @Column(updatable = true)
    private String deletedAt; //Fecha de eliminación
    
    //Constructor Vacío
    public Usuario() {
    }

    //Constructor con atributos
    public Usuario(String nombre, String apellido, String rut, String fechaDeNacimiento, String correo, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correo = correo;
        this.password = password;
    }

    //Getter and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Insertará en el atributo, la fecha antes de insertar a la base de datos
    @PrePersist
    protected void onCreate(){
        this.createdAt = new String();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new String();
    }


}
