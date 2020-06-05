package com.mastertech.sistemaponto.repository;

import java.util.Optional;

import com.mastertech.sistemaponto.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 

        @Query("SELECT t FROM Usuario t WHERE t.cpf = :cpf")
        Optional<Usuario> findByCpf(@Param("cpf") String cpf);

}