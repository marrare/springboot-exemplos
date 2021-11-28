package br.ifpe.web2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nomeGrupo;
	@Enumerated(EnumType.STRING)
	private Visibilidade visibilidade;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataExpiracao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	public Visibilidade getVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(Visibilidade visibilidade) {
		this.visibilidade = visibilidade;
	}
	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
}
