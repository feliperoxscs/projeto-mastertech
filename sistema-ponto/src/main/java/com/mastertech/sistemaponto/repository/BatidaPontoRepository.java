package com.mastertech.sistemaponto.repository;

import java.util.List;
import java.util.Optional;

import com.mastertech.sistemaponto.model.BatidaPonto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BatidaPontoRepository extends JpaRepository<BatidaPonto, Long> {
    
    @Query("SELECT t FROM BatidaPonto t WHERE t.idUsuario = :idUsuario")
    Optional<List<BatidaPonto>> findByIdUser(@Param("idUsuario") long idUsuario);
}