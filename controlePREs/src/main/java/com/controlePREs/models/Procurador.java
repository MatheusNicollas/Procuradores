package com.controlePREs.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Procurador implements Serializable{
	
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
	private String etiqueta_endereco;
	private String telefone;
	
	@OneToOne
	private Substituto substituto;
	
	@OneToOne
	private Secretario secretario;

	public Secretario getSecretario() {
		return secretario;
	}
	public void setSecretario(Secretario secretario) {
		this.secretario = secretario;
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
	public Substituto getSubstituto() {
		return substituto;
	}
	public void setSubstituto(Substituto substituto) {
		this.substituto = substituto;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
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
	public String getEtiqueta_endereco() {
		return etiqueta_endereco;
	}
	public void setEtiqueta_endereco(String etiqueta_endereco) {
		this.etiqueta_endereco = etiqueta_endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
