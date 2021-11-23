package br.ifpe.web2.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoDAO extends JpaRepository<Grupo, Integer>{
	public Grupo findByNomeGrupo(String nomeGrupo);
	public List<Grupo> findByDataExpiracaoGreaterThanEqual(Date date);
}