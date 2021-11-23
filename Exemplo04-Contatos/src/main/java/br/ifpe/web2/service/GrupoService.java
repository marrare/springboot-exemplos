package br.ifpe.web2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.model.GrupoDAO;

@Service
public class GrupoService {

	@Autowired
	private GrupoDAO grupoDAO;
	
	public void cadastrarGrupo(Grupo grupoModel) {
		this.grupoDAO.save(grupoModel);
	}
	
	public List<Grupo> listaGrupoVigente() {
		Date today = new Date();
		List<Grupo> listaGrupos = this.grupoDAO.findByDataExpiracaoGreaterThanEqual(today);
		return listaGrupos;
	}
	
	public List<Grupo> listaGrupo() {
		List<Grupo> listaGrupos = this.grupoDAO.findAll();
		return listaGrupos;
	}
	
	public Grupo getGrupoNome(String nomeGrupo) {
		Grupo grupo = this.grupoDAO.findByNomeGrupo(nomeGrupo);
		return grupo;
	}
	
	public void deletarGrupo(String nomeGrupo) {
		Grupo grupo = this.grupoDAO.findByNomeGrupo(nomeGrupo);
		this.grupoDAO.delete(grupo);
	}
}
