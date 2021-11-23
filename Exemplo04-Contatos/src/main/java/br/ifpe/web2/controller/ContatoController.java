package br.ifpe.web2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Contato;
import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.service.ContatoService;
import br.ifpe.web2.service.GrupoService;

@Controller
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;
	@Autowired
	private GrupoService grupoService;

	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato, Model model) {
		List<Grupo> listaGrupos = this.grupoService.listaGrupoVigente();
		model.addAttribute("listaGrupo", listaGrupos);
		return "contatos-form";
	}
	
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato, Grupo grupo) {
		Grupo grupo2 = this.grupoService.getGrupoNome(grupo.getNomeGrupo());
		contato.setGrupo(grupo2);
		this.contatoService.cadastrarContato(contato);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		List<Contato> listaContatos = this.contatoService.listaContato();
		model.addAttribute("lista", listaContatos);
		return "contatos-list";
	}
	
	@GetMapping("/removerContato")
	public String removerContato(String email) {
		this.contatoService.deletarContato(email);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/editarContato")
	public String editarContato(String email, Model model) {
		Contato contato = this.contatoService.getContatoByEmail(email);
		model.addAttribute("contato", contato);
		return "contatos-form";
	}
}
