package com.listeners.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ContaDTO implements Serializable{
	private int id;
	private int clienteId;
	private int gerenteId;
	private String numero;
	private double saldo;
	private double limite;
	private Date dataCriacao;
	public List<MovimentacaoDTO> movimentacoes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public int getGerenteId() {
		return gerenteId;
	}
	public void setGerenteId(int gerenteId) {
		this.gerenteId = gerenteId;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public List<MovimentacaoDTO> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<MovimentacaoDTO> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	
}
