package br.ifpe.web2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.service.GrupoService;

@Controller
public class GrupoController {

	@Autowired
	private GrupoService grupoService;

	@GetMapping("/exibirGrupo")
	public String exibirFormGrupo(Grupo grupo) {
		return "grupos-form";
	}
	
	@PostMapping("/salvarGrupo")
	public String salvarGrupo(Grupo grupo) {
		this.grupoService.cadastrarGrupo(grupo);
		return "redirect:/listarGrupos";
	}
	
	@GetMapping("/listarGrupos")
	public String listarGrupos(Model model) {
		List<Grupo> listaGrupos = this.grupoService.listaGrupo();
		model.addAttribute("lista", listaGrupos);
		return "grupos-list";
	}
	
	@GetMapping("/removerGrupo")
	public String removerGrupo(int id) {
		this.grupoService.deletarGrupo(id);
		return "redirect:/listarGrupos";
	}
	
	@GetMapping("/editarGrupo")
	public String editarGrupo(int id, Model model) {
		Grupo grupo = this.grupoService.getById(id);
		model.addAttribute("grupo", grupo);
		return "grupos-form";
	}
}
