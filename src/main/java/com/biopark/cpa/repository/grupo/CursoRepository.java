package com.biopark.cpa.repository.grupo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biopark.cpa.entities.grupos.Curso;

import jakarta.transaction.Transactional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByCodCurso(String codigoCurso);

    Optional<Curso> findByNomeCurso(String curso);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO curso (nome_curso, cod_curso, instituicao_id, coordenador_id, created_at, updated_at) VALUES (:#{#curso.nomeCurso.toLowerCase()}, :#{#curso.codCurso.toLowerCase()}, :#{#curso.instituicao.id}, :#{#curso.professor.id}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP) ON DUPLICATE KEY UPDATE nome_curso = VALUES(nome_curso), instituicao_id = VALUES(instituicao_id), coordenador_id = VALUES(coordenador_id), created_at = VALUES(created_at), updated_at = VALUES(updated_at)", nativeQuery = true)
    void upsert(@Param("curso") Curso curso);
}