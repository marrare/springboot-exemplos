package br.ifpe.web2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.model.Contato;
import br.ifpe.web2.model.ContatoDAO;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoDAO contatoDAO;
	
	public void cadastrarContato(Contato contatoModel) {
		this.contatoDAO.save(contatoModel);
	}
	
	public List<Contato> listaContato() {
		List<Contato> listaContatos = this.contatoDAO.findAll();
		return listaContatos;
	}
	
	public Contato getContatoByEmail(String email) {
		Contato contato = this.contatoDAO.findByEmail(email);
		return contato;
	}
	
	public void deletarContato(String email) {
		Contato contato = this.contatoDAO.findByEmail(email);
		this.contatoDAO.delete(contato);
	}

}
