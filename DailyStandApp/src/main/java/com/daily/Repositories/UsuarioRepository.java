package com.daily.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.daily.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Query comun o nativa utilizamos la tabla
    @Query(value = "select * from usuarios u where u.nombre=?1", nativeQuery = true)
    List<Usuario> buscarNombre(String nombre);

}
