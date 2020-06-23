package com.controlePREs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Substituto {
	
private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String uf;
	private String nome;
	private String email;
	private String celular;
	private String portaria;
	private String inicioMandato;
	private String fimMandato;

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getPortaria() {
		return portaria;
	}
	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}
	public String getInicioMandato() {
		return inicioMandato;
	}
	public void setInicioMandato(String inicioMandato) {
		this.inicioMandato = inicioMandato;
	}
	public String getFimMandato() {
		return fimMandato;
	}
	public void setFimMandato(String fimMandato) {
		this.fimMandato = fimMandato;
	}
	
	
}
